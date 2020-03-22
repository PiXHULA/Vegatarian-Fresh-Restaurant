import java.util.Scanner;

public class View {
    Scanner sc;
    String userInput;

    public void printMessage(String message) {
        System.out.println(message);
    }

    public View() {
        Menu menu = new Menu (this);
        sc = new Scanner(System.in);
        printMessage("Welcome to Restaurant Vegetarian Fresh!");
        while (true){
        menu.showMenu();
        printMessage("Do you want to see the menu sorted by price in an ascending order? Type [Yes] or [No]");
        userInput = sc.nextLine().trim().toLowerCase();
        if(userInput.equals("yes")){
            menu.showMenuSorted();
            printMessage("Do you want to see the menu again? Type [Yes] or [No]");
            userInput = sc.nextLine().trim().toLowerCase();
            if(userInput.equals("no")) {
                printMessage("Good bye, please come back again!");
                System.exit(0);
            }
        } else if (userInput.equals("no")){
            printMessage("Good bye, please come back again!");
            System.exit(0);
        }else
            printMessage("You didn't write [Yes] or [No]\nPlease try again:");
        }
    }
    public static void main(String[] args) {
        View view = new View();
    }
}
