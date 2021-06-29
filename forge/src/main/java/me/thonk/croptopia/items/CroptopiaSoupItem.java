package me.thonk.croptopia.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class CroptopiaSoupItem extends net.minecraft.item.SoupItem {

    public CroptopiaSoupItem(Properties builder) {
        super(builder);
    }


    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity user) {
        PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity)user : null;
        if (playerEntity != null) {
            if (!playerEntity.abilities.isCreativeMode) {
                if (isFood()) {
                    user.onFoodEaten(worldIn, stack);
                }
            }
        }

        if (playerEntity == null || !playerEntity.abilities.isCreativeMode) {
            if (stack.isEmpty()) {
                return new ItemStack(Items.BOWL);
            }

            if (playerEntity != null) {
                playerEntity.inventory.addItemStackToInventory(new ItemStack(Items.BOWL));
            }
        }

        return stack;
    }
}
