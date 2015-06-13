package eu.matejkormuth.anvilrunner.worktypes;

import eu.matejkormuth.anvilrunner.Block;

public abstract class BlockTest {
    public final boolean checkAir;

    protected BlockTest(boolean checkAir) {
        this.checkAir = checkAir;
    }
    public abstract boolean testBlock(Block block);
}
