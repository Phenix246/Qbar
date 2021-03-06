package net.qbar.common.init;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.qbar.QBar;
import net.qbar.common.block.BlockAssembler;
import net.qbar.common.block.BlockBase;
import net.qbar.common.block.BlockBelt;
import net.qbar.common.block.BlockBoiler;
import net.qbar.common.block.BlockExtractor;
import net.qbar.common.block.BlockFluidPipe;
import net.qbar.common.block.BlockFluidPump;
import net.qbar.common.block.BlockKeypunch;
import net.qbar.common.block.BlockMachineBase;
import net.qbar.common.block.BlockOffshorePump;
import net.qbar.common.block.BlockSteamPipe;
import net.qbar.common.block.BlockTank;
import net.qbar.common.multiblock.TileMultiblockGag;
import net.qbar.common.tile.TileAssembler;
import net.qbar.common.tile.TileBelt;
import net.qbar.common.tile.TileBoiler;
import net.qbar.common.tile.TileExtractor;
import net.qbar.common.tile.TileFluidPipe;
import net.qbar.common.tile.TileFluidPump;
import net.qbar.common.tile.TileKeypunch;
import net.qbar.common.tile.TileOffshorePump;
import net.qbar.common.tile.TileSteamPipe;
import net.qbar.common.tile.TileTank;

@ObjectHolder(QBar.MODID)
public class QBarBlocks
{
    @ObjectHolder("keypunch")
    public static final BlockMachineBase PUNCHING_MACHINE = null;
    @ObjectHolder("tank")
    public static final BlockMachineBase FLUID_TANK       = null;
    @ObjectHolder("boiler")
    public static final BlockMachineBase SOLID_BOILER     = null;
    @ObjectHolder("fluidpipe")
    public static final BlockMachineBase FLUID_PIPE       = null;
    @ObjectHolder("steampipe")
    public static final BlockMachineBase STEAM_PIPE       = null;
    @ObjectHolder("fluidpump")
    public static final BlockMachineBase FLUID_PUMP       = null;
    @ObjectHolder("offshorepump")
    public static final BlockMachineBase OFFSHORE_PUMP    = null;
    @ObjectHolder("assembler")
    public static final BlockMachineBase ASSEMBLER        = null;

    @ObjectHolder("belt")
    public static final BlockMachineBase BELT             = null;
    @ObjectHolder("itemextractor")
    public static final BlockMachineBase ITEM_EXTRACTOR   = null;

    public static final void registerBlocks()
    {
        QBarBlocks.registerBlock(new BlockKeypunch());
        QBarBlocks.registerBlock(new BlockTank());
        QBarBlocks.registerBlock(new BlockBoiler());
        QBarBlocks.registerBlock(new BlockFluidPipe());
        QBarBlocks.registerBlock(new BlockSteamPipe());
        QBarBlocks.registerBlock(new BlockFluidPump());
        QBarBlocks.registerBlock(new BlockOffshorePump());
        QBarBlocks.registerBlock(new BlockAssembler());

        QBarBlocks.registerBlock(new BlockBelt());
        QBarBlocks.registerBlock(new BlockExtractor());

        QBarBlocks.registerTile(TileTank.class, "tank");
        QBarBlocks.registerTile(TileKeypunch.class, "keypunch");
        QBarBlocks.registerTile(TileBoiler.class, "boiler");
        QBarBlocks.registerTile(TileFluidPipe.class, "fluidpipe");
        QBarBlocks.registerTile(TileSteamPipe.class, "steampipe");
        QBarBlocks.registerTile(TileFluidPump.class, "fluidpump");
        QBarBlocks.registerTile(TileOffshorePump.class, "offshore_pump");
        QBarBlocks.registerTile(TileAssembler.class, "assembler");
        QBarBlocks.registerTile(TileBelt.class, "belt");
        QBarBlocks.registerTile(TileExtractor.class, "itemextractor");
        QBarBlocks.registerTile(TileMultiblockGag.class, "multiblockgag");
    }

    public static final void registerBlock(final Block block, final String name)
    {
        final ItemBlock itemBlock = new ItemBlock(block);

        GameRegistry.register(block.setRegistryName(QBar.MODID, name));
        GameRegistry.register(itemBlock, block.getRegistryName());

        QBar.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    public static final void registerBlock(final BlockBase block)
    {
        QBarBlocks.registerBlock(block, block.name);
    }

    public static final void registerBlock(final BlockMachineBase block)
    {
        QBarBlocks.registerBlock(block, block.name);
    }

    public static final void registerTile(final Class<? extends TileEntity> c, final String name)
    {
        GameRegistry.registerTileEntity(c, QBar.MODID + ":" + name);
    }
}