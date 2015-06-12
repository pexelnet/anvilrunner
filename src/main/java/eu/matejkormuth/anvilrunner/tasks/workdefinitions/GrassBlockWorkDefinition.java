package eu.matejkormuth.anvilrunner.tasks.workdefinitions;

import eu.matejkormuth.anvilrunner.Block;
import eu.matejkormuth.anvilrunner.BlockTypes;
import eu.matejkormuth.anvilrunner.WorldLoader;
import eu.matejkormuth.anvilrunner.jobs.worksplitters.ChunkToBlockSplitter;
import eu.matejkormuth.anvilrunner.jobs.worksplitters.ChunkWorkSplitter;
import eu.matejkormuth.anvilrunner.jobs.worktypes.BlockTest;
import eu.matejkormuth.anvilrunner.jobs.worktypes.BlockTestResultHandler;
import eu.matejkormuth.anvilrunner.tasks.TaskExecutor;
import eu.matejkormuth.anvilrunner.tasks.ThreadedWorker;
import eu.matejkormuth.anvilrunner.tasks.WorkResultCouple;

import java.nio.file.Paths;

public class GrassBlockWorkDefinition {

    // Check for existence of grass block.
    public class GrassBlockExistence extends BlockTest {
        protected GrassBlockExistence() {
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
    public class ConcreteBlockTestResultHandler extends BlockTestResultHandler {
        @Override
        public void onResult(Block parameter, Boolean result) {
            System.out.println(parameter + " : " + result);
        }
    }

    public void make() {
        WorldLoader worldLoader = new WorldLoader(Paths.get("world"));
        // worldLoader.requestBiomes();

        WorkResultCouple work = new WorkResultCouple(new GrassBlockExistence(), new ConcreteBlockTestResultHandler());
        TaskExecutor executor = new ThreadedWorker(8, 2);
        executor.setWorkParameterProvider(new ChunkToBlockSplitter(new ChunkWorkSplitter(worldLoader)));
        executor.setTask(work);
        executor.start();
    }
}
