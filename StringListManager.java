import java.util.ArrayList;
import java.util.Scanner;

public class StringListManager {
    private ArrayList<String> list;

    public StringListManager() {
        list = new ArrayList<>();
    }

    public void insert(String value) {
        list.add(value);
        System.out.println("Inserted: " + value);
    }

    public void update(int index, String newValue) {
        if (index >= 0 && index < list.size()) {
            String oldValue = list.set(index, newValue);
            System.out.println("Updated index " + index + ": " + oldValue + " to " + newValue);
        } else {
            System.out.println("Index out of bounds.");
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < list.size()) {
            String removedValue = list.remove(index);
            System.out.println("Deleted: " + removedValue);
        } else {
            System.out.println("Index out of bounds.");
        }
    }

    public void search(String value) {
        int index = list.indexOf(value);
        if (index != -1) {
            System.out.println("Found '" + value + "' at index: " + index);
        } else {
            System.out.println("'" + value + "' not found in the list.");
        }
    }

    public void display() {
        System.out.println("Current List: " + list);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringListManager manager = new StringListManager();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Display List");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter string to insert: ");
                    String toInsert = scanner.nextLine();
                    manager.insert(toInsert);
                    break;
                case 2:
                    System.out.print("Enter index to update: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new string: ");
                    String newValue = scanner.nextLine();
                    manager.update(updateIndex, newValue);
                    break;
                case 3:
                    System.out.print("Enter index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    manager.delete(deleteIndex);
                    break;
                case 4:
                    System.out.print("Enter string to search: ");
                    String toSearch = scanner.nextLine();
                    manager.search(toSearch);
                    break;
                case 5:
                    manager.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
