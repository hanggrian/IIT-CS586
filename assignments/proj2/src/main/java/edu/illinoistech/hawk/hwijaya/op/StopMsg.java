package edu.illinoistech.hawk.hwijaya.op;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Interface for the StopMsg operation in the OutputProcessor.
 */
public interface StopMsg {
    default void stopMessage() {
        out.println(on("Gas pump stopped, please collect your receipt.").green());
    }
}
