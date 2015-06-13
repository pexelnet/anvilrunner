package eu.matejkormuth.anvilrunner.locations;

import eu.matejkormuth.anvilrunner.Chunk;

public final class RegionLoc {
    public final int regionX;
    public final int regionZ;

    public RegionLoc(int regionX, int regionZ) {
        this.regionX = regionX;
        this.regionZ = regionZ;
    }

    public RegionLoc(ChunkLoc loc) {
        this.regionX = loc.chunkX / 32;
        this.regionZ = loc.chunkZ / 32;
    }

    public RegionLoc(BlockLoc loc) {
        this.regionX = loc.blockX / Chunk.CHUNK_WIDTH / 32;
        this.regionZ = loc.blockZ / 16 / 32;
    }

    @Override
    public String toString() {
        return "RegionLoc{" +
                "regionX=" + regionX +
                ", regionZ=" + regionZ +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionLoc regionLoc = (RegionLoc) o;

        if (regionX != regionLoc.regionX) return false;
        return regionZ == regionLoc.regionZ;

    }

    @Override
    public int hashCode() {
        int result = regionX;
        result = 31 * result + regionZ;
        return result;
    }
}
