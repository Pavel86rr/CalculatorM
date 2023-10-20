package src;

import java.util.Scanner;

import java.util.logging.Logger;

public class ViewCalculator {
    Logger logger = Logger.getLogger(Main.class.getName());

    private final ICalculableFactopy calculableFactory;

    public ViewCalculator(ICalculableFactopy calculableFactory) {

        this.calculableFactory = calculableFactory;
    }

    public void run1() {

        while (true) {
            int  real1 = promptInt("Введите часть real первoго аргумента: ");
            int  imaginary1 = promptInt("Введите imaginary часть  первoго аргумента: ");
            Complex a = new Complex(real1,imaginary1);
            ComplexCalculator calculator = new ComplexCalculator(logger);

            while (true) {
                String cmd = prompt("Введите команду (*, +, /) : ");
                if (cmd.equals("*")) {
                    int  real2 = promptInt("Введите часть real вторoго аргумента: ");
                    int  imaginary2 = promptInt("Введите imaginary часть  вторoго аргумента: ");
                    Complex b = new Complex(real2,imaginary2);
                    Complex product = calculator.multiply(a, b);
                    continue;
                }
                if (cmd.equals("+")) {
                    int  real2 = promptInt("Введите часть real вторoго аргумента: ");
                    int  imaginary2 = promptInt("Введите imaginary часть  вторoго аргумента: ");
                    Complex b = new Complex(real2,imaginary2);
                    Complex sum = calculator.add(a, b);
                    continue;
                }
                if (cmd.equals("/")) {
                    int  real2 = promptInt("Введите часть real вторoго аргумента: ");
                    int  imaginary2 = promptInt("Введите imaginary часть  вторoго аргумента: ");
                    Complex b = new Complex(real2,imaginary2);
                    Complex quotient = calculator.divide(a, b);
                    break;
                }

            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }
    public void run2() {
        while (true) {
            int primaryArg = promptInt("Введите первый аргумент: ");
            Calculable calculator = calculableFactory.create(primaryArg, true);
            while (true) {
                String cmd = prompt("Введите команду (*, +, =) : ");
                if (cmd.equals("*")) {
                    int arg = promptInt("Введите второй аргумент: ");
                    calculator.multi(arg);
                    continue;
                }
                if (cmd.equals("+")) {
                    int arg = promptInt("Введите второй аргумент: ");
                    calculator.sum(arg);
                    continue;
                }
                if (cmd.equals("=")) {
                    int result = calculator.getResult();
                    System.out.printf("Результат %d\n", result);
                    break;
                }
            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }
}