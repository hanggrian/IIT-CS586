package edu.illinoistech.hawk.hwijaya.output;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the EnterPinMsg operation for GasPump2.
 */
public class EnterPinMsg2 implements EnterPinMsg {
    @Override
    public void enterPinMsg() {
        out.println(on("Debit card PIN established.").green());
    }
}
