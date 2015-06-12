package eu.matejkormuth.anvilrunner;

import eu.matejkormuth.anvilrunner.nbt.CompoundTag;
import eu.matejkormuth.anvilrunner.nbt.ListTag;
import eu.matejkormuth.anvilrunner.nbt.Tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;

public class RegionTagWrapper {
    private final CompoundTag tag;

    public RegionTagWrapper(CompoundTag tag) {
        this.tag = tag;
    }

    public Collection<Tag> getAllTags() {
        return tag.getAllTags();
    }

    public Tag copy() {
        return tag.copy();
    }

    public void putInt(String name, int value) {
        tag.putInt(name, value);
    }

    public byte[] getByteArray(String name) {
        return tag.getByteArray(name);
    }

    public Tag setName(String name) {
        return tag.setName(name);
    }

    public void putFloat(String name, float value) {
        tag.putFloat(name, value);
    }

    public void putDouble(String name, double value) {
        tag.putDouble(name, value);
    }

    public long getLong(String name) {
        return tag.getLong(name);
    }

    public Tag get(String name) {
        return tag.get(name);
    }

    public void putByte(String name, byte value) {
        tag.putByte(name, value);
    }

    public static Tag readNamedTag(DataInput dis) throws IOException {
        return Tag.readNamedTag(dis);
    }

    public boolean getBoolean(String string) {
        return tag.getBoolean(string);
    }

    public void putShort(String name, short value) {
        tag.putShort(name, value);
    }

    public byte getId() {
        return tag.getId();
    }

    public void put(String name, Tag tag) {
        this.tag.put(name, tag);
    }

    public void putCompound(String name, CompoundTag value) {
        tag.putCompound(name, value);
    }

    public void putString(String name, String value) {
        tag.putString(name, value);
    }

    public static Tag newTag(byte type, String name) {
        return Tag.newTag(type, name);
    }

    public void putByteArray(String name, byte[] value) {
        tag.putByteArray(name, value);
    }

    public String getString(String name) {
        return tag.getString(name);
    }

    public int[] getIntArray(String name) {
        return tag.getIntArray(name);
    }

    public float getFloat(String name) {
        return tag.getFloat(name);
    }

    public double getDouble(String name) {
        return tag.getDouble(name);
    }

    public void print(PrintStream out) {
        tag.print(out);
    }

    public static void writeNamedTag(Tag tag, DataOutput dos) throws IOException {
        Tag.writeNamedTag(tag, dos);
    }

    public CompoundTag getCompound(String name) {
        return tag.getCompound(name);
    }

    public boolean isEmpty() {
        return tag.isEmpty();
    }

    public void putBoolean(String string, boolean val) {
        tag.putBoolean(string, val);
    }

    public short getShort(String name) {
        return tag.getShort(name);
    }

    public ListTag<? extends Tag> getList(String name) {
        return tag.getList(name);
    }

    public void print(String prefix, PrintStream out) {
        tag.print(prefix, out);
    }

    public void putLong(String name, long value) {
        tag.putLong(name, value);
    }

    public byte getByte(String name) {
        return tag.getByte(name);
    }

    public int getInt(String name) {
        return tag.getInt(name);
    }

    public static String getTagName(byte type) {
        return Tag.getTagName(type);
    }

    public boolean contains(String name) {
        return tag.contains(name);
    }

    public String getName() {
        return tag.getName();
    }

    public void putIntArray(String name, int[] value) {
        tag.putIntArray(name, value);
    }
}
