package Account;

public class Save {
    private int id;
    private int time; // số tháng
    private double percent;
    private double money;

    public Save() {
    }

    public Save(int id, int time, double percent, double money) {
        this.id = id;
        this.time = time;
        this.percent = percent;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
