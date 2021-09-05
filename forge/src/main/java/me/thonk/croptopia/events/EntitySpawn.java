package me.thonk.croptopia.events;

import me.thonk.croptopia.registry.ItemRegistry;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntitySpawn {


    @SubscribeEvent
    public void onEntitySpawn(LivingSpawnEvent.SpecialSpawn event) {
        if (event.getEntityLiving() instanceof Mob mob) {
            if (mob instanceof Pig) {
                mob.goalSelector.addGoal(4, new TemptGoal((PathfinderMob) mob, 1.2D, Ingredient.of(ItemRegistry.yam, ItemRegistry.sweetPotato), false));
            }

            if (mob instanceof Cow) {
                mob.goalSelector.addGoal(3, new TemptGoal((PathfinderMob) mob, 1.25D, Ingredient.of(ItemRegistry.barley, ItemRegistry.corn), false));
            }
        }
    }
}
