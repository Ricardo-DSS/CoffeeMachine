import java.util.Scanner;

public class Control {

    Scanner scanner = new Scanner(System.in);
    Machine machine = new Machine();
    private boolean executeProgram = true;

    public void menu() {
        while (executeProgram) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String option = scanner.next();
            switch (option) {
                case "buy"       -> buy();
                case "fill"      -> fill();
                case "take"      -> take();
                case "remaining" -> machineStatus();
                case "exit"      -> executeProgram = false;
            }
        }
    }

    private void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String option = scanner.next();
        if (!"back".equals(option)) {
            String result = machine.isPossibleToMake(option);
            if ("1".equals(result)) {
                System.out.println("I have enough resources, making you a coffee!");
                machine.buyCoffee(option);
                System.out.println();
            } else {
                System.out.println(result);
            }
        }
    }

    private void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int beans = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        int cups = scanner.nextInt();
        machine.updateSupplies(water, milk, beans, cups);
        System.out.println();
    }

    private void take() {
        System.out.println("I gave you: $" + machine.money);
        machine.takeMoney();
        System.out.println();
    }

    private void machineStatus() {
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """, machine.water, machine.milk, machine.beans, machine.cups, machine.money);
        System.out.println();
    }
}
