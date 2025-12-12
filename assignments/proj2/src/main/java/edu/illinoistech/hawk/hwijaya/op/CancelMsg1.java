package edu.illinoistech.hawk.hwijaya.op;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the CancelMsg operation for GasPump1.
 */
public class CancelMsg1 implements CancelMsg {
    @Override
    public void cancelMsg() {
        out.println(on("Credit or cash transaction cancelled.").green());
    }
}
