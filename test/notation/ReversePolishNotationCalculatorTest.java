package notation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReversePolishNotationCalculatorTest {

    private static final ReversePolishNotationCalculator calculator = new ReversePolishNotationCalculator();

    @Test
    public void shouldCalculateAddition() {
        var result = calculator.calculatePolishNotation("2 3 + ");
        Assertions.assertEquals(5, result);
    }

    @Test
    public void shouldCalculateSubtraction() {
        var result = calculator.calculatePolishNotation("6 9 -");
        Assertions.assertEquals(-3, result);
    }

    @Test
    public void shouldCalculateMultiplication() {
        var result = calculator.calculatePolishNotation("10 10 *");
        Assertions.assertEquals(100, result);
    }

}