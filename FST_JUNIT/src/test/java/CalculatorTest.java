import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }
    @Test
    @Order(2)
    //@DisplayName("Simple multiplication")
    public void testMultiply(){
        assertEquals(20, calculator.multiply(4, 5));
    }
    @Test
    @Order(3)
    public void testAdd(){
        assertEquals(10, calculator.add(2,8));
    }

    @Test
    @Order(1)
    public void testSub(){
        assertEquals(20, calculator.subtract(30,50));
    }
}
