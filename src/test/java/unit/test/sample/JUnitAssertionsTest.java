package unit.test.sample;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class JUnitAssertionsTest {

    @Test
    public void shouldAssertEquals() {
        String expected = "text1";
        String actual = "text1";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAssertSame() {
        String text = new String("text");

        assertSame(text, text, "text are not not same");
    }

    @Test
    public void shouldAssertNullable() {
        String text = "text";
        String textNull = null;

        assertNull(textNull);
        assertNotNull(text);
    }

    @Test
    public void shouldAssertBoolean() {
        assertTrue(Boolean.TRUE);
        assertFalse(Boolean.FALSE);
    }

    @Test
    public void shouldAssertArray() {
        int[] firstArray = {10, 20, 30};
        int[] secondArray = {10, 20, 30};

        assertArrayEquals(firstArray, secondArray);
    }

}
