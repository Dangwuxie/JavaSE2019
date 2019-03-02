package Day03.Test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

//例子：停车场停车
interface Car{
    void carStop();
}
class StopCar{
    public void stopCar(Car car){
        car.carStop();
    }
}
class XiaoJiaoChe implements Car{
    @Override
    public void carStop() {
        System.out.println("停个小轿车");
    }
}
class DaZhunChe implements Car{
    @Override
    public void carStop() {
        System.out.println("停个大众车");
    }
}
class MotorCar implements Car{
    @Override
    public void carStop() {
        System.out.println("停个摩托车");
    }
}
class GongJiaoChe implements Car{
    @Override
    public void carStop() {
        System.out.println("停个公交车");
    }
}
public class Test8 {
    public static void main(String[] args) {
        StopCar stopCar = new StopCar();
        stopCar.stopCar(new XiaoJiaoChe());
        stopCar.stopCar(new DaZhunChe());
        stopCar.stopCar(new MotorCar());
        stopCar.stopCar(new GongJiaoChe());
    }
}
