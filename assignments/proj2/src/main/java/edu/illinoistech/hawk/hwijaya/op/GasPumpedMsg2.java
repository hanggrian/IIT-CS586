package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore2;

import static com.github.tomaslanger.chalk.Chalk.on;
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
                "1 gallon has been pumped.\n"
                    + "Total gallon = " + dataStore2.gallonCount
            ).green()
        );
    }
}
