package com.test.designmode.factory2.abstracts;

/**
 * @author 老肥猪
 * @since 2019/3/2
 * msg:
 */
public interface IBikeFactory {
    IBike getCar();

    IVehicleWheel getVehicleWheel();
}
