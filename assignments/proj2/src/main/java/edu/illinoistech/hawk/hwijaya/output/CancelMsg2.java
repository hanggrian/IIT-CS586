package edu.illinoistech.hawk.hwijaya.output;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the CancelMsg operation for GasPump2.
 */
public class CancelMsg2 implements CancelMsg {
    @Override
    public void cancelMsg() {
        out.println(on("Credit or debit transaction cancelled.").green());
    }
}
