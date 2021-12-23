package unit.test.sample;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;

public class HamcrestTest {

    @Test
    public void shouldAssertIsAndNot() {
        String text = "text1";
        assertThat(text, is(equalTo("text1")));
        assertThat(text, is(not(equalTo("text2"))));
    }

    @Test
    public void shouldAssertMultipleAssert() {
        String name = "Emir";
        assertThat(name, anyOf(startsWith("E"), endsWith("t")));
        assertThat(name, allOf(startsWith("E"), endsWith("r")));
    }

    @Test
    public void shouldAssertArrayAndCollections() {
        List<String> colourList = Arrays.asList("Red", "Green", "Blue");
        String[] colourArray = {"Red", "Green", "Blue"};

        assertThat(colourList, hasItem("Red"));
        assertThat(colourArray, hasItemInArray("Green"));
    }

    @Test
    public void shouldAssertNumber() {

        assertThat(1D, is(lessThan(10D)));
        assertThat(10D, is(greaterThan(1D)));

        assertThat(10.5D, is(closeTo(10D, 0.5D)));
    }

    @Test
    public void shouldAssertString() {
        String colour = "Red";

        assertThat(colour, is(equalTo("Red")));
        assertThat(colour, is(not(equalTo("Green"))));
        assertThat(colour, is(equalToIgnoringCase("red")));
        assertThat(colour, is(equalToIgnoringWhiteSpace("red  ")));
        assertThat(colour, is(startsWith("R")));
        assertThat(colour, is(endsWith("d")));
        assertThat(colour, is(containsString("ed")));

    }

}
