public class Miner {
    private String name;
    private double rate;
    private double wattage;

    public Miner(String name, double rate, double wattage) {
        this.name = name;
        this.rate = rate;
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "Miner{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", wattage=" + wattage +
                '}';
    }
}
