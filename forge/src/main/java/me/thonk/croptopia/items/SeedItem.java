package me.thonk.croptopia.items;

import me.thonk.croptopia.blocks.CroptopiaCropBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Locale;

public class SeedItem extends ItemNameBlockItem {

    private Biome.BiomeCategory category;

    public SeedItem(Block block, Item.Properties settings, Biome.BiomeCategory category) {
        super(block, settings);
        ((CroptopiaCropBlock) block).setSeed(this);
        this.category = category;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos hitPos = context.getClickedPos();
        Level world = context.getLevel();
        BlockState state = world.getBlockState(hitPos);
        if (state.is(Blocks.FARMLAND)) {
            return super.useOn(context);
        }
        return InteractionResult.FAIL;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(new TranslatableComponent("info.croptopia.seed").setStyle(Style.EMPTY.applyFormat(ChatFormatting.GRAY)).append(" ").append(category.getName().toLowerCase(Locale.ROOT)));
    }

    public Biome.BiomeCategory getCategory() {
        return category;
    }
}
