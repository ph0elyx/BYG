package voronoiaoc.byg.common.biomes;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.placement.DecoratedPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.BYG;

public class BiomeHelper {
    public static int calcSkyColor(float f) {
        float g = f / 3.0F;
        g = MathHelper.clamp(g, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
    }

    public static ConfiguredSurfaceBuilder<?> newConfiguredSurfaceBuilder(String id, ConfiguredSurfaceBuilder<?> configuredSurfaceBuilder) {
        Registry.register(WorldGenRegistries.field_243651_c, new ResourceLocation(BYG.MOD_ID, id), configuredSurfaceBuilder);
        return configuredSurfaceBuilder;
    }

    public static <T extends DecoratedPlacementConfig, G extends Placement<T>> G newDecorator(String id, G decorator) {
        Registry.register(Registry.DECORATOR, new ResourceLocation(BYG.MOD_ID, id), decorator);
        return decorator;
    }
}
