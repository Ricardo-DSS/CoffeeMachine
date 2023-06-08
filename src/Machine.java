public class Machine {

    public int water = 400;
    public int milk = 540;
    public int beans = 120;
    public int cups = 9;
    public int money = 550;

    public void buyCoffee(String option) {
        switch (option) {
            case "1" -> {
                water -= CoffeeTypes.ESPRESSO.getWater();
                milk  -= CoffeeTypes.ESPRESSO.getMilk();
                beans -= CoffeeTypes.ESPRESSO.getBeans();
                cups  -= 1;
                money += CoffeeTypes.ESPRESSO.getPrice();
            }
            case "2" -> {
                water -= CoffeeTypes.LATTE.getWater();
                milk  -= CoffeeTypes.LATTE.getMilk();
                beans -= CoffeeTypes.LATTE.getBeans();
                cups  -= 1;
                money += CoffeeTypes.LATTE.getPrice();
            }
            case "3" -> {
                water -= CoffeeTypes.CAPPUCCINO.getWater();
                milk  -= CoffeeTypes.CAPPUCCINO.getMilk();
                beans -= CoffeeTypes.CAPPUCCINO.getBeans();
                cups  -= 1;
                money += CoffeeTypes.CAPPUCCINO.getPrice();
            }
        }
    }

    public String isPossibleToMake(String option) {
        int water = 0;
        int milk = 0;
        int beans = 0;
        int cups = this.cups - 1;
        switch (option) {
            case "1" -> {
                water = this.water - CoffeeTypes.ESPRESSO.getWater();
                milk  = this.milk  - CoffeeTypes.ESPRESSO.getMilk();
                beans = this.beans - CoffeeTypes.ESPRESSO.getBeans();
            }
            case "2" -> {
                water = this.water - CoffeeTypes.LATTE.getWater();
                milk  = this.milk  - CoffeeTypes.LATTE.getMilk();
                beans = this.beans - CoffeeTypes.LATTE.getBeans();
            }
            case "3" -> {
                water = this.water - CoffeeTypes.CAPPUCCINO.getWater();
                milk  = this.milk  - CoffeeTypes.CAPPUCCINO.getMilk();
                beans = this.beans - CoffeeTypes.CAPPUCCINO.getBeans();
            }
        }
        if (water < 0 && milk < 0 && beans < 0 && cups < 0) {
            return "Sorry, not enough water, milk, beans and cups!";
        } else if (water < 0) {
            return "Sorry, not enough water!";
        } else if (milk < 0) {
            return "Sorry, not enough milk!";
        } else if (beans < 0) {
            return "Sorry, not enough beans!";
        } else if (cups < 0) {
            return "Sorry, not enough cups!";
        }
        return "1";
    }

    public void updateSupplies(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk  += milk;
        this.beans += beans;
        this.cups  += cups;
    }

    public void takeMoney() {
        money = 0;
    }

}
