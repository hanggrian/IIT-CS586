package edu.illinoistech.hawk.hwijaya.output;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the PayMsg operation for GasPump1.
 */
public class PayMsg1 implements PayMsg {
    @Override
    public void payMsg() {
        out.println(on("Cash and credit card are supported.").green());
    }
}
