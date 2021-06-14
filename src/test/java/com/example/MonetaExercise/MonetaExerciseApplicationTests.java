package com.example.MonetaExercise;

import com.example.MonetaExercise.utils.NumberModifierUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class MonetaExerciseApplicationTests {

	@Test
	void moveDigitsOnePositionRight() {
		Long num1 = 3L;
		Long num2 = 43256791L;
		Assertions.assertEquals(3L, NumberModifierUtil.moveDigitsOnePositionRight(num1));
		Assertions.assertEquals(45326791L, NumberModifierUtil.moveDigitsOnePositionRight(num2));
	}

	@Test
	void multiplyDigits() {
		Long num1 = 45326791L;
		Long num2 = 7777L;
		Assertions.assertEquals(453267181L, NumberModifierUtil.multiplyDigits(num1, 2, Arrays.asList(8, 9)));
		Assertions.assertEquals(7777L, NumberModifierUtil.multiplyDigits(num2, 2, Arrays.asList(8, 9)));
	}

	@Test
	void deleteDigit() {
		Long num1 = 453267181L;
		Long num2 = 7777L;
		Assertions.assertEquals(45326181L, NumberModifierUtil.deleteDigit(num1, 7));
		Assertions.assertEquals(0L, NumberModifierUtil.deleteDigit(num2, 7));
	}

	@Test
	void divideNumberByEvenDigits() {
		Long num1 = 122L;
		Long num2 = 45326181L;
		Assertions.assertEquals(61L, NumberModifierUtil.divideNumberByEvenDigits(num1));
		Assertions.assertEquals(11331545L, NumberModifierUtil.divideNumberByEvenDigits(num2));
	}

	@Test
	void evenNumbersCount() {
		Long num1 = 12L;
		Long num2 = 11L;
		Assertions.assertEquals(1, NumberModifierUtil.evenNumbersCount(num1));
		Assertions.assertEquals(0, NumberModifierUtil.evenNumbersCount(num2));
	}

	@Test
	void modifyNumber() {
		Long num1 = 43256791L;
		NumberModifierUtil.modifyNumber(num1);
		Assertions.assertEquals(11331545L, NumberModifierUtil.modifyNumber(num1));

		Long num2 = Long.MAX_VALUE;
		Assertions.assertEquals(-1L, NumberModifierUtil.modifyNumber(num2));
	}

}
