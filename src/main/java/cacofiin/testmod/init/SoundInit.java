package cacofiin.testmod.init;

import cacofiin.testmod.TestMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, TestMod.MOD_ID);

    public static final Lazy<SoundEvent> LAZY_SEPTEMBER_MUSIC = Lazy.of(() -> new SoundEvent(new ResourceLocation(TestMod.MOD_ID, "disc.september")));

    public static final RegistryObject<SoundEvent> lazy_september_music = SOUNDS.register("september_music", LAZY_SEPTEMBER_MUSIC);
}
