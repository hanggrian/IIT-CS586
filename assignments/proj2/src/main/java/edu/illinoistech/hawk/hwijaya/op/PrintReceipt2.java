package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore2;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the PrintReceipt operation for GasPump2.
 */
public class PrintReceipt2 implements PrintReceipt {
    DataStore2 dataStore2;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore2 = (DataStore2) dataStore;
    }

    @Override
    public void printReceipt() {
        out.println(
            on(
                "Receipt:\n"
                    + "Gallon = " + dataStore2.gallonCount + '\n'
                    + "Total = $" + dataStore2.total
            ).green()
        );
    }
}
