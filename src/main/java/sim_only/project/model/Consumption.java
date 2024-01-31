package sim_only.project.model;

public class Consumption {
    private final static String DEFAULT_MONTH = "Onbekend";

    private String month;
    private int mbQuantity;
    private double cost;

    public Consumption(String month, int mbQuantity) {
    }

    public Consumption(String month) {
    }

    public Consumption() {
    }

    public void calculateCosts() {
    }

    public void showUsage() {
    }

    public String getMonth() {
        return "";
    }

    public void setMbQuantity(int mbQuantity) {
    }

    public double getCost(){
        return 0;
    }
}
