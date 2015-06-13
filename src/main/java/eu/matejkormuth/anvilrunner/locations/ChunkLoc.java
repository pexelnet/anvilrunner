package eu.matejkormuth.anvilrunner.locations;

public final class ChunkLoc {
    public final int chunkX;
    public final int chunkZ;

    public ChunkLoc(int chunkX, int chunkZ) {
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
    }

    public ChunkLoc(BlockLoc blockLoc) {
        this.chunkX = blockLoc.blockX / 16;
        this.chunkZ = blockLoc.blockZ / 16;
    }

    @Override
    public String toString() {
        return "ChunkLoc{" +
                "chunkX=" + chunkX +
                ", chunkZ=" + chunkZ +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChunkLoc chunkLoc = (ChunkLoc) o;

        if (chunkX != chunkLoc.chunkX) return false;
        return chunkZ == chunkLoc.chunkZ;

    }

    @Override
    public int hashCode() {
        int result = chunkX;
        result = 31 * result + chunkZ;
        return result;
    }

    public final RegionLoc getRegionLocation() {
        return new RegionLoc(this);

    }
}
