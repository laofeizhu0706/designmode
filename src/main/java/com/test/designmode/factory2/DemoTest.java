package com.test.designmode.factory2;

import com.test.designmode.factory2.abstracts.IBikeFactory;
import com.test.designmode.factory2.abstracts.MountainBikeFactory;
import com.test.designmode.factory2.abstracts.RoadWheelFactory;
import com.test.designmode.factory2.common.BikeFactory;
import com.test.designmode.factory2.common.BusFactory;
import com.test.designmode.factory2.common.Car;
import com.test.designmode.factory2.common.CarFactory;
import com.test.designmode.factory2.simagle.CarType;
import com.test.designmode.factory2.simagle.Factory;
import org.junit.Test;

/**
 * @author 老肥猪
 * @since 2019/3/2
 * msg: 工厂模式测试类
 */
public class DemoTest {

    /**
     * 简单工厂测试
     */
    @Test
    public void simagleFactoryTest() {
        Factory factory = new Factory();
        factory.getCarByType(CarType.BMW).getCar();
        factory.getCarByType(CarType.JEEP).getCar();
    }

    /**
     * 工厂模式测试
     */
    @Test
    public void commonFactoryTest() {
        CarFactory carFactory=null;
        carFactory=new BusFactory();
        Car bus = carFactory.getCar();
        bus.gotowork();
        carFactory=new BikeFactory();
        Car bike = carFactory.getCar();
        bike.gotowork();
    }

    /**
     * 抽象工厂测试
     */
    @Test
    public void abstractFactoryTest() {
        /**
         * 山地车
         */
        IBikeFactory mountainBikeFactory = new MountainBikeFactory();
        mountainBikeFactory.getCar();
        mountainBikeFactory.getVehicleWheel();
        /**
         * 公路车
         */
        IBikeFactory roadWheelFactory = new RoadWheelFactory();
        roadWheelFactory.getCar();
        roadWheelFactory.getVehicleWheel();

    }
}
