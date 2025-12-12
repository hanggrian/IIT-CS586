package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore1;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the ResetCounter operation for GasPump1.
 */
public class ResetCounter1 implements ResetCounter {
    DataStore1 dataStore1;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore1 = (DataStore1) dataStore;
    }

    @Override
    public void resetCounter() {
        dataStore1.total = 0.0f;
        dataStore1.literCount = 0;
        out.println(on("Total and liter count reset.").green());
    }
}
