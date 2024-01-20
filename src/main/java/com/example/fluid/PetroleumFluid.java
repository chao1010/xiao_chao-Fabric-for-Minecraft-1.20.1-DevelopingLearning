package com.example.fluid;

import com.example.registry.ModBlocks;
import com.example.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class PetroleumFluid extends FlowableFluid {

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_Petroleum;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.Petroleum;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.PETROLEUM_BUCKET;
    }

    @Override
    public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        if (!state.isStill() && !state.get(FALLING).booleanValue()) {
            if (random.nextInt(64) == 0) {
                world.playSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25f + 0.75f, random.nextFloat() + 0.5f, false);
            }
        } else if (random.nextInt(10) == 0) {
            world.addParticle(ParticleTypes.UNDERWATER, (double)pos.getX() + random.nextDouble(), (double)pos.getY() + random.nextDouble(), (double)pos.getZ() + random.nextDouble(), 0.0, 0.0, 0.0);
        }
    }

    @Override
    @Nullable
    public ParticleEffect getParticle() {
        return ParticleTypes.DRIPPING_WATER;
    }
    //无限
    @Override
    protected boolean isInfinite(World world) {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }
    //流速
    @Override
    public int getFlowSpeed(WorldView world) {
        return 2;
    }

    @Override
    public BlockState toBlockState(FluidState state) {
        return (BlockState) ModBlocks.PETROLEUM.getDefaultState().with(FluidBlock.LEVEL, PetroleumFluid.getBlockStateLevel(state));
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == ModFluids.Petroleum || fluid == ModFluids.FLOWING_Petroleum;
    }

    @Override
    public int getLevelDecreasePerBlock(WorldView world) {
        return 1;
    }
    //返回每流一格需要花费的时间
    @Override
    public int getTickRate(WorldView world) {
        return 20;
    }

    @Override
    public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.isIn(ModFluidTags.Petroleum);
    }
    //爆炸抗性
    @Override
    protected float getBlastResistance() {
        return 100.0f;
    }

    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ITEM_BUCKET_FILL);
    }

    public static class Flowing
            extends PetroleumFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still
            extends PetroleumFluid {
        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }
}
