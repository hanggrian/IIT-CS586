package edu.illinoistech.hawk.hwijaya;

import com.github.tomaslanger.chalk.Chalk;
import edu.illinoistech.hawk.hwijaya.af.AbstractFactory;
import edu.illinoistech.hawk.hwijaya.af.GasPumpFactory1;
import edu.illinoistech.hawk.hwijaya.af.GasPumpFactory2;
import edu.illinoistech.hawk.hwijaya.gp.GasPump1;
import edu.illinoistech.hawk.hwijaya.gp.GasPump2;
import edu.illinoistech.hawk.hwijaya.op.OutputProcessor;
import edu.illinoistech.hawk.hwijaya.s.MdaEfsm;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.github.tomaslanger.chalk.Chalk.on;
import static edu.illinoistech.hawk.hwijaya.RegexChalk.onAll;
import static java.lang.System.out;

/**
 * The driver class for the gas pump system, providing a console-based interface
 * to interact with GasPump1 and GasPump2. Uses loop stack to progress.
 */
public class Main {
    private static final RestrictedReader READER = new RestrictedReader();
    private static final String INDEX_REGEX = "([0-9]+\\.|q+\\.)";
    private static final String PAREN_REGEX = "\\((.*?)\\)";

    public static void main(String[] args) {
        Main main = new Main();
        while (true) {
            out.println();
            out.print(on("Welcome to Gas Pump!").inverse());
            out.print(
                onAll(
                    "\n"
                        + "1. GasPump1  q. quit\n"
                        + "2. GasPump2\n"
                ).regex(INDEX_REGEX, Chalk::bold)
            );
            out.println(on("Which pump:").yellow());
            switch (READER.readText(restrictUntil(2))) {
                case "1":
                    main.runGasPump1();
                    break;
                case "2":
                    main.runGasPump2();
                    break;
                case "quit":
                case "q":
                    out.println();
                    out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }

    public void runGasPump1() {
        AbstractFactory factory = new GasPumpFactory1();
        GasPump1 pump =
            new GasPump1(
                new MdaEfsm(new OutputProcessor(factory)),
                factory
            );
        loop:
        while (true) {
            out.println();
            out.print(on("GasPump 1:").inverse());
            out.print(
                onAll(
                    "\n"
                        + "1. activate(float)  4. payCredit()  7. cancel()     10. stopPump()\n"
                        + "2. start()          5. approved()   8. startPump()   q. quit\n"
                        + "3. payCash(float)   6. reject()     9. pumpLiter()\n"
                ).regex(INDEX_REGEX, Chalk::bold)
                    .regex(PAREN_REGEX, Chalk::gray)
            );
            out.println(on("Select menu:").yellow());
            switch (READER.readText(restrictUntil(10))) {
                case "1":
                    out.println(on("Set regular gas price:").yellow());
                    pump.activate(READER.readDecimal(1, 50));
                    break;
                case "2":
                    pump.start();
                    break;
                case "3":
                    out.println(on("Set cash value:").yellow());
                    pump.payCash(READER.readNumber(0, Integer.MAX_VALUE));
                    break;
                case "4":
                    pump.payCredit();
                    break;
                case "5":
                    pump.approved();
                    break;
                case "6":
                    pump.reject();
                    break;
                case "7":
                    pump.cancel();
                    break;
                case "8":
                    pump.startPump();
                    break;
                case "9":
                    pump.pumpLiter();
                    break;
                case "10":
                    pump.stopPump();
                    break;
                case "quit":
                case "q":
                    break loop;
            }
        }
    }

    public void runGasPump2() {
        AbstractFactory factory = new GasPumpFactory2();
        GasPump2 pump =
            new GasPump2(
                new MdaEfsm(new OutputProcessor(factory)),
                factory
            );
        loop:
        while (true) {
            out.println();
            out.print(on("GasPump 2:").inverse());
            out.print(
                onAll(
                    "\n"
                        + "1. activate(int, int)  5. payCredit()   9. cancel()     13. stopPump()\n"
                        + "2. start()             6. approved()   10. startPump()  14. fullTank()\n"
                        + "3. payDebit(int)       7. reject()     11. pumpLiter()   q. quit\n"
                        + "4. pin(int)            8. cancel()     12. pumpLiter()\n"
                ).regex(INDEX_REGEX, Chalk::bold)
                    .regex(PAREN_REGEX, Chalk::gray)
            );
            out.println(on("Select menu:").yellow());
            switch (READER.readText(restrictUntil(14))) {
                case "1":
                    out.println(on("Set regular gas price:").yellow());
                    int regularGasPrice = READER.readNumber(1, 50);
                    out.println(on("Set diesel gas price:").yellow());
                    int dieselGasPrice = READER.readNumber(1, 50);
                    pump.activate(regularGasPrice, dieselGasPrice);
                    break;
                case "2":
                    pump.start();
                    break;
                case "3":
                    out.println(on("Enter pin:").yellow());
                    pump.payDebit(READER.readNumber(0, 999999));
                    break;
                case "4":
                    out.println(on("Enter p:").yellow());
                    pump.pin(READER.readNumber(0, 999999));
                    break;
                case "5":
                    pump.payCredit();
                    break;
                case "6":
                    pump.approved();
                    break;
                case "7":
                    pump.reject();
                    break;
                case "8":
                    pump.cancel();
                    break;
                case "9":
                    pump.regular();
                    break;
                case "10":
                    pump.diesel();
                    break;
                case "11":
                    pump.startPump();
                    break;
                case "12":
                    pump.pumpGallon();
                    break;
                case "13":
                    pump.stopPump();
                    break;
                case "14":
                    pump.fullTank();
                    break;
                case "quit":
                case "q":
                    break loop;
            }
        }
    }

    private static String[] restrictUntil(int max) {
        List<String> restriction =
            IntStream
                .rangeClosed(1, max)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
        restriction.add("quit");
        restriction.add("q");
        return restriction.toArray(new String[0]);
    }
}
