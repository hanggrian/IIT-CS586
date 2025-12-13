package edu.illinoistech.hawk.hwijaya.output;

import com.github.tomaslanger.chalk.Chalk;
import edu.illinoistech.hawk.hwijaya.RegexChalk;
import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore2;

import static com.github.tomaslanger.chalk.Chalk.on;
import static edu.illinoistech.hawk.hwijaya.RegexChalk.CURRENCY_REGEX;
import static edu.illinoistech.hawk.hwijaya.RegexChalk.NUMBER_REGEX;
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
        out.print(on("Done, printing receipt...").green());
        out.print(
            new RegexChalk(
                "%n"
                    + "  Gallon: %d%n"
                    + "  Price : $%d%n"
                    + "  Total : $%d%n",
                dataStore2.gallonCount,
                dataStore2.price,
                dataStore2.total
            ).regex(NUMBER_REGEX + '|' + CURRENCY_REGEX, Chalk::bold)
                .all(Chalk::blue)
        );
    }
}
