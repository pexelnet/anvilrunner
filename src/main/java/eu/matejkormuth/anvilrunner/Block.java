package eu.matejkormuth.anvilrunner;

public class Block {
    public final int x;
    public final int y;
    public final int z;
    public final BlockType type;
    private final World w;

    public Block(World w, int x, int y, int z, BlockType type) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
    }

    public Block getRelative(int modx, int mody, int modz) {
        // TODO: Decide whether we want to load the chunk if not loaded?
        return w.getBlock(this.x + modx, this.y + mody, this.z + modz, true);
    }

    public BlockLocation getBlockLocation() {
        return new BlockLocation(x, y, z);
    }
}
