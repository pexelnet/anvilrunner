package eu.matejkormuth.anvilrunner;

public final class BlockTypes {
    private BlockTypes() {
    }

    public static final BlockType AIR = new BlockType(0, 0);

    public static final BlockType STONE = new BlockType(1, 0);
    public static final BlockType GRANITE = new BlockType(1, 1);
    public static final BlockType POLISHED_GRANITE = new BlockType(1, 2);
    public static final BlockType DIORITE = new BlockType(1, 3);
    public static final BlockType POLISHED_DIORITE = new BlockType(1, 4);
    public static final BlockType ANDESITE = new BlockType(1, 5);
    public static final BlockType POLISHED_ANDESITE = new BlockType(1, 6);

    public static final BlockType GRASS = new BlockType(2, 0);

    public static final BlockType DIRT = new BlockType(3, 0);
    public static final BlockType COARSE_DIRT = new BlockType(3, 1);
    public static final BlockType PODZOL = new BlockType(3, 2);

    public static final BlockType COBBLESTONE = new BlockType(4, 0);

    public static final BlockType OAK_WOOD_PLANKS = new BlockType(5, 0);
    public static final BlockType SPRUCE_WOOD_PLANKS = new BlockType(5, 1);
    public static final BlockType BIRCH_WOOD_PLANKS = new BlockType(5, 2);
    public static final BlockType JUNGLE_WOOD_PLANKS = new BlockType(5, 3);
    public static final BlockType ACACIA_WOOD_PLANKS = new BlockType(5, 4);
    public static final BlockType DARK_OAK_WOOD_PLANKS = new BlockType(5, 5);

    public static final BlockType OAK_SAPLING = new BlockType(6, 0);
    public static final BlockType SPRUCE_SAPLING = new BlockType(6, 1);
    public static final BlockType BIRCH_SAPLING = new BlockType(6, 2);
    public static final BlockType JUNGLE_SAPLING = new BlockType(6, 3);
    public static final BlockType ACACIA_SAPLING = new BlockType(6, 4);
    public static final BlockType DARK_OAK_SAPLING = new BlockType(6, 5);

    public static final BlockType BEDROCK = new BlockType(7, 0);

    public static final BlockType FLOWING_WATER = new BlockType(8, 0);

    public static final BlockType STILL_WATER = new BlockType(9, 0);

    public static final BlockType FLOWING_LAVA = new BlockType(10, 0);

    public static final BlockType STILL_LAVA = new BlockType(11, 0);

    public static final BlockType SAND = new BlockType(12, 0);
    public static final BlockType RED_SAND = new BlockType(12, 1);

    public static final BlockType GRAVEL = new BlockType(13, 0);

    public static final BlockType GOLD_ORE = new BlockType(14, 0);

    public static final BlockType IRON_ORE = new BlockType(15, 0);

    public static final BlockType COAL_ORE = new BlockType(16, 0);

    public static final BlockType OAK_WOOD = new BlockType(17, 0);
    public static final BlockType SPRUCE_WOOD = new BlockType(17, 1);
    public static final BlockType BIRCH_WOOD = new BlockType(17, 2);
    public static final BlockType JUNGLE_WOOD = new BlockType(17, 3);

    public static final BlockType OAK_LEAVES = new BlockType(18, 0);
    public static final BlockType SPRUCE_LEAVES = new BlockType(18, 1);
    public static final BlockType BIRCH_LEAVES = new BlockType(18, 2);
    public static final BlockType JUNGLE_LEAVES = new BlockType(18, 3);

    public static final BlockType SPONGE = new BlockType(19, 0);
    public static final BlockType WET_SPONGE = new BlockType(19, 1);

    public static final BlockType GLASS = new BlockType(20, 0);

    public static final BlockType LAPIS_LAZULI_ORE = new BlockType(21, 0);

    public static final BlockType LAPIS_LAZULI_BLOCK = new BlockType(22, 0);

    public static final BlockType DISPENSER = new BlockType(23, 0);

    public static final BlockType SANDSTONE = new BlockType(24, 0);
    public static final BlockType CHISELED_SANDSTONE = new BlockType(24, 1);
    public static final BlockType SMOOTH_SANDSTONE = new BlockType(24, 2);

    public static final BlockType NOTE_BOCK = new BlockType(25, 0);

    public static final BlockType BED = new BlockType(26, 0);

    public static final BlockType POWERED_RAIL = new BlockType(27, 0);

    public static final BlockType DETECTOR_RAIL = new BlockType(28, 0);

    public static final BlockType STICKY_PISTON = new BlockType(29, 0);

    public static final BlockType COBWEB = new BlockType(30, 0);

    public static final BlockType DEAD_SHRUB = new BlockType(31, 0);
    public static final BlockType LONG_GRASS = new BlockType(31, 1);
    public static final BlockType FERN = new BlockType(31, 2);

    public static final BlockType DEAD_BUSH = new BlockType(32, 0);

    public static final BlockType PISTON = new BlockType(33, 0);

    public static final BlockType PISTON_HEAD = new BlockType(34, 0);

    public static final BlockType WHITE_WOOL = new BlockType(35, 0);
    public static final BlockType ORANGE_WOOL = new BlockType(35, 1);
    public static final BlockType MAGENTA_WOOL = new BlockType(35, 2);
    public static final BlockType LIGHT_BLUE_WOOL = new BlockType(35, 3);
    public static final BlockType YELLOW_WOOL = new BlockType(35, 4);
    public static final BlockType LIME_WOOL = new BlockType(35, 5);
    public static final BlockType PINK_WOOL = new BlockType(35, 6);
    public static final BlockType GRAY_WOOL = new BlockType(35, 7);
    public static final BlockType LIGHT_GRAY_WOOL = new BlockType(35, 8);
    public static final BlockType CYAN_WOOL = new BlockType(35, 9);
    public static final BlockType PURPLE_WOOL = new BlockType(35, 10);
    public static final BlockType BLUE_WOOL = new BlockType(35, 11);
    public static final BlockType BROWN_WOOL = new BlockType(35, 12);
    public static final BlockType RED_WOOL = new BlockType(35, 13);
    public static final BlockType GREEN_WOOL = new BlockType(35, 14);
    public static final BlockType BLACK_WOOL = new BlockType(35, 15);

    public static final BlockType DANDELION = new BlockType(37, 0);

    public static final BlockType POPPY = new BlockType(38, 0);
    public static final BlockType BLUE_ORCHID = new BlockType(38, 1);
    public static final BlockType ALLIUM = new BlockType(38, 2);
    public static final BlockType AZURE_BULET = new BlockType(38, 3);
    public static final BlockType RED_TULIP = new BlockType(38, 4);
    public static final BlockType ORANGE_TULIP = new BlockType(38, 5);
    public static final BlockType WHITE_TULIP = new BlockType(38, 6);
    public static final BlockType PINK_TULIP = new BlockType(38, 7);
    public static final BlockType OXEYE_DAISY = new BlockType(38, 8);

    public static final BlockType BROWN_MUSHROOM = new BlockType(39, 0);

    public static final BlockType RED_MUSHROOM = new BlockType(40, 0);

    public static final BlockType GOLD_BLOCK = new BlockType(41, 0);

    public static final BlockType IRON_BLOCK = new BlockType(42, 0);

    public static final BlockType DOUBLE_STONE_SLAB = new BlockType(43, 0);
    public static final BlockType DOUBLE_SANDSTONE_SLAB = new BlockType(43, 1);
    public static final BlockType DOUBLE_WOODEN_SLAB = new BlockType(43, 2);
    public static final BlockType DOUBLE_COBBLESTONE_SLAB = new BlockType(43, 3);
    public static final BlockType DOUBLE_BRICK_SLAB = new BlockType(43, 4);
    public static final BlockType DOUBLE_STONE_BRICK_SLAB = new BlockType(43, 5);
    public static final BlockType DOUBLE_NETHER_BRICK_SLAB = new BlockType(43, 6);
    public static final BlockType DOUBLE_QUARTZ_SLAB = new BlockType(43, 7);

    public static final BlockType STONE_SLAB = new BlockType(44, 0);
    public static final BlockType SANDSTONE_SLAB = new BlockType(44, 1);
    public static final BlockType WOODEN_SLAB = new BlockType(44, 2);
    public static final BlockType COBBLESTONE_SLAB = new BlockType(44, 3);
    public static final BlockType BRICK_SLAB = new BlockType(44, 4);
    public static final BlockType STONE_BRICK_SLAB = new BlockType(44, 5);
    public static final BlockType NETHER_BRICK_SLAB = new BlockType(44, 6);
    public static final BlockType QUARTZ_SLAB = new BlockType(44, 7);

    public static final BlockType BRICKS = new BlockType(45, 0);

    public static final BlockType TNT = new BlockType(46, 0);

    public static final BlockType BOOKSHELF = new BlockType(47, 0);

    public static final BlockType MOSSY_STONE = new BlockType(48, 0);

    public static final BlockType OBSIDIAN = new BlockType(49, 0);

    public static final BlockType TORCH = new BlockType(50, 0);

    public static final BlockType FIRE = new BlockType(51, 0);

    public static final BlockType MONSTER_SPAWNER = new BlockType(52, 0);

    public static final BlockType OAK_WOOD_STAIRS = new BlockType(53, 0);

    public static final BlockType CHEST = new BlockType(54, 0);

    public static final BlockType REDSTONE_WIRE = new BlockType(55, 0);

    public static final BlockType DIAMOND_ORE = new BlockType(56, 0);

    public static final BlockType DIAMOND_BLOCK = new BlockType(57, 0);

    public static final BlockType CRAFTING_TABLE = new BlockType(58, 0);

    public static final BlockType WHEAT_CROPS = new BlockType(59, 0);

    public static final BlockType FARMLAND = new BlockType(60, 0);

    public static final BlockType FURNACE = new BlockType(61, 0);

    public static final BlockType BURNING_FURNACE = new BlockType(62, 0);

    public static final BlockType STANDING_SIGN_BLOCK = new BlockType(63, 0);

    public static final BlockType OAK_DOOR_BLOCK = new BlockType(64, 0);

    public static final BlockType LADDER = new BlockType(65, 0);

    public static final BlockType RAIL = new BlockType(66, 0);

    public static final BlockType COBBLESTONE_STAIRS = new BlockType(67, 0);

    public static final BlockType WALL_MOUNTED_SIGN_BLOCK = new BlockType(68, 0);

    public static final BlockType LEVER = new BlockType(69, 0);

    public static final BlockType STONE_PRESSURE_PLATE = new BlockType(70, 0);

    public static final BlockType IRON_DOOR_BLOCK = new BlockType(71, 0);

    public static final BlockType WOODEN_PRESSURE_PLATE = new BlockType(72, 0);

    public static final BlockType REDSTONE_ORE = new BlockType(73, 0);

    public static final BlockType GLOWING_REDSTONE_ORE = new BlockType(74, 0);

    public static final BlockType REDSTONE_TORCH_OFF = new BlockType(75, 0);

    public static final BlockType REDSTONE_TORCH_ON = new BlockType(76, 0);

    public static final BlockType STONE_BUTTON = new BlockType(77, 0);

    public static final BlockType SNOW = new BlockType(78, 0);

    public static final BlockType ICE = new BlockType(79, 0);

    public static final BlockType SNOW_BLOCK = new BlockType(80, 0);

    public static final BlockType CACTUS = new BlockType(81, 0);

    public static final BlockType CLAY = new BlockType(82, 0);

    public static final BlockType SUGAR_CANES = new BlockType(83, 0);

    public static final BlockType JUKEBOX = new BlockType(84, 0);

    public static final BlockType OAK_FENCE = new BlockType(85, 0);

    public static final BlockType PUMPKIN = new BlockType(86, 0);

    public static final BlockType NETHERRACK = new BlockType(87, 0);

    public static final BlockType SOUL_SAND = new BlockType(88, 0);

    public static final BlockType GLOWSTONE = new BlockType(89, 0);

    public static final BlockType NETHER_PORTAL = new BlockType(90, 0);

    public static final BlockType JACK_O_LANTERN = new BlockType(91, 0);

    public static final BlockType CACKE_BLOCK = new BlockType(92, 0);

    public static final BlockType REDSTONE_REPEATER_OFF = new BlockType(93, 0);

    public static final BlockType REDSTONE_REPEATER_ON = new BlockType(94, 0);

    public static final BlockType WHITE_STAINED_GLASS = new BlockType(95, 0);
    public static final BlockType ORANGE_STAINED_GLASS = new BlockType(95, 1);
    public static final BlockType MAGENTA_STAINED_GLASS = new BlockType(95, 2);
    public static final BlockType LIGHT_BLUE_STAINED_GLASS = new BlockType(95, 3);
    public static final BlockType YELLOW_STAINED_GLASS = new BlockType(95, 4);
    public static final BlockType LIME_STAINED_GLASS = new BlockType(95, 5);
    public static final BlockType PINK_STAINED_GLASS = new BlockType(95, 6);
    public static final BlockType GRAY_STAINED_GLASS = new BlockType(95, 7);
    public static final BlockType LIGHT_GRAY_STAINED_GLASS = new BlockType(95, 8);
    public static final BlockType CYAN_STAINED_GLASS = new BlockType(95, 9);
    public static final BlockType PURPLE_STAINED_GLASS = new BlockType(95, 10);
    public static final BlockType BLUE_STAINED_GLASS = new BlockType(95, 11);
    public static final BlockType BROWN_STAINED_GLASS = new BlockType(95, 12);
    public static final BlockType RED_STAINED_GLASS = new BlockType(95, 13);
    public static final BlockType GREEN_STAINED_GLASS = new BlockType(95, 14);
    public static final BlockType BLACK_STAINED_GLASS = new BlockType(95, 15);

}
