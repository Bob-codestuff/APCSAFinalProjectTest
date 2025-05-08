/**
 * The Player class represents a player in a game.
 * Each player has a name and starts with a default amount of money.
 * This class provides functionality to initialize a player with a name,
 * manage their money, and perform operations such as adding or subtracting money.
 */
public class Player {
    private String name;
    private double money; // Player's total money


    public Player(String name) {
        this.name = name;
        this.money = 100.0; 
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