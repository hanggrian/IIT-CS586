package edu.illinoistech.hawk.hwijaya.output;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Interface for the RejectMsg operation in the OutputProcessor.
 */
public interface RejectMsg {
    default void rejectMsg() {
        out.println(on("Credit card rejected.").red());
    }
}
