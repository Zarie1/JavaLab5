import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Абстрактний клас, який описує базову інформацію для вагонів потягу.
 * Всі типи вагонів повинні успадковувати цей клас.
 */
abstract class Vagon {
    protected int passengers; // Кількість пасажирів у вагоні
    protected int luggage;    // Кількість багажу у вагоні
    protected int comfortLevel; // Рівень комфортності вагона

    /**
     * Конструктор для створення об'єкта типу TrainCar.
     *
     * @param passengers кількість пасажирів у вагоні
     * @param luggage кількість одиниць багажу у вагоні
     * @param comfortLevel рівень комфортності вагона
     */
    public Vagon(int passengers, int luggage, int comfortLevel) {
        this.passengers = passengers;
        this.luggage = luggage;
        this.comfortLevel = comfortLevel;
    }

    /**
     * Метод для отримання кількості пасажирів у вагоні.
     *
     * @return кількість пасажирів
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Метод для отримання кількості багажу в вагоні.
     *
     * @return кількість одиниць багажу
     */
    public int getLuggage() {
        return luggage;
    }

    /**
     * Метод для отримання рівня комфортності вагона.
     *
     * @return рівень комфортності
     */
    public int getComfortLevel() {
        return comfortLevel;
    }

    /**
     * Абстрактний метод для виведення інформації про вагон.
     * Повинен бути реалізований у кожному з нащадків.
     */
    public abstract void printDetails();
}

/**
 * Клас для пасажирського вагона.
 * Наслідує абстрактний клас TrainCar та реалізує метод printDetails.
 */
class PassengerCar extends Vagon {

    /**
     * Конструктор для створення пасажирського вагона.
     *
     * @param passengers кількість пасажирів у вагоні
     * @param luggage кількість одиниць багажу в вагоні
     * @param comfortLevel рівень комфортності вагона
     */
    public PassengerCar(int passengers, int luggage, int comfortLevel) {
        super(passengers, luggage, comfortLevel);
    }

    /**
     * Виводить інформацію про пасажирський вагон.
     */
    @Override
    public void printDetails() {
        System.out.println("Пасажирський вагон: " + passengers + " пасажирів, " + luggage + " одиниць багажу, комфортність: " + comfortLevel);
    }
}

/**
 * Клас для багажного вагона.
 * Наслідує абстрактний клас TrainCar та реалізує метод printDetails.
 */
class BaggageCar extends Vagon {

    /**
     * Конструктор для створення багажного вагона.
     *
     * @param passengers кількість пасажирів у вагоні
     * @param luggage кількість одиниць багажу в вагоні
     * @param comfortLevel рівень комфортності вагона
     */
    public BaggageCar(int passengers, int luggage, int comfortLevel) {
        super(passengers, luggage, comfortLevel);
    }

    /**
     * Виводить інформацію про багажний вагон.
     */
    @Override
    public void printDetails() {
        System.out.println("Багажний вагон: " + passengers + " пасажирів, " + luggage + " одиниць багажу, комфортність: " + comfortLevel);
    }
}

/**
 * Клас для люксового вагона.
 * Наслідує абстрактний клас TrainCar та реалізує метод printDetails.
 */
class LuxuryCar extends Vagon {

    /**
     * Конструктор для створення люксового вагона.
     *
     * @param passengers кількість пасажирів у вагоні
     * @param luggage кількість одиниць багажу в вагоні
     * @param comfortLevel рівень комфортності вагона
     */
    public LuxuryCar(int passengers, int luggage, int comfortLevel) {
        super(passengers, luggage, comfortLevel);
    }

    /**
     * Виводить інформацію про люксовий вагон.
     */
    @Override
    public void printDetails() {
        System.out.println("Люксовий вагон: " + passengers + " пасажирів, " + luggage + " одиниць багажу, комфортність: " + comfortLevel);
    }
}

/**
 * Клас для потягу, який містить колекцію вагонів та методи для виконання різних операцій з вагонами.
 */
class Train {
    private List<Vagon> cars;

    /**
     * Конструктор для створення порожнього потягу.
     */
    public Train() {
        cars = new ArrayList<>();
    }

    /**
     * Додає вагон до потягу.
     *
     * @param car об'єкт вагону, який додається до потягу
     */
    public void addCar(Vagon car) {
        cars.add(car);
    }

    /**
     * Підраховує загальну кількість пасажирів у всіх вагонах потягу.
     *
     * @return загальна кількість пасажирів
     */
    public int totalPassengers() {
        int total = 0;
        for (Vagon car : cars) {
            total += car.getPassengers();
        }
        return total;
    }

    /**
     * Підраховує загальну кількість багажу в усіх вагонах потягу.
     *
     * @return загальна кількість одиниць багажу
     */
    public int totalLuggage() {
        int total = 0;
        for (Vagon car : cars) {
            total += car.getLuggage();
        }
        return total;
    }

    /**
     * Сортує вагони за рівнем комфортності від найвищого до найнижчого.
     */
    public void sortCarsByComfort() {
        cars.sort(Comparator.comparingInt(Vagon::getComfortLevel).reversed());
    }

    /**
     * Знаходить вагони в потягу, де кількість пасажирів знаходиться в заданому діапазоні.
     *
     * @param min мінімальна кількість пасажирів
     * @param max максимальна кількість пасажирів
     */
    public void findCarsByPassengerRange(int min, int max) {
        for (Vagon car : cars) {
            if (car.getPassengers() >= min && car.getPassengers() <= max) {
                car.printDetails();
            }
        }
    }

    /**
     * Виводить інформацію про всі вагони потягу.
     */
    public void printAllCars() {
        for (Vagon car : cars) {
            car.printDetails();
        }
    }
}

/**
 * Головний клас для запуску програми та взаємодії з користувачем.
 */
public class SpidVagon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Створюємо потяг
        Train train = new Train();

        // Додаємо кілька вагонів до потягу
        train.addCar(new PassengerCar(100, 50, 3)); // Пасажирський вагон
        train.addCar(new BaggageCar(0, 200, 1));   // Багажний вагон
        train.addCar(new LuxuryCar(20, 10, 5));     // Люксовий вагон

        // Виводимо всі вагони
        System.out.println("Інформація про всі вагони:");
        train.printAllCars();

        // Підраховуємо загальну кількість пасажирів та багажу
        System.out.println("Загальна кількість пасажирів: " + train.totalPassengers());
        System.out.println("Загальна кількість багажу: " + train.totalLuggage());

        // Сортуємо вагони за рівнем комфортності
        train.sortCarsByComfort();
        System.out.println("\nВагони після сортування за комфортністю:");
        train.printAllCars();

        // Пошук вагонів за діапазоном кількості пасажирів
        System.out.print("\nВведіть мінімальну кількість пасажирів: ");
        int min = scanner.nextInt();
        System.out.print("Введіть максимальну кількість пасажирів: ");
        int max = scanner.nextInt();
        System.out.println("\nВагони з кількістю пасажирів у діапазоні від " + min + " до " + max + ":");
        train.findCarsByPassengerRange(min, max);
    }
}
