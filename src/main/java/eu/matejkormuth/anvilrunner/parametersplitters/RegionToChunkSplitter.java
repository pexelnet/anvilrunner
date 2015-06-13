package eu.matejkormuth.anvilrunner.parametersplitters;

import eu.matejkormuth.anvilrunner.Chunk;
import eu.matejkormuth.anvilrunner.Region;

import java.util.Iterator;

public class RegionToChunkSplitter implements Iterable<Chunk>{
    private final Iterable<Region> worldLoader;

    public RegionToChunkSplitter(Iterable<Region> worldLoader) {
        this.worldLoader = worldLoader;
    }

    @Override
    public Iterator<Chunk> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Chunk> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Chunk next() {
            return null;
        }
    }
}
