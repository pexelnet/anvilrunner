package eu.matejkormuth.anvilrunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public class FileSystemRegionsChunksIterator implements Iterator<Chunk> {
    private final Path regionFilesFolder;
    private Iterator<Path> regionIter;
    private RegionTagWrapper regionTagWrapper;

    public FileSystemRegionsChunksIterator(Path worldPath) {
        this.regionFilesFolder = worldPath.resolve("region/");

        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        this.regionIter = Files.walk(this.regionFilesFolder).iterator();
    }

    @Override
    public boolean hasNext() {
        if (regionHasNextChunk()) {
            return true;
        } else {
            // Whether we have next region, when we are at the end of current region.
            return regionIter.hasNext();
        }
    }

    @Override
    public Chunk next() {
        if (regionHasNextChunk()) {
            return regionNextChunk();
        } else {
            // Decode next region.
            loadNextRegionFile();
            return regionNextChunk();
        }
    }
}
