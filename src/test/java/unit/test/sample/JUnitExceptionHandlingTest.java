package unit.test.sample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class JUnitExceptionHandlingTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldAssertByHandleException() {
        try {
            new SampleService().throwRuntimeException();
            fail();
        } catch (RuntimeException e) {
            assertEquals("system error", e.getMessage());
        }
    }

    @Test(expected = RuntimeException.class)
    public void shouldAssertByExpected() {
        new SampleService().throwRuntimeException();
    }

    @Test
    public void shouldAssertByRules() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("system error");
        new SampleService().throwRuntimeException();
    }

}
