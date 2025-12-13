package edu.illinoistech.hawk.hwijaya;

import com.github.tomaslanger.chalk.Chalk;
import java.util.function.Consumer;

import static com.github.tomaslanger.chalk.Chalk.on;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;
import static java.util.regex.Pattern.compile;

/**
 * Helper class to apply Chalk styles using regex replacements.
 */
public final class RegexChalk {
    public static final String NUMBER_REGEX = "([0-9])";
    public static final String CURRENCY_REGEX = "\\$+([0-9])+.([0-9])";

    private String text;

    /**
     * Create a new instance of this wrapper class.
     *
     * @param format format string.
     * @param args format arguments.
     */
    public RegexChalk(String format, Object... args) {
        this(format(format, args));
    }

    /**
     * Create a new instance of this wrapper class.
     *
     * @param text input string, never null.
     */
    public RegexChalk(String text) {
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

    /**
     * Apply {@link Chalk} configuration to the entire text.
     *
     * @param configuration lambda carrying configurator, never null.
     */
    public RegexChalk all(Consumer<Chalk> configuration) {
        checkNotNull(configuration);

        Chalk chalk = on(text);
        configuration.accept(chalk);
        text = chalk.toString();
        return this;
    }

    @Override
    public String toString() {
        return text;
    }
}
