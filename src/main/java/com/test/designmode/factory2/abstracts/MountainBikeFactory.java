package com.test.designmode.factory2.abstracts;

/**
 * @author 老肥猪
 * @since 2019/3/4
 */
public class MountainBikeFactory implements IBikeFactory {
    @Override
    public IBike getCar() {
        return new MountainBike();
    }

    @Override
    public IVehicleWheel getVehicleWheel() {
        return new MountainVenicleWheel();
    }
}
