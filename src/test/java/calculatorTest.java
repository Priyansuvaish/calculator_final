import org.example.calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class calculatorTest {
    private static final double delta = 1e-15;
    calculator c=new calculator();

    @Test
    public void sqroot_true(){
        assertEquals("Square root function check for, True positive result ",7.0,c.sqroot(49),delta);
        assertEquals("Square root function check for, True negative result ",Double.NaN,c.sqroot(-49),delta);
    }
    @Test
    public void sqroot_false(){
        assertNotEquals("Square root function check for, False positive result ",8.0,c.sqroot(49),delta);
        assertNotEquals("Square root function check for, False negative result ",7,c.sqroot(-49),delta);

    }

    @Test
    public void fact_true(){
        assertEquals("Factorial function check for, True positive result ",5040,c.fact(7),delta);
        assertEquals("Factorial function check for, True negative result ",Double.NaN,c.fact(-4),delta);


    }
    @Test
    public void fact_false(){
        assertNotEquals("Factorial function check for, False positive result ",8,c.fact(3),delta);
        assertNotEquals("Factorial function check for, False negative result ",12001,c.fact(5),delta);

    }

    @Test
    public void power_true(){
        assertEquals("Power function check for, True positive result ",16,c.power(4,2),delta);
        assertEquals("Power function check for, True negative result ",1,c.power(3,0),delta);

    }
    @Test
    public void power_false(){
        assertNotEquals("Power function check for, False positive result ",2,c.power(2,8),delta);
        assertNotEquals("Power function check for, False negative result ",1,c.power(0,1),delta);

    }


    @Test
    public void logarithm_true(){
        assertEquals("Logarithm function check for, True positive result ",1.3862943611198906,c.naturalLog(4),delta);
        assertEquals("Logarithm function check for, True negative result ",Double.NaN,c.naturalLog(-4),delta);

    }
    @Test
    public void logarithm_false() {
        assertNotEquals("Logarithm function check for, False positive result ", Double.NaN, c.naturalLog(3), delta);
        assertNotEquals("Logarithm function check for, False negative result ", 1.3862943611198906, c.naturalLog(-4), delta);
    }
}
