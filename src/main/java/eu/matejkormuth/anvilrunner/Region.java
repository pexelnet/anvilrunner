package eu.matejkormuth.anvilrunner;

import eu.matejkormuth.anvilrunner.locations.RegionLoc;

public class Region {
    public final int regionX;
    public final int regionZ;
    private boolean loaded;
    Chunk[] chunks;

    public Region(RegionLoc loc) {
        this.regionX = loc.regionX;
        this.regionZ = loc.regionZ;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public Chunk getChunk(byte localChunkX, byte localChunkZ) {
        return chunks[localChunkZ * 16 + localChunkX];
    }
}
