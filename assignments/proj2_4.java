
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GasPump_1 gp1 = new GasPump_1();

        System.out.println("                          GasPump-1");
        System.out.println("                  MENU of Operations");
        System.out.println("          0. Activate(float)");
        System.out.println("          1. Start()");
        System.out.println("          2. PayCredit");
        System.out.println("          3. Reject()");
        System.out.println("          4. Cancel()");
        System.out.println("          5. Approved()");
        System.out.println("          6. PayCash(float)");
        System.out.println("          7. StartPump()");
        System.out.println("          8. Pump()");          
        System.out.println("          9. StopPump()");
        System.out.println("          q. Quit the program");
        System.out.println("  Please make a note of these operations");
        System.out.println("           GasPump-1 Execution");

        char ch = '1';
        while (ch != 'q') {
            System.out.println("Select Operation:");
            System.out.println("0-Activate,1-Start,2-PayCredit,3-Reject,4-Cancel,5-Approved,6-PayCash,7-StartPump,8-PumpLiter,9-StopPump,q-quit");
            ch = sc.next().charAt(0);

            switch (ch) {
                case '0': {
                    System.out.println("Operation: Activate(float a)");
                    System.out.print("Enter value of the parameter a: ");
                    float a = sc.nextFloat();
                    gp1.Activate(a);
                    break;
                }
                case '1': {
                    System.out.println("Operation: Start()");
                    gp1.Start();
                    break;
                }
		case '2': {
                    System.out.println("Operation: PayCredit()");
                    gp1.PayCredit();
                    break;
                }
                case '3': {
                    System.out.println("Operation: Reject()");
                    gp1.Reject();
                    break;
                }
                case '4': {
                    System.out.println("Operation: Cancel()");
                    gp1.Cancel();
                    break;
                }
                case '5': {
                    System.out.println("Operation: Approved()");
                    gp1.Approved();
                    break;
                }
                case '6': {
                    System.out.println("Operation: PayCash(float c)");
                    System.out.print("Enter value of the parameter c: ");
                    float c = sc.nextFloat();
                    gp1.PayCash(c);
                    break;
                }
                case '7': {
                    System.out.println("Operation: StartPump()");
                    gp1.StartPump();
                    break;
                }
                case '8': {
                    System.out.println("Operation: PumpLiter()");
                    gp1.PumpLiter();
                    break;
                }
                case '9': {
                    System.out.println("Operation: StopPump()");
                    gp1.StopPump();
                    break;
                }
                case 'q': {
                    System.out.println("Quitting program...");
                    break;
                }
                default: {
                    System.out.println("Invalid option. Try again.");
                }
            }
        }

        sc.close();
    }
}