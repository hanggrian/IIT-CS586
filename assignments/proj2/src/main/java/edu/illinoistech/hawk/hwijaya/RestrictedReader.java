package edu.illinoistech.hawk.hwijaya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.github.tomaslanger.chalk.Chalk.on;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;

/**
 * Helper class to read command line input with restrictions. Uses recursive call stack to re-prompt
 * on invalid input.
 */
public final class RestrictedReader {
    private final BufferedReader reader;

    /**
     * Create a default instance.
     */
    public RestrictedReader() {
        this(new BufferedReader(new InputStreamReader(System.in)));
    }

    /**
     * Create an instance with custom reader, for unit testing.
     *
     * @param reader input reader, never null.
     */
    public RestrictedReader(BufferedReader reader) {
        this.reader = checkNotNull(reader);
    }

    /**
     * Returns lowercased text that is guaranteed to be in the restriction.
     *
     * @param restriction list of restricted text.
     */
    public String readText(String... restriction) {
        return readText(restriction, false);
    }

    /**
     * Returns lowercased text that is guaranteed to be in the restriction.
     *
     * @param restriction list of restricted text.
     * @param isTest flag to stop endless recursion in unit testing.
     */
    public String readText(String[] restriction, boolean isTest) {
        checkArgument(restriction.length > 0);

        List<String> strings = Arrays.asList(restriction);
        try {
            String text = reader.readLine().toLowerCase(Locale.US);
            if (strings.contains(text)) {
                return text;
            }
            out.println(on("Unknown input, try again...").yellow());
        } catch (IOException e) {
            out.println(on(e.getMessage()).red());
        }
        return isTest ? null : readText(restriction, false);
    }

    /**
     * Returns number that is guaranteed to be in range.
     *
     * @param low the lower bound.
     * @param high the higher bound.
     */
    public int readNumber(int low, int high) {
        return readNumber(low, high, false);
    }

    /**
     * Returns number that is guaranteed to be in range.
     *
     * @param low the lower bound.
     * @param high the higher bound.
     * @param isTest flag to stop endless recursion in unit testing.
     */
    public int readNumber(int low, int high, boolean isTest) {
        checkArgument(low < high);

        try {
            int number = parseInt(reader.readLine());
            if (number >= low && number <= high) {
                return number;
            }
            out.println(on("Out of range, try again...").yellow());
        } catch (IOException | NumberFormatException e) {
            out.println(on(e.getMessage()).red());
        }
        return isTest ? -1 : readNumber(low, high, false);
    }

    /**
     * Returns decimal that is guaranteed to be in range.
     *
     * @param low the lower bound.
     * @param high the higher bound.
     */
    public float readDecimal(float low, float high) {
        return readDecimal(low, high, false);
    }

    /**
     * Returns decimal that is guaranteed to be in range.
     *
     * @param low the lower bound.
     * @param high the higher bound.
     * @param isTest flag to stop endless recursion in unit testing.
     */
    public float readDecimal(float low, float high, boolean isTest) {
        checkArgument(low < high);

        try {
            float decimal = parseFloat(reader.readLine());
            if (decimal >= low && decimal <= high) {
                return decimal;
            }
            out.println(on("Out of range, try again...").yellow());
        } catch (IOException | NumberFormatException e) {
            out.println(on(e.getMessage()).red());
        }
        return isTest ? -1 : readDecimal(low, high, false);
    }
}
