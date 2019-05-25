package by.bsuir.logic;

import org.apache.log4j.Logger;

public class Manipulations {
    private static final Manipulations INSTANCE = new Manipulations();
    private static final Logger logger = Logger.getLogger(Manipulations.class);

    private Manipulations() {}

    public static Manipulations getInstance() {
        logger.info("Got INSTANCE");
        return INSTANCE;
    }

    public boolean isIsoscelesTriangle(int a, int b, int c) {
        logger.info("boolean isIsoscelesTriangle works");

        return (a == b || b == c || a == c) ? true : false;
    }

    public boolean isEquilateralTriangle(int a, int b, int c) {
        logger.info("boolean isEquilateralTriangle works");

        return (a == b && b == c) ? true : false;
    }

    public boolean isRightTriangle(int a, int b, int c) {
        logger.info("boolean isRightTriangle works");

        if ((c * c) == ((a * a) + (b * b))) {
            return true;
        } else if ((b * b) == ((a * a) + (c * c))) {
            return true;
        } else if ((a * a) == ((b * b) + (c * c))) {
            return true;
        } else {
            return false;
        }
    }

//    public int convert(MyFunctional myFunctional, int number) {
//        int mod, bin = 0;
//
//        while (number != 0)
//        {
//            mod = number % 2;
//            number /= 2;
//
//            bin = 10*bin+mod;
//        }
//
//        return number;
//    }
}
