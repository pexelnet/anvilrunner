package eu.matejkormuth.anvilrunner;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public class WorldLoader {
    private World world;
    private final Path worldPath;

    public WorldLoader(Path worldPath) {
        checkWorldPath(worldPath);

        this.worldPath = worldPath;
        this.world = new World(this);
    }

    private void checkWorldPath(Path worldPath) {
        if (worldPath == null) {
            throw new IllegalArgumentException("Path can't be null!");
        }

        if (Files.isDirectory(worldPath)) {
            throw new IllegalArgumentException("Path must be directory.");
        }

        if (Files.exists(worldPath.resolve("level.dat"))) {
            throw new IllegalArgumentException("Folder specified in path must contain level.dat and region folder.");
        }

        if (Files.exists(worldPath.resolve("region"))) {
            throw new IllegalArgumentException("Folder specified in path must contain level.dat and region folder.");
        }
    }

    public World getWorld() {
        return world;
    }

    public void requestBiomes() {

    }

    public Iterator<Chunk> createFileSystemChunkIterator() {
        return null;
    }

    public Chunk provideChunk(int chunkX, int chunkZ) {
        // Find region - there are 32x32 chunks in one region (mca) file.
        int regionX = chunkX / 32;
        int regionZ = chunkZ / 32;

        return null;
    }
}
