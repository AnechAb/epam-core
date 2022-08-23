package com.epam.se06;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import static org.hamcrest.Matchers.*;

import static org.hamcrest.MatcherAssert.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void createCalculator() {
        calculator = null;
    }

    @Nested
    class PositiveTests {

        @Nested
        class SumMethodTests {

            @Test
            void sumOverflowShouldWorkCorrectly() {
                int result = calculator.add(Integer.MAX_VALUE, 1);

                assertThat(result, lessThan(0));
                assertThat(result, is(Integer.MIN_VALUE));

            }

            @Test
            void sumUnderflowShouldWorkCorrectly() {

                int result = calculator.add(Integer.MIN_VALUE, -1);

                assertThat(result, is(Integer.MAX_VALUE));
            }

            @Test
            void sumWithZeroLeftShouldResultSameValue() {

                int original = 42;

                int result = calculator.add(0, original);

                assertThat(result, is(original));
            }

            @Test
            void sumWithZeroRightShouldResultSameValue() {

                int original = 42;

                int result = calculator.add(original, 0);

                assertThat(result, is(original));
            }

            @Test
            void sumTwoPositiveValues() {

                int result = calculator.add(1, 2);

                assertThat(result, is(3));
            }
        }

        @Nested
        class SubtractMethodTests {
            @Test
            void subtractZeroShouldResultSameValue() {
                int original = 42;

                int result = calculator.subtract(original, 0);

                assertThat(result, is(original));
            }

            @Test
            void subtractFromZeroShouldResultSameNegativeValue() {
                int original = 42;

                int result = calculator.subtract(0, original);

                assertThat(result, is(-original));
            }

            @Test
            void subtractPositiveValues() {
                int result = calculator.subtract(42, 10);

                assertThat(result, is(32));
            }

            @Test
            void subtractNegativeValues() {
                int result = calculator.subtract(-42, -10);

                assertThat(result, is(-32));
            }

            @Test
            void subtractPositiveAndNegativeValues() {
                int result = calculator.subtract(42, -10);

                assertThat(result, is(52));
            }

            @Test
            void subtractNegativeAndPositiveValues() {
                int result = calculator.subtract(-42, 10);

                assertThat(result, is(-52));
            }

            @Test
            void subtractOverflowShouldWorkCorrectly() {
                int result = calculator.subtract(Integer.MAX_VALUE, -1);

                assertThat(result, is(Integer.MIN_VALUE));
            }

            @Test
            void subtractUnderflowShouldWorkCorrectly() {
                int result = calculator.subtract(Integer.MIN_VALUE, 1);

                assertThat(result, is(Integer.MAX_VALUE));
            }
        }

        @Nested
        class MultiplyMethod {
            @Test
            void multiplyWithZeroShouldReturnZero() {
                int result = calculator.multiply(42, 0);

                assertThat(result, is(0));
            }

            @Test
            void multiplyWithOneShouldReturnSameValue() {
                int originalValue = 42;

                int result = calculator.multiply(originalValue, 1);

                assertThat(result, is(originalValue));
            }

            @Test
            void multiplyTwoPositiveValueShouldProducePositiveValue() {
                int result = calculator.multiply(42, 2);

                assertThat(result, is(84));
            }

            @Test
            void multiplyPositiveAndNegativeValueShouldProduceNegativeValue() {
                int result = calculator.multiply(42, -2);

                assertThat(result, is(-84));
            }

            @Test
            void multiplyTwoNegativeValuesShouldProducePositiveValue() {
                int result = calculator.multiply(-42, -2);

                assertThat(result, is(84));
            }

            @Test
            void multiplyOverflowShouldWorkCorrectly() {
                int result = calculator.multiply(Integer.MAX_VALUE / 2 + 1, 2);

                assertThat(result, is(Integer.MIN_VALUE));
            }
        }
    }

    @Nested
    class NegativeTests {
        @Test
        void name() {
            assertThat(true, is(false));
        }
    }
}