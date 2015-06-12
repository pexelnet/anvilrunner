package eu.matejkormuth.anvilrunner.jobs.worksplitters;

import eu.matejkormuth.anvilrunner.Chunk;
import eu.matejkormuth.anvilrunner.WorldLoader;

import java.util.Iterator;

public class ChunkWorkSplitter implements Iterable<Chunk> {
    private final WorldLoader worldLoader;

    public ChunkWorkSplitter(WorldLoader worldLoader) {
        this.worldLoader = worldLoader;
    }

    @Override
    public Iterator<Chunk> iterator() {
        return worldLoader.createFileSystemChunkIterator();
    }
}
