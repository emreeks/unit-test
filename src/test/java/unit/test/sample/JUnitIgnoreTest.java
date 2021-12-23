package unit.test.sample;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JUnitIgnoreTest {

    @Ignore("not ready")
    @Test
    public void shouldFail() {
        assertTrue(Boolean.FALSE);
    }

}
