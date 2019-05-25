package by.bsuir.validation;

import static by.bsuir.Constants.*;

public class Validator {
    private static final Validator INSTANCE = new Validator();
    private Validator() {}

    public static Validator getInstance() {
        return INSTANCE;
    }

    public boolean checkSubStrings(String side1, String side2, String side3) {
        int counter = 0;

        if(side1.equals(KEY_SIDE_1)) {
            counter++;
            if(side2.equals(KEY_SIDE_2)) {
                counter++;
                if(side3.equals(KEY_SIDE_3)) {
                    counter++;
                }
            }
        }


        return counter == 3;
    }
}
