package eu.matejkormuth.anvilrunner;

public final class BlockType {
    public final byte data;
    public final byte type;

    public BlockType(int type, int data) {
        this.type = (byte) type;
        this.data = (byte) data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlockType blockType = (BlockType) o;

        if (data != blockType.data) return false;
        return type == blockType.type;

    }

    @Override
    public int hashCode() {
        int result = (int) data;
        result = 31 * result + (int) type;
        return result;
    }

    @Override
    public String toString() {
        return "BlockType{" +
                "data=" + data +
                ", type=" + type +
                '}';
    }
}
