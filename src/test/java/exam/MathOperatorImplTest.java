package exam;

import exam.v1.Exceptions.InvalidOperationException;
import exam.v1.ServiceImpl.MathOperatorImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;


//unit testing
@RunWith(MockitoJUnitRunner.class)
public class MathOperatorImplTest {

    @InjectMocks
    private MathOperatorImpl mathOperator;

    @Test
    public void testDoMath_Addition() throws InvalidOperationException {
        double result = mathOperator.doMath(2, 3, "+");
        assertEquals(5, result, 0.001);
    }

    @Test
    public void testDoMath_Subtraction() throws InvalidOperationException {
        double result = mathOperator.doMath(5, 3, "-");
        assertEquals(2, result, 0.001);
    }

    @Test
    public void testDoMath_Multiplication() throws InvalidOperationException {
        double result = mathOperator.doMath(2, 3, "*");
        assertEquals(6, result, 0.001);
    }

    @Test
    public void testDoMath_Multiplication_ByZero() throws InvalidOperationException {
        double result = mathOperator.doMath(5, 0, "*");
        assertEquals(0, result, 0.001);
    }

    @Test
    public void testDoMath_Multiplication_ByOne() throws InvalidOperationException {
        double result = mathOperator.doMath(8, 1, "*");
        assertEquals(8, result, 0.001);
    }

    @Test
    public void testDoMath_Division() throws InvalidOperationException {
        double result = mathOperator.doMath(6, 3, "/");
        assertEquals(2, result, 0.001);
    }

    @Test
    public void testDoMath_Division_ByOne() throws InvalidOperationException {
        double result = mathOperator.doMath(8, 1, "/");
        assertEquals(8, result, 0.001);
    }

    @Test
    public void testDoMath_Division_ByZero() {
        try {
            double result = mathOperator.doMath(5, 0, "/");
            assertEquals(true, false);
        } catch (InvalidOperationException e) {
            assertEquals("Cannot divide by 0", e.getMessage());
        }
    }

    @Test
    public void testDoMath_Zero_Divided_ByNumber() throws InvalidOperationException {
        double result = mathOperator.doMath(0, 5, "/");
        assertEquals(0, result, 0.001);
    }

}


