package eu.matejkormuth.anvilrunner.jobs.worksplitters;

import eu.matejkormuth.anvilrunner.Chunk;
import eu.matejkormuth.anvilrunner.World;

import java.util.Iterator;

public class ChunkWorkSplitter implements Iterable<Chunk> {
    private final World w;

    public ChunkWorkSplitter(World w) {
        this.w = w;
    }

    @Override
    public Iterator<Chunk> iterator() {
        return w.getChunkIterator();
    }
}
