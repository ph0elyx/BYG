package voronoiaoc.byg.common.biomes.netherbiome;

import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.MoodSoundAmbience;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class WarpedDesert extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("warped_desert", new ConfiguredSurfaceBuilder<>(BYGSBList.WARPEDDESERT_SB, BYGSBList.BYGSBConfigList.WARPEDDESERT));
    static final RainType PRECIPATATION = RainType.RAIN;
    static final Category CATEGORY = Category.NETHER;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Climate WEATHER = new Climate(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).func_242517_a(SURFACE_BUILDER);

    public WarpedDesert() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR)
                .setFogColor(1705242)
                .func_242539_d(BiomeHelper.calcSkyColor(2.0F))
                .particleConfig(new BiomeParticleConfig(ParticleTypes.WARPED_SPORE, 0.01428F))
                .loopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP)
                .setMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                .music(MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_SOUL_SAND_VALLEY)).build(), GENERATION_SETTINGS.func_242508_a(), SPAWN_SETTINGS.func_242577_b());

    }

    static {
        GENERATION_SETTINGS.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_field_235027_b_);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_CLOSED);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_LAVA);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, ConfiguredFeatures.PATCH_FIRE);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE_EXTRA);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, ConfiguredFeatures.BROWN_MUSHROOM_NETHER);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, ConfiguredFeatures.RED_MUSHROOM_NETHER);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_MAGMA);
        BYGFeatures.addWarpedVegetation(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addNetherMineables(GENERATION_SETTINGS);

        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.GHAST, 50, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.MAGMA_CUBE, 2, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 1, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.PIGLIN, 15, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.STRIDER, 60, 1, 2));

    }
}
