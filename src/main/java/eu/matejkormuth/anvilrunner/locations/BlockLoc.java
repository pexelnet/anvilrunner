package eu.matejkormuth.anvilrunner.locations;

public final class BlockLoc {
    public final int blockX;
    public final int blockY;
    public final int blockZ;

    public BlockLoc(int blockX, int blockY, int blockZ) {
        this.blockX = blockX;
        this.blockY = blockY;
        this.blockZ = blockZ;
    }

    public final ChunkLoc getChunkLocation() {
        return new ChunkLoc(this);
    }

    public final RegionLoc getRegionLocation() {
        return new RegionLoc(this);
    }

    @Override
    public String toString() {
        return "BlockLoc{" +
                "blockX=" + blockX +
                ", blockY=" + blockY +
                ", blockZ=" + blockZ +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlockLoc blockLoc = (BlockLoc) o;

        if (blockX != blockLoc.blockX) return false;
        if (blockY != blockLoc.blockY) return false;
        return blockZ == blockLoc.blockZ;

    }

    @Override
    public int hashCode() {
        int result = blockX;
        result = 31 * result + blockY;
        result = 31 * result + blockZ;
        return result;
    }
}
