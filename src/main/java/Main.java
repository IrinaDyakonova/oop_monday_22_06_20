import lib.Injector;
import service.CarDoorService;
import service.CarService;
import service.CarWheelService;

public class Main {
    private static Injector injector = Injector.getInstance("");
    private static CarDoorService movieService
            = (CarDoorService) injector.getInstance(CarDoorService.class);
    private static CarService movieSessionService
            = (CarService) injector.getInstance(CarService.class);
    private static CarWheelService cinemaHallService
            = (CarWheelService) injector.getInstance(CarWheelService.class);

    public static void main(String[] args) {

    }
}
