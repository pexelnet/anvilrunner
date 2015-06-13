package eu.matejkormuth.anvilrunner;

import eu.matejkormuth.anvilrunner.nbt.CompoundTag;
import eu.matejkormuth.anvilrunner.nbt.NbtIo;

import java.io.IOException;
import java.util.List;

public class DataLoader {
    private final RequiredData requiredData;

    public DataLoader(RequiredData requiredData) {
        this.requiredData = requiredData;
    }

    public void loadIntoRegion(Region region, byte[] data) throws IOException {
        CompoundTag compoundTag = NbtIo.decompress(data);

        region.chunks = new Chunk[32 * 32];

        for (int x = 0; x < 32; x++) {
            for (int z = 0; z < 32; z++) {
                // Check stored yPos and xPos with region * 32 * x, region * 32 * z.
                // If they are not equal... well, I don't know what we do then.

                loadIntoChunk(region.chunks[z * 16 + x], compoundTag);
            }
        }
    }

    private void loadIntoChunk(Chunk chunk, CompoundTag chunkTag) {
        if (requiredData.biomes)
            chunk.biomes = initByteArray();

        if (requiredData.blockLight)
            chunk.blockLight = initByteArray();

        if (requiredData.data)
            chunk.data = initByteArray();

        if (requiredData.skyLight)
            chunk.skyLight = initByteArray();

        if (requiredData.type)
            chunk.type = initByteArray();

        int sectionY;
        for (CompoundTag sectionTag : (List<CompoundTag>) chunkTag.getList("Sections").getList()) {
            sectionY = sectionTag.getByte("Y");

            for (int z = 0; z < 16; z++) {
                for (int x = 0; x < 16; x++) {

                }
            }

        }
    }

    private byte[] initByteArray() {
        return new byte[16 * 16 * 256];
    }

}
