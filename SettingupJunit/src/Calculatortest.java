import static org.junit.Assert.*;
import org.junit.Test;

public class Calculatortest {

    @Test
    public void testAdd() {

        Calculator c = new Calculator();

        assertEquals(5, c.add(2, 3));
        assertTrue(5 > 3);
        assertFalse(5 < 3);
        assertNotNull(c);

    }
}
