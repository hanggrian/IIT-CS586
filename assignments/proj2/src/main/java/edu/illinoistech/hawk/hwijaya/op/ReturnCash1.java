package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore1;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the ReturnCash operation for GasPump1.
 */
public class ReturnCash1 implements ReturnCash {
    DataStore1 dataStore1;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore1 = (DataStore1) dataStore;
    }

    @Override
    public void returnCash() {
        float total = dataStore1.total;
        float cash = dataStore1.cash;
        out.println(
            on(
                cash - total > 0
                    ? "Collected $" + (cash - total) + "."
                    : "Nothing to return."
            ).green()
        );
        dataStore1.literCount = 0;
        dataStore1.cash = 0;
        dataStore1.total = 0;
    }
}
