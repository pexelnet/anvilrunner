package eu.matejkormuth.anvilrunner;

import java.util.Iterator;

public class World {

    private final WorldLoader loader;

    public World(WorldLoader loader) {
        this.loader = loader;
    }

    public Block getBlock(int x, int y, int z, boolean loadChunk) {
        // Find chunk - no need to Math.floor() JVM always rounds integer downwards to zero.
        int chunkX = x / Chunk.CHUNK_WIDTH;
        int chunkZ = z / Chunk.CHUNK_LENGTH;

        // Load chunk.
        Chunk chunk = loader.provideChunk(chunkX, chunkZ);

        if (chunk.isLoaded()) {
            return chunk.getBlock(x % Chunk.CHUNK_WIDTH, y, z % Chunk.CHUNK_LENGTH);
        } else {
            if (loadChunk) {
                chunk.load();
                return chunk.getBlock(x % Chunk.CHUNK_WIDTH, y, z % Chunk.CHUNK_LENGTH);
            } else {
                throw new IllegalStateException("Chunk " + chunk.toString()
                        + " is not loaded and loadChunk is set to false!");
            }
        }
    }

    public Iterator<Chunk> getChunkIterator() {
        return loader.createFileSystemChunkIterator();
    }
}
