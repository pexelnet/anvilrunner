package eu.matejkormuth.anvilrunner;

public class Chunk {
    public static final int CHUNK_WIDTH = 16;
    public static final int CHUNK_LENGTH = 16;
    public static final int CHUNK_HEIGHT = 255;

    private final int x;
    private final int z;
    private final World w;
    boolean loaded;
    boolean dirty = false;

    // Accessed by loader(s).
    byte[] biomes;
    byte[] blockLight;
    byte[] skyLight;
    byte[] type;
    byte[] data;
    int[] heightMap;

    public Chunk(World w, int x, int z) {
        this.w = w;
        this.x = x;
        this.z = z;
    }

    /**
     * Same as calling World.loadChunk(Chunk).
     */
    public void load() {
        this.w.loadChunk(this);
    }

    /**
     * Same as calling World.unloadChunk(Chunk).
     */
    public void unload() {
        this.w.unloadChunk(this);
    }

    public final int getRegionX() {
        return this.x / 32;
    }

    public final int getRegionZ() {
        return this.z / 32;
    }

    public final boolean isLoaded() {
        return loaded;
    }


    public Block getBlock(int cx, int cy, int cz) {
        return new Block(w, x * CHUNK_WIDTH + cx, cy, z * CHUNK_LENGTH + cz,
                new BlockType(getType(cx, cy, cz), getData(cx, cy, cz)));
    }

    public int getHighestBlock(int cx, int cz) {
        return -1;
    }

    public byte getType(int cx, int cy, int cz) {
        return type[((cy * 16 + cz) * 16 + cx)];
    }

    public byte getData(int cx, int cy, int cz) {
        return data[((cy * 16 + cz) * 16 + cx)];
    }

    public byte getBlockLight(int cx, int cy, int cz) {
        return blockLight[((cy * 16 + cz) * 16 + cx)];
    }

    public byte getSkyLight(int cx, int cy, int cz) {
        return skyLight[((cy * 16 + cz) * 16 + cx)];
    }

    public byte getBiome(int cx, int cy, int cz) {
        return biomes[((cy * 16 + cz) * 16 + cx)];
    }

    @Override
    public String toString() {
        return "Chunk{" +
                "x=" + x +
                ", z=" + z +
                '}';
    }
}
