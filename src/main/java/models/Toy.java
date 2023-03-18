package models;

public class Toy {
    public static int count = 0;
    private int id;
    private String title;
    private int amount;
    private int weight;

    public Toy(String title, int amount, int weight) {
        this.title = title;
        this.amount = amount;
        this.weight = weight;
    }

    public Toy(int id, String title, int amount, int weight) {
        this(title,amount,weight);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                ", weight=" + weight +
                '}';
    }
}
