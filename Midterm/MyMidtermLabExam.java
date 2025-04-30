import java.util.Scanner;

public class MyMidtermLabExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] descriptions = new String[100];
        String[] urgencies = new String[100];
        String[] statuses = new String[100];
        int ticketCount = 0;

        int choice;
        do {
            System.out.println("\n=== IT Ticket System ===");
            System.out.println("1. Add Ticket");
            System.out.println("2. Update Ticket Status");
            System.out.println("3. Show All Tickets");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> {
                    if (ticketCount < 100) {
                        System.out.print("Enter issue description: ");
                        descriptions[ticketCount] = scanner.nextLine();
                        System.out.print("Enter urgency level (Low / Medium / High): ");
                        urgencies[ticketCount] = scanner.nextLine();
                        statuses[ticketCount] = "Open";
                        ticketCount++;
                        System.out.println("Ticket successfully added!");
                    } else {
                        System.out.println("Ticket list full!");
                    }
                }
                case 2 -> {
                    System.out.print("Enter ticket number to update: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    if (index >= 0 && index < ticketCount) {
                        System.out.print("Enter new status (Open / In Progress / Closed): ");
                        statuses[index] = scanner.nextLine();
                        System.out.println("Ticket updated.");
                    } else {
                        System.out.println("Invalid ticket number.");
                    }
                }
                case 3 -> {
                    if (ticketCount == 0) {
                        System.out.println("No tickets found.");
                    } else {
                        for (int i = 0; i < ticketCount; i++) {
                            System.out.println(i + ". Issue: " + descriptions[i] +
                                    " | Urgency: " + urgencies[i] +
                                    " | Status: " + statuses[i]);
                        }
                    }
                }
                case 4 -> {
                    int open = 0, inProgress = 0, closed = 0;
                    for (int i = 0; i < ticketCount; i++) {
                        switch (statuses[i].toLowerCase()) {
                            case "open" -> open++;
                            case "in progress" -> inProgress++;
                            case "closed" -> closed++;
                        }
                    }
                    System.out.println("=== Ticket Report ===");
                    System.out.println("Open: " + open);
                    System.out.println("In Progress: " + inProgress);
                    System.out.println("Closed: " + closed);
                }
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}