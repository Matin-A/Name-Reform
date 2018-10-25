import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        do {
            Scanner scanner = new Scanner(System.in);
            boolean badInput;

            String targetIn;
            do {
                System.out.println("Enter Target Path: ");
                targetIn = scanner.nextLine();
                if(!new File(targetIn).exists()){
                    badInput=true;
                    System.out.println("Path Not Exists.");
                }else{
                    badInput=false;
                }
            }while (badInput);

            System.out.println("Enter Full Name Regex: ");
            String regex = scanner.nextLine();

            System.out.println("Enter Replacement Regex: ");
            String replacementRegex = scanner.nextLine();

            NameReform nameReform = new NameReform(regex, replacementRegex, new File(targetIn));

            do {
                System.out.println("Start? (y or n)");
                String input = scanner.nextLine();
                if (input.matches("n")){
                    return;
                }else badInput = !input.matches("y");
            }while (badInput);

            nameReform.reformNames();
            System.out.println("Name Reformed.");

            do {
                System.out.println("Rollback? (y or n)");
                String input = scanner.nextLine();
                if (input.matches("y")){
                    nameReform.rollback();
                }else badInput = !input.matches("n");
            }while (badInput);

            do {
                System.out.println("Exit? (y or n)");
                String input = scanner.nextLine();
                if (input.matches("y")){
                    return;
                }else badInput = !input.matches("n");
            }while (badInput);
        }while (true);
    }
}
