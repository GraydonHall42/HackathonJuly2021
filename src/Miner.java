public class Miner {
    public String name;
    public double rate;
    public double wattage;

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
