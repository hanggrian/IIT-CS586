package edu.illinoistech.hawk.hwijaya.output;

import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore1;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.String.format;
import static java.lang.System.out;

/**
 * Implementation of the GasPumpedMsg operation for GasPump1.
 */
public class GasPumpedMsg1 implements GasPumpedMsg {
    DataStore1 dataStore1;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore1 = (DataStore1) dataStore;
    }

    @Override
    public void gasPumpedMsg() {
        out.println(
            on(
                format(
                    "%d %s been pumped.",
                    dataStore1.literCount,
                    dataStore1.literCount == 1
                        ? "liter has"
                        : "liters have"
                )
            ).green()
        );
    }
}
