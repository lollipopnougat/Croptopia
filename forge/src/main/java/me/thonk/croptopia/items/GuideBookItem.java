package me.thonk.croptopia.items;

import me.thonk.croptopia.CroptopiaForge;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
//import vazkii.patchouli.api.PatchouliAPI;

public class GuideBookItem extends Item {


    public GuideBookItem(Item.Properties properties) {
        super(properties);
    }


    /*@Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getHeldItem(hand);

        if (user instanceof ServerPlayerEntity && CroptopiaForge.patchouli.isLoaded()) {
            ServerPlayerEntity player = (ServerPlayerEntity) user;
            PatchouliAPI.get().openBookGUI(player, ForgeRegistries.ITEMS.getKey(this));
        }

        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }*/

}
