package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore1;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the PrintReceipt operation for GasPump1.
 */
public class PrintReceipt1 implements PrintReceipt {
    DataStore1 dataStore1;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore1 = (DataStore1) dataStore;
    }

    @Override
    public void printReceipt() {
        out.println(
            on(
                "Receipt:\n"
                    + "Liter = " + dataStore1.literCount + '\n'
                    + "Total = $" + dataStore1.total
            ).green()
        );
    }
}
