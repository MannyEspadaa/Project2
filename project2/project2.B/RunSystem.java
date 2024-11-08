import java.util.Scanner;

public class RunSystem {    
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ExecManagement system = new ExecManagement(10); 

            String command;
            while (true) {
                System.out.print("Enter a command: ");
                System.out.print("Commands : hire, add, join, quit, change, payroll,salary, or exit ");
                command = scanner.nextLine();
                String[] parts = command.split(" ");

                switch (parts[0].toLowerCase()) {
                    case "add":
                        system.addDepartment(parts[1]);
                        break;
                    case "hire":
                        system.hireExecutive(parts[1]);
                        break;
                    case "join":
                        system.joinExecutive(parts[1], parts[2]);
                        break;
                    case "quit":
                        system.quitExecutive(parts[1]);
                        break;
                    case "change":
                        system.changeDepartment(parts[1], parts[2]);
                        break;
                    case "payroll":
                        system.payroll();
                        break;
                    case "salary":
                        system.salary(parts[1]);
                        break;
                    case "exit":
                        System.out.println("Exiting the program.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Unknown command.");
            }
        }
    }
}