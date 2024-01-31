package sim_only.project.model;

public class Consumption {

    private final static String DEFAULT_MONTH = "Onbekend";

    private final static double BASIC_COST = 9.95;
    private final static int SUBSCRIPTION_CONSUMPTION = 3000;
    private final static double ADDITIONAL_CHARGE = 0.025;

    private String month;
    private int mbQuantity;
    private double cost;

    public Consumption(String month, int mbQuantity) {
        this.month = month;
        this.mbQuantity = mbQuantity;
    }

    public Consumption(String month) {
        this(month, 0);
    }

    public Consumption() {
        this(DEFAULT_MONTH);
    }

    public void calculateCosts() {
        // Berekening: in elk geval Basis kosten, eventueel meerprijs
        cost = BASIC_COST;
        if (mbQuantity > SUBSCRIPTION_CONSUMPTION) {
            cost += (mbQuantity - SUBSCRIPTION_CONSUMPTION) * ADDITIONAL_CHARGE;
        }
    }

    public void showUsage() {
        String info = "";
        if (mbQuantity > SUBSCRIPTION_CONSUMPTION) {
            info = "buiten je bundel!";
        }
        System.out.printf("%-14s%5d%7.2f %20s\n", month, mbQuantity, cost, info );
    }

    public String getMonth() {
        return month;
    }

    public void setMbQuantity(int mbQuantity) {
        this.mbQuantity = mbQuantity;
    }

    public double getCost(){
        return cost;
    }
}
