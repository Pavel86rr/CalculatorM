package src;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, выберите калькулятор (1 - означает простой Calculator, " +
                           "0 - означает калькулятор комплексных чисел ComplexCalculator):");
        int who = scanner.nextInt();
        if (who == 1) {
            ICalculableFactopy calculableFactory = new CalculableFactory();
            ViewCalculator view2 = new ViewCalculator(calculableFactory);
            view2.run2();
        } else {
            // Создание логгера
            Logger logger = Logger.getLogger(Main.class.getName());
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.ALL);
            consoleHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(consoleHandler);

            // Создание калькулятора
            ICalculableFactopy calculableFactory = new CalculableFactory();
            ViewCalculator view1 = new ViewCalculator(calculableFactory);
            view1.run1();

        }


    }
}