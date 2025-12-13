package edu.illinoistech.hawk.hwijaya.output;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the PayMsg operation for GasPump2.
 */
public class PayMsg2 implements PayMsg {
    @Override
    public void payMsg() {
        out.println(on("Debit card and credit card are supported.").green());
    }
}
