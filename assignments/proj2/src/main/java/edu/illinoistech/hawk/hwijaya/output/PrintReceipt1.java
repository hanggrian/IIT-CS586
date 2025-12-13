package edu.illinoistech.hawk.hwijaya.output;

import com.github.tomaslanger.chalk.Chalk;
import edu.illinoistech.hawk.hwijaya.RegexChalk;
import edu.illinoistech.hawk.hwijaya.data.DataStore;
import edu.illinoistech.hawk.hwijaya.data.DataStore1;

import static com.github.tomaslanger.chalk.Chalk.on;
import static edu.illinoistech.hawk.hwijaya.RegexChalk.CURRENCY_REGEX;
import static edu.illinoistech.hawk.hwijaya.RegexChalk.NUMBER_REGEX;
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
        out.print(on("Done, printing receipt...").green());
        out.print(
            new RegexChalk(
                "%n"
                    + "  Liter: %d%n"
                    + "  Price: $%.1f%n"
                    + "  Total: $%.1f%n",
                dataStore1.literCount,
                dataStore1.price,
                dataStore1.total
            ).regex(NUMBER_REGEX + '|' + CURRENCY_REGEX, Chalk::bold)
                .all(Chalk::blue)
        );
    }
}
