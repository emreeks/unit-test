package unit.test.sample;

import org.assertj.core.api.Condition;
import org.junit.Test;

import java.io.Serializable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void shouldAssertNullable() {

        String colour = "Red";
        String nullText = null;
        String emptyTest = "";

        assertThat(nullText).isNull();
        assertThat(emptyTest).isNullOrEmpty();

        assertThat(colour).isNotNull().has(new Condition<String>(m -> m.contains("E"), "character"));
        //assertThat(colour).isNotNull().has(new Condition<String>(m -> m.contains("f"), "f letter"));
    }

    @Test
    public void shouldAssertCollections() {
        List<String> colourList = Arrays.asList("Red", "Green", "Blue");

        assertThat(colourList)
                .containsOnlyOnce("Red")
                .contains("Green")
                .doesNotContain("Pink")
                .containsAll(Arrays.asList("Red", "Blue"))
                .hasSize(3)
                .startsWith("Red");
    }

    @Test
    public void shouldAssertDate() {

        Instant todayInstant = Instant.now();
        Date today = Date.from(todayInstant);
        Date yesterday = Date.from(todayInstant.minus(1, ChronoUnit.DAYS));
        Date tomorrow = Date.from(todayInstant.plus(1, ChronoUnit.DAYS));

        assertThat(today)
                .isBefore(tomorrow)
                .isAfter(yesterday)
                .isBetween(yesterday, tomorrow)
                .isEqualTo(today);
    }

    @Test
    public void shouldAnnotateClassInformation() {
        assertThat(Serializable.class).isInterface();
        assertThat(Override.class).isAnnotation();
    }

}
