package eu.matejkormuth.anvilrunner;

import eu.matejkormuth.anvilrunner.nbt.NbtIo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class WorldLoader {
    private OldWorld world;
    private final Path worldPath;
    private final Map<Long, Chunk> chunks;

    public WorldLoader(Path worldPath) {
        checkWorldPath(worldPath);

        chunks = new HashMap<>();

        this.worldPath = worldPath;
        this.world = new OldWorld(this);
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

        if (Files.exists(worldPath.resolve("region/"))) {
            throw new IllegalArgumentException("Folder specified in path must contain level.dat and region folder.");
        }
    }

    public OldWorld getWorld() {
        return world;
    }

    public Chunk provideChunk(int chunkX, int chunkZ) {
        long position = pos2long(chunkX, chunkZ);

        if (chunks.containsKey(position)) {
            return chunks.get(position);
        } else {
            Chunk c = new Chunk(this.world, chunkX, chunkZ);
            chunks.put(position, c);
            return c;
        }
    }

    private long pos2long(int x, int z) {
        return (long) x << 32 | z & 0xFFFFFFFFL;
    }

    public void loadChunk(Chunk c) {
        if (c.loaded) {
            throw new IllegalStateException("Chunk " + c + " is already loaded!");
        }

        throw new UnsupportedOperationException("Use loadChunks().");
    }

    private Path getRegionFile(int regionX, int regionZ) {
        return this.worldPath.resolve("region/r." + regionX + "." + regionZ + ".mca");
    }

    public void unloadChunk(Chunk chunk) {
        if (!chunk.loaded) {
            throw new IllegalStateException("Chunk " + chunk + " is already unloaded!");
        }

        if (chunk.dirty) {
            throw new UnsupportedOperationException("Chunk " + chunk
                    + " is dirty! Saving changes is currently not supported!");
        }

        chunk.biomes = null;
        chunk.blockLight = null;
        chunk.skyLight = null;
        chunk.type = null;
        chunk.data = null;
        chunk.heightMap = null;
    }

    public void loadChunks(ChunkLoadTicket req) throws IOException {
        // Open region, load chunk, read subchunk arrays and merge them to big arrays.
        Map<Long, Region> regionTagCache = new HashMap<>();

        // For each chunk in request.
        for (Chunk chunk : req.chunks) {
            long regionPosLong = pos2long(chunk.getRegionX(), chunk.getRegionZ());
            // If region tag is not loaded, read and decompress it.
            if (!regionTagCache.containsKey(regionPosLong)) {
                byte[] bytes = Files.readAllBytes(getRegionFile(chunk.getRegionX(), chunk.getRegionZ()));
                Region region = new Region(NbtIo.decompress(bytes));
                // Cache region Tag.
                regionTagCache.put(regionPosLong, region);
            }
        }
        // Fill Chunk objects with data from region nbt tags.


        // Clear cache.
        regionTagCache.clear();
    }
}
