package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    private static GradeCalculator gradeCalculator;

    // @BeforeAll // static
    // @BeforeEach // normal method
    // @AfterAll // static
    // @AfterEach // normal method

    @BeforeAll
    static void setupAll() {
        gradeCalculator = new GradeCalculator();
    }

    @Nested
    @DisplayName("Unit tests that implement without parameter setup")
    class NonParameterTest {

        @Test
        void shouldReturnA() {
            var actual = gradeCalculator.calculateGrade(82);
            assertEquals('A', actual);
        }

        @Test
        void shouldReturnB() {
            var actual = gradeCalculator.calculateGrade(76);
            assertEquals('B', actual);
        }

        @Test
        void shouldReturnC() {
            var actual = gradeCalculator.calculateGrade(63);
            assertEquals('C', actual);
        }

        @Test
        void shouldReturnD() {
            var actual = gradeCalculator.calculateGrade(58);
            assertEquals('D', actual);
        }

        @Test
        void shouldReturnF() {
            var actual = gradeCalculator.calculateGrade(35);
            assertEquals('F', actual);
        }
    }

    @Nested
    @DisplayName("Unit tests that implement parameterized setup")
    class ParameterTest {

        @ParameterizedTest
        @CsvSource({
                "82,A",
                "76,B",
                "63,C",
                "58,D",
                "35,F"
        })
        void shouldReturnA(int score, char expectedGrade) {
            var actual = gradeCalculator.calculateGrade(score);
            assertEquals(expectedGrade, actual);
        }
    }

    @Nested
    @DisplayName("Unit tests that implement parameterized setup with read CSV file directly")
    class ParameterWithCsvFileTest {

        @ParameterizedTest
        @CsvFileSource(files = "src/test/resources/test.csv", numLinesToSkip = 1)
        void shouldReturnA(int score, char expectedGrade) {
            var actual = gradeCalculator.calculateGrade(score);
            assertEquals(expectedGrade, actual);
        }
    }

    @Test
    @DisplayName("Throw IllegalArgumentException due to invalid score")
    void shouldThrowErrorDueToInvalidScore() {
        assertThrows(IllegalArgumentException.class, () -> gradeCalculator.calculateGrade(500));
    }
}