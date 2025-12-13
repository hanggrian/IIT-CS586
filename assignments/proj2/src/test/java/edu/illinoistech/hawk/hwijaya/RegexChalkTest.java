package edu.illinoistech.hawk.hwijaya;

import com.github.tomaslanger.chalk.Chalk;
import org.junit.jupiter.api.Test;

import static com.github.tomaslanger.chalk.Chalk.on;
import static com.google.common.truth.Truth.assertThat;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegexChalkTest {
    @Test
    public void singleStyle() {
        assertThat(
            new RegexChalk("Quick brown fox")
                .regex("Quick", Chalk::red)
                .regex("brown", Chalk::green)
                .regex("fox", Chalk::blue)
                .toString()
        ).isEqualTo(
            format(
                "%s %s %s",
                on("Quick").red(),
                on("brown").green(),
                on("fox").blue()
            )
        );
        assertThat(new RegexChalk("Quick brown fox").all(Chalk::green).toString())
            .isEqualTo(on("Quick brown fox").green().toString());
    }

    @Test
    public void multipleStyles() {
        assertThat(
            new RegexChalk("Lorem ipsum")
                .regex("ipsum", Chalk::bold)
                .all(Chalk::blue)
                .toString()
        ).isEqualTo(
            on("Lorem " + on("ipsum").bold())
                .blue()
                .toString()
        );
    }

    @Test
    public void invalidParameter() {
        assertThrows(
            NullPointerException.class,
            () -> new RegexChalk(null)
        );
        assertThrows(
            NullPointerException.class,
            () -> new RegexChalk("").regex(null, Chalk::bold)
        );
        assertThrows(
            NullPointerException.class,
            () -> new RegexChalk("").regex("", null)
        );
        assertThrows(
            NullPointerException.class,
            () -> new RegexChalk("").all(null)
        );
    }
}
