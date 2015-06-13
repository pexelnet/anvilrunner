package eu.matejkormuth.anvilrunner.customcode;

import eu.matejkormuth.anvilrunner.*;
import eu.matejkormuth.anvilrunner.parametersplitters.ChunkToBlockSplitter;
import eu.matejkormuth.anvilrunner.parametersplitters.ChunkWorkSplitter;
import eu.matejkormuth.anvilrunner.parametersplitters.RegionToChunkSplitter;
import eu.matejkormuth.anvilrunner.worktypes.BlockTest;
import eu.matejkormuth.anvilrunner.resulthandlers.BlockTestResultHandler;
import eu.matejkormuth.anvilrunner.workers.Worker;
import eu.matejkormuth.anvilrunner.workers.threaded.ThreadedWorker;
import eu.matejkormuth.anvilrunner.workers.WorkResultCouple;

import java.nio.file.Paths;

public class GrassBlockWorkDefinition {

    // Check for existence of grass block.
    public class GrassBlockTest extends BlockTest {
        protected GrassBlockTest() {
            // We do not check air.
            super(false);
        }

        public boolean testBlock(Block block) {
            return block.type == BlockTypes.GRASS;
        }
    }

    public class TreeFoundationExistence extends BlockTest {
        protected TreeFoundationExistence() {
            // We do not check air.
            super(false);
        }

        public boolean testBlock(Block block) {
            if (block.type.type != BlockTypes.OAK_WOOD.type) {
                return false;
            }

            // Check relative blocks.
            return block.getRelative(1, -1, 0).type == BlockTypes.GRASS &&
                    block.getRelative(1, -1, 1).type == BlockTypes.GRASS &&
                    block.getRelative(0, -1, 1).type == BlockTypes.GRASS &&
                    block.getRelative(-1, -1, 0).type == BlockTypes.GRASS &&
                    block.getRelative(-1, -1, -1).type == BlockTypes.GRASS &&
                    block.getRelative(0, -1, -1).type == BlockTypes.GRASS &&
                    block.getRelative(1, -1, -1).type == BlockTypes.GRASS &&
                    block.getRelative(-1, -1, 1).type == BlockTypes.GRASS;
        }
    }

    public class TreeFoundationTestResultHandler extends BlockTestResultHandler {
        @Override
        public void onResult(Block parameter, Boolean result) {
            if (result)
                return;
            System.out.println("Tree foundation is missing at " + parameter.getBlockLocation());
        }
    }

    // For example print to stdout.
    public class GrassBlockTestResultHandler extends BlockTestResultHandler {
        @Override
        public void onResult(Block parameter, Boolean result) {
            System.out.println(parameter + " : " + result);
        }
    }

    public void make() {
        RequiredData requiredData = RequiredData.builder()
                .requireBlockType()
                .requireBlockData()
                .build();
        DataLoader dataLoader = new DataLoader(requiredData);

        WorldLoader worldLoader = new WorldLoader(Paths.get("world"));

        WorkResultCouple work = new WorkResultCouple(new GrassBlockTest(), new GrassBlockTestResultHandler());
        Worker executor = new ThreadedWorker(8, 2);
        executor.setWorkParameterProvider(new ChunkToBlockSplitter(new RegionToChunkSplitter(worldLoader.createRegionProvider())));
        executor.setWork(work);
        executor.start();
    }
}
