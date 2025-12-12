package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore2;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the ResetCounter operation for GasPump2.
 */
public class ResetCounter2 implements ResetCounter {
    DataStore2 dataStore2;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore2 = (DataStore2) dataStore;
    }

    @Override
    public void resetCounter() {
        dataStore2.total = 0;
        dataStore2.gallonCount = 0;
        out.println(on("Total and gallon count reset.").green());
    }
}
