package edu.illinoistech.hawk.hwijaya;

import com.github.tomaslanger.chalk.Chalk;
import java.util.function.Consumer;

import static com.github.tomaslanger.chalk.Chalk.on;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.regex.Pattern.compile;

/**
 * Helper class to apply Chalk styles using regex replacements.
 */
public final class RegexChalk {
    private String text;

    private RegexChalk(String text) {
        this.text = checkNotNull(text);
    }

    /**
     * Apply {@link Chalk} configuration using regex pattern.
     *
     * @param regex the pattern, never null.
     * @param configuration lambda carrying configurator, never null.
     */
    public RegexChalk regex(String regex, Consumer<Chalk> configuration) {
        checkNotNull(regex);
        checkNotNull(configuration);

        Chalk chalk = on("$0");
        configuration.accept(chalk);
        text = compile(regex).matcher(text).replaceAll(chalk.toString());
        return this;
    }

    @Override
    public String toString() {
        return text;
    }

    /**
     * Create a new instance of this wrapper class.
     *
     * @param text input String, never null.
     */
    public static RegexChalk onAll(String text) {
        return new RegexChalk(text);
    }
}
