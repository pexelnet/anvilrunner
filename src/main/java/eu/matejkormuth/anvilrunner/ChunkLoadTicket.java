package eu.matejkormuth.anvilrunner;

import java.util.Set;

/**
 * Represents set of chunks that will be loaded at batch.
 * <p>
 * This is useful when loading a lot of chunks from one region file.
 * Using this class ensures that each region file will be read one
 * time during the load at most.
 */
public class ChunkLoadTicket {

    public final Set<Chunk> chunks;

    public ChunkLoadTicket(Set<Chunk> chunks) {
        this.chunks = chunks;
    }
}
