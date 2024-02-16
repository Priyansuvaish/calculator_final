package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class calculator {

    private static final Logger logger = LogManager.getLogger(calculator.class);

    public static double fact(double number1) {
        if (number1 < 0.0) {
            logger.error("invalid data");
            return Double.NaN;
        } else {
            logger.info("[FACTORIAL] - " + number1);
            double fact = 1.0;

            for(int i = 2; (double)i <= number1; ++i) {
                fact *= (double)i;
            }

            logger.info("[RESULT - FACTORIAL] - " + fact);
            return fact;
        }
    }

    public static double sqroot(double number1) {
        if (number1 < 0.0) {
            logger.error("invalid data");
        }

        logger.info("[SQ ROOT] - " + number1);
        double result = Math.sqrt(number1);
        logger.info("[RESULT - SQ ROOT] - " + result);
        return result;
    }

    public static double power(double number1, double number2) {
        if (number1 <= 0.0) {
            logger.error("invalid data");
        }

        logger.info("[POWER - " + number1 + " RAISED TO] " + number2);
        double result = Math.pow(number1, number2);
        logger.info("[RESULT - POWER] - " + result);
        return result;
    }

    public static double naturalLog(double number1) {
        if (number1 < 0.0) {
            logger.error("invalid data");
        }

        logger.info("[NATURAL LOG] - " + number1);
        double result = 0.0;

        try {
            if (number1 < 0.0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }

            result = Math.log(number1);
        } catch (ArithmeticException var6) {
            System.out.println("[EXCEPTION - LOG] - Cannot find log of negative numbers " + var6.getLocalizedMessage());
        }

        logger.info("[RESULT - NATURAL LOG] - " + result);
        return result;
    }

    public static void main(String[] args) {

        calculator c=new calculator();
        Scanner scanner = new Scanner(System.in);
        double number1, number2;
        do {
            System.out.println("calculatordev_project, Choose to perform operation");
            System.out.print("Type 1 to find factorial\nType 2 to find Square root\nType 3 to find power\nType 4 to find natural logarithm\n" +
                    "Type any other digit to exit\nEnter the type of operation: ");
            int ch;
            try {
                ch = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            switch (ch) {
                case 1:
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Factorial of "+number1+" is : " + c.fact(number1));
                    System.out.println("\n");

                    break;
                case 2:
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Square root of "+number1+" is : " + c.sqroot(number1));
                    System.out.println("\n");


                    break;
                case 3:
                    // find power of entered numbers
                    System.out.print("Enter the first number : ");
                    number1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    number2 = scanner.nextDouble();
                    System.out.println(number1+ " raised to power "+number2+" is : " + c.power(number1, number2));
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Natural log of "+number1+" is : " + c.naturalLog(number1));
                    System.out.println("\n");

                    break;
                default:
                    System.out.println("Exiting....");
                    return;
            }
        } while (true);

    }
}