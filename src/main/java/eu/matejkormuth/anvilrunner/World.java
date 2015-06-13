package eu.matejkormuth.anvilrunner;

import eu.matejkormuth.anvilrunner.locations.BlockLoc;
import eu.matejkormuth.anvilrunner.locations.ChunkLoc;
import eu.matejkormuth.anvilrunner.locations.RegionLoc;

import java.util.HashMap;
import java.util.Map;

public class World {

    private final Map<RegionLoc, Region> regions;

    public World() {
        regions = new HashMap<>();
    }

    public Region getRegion(BlockLoc loc) {
        return getRegion(loc.getRegionLocation());
    }

    public Region getRegion(ChunkLoc loc) {
        return getRegion(loc.getRegionLocation());
    }

    public Region getRegion(RegionLoc loc) {
        if (!regions.containsKey(loc)) {
            createRegionObj(loc);
        }

        return regions.get(loc);
    }

    private void createRegionObj(RegionLoc loc) {
        Region region = new Region(loc);
        regions.put(loc, region);
    }
}
