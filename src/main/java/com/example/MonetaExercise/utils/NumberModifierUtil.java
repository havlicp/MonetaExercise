package com.example.MonetaExercise.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class NumberModifierUtil {
    private static final Logger logger = LoggerFactory.getLogger(NumberModifierUtil.class);

    public static Long modifyNumber(Long number) {
        try {
            Long modifiedNumber = number;
            modifiedNumber = moveDigitsOnePositionRight(modifiedNumber);
            modifiedNumber = multiplyDigits(modifiedNumber, 2, Arrays.asList(8, 9));
            modifiedNumber = deleteDigit(modifiedNumber, 7);
            modifiedNumber = divideNumberByEvenDigits(modifiedNumber);
            return modifiedNumber;
        } catch (NumberFormatException ex) {
            logger.error("Cannot modify number: " + number + ". The number is too large.", ex);
            return -1L;
        }

    }


    /**
     * Moves all digits less than or equal to 3 one position to the right.
     *
     * @param number the number
     * @return the long
     */
    public static Long moveDigitsOnePositionRight(Long number) {
        char [] numberInCharArray = String.valueOf(number).toCharArray();
        for (int i = numberInCharArray.length - 2; i >= 0; i--) {
            if (Character.getNumericValue(numberInCharArray[i]) <= 3) {
                char tmp = numberInCharArray[i];
                numberInCharArray[i] = numberInCharArray[i+1];
                numberInCharArray[i+1] = tmp;
            }
        }
        return Long.parseLong(new String(numberInCharArray));
    }

    /**
     * Multiplies digitsToMultiply by multiplier and returns whole number with multiplied digits.
     *
     * @param number           the number
     * @param multiplier       the multiplier
     * @param digitsToMultiply the digits to multiply
     * @return the long
     */
    public static Long multiplyDigits(Long number, int multiplier, List<Integer> digitsToMultiply) {
        char [] numberInCharArray = String.valueOf(number).toCharArray();
        StringBuilder multipliedNumber = new StringBuilder();
        for (char ch : numberInCharArray) {
            int digit = Character.getNumericValue(ch);
            if (digitsToMultiply.contains(digit)) {
                digit *= multiplier;
                multipliedNumber.append(digit);
            } else {
                multipliedNumber.append(ch);
            }
        }
        return Long.parseLong(multipliedNumber.toString());
    }

    /**
     * Deletes digitToDelete from number.
     *
     * @param number        the number
     * @param digitToDelete the digit to delete
     * @return the long
     */
    public static Long deleteDigit(Long number, int digitToDelete) {
        char [] numberInCharArray = String.valueOf(number).toCharArray();
        StringBuilder multipliedNumber = new StringBuilder();
        for (char ch : numberInCharArray) {
            int digit = Character.getNumericValue(ch);
            if (digit != digitToDelete) {
                multipliedNumber.append(ch);
            }
        }
        if (multipliedNumber.length() == 0) {
            return 0L;
        } else {
            return Long.parseLong(multipliedNumber.toString());
        }
    }

    public static Long divideNumberByEvenDigits(Long number) {
        int evenNumbers = evenNumbersCount(number);
        if (evenNumbers > 0) {
            return number / evenNumbers;
        }
        return number;
    }

    public static int evenNumbersCount(Long number) {
        char [] numberInCharArray = String.valueOf(number).toCharArray();
        int evenNumbers = 0;
        for (char ch : numberInCharArray) {
            if (Character.getNumericValue(ch) % 2 == 0) {
                evenNumbers++;
            }
        }
        return evenNumbers;
    }
}
