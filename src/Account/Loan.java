package Account;

public class Loan {
    private int id;
    private int month;
    private double money;
    private double percent;

    public Loan(int id, int month, double money, double percent) {
        this.id = id;
        this.month = month;
        this.money = money;
        this.percent = percent;
    }

    public int getMonth() {
        return month;
    }

    public int getId() {
        return id;
    }

    public double getMoney() {
        return money;
    }

    public double getPercent() {
        return percent;
    }
}
