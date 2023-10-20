package src;
import java.util.logging.Logger;
public class ComplexCalculator {
    private Logger logger;

    public ComplexCalculator(Logger logger) {
        this.logger = logger;
    }

    public Complex add(Complex a, Complex b) {
        double real = a.getReal() + b.getReal();
        double imag = a.getImaginary() + b.getImaginary();
        Complex result = new Complex(real, imag);
        logger.info("Addition:" + a + " + " + b + " = " + result);
        return result;
    }

    public Complex multiply(Complex a, Complex b) {
        double real = a.getReal() * b.getReal() - a.getImaginary() * b.getImaginary();
        double imag = a.getReal() * b.getImaginary() + a.getImaginary() * b.getReal();
        Complex result = new Complex(real, imag);
        logger.info("Multiplication: " + a + " * " + b + " = " + result);
        return result;
    }

    public Complex divide(Complex a, Complex b) {
        double denominator = b.getReal() * b.getReal() + b.getImaginary() * b.getImaginary();
        double real = (a.getReal() * b.getReal() + a.getImaginary() * b.getImaginary()) / denominator;
        double imag = (a.getImaginary() * b.getReal() - a.getReal() * b.getImaginary()) / denominator;
        Complex result = new Complex(real, imag);
        logger.info("Division: " + a + " / " + b + " = " + result);
        return result;
    }

    public int getResult(int result) {
        return result;
    }

}
