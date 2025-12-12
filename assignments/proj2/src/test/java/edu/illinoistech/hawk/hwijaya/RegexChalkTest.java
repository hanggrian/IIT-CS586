package edu.illinoistech.hawk.hwijaya;

import com.github.tomaslanger.chalk.Chalk;
import org.junit.jupiter.api.Test;

import static com.github.tomaslanger.chalk.Chalk.on;
import static com.google.common.truth.Truth.assertThat;
import static edu.illinoistech.hawk.hwijaya.RegexChalk.onAll;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegexChalkTest {
    @Test
    public void simple() {
        assertThat(onAll("Quick brown fox").regex("\\w+", Chalk::green).toString())
            .isEqualTo(
                format(
                    "%s %s %s",
                    on("Quick").green(),
                    on("brown").green(),
                    on("fox").green()
                )
            );
    }

    @Test
    public void invalidParameter() {
        assertThrows(
            NullPointerException.class,
            () -> onAll(null)
        );
        assertThrows(
            NullPointerException.class,
            () -> onAll("").regex(null, Chalk::bold)
        );
        assertThrows(
            NullPointerException.class,
            () -> onAll("").regex("", null)
        );
    }
}
