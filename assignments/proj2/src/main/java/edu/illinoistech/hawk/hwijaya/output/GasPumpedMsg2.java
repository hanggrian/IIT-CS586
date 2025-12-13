package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore2;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.String.format;
import static java.lang.System.out;

/**
 * Implementation of the GasPumpedMsg operation for GasPump2.
 */
public class GasPumpedMsg2 implements GasPumpedMsg {
    DataStore2 dataStore2;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore2 = (DataStore2) dataStore;
    }

    @Override
    public void gasPumpedMsg() {
        out.println(
            on(
                format(
                    "%d %s been pumped.",
                    dataStore2.gallonCount,
                    dataStore2.gallonCount == 1
                        ? "gallon has"
                        : "gallons have"
                )
            ).green()
        );
    }
}
