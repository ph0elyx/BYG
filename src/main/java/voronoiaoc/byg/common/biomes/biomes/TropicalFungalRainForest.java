package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.sound.MoodSoundAmbience;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.HashMap;
import java.util.Random;

public class TropicalFungalRainForest extends Biome implements BiomeTools  {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("tropical_fungal_rainforest", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
    static final RainType PRECIPATATION = RainType.RAIN;
    static final Category CATEGORY = Category.JUNGLE;
    static final float DEPTH = 0.2F;
    static final float SCALE = 0.25F;
    static final float TEMPERATURE = 0.95F;
    static final float DOWNFALL = 0.9F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 10145074;
    static final int FOLIAGE_COLOR = 10145074;
    static final String PARENT = null;
    static final Climate WEATHER = new Climate(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).func_242517_a(SURFACE_BUILDER);

    public TropicalFungalRainForest() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).func_242541_f(GRASS_COLOR).func_242540_e(FOLIAGE_COLOR).func_242539_d(BiomeHelper.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.field_235027_b_).build(), GENERATION_SETTINGS.func_242508_a(), SPAWN_SETTINGS.func_242577_b());
    }


    @Override
    public HashMap<Biome, Integer> getHills() {
        HashMap<Biome, Integer> map = new HashMap<>();
        map.put(BYGBiomeList.TROPICALFUNGALRAINFORESTHILLS, 1);
        map.put(BYGBiomeList.FUNGAL_PATCH, 2);
        map.put(BYGBiomeList.FRESHWATERLAKE, 1);
        return map;
    }


    public Biome randomSubBiome(Random random) {
        int randomPicker = random.nextInt(4);
        if (randomPicker == 0)
            return BYGBiomeList.TROPICALFUNGALRAINFORESTHILLS;
        else if (randomPicker == 1)
            return BYGBiomeList.FUNGAL_PATCH;
        else if (randomPicker == 2)
            return BYGBiomeList.FUNGAL_PATCH;
        else
            return BYGBiomeList.FRESHWATERLAKE;
    }

    static {
        DefaultBiomeFeatures.func_243733_b(GENERATION_SETTINGS);
        //this.add//StructureFeature(DefaultBiomeFeatures.JUNGLE_PYRAMID);
        DefaultBiomeFeatures.func_243738_d(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243746_h(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243748_i(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243750_j(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243754_n(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243708_V(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243712_Z(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243717_aa(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243727_ak(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243719_ac(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243730_an(GENERATION_SETTINGS);
        BYGTreeFeatures.addFungalRainForestTrees(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243712_Z(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243712_Z(GENERATION_SETTINGS);
        BYGFeatures.addTropFungalMushrooms(GENERATION_SETTINGS);
        BYGFeatures.addWeedGrass(GENERATION_SETTINGS);
        BYGFeatures.addGrass(GENERATION_SETTINGS);
        BYGFeatures.addBYGTropicFlowers(GENERATION_SETTINGS);
        BYGFeatures.addBYGMushrooms(GENERATION_SETTINGS);

        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PARROT, 40, 1, 2));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.OCELOT, 2, 1, 1));

    }
}

