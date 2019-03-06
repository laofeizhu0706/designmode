package com.test.designmode.factory2.simagle;

/**
 * @author 老肥猪
 * @since 2019/3/4
 */
public class Factory {

    public ICar getCarByType(CarType type) {
        switch (type) {
            case BMW: return new BMWCar();
            case JEEP: return new JeepCar();
            default:return null;
        }
    }
}
