public class Player {
    private String name;
    private double money; // Player's total money

    public Player(String name) {
        this.name = name;
        this.money = 100.0; // Start with $100
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double amount) {
        this.money += amount;
    }

    public void subtractMoney(double amount) {
        this.money -= amount;
    }

    @Override
    public String toString() {
        return name + " has $" + String.format("%.2f", money);
    }
}