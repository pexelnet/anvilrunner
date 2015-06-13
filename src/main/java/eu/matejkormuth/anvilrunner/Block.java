package eu.matejkormuth.anvilrunner;

import eu.matejkormuth.anvilrunner.locations.BlockLoc;

public final class Block {
    public final int x;
    public final int y;
    public final int z;
    public final BlockType type;
    private final OldWorld w;

    public Block(OldWorld w, int x, int y, int z, BlockType type) {
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

    public final BlockLoc getBlockLocation() {
        return new BlockLoc(this.x, this.y, this.z);
    }
}
