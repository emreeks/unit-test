package unit.test.sample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitLifeCycleTest {

    @BeforeClass
    public static void setUp() {
        System.out.println("setUp");
    }

    @AfterClass
    public static void dispose() {
        System.out.println("dispose");
    }

    @Before
    public void initialize() {
        System.out.println("initialize");
    }

    @After
    public void callBack() {
        System.out.println("callBack");
    }

    @Test
    public void shouldMethod1WorksAsExpected() {
        System.out.println("method1 test method");
    }

    @Test
    public void shouldMethod2WorksAsExpected() {
        System.out.println("method2 test method");
    }
}
