package edu.illinoistech.hawk.hwijaya.op;

import edu.illinoistech.hawk.hwijaya.ds.DataStore;
import edu.illinoistech.hawk.hwijaya.ds.DataStore2;

import static com.github.tomaslanger.chalk.Chalk.on;
import static java.lang.System.out;

/**
 * Implementation of the DisplayMenu operation for GasPump2.
 */
public class DisplayMenu2 implements DisplayMenu {
    DataStore2 dataStore2;

    @Override
    public void initialize(DataStore dataStore) {
        this.dataStore2 = (DataStore2) dataStore;
    }

    @Override
    public void displayMenu() {
        out.println(on("Payment is approved, regular and diesel are available.").green());
    }
}
