import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc;

    @BeforeEach
    public void setUp() {
        calc = new Calculator();
        System.out.println("test starting");
    }

    // runs after every test
    @AfterEach
    public void tearDown() {
        System.out.println("test finished");
    }

    @Test
    public void testAssertions() {
        assertEquals(5, calc.add(2, 3));
        assertTrue(calc.add(2, 3) > 0);
        assertFalse(calc.add(2, 3) < 0);
        assertNotNull(calc);
    }
    @Test
    public void testAdd() {
        int a = 10;
        int b = 15;
        int result = calc.add(a, b);
        assertEquals(25, result);
    }

    @Test
    public void testSubtract() {
        assertEquals(7, calc.subtract(10, 3));
    }
}
