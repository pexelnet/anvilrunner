package eu.matejkormuth.anvilrunner.jobs.worksplitters;

import eu.matejkormuth.anvilrunner.Block;
import eu.matejkormuth.anvilrunner.Chunk;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ChunkToBlockSplitter implements Iterable<Block> {
    private final ChunkWorkSplitter chunkProvider;

    public ChunkToBlockSplitter(ChunkWorkSplitter chunkProvider) {
        this.chunkProvider = chunkProvider;
    }

    @Override
    public Iterator<Block> iterator() {
        return new BlockInChunkItr(chunkProvider.iterator());
    }

    private class BlockInChunkItr implements Iterator<Block> {
        private final Iterator<Chunk> chunkItr;
        private short x = 0;
        private short y = 0;
        private short z = 0;
        private Chunk chunk;

        public BlockInChunkItr(Iterator<Chunk> iterator) {
            this.chunkItr = iterator;
        }

        @Override
        public boolean hasNext() {
            return y != 255 || x != 15 || z != 15;
        }

        @Override
        public Block next() {
            if (x == 15) {
                x = 0;
                if (z == 15) {
                    if (y == 255) {
                        // Get new chunk.
                        if (chunkItr.hasNext()) {
                            chunk = chunkItr.next();
                            x = 0;
                            z = 0;
                            y = 0;
                        } else {
                            throw new NoSuchElementException("We run out of chunks and x and z are 15 and y is 255!");
                        }
                    } else {
                        y++;
                    }
                } else {
                    z++;
                }
            } else {
                x++;
            }
            return chunk.getBlock(x, y, z);
        }
    }
}
