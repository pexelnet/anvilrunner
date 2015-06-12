package eu.matejkormuth.anvilrunner;

import java.util.Iterator;

public class World {

    private final WorldLoader loader;

    public World(WorldLoader loader) {
        this.loader = loader;
    }

    public void loadChunk(Chunk chunk) {
        this.loader.loadChunk(chunk);
    }

    public void unloadChunk(Chunk chunk) {
        this.loader.unloadChunk(chunk);
    }

    public Chunk getChunk(int x, int z, boolean loadChunk) {
        Chunk chunk = loader.provideChunk(x, z);

        if(!chunk.isLoaded() && loadChunk) {
            chunk.load();
        }

        return chunk;
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
}
