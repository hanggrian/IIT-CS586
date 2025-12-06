package edu.illinoistech.hawk.hwijaya;

import com.github.tomaslanger.chalk.Chalk;
import edu.illinoistech.hawk.hwijaya.af.AbstractFactory;
import edu.illinoistech.hawk.hwijaya.af.GasPumpFactory1;
import edu.illinoistech.hawk.hwijaya.af.GasPumpFactory2;
import edu.illinoistech.hawk.hwijaya.gp.GasPump1;
import edu.illinoistech.hawk.hwijaya.gp.GasPump2;
import edu.illinoistech.hawk.hwijaya.op.OutputProcessor;
import edu.illinoistech.hawk.hwijaya.s.MdaEfsm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The driver class for the gas pump system, providing a console-based interface
 * to interact with GasPump1 and GasPump2.
 */
public class Main {
    public static final String OPTION1 = "1";
    public static final String OPTION2 = "2";
    public static final String OPTION3 = "3";
    public static final String OPTION4 = "4";
    public static final String OPTION5 = "5";
    public static final String OPTION6 = "6";
    public static final String OPTION7 = "7";
    public static final String OPTION8 = "8";
    public static final String OPTION9 = "9";
    public static final String OPTION10 = "10";
    public static final String OPTION11 = "11";
    public static final String OPTION12 = "12";
    public static final String OPTION13 = "13";
    public static final String OPTION14 = "14";
    public static final String OPTION_QUIT = "q";

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        while (true) {
            print("Welcome to Gas Pump", "GasPump1", "GasPump2");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            switch (reader.readLine()) {
                case OPTION1:
                    main.runGasPump1(reader);
                    break;
                case OPTION2:
                    main.runGasPump2(reader);
                    break;
                case OPTION_QUIT:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }

    public void runGasPump1(BufferedReader reader) throws IOException {
        AbstractFactory abstractFactory = new GasPumpFactory1();
        GasPump1 gasPump1 =
            new GasPump1(
                new MdaEfsm(new OutputProcessor(abstractFactory)),
                abstractFactory
            );
        loop:
        while (true) {
            print(
                "GasPump1 menu",
                "activate(float)",
                "start()",
                "payCash(float)",
                "payCredit()",
                "approved()",
                "reject()",
                "cancel()",
                "startPump()",
                "pumpLiter()",
                "stopPump()"
            );
            switch (reader.readLine()) {
                case OPTION1:
                    System.out.println(Chalk.on("Set regular gas price:").underline());
                    gasPump1.activate(Float.parseFloat(reader.readLine()));
                    break;
                case OPTION2:
                    gasPump1.start();
                    break;
                case OPTION3:
                    System.out.println(Chalk.on("Set cash value:").underline());
                    gasPump1.payCash(Integer.parseInt(reader.readLine()));
                    break;
                case OPTION4:
                    gasPump1.payCredit();
                    break;
                case OPTION5:
                    gasPump1.approved();
                    break;
                case OPTION6:
                    gasPump1.reject();
                    break;
                case OPTION7:
                    gasPump1.cancel();
                    break;
                case OPTION8:
                    gasPump1.startPump();
                    break;
                case OPTION9:
                    gasPump1.pumpLiter();
                    break;
                case OPTION10:
                    gasPump1.stopPump();
                    break;
                case OPTION_QUIT:
                    System.out.println("Exiting GasPump1.");
                    break loop;
            }
        }
    }

    public void runGasPump2(BufferedReader reader) throws IOException {
        AbstractFactory abstractFactory = new GasPumpFactory2();
        GasPump2 gasPump2 =
            new GasPump2(
                new MdaEfsm(new OutputProcessor(abstractFactory)),
                abstractFactory
            );
        loop:
        while (true) {
            print(
                "GasPump2 menu",
                "activate(int, int)",
                "start()",
                "payDebit(int)",
                "pin(int)",
                "payCredit()",
                "approved()",
                "reject()",
                "cancel()",
                "regular()",
                "diesel()",
                "startPump()",
                "pumpGallon()",
                "stopPump()",
                "fullTank()"
            );
            switch (reader.readLine()) {
                case OPTION1:
                    System.out.println(Chalk.on("Set regular gas price:").underline());
                    int regularGasPrice = Integer.parseInt(reader.readLine());
                    System.out.println(Chalk.on("Set diesel gas price:").underline());
                    int dieselGasPrice = Integer.parseInt(reader.readLine());
                    gasPump2.activate(regularGasPrice, dieselGasPrice);
                    break;
                case OPTION2:
                    gasPump2.start();
                    break;
                case OPTION3:
                    System.out.println(Chalk.on("Enter pin:").underline());
                    gasPump2.payDebit(Integer.parseInt(reader.readLine()));
                    break;
                case OPTION4:
                    System.out.println(Chalk.on("Enter p:").underline());
                    gasPump2.pin(Integer.parseInt(reader.readLine()));
                    break;
                case OPTION5:
                    gasPump2.payCredit();
                    break;
                case OPTION6:
                    gasPump2.approved();
                    break;
                case OPTION7:
                    gasPump2.reject();
                    break;
                case OPTION8:
                    gasPump2.cancel();
                    break;
                case OPTION9:
                    gasPump2.regular();
                    break;
                case OPTION10:
                    gasPump2.diesel();
                    break;
                case OPTION11:
                    gasPump2.startPump();
                    break;
                case OPTION12:
                    gasPump2.pumpGallon();
                    break;
                case OPTION13:
                    gasPump2.stopPump();
                    break;
                case OPTION14:
                    gasPump2.fullTank();
                    break;
                case OPTION_QUIT:
                    System.out.println("Exiting GasPump2.");
                    break loop;
            }
        }
    }

    private static void print(String title, String... actions) {
        StringBuilder builder = new StringBuilder("\n" + Chalk.on(title).bold() + ":\n");
        int i = 0;
        for (String action : actions) {
            builder
                .append(Chalk.on(++i + (i < 10 ? ".  " : ". ") + action).bold())
                .append('\n');
        }
        System.out.println(
            builder.append(Chalk.on("q.  quit").bold())
        );
    }
}
