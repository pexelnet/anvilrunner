package eu.matejkormuth.anvilrunner;

public class RequiredData {
    public final boolean type;
    public final boolean data;
    public final boolean biomes;
    public final boolean skyLight;
    public final boolean blockLight;

    private RequiredData(boolean type, boolean data, boolean biomes, boolean skyLight, boolean blockLight) {
        this.type = type;
        this.data = data;
        this.biomes = biomes;
        this.skyLight = skyLight;
        this.blockLight = blockLight;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private boolean type;
        private boolean data;
        private boolean biomes;
        private boolean skyLight;
        private boolean blockLight;

        public Builder requireBlockType() {
            this.type = true;
            return this;
        }

        public Builder requireBlockData() {
            this.data = true;
            return this;
        }

        public Builder requireBiomes() {
            this.biomes = true;
            return this;
        }

        public Builder requireSkyLight() {
            this.skyLight = true;
            return this;
        }

        public Builder requireBlockLight() {
            this.blockLight = true;
            return this;
        }

        public final RequiredData build() {
            return new RequiredData(type, data, biomes, skyLight, blockLight);
        }
    }
}
