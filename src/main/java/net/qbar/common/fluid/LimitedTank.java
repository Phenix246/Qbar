package net.qbar.common.fluid;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class LimitedTank extends FluidTank
{
    private final String name;
    private final int    transferCapacity;

    public LimitedTank(final String name, final int capacity, final int transferCapacity)
    {
        super(capacity);

        this.name = name;
        this.transferCapacity = transferCapacity;
    }

    @Override
    public int fillInternal(final FluidStack resource, final boolean doFill)
    {
        resource.amount = Math.min(resource.amount, this.transferCapacity);
        return super.fillInternal(resource, doFill);
    }

    @Override
    public FluidStack drainInternal(final int maxDrain, final boolean doDrain)
    {
        return super.drainInternal(Math.min(maxDrain, this.transferCapacity), doDrain);
    }

    public Fluid getFluidType()
    {
        if (this.getFluid() != null)
            return this.getFluid().getFluid();
        return null;
    }
}
