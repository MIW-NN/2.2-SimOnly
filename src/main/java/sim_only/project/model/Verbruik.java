package sim_only.project.model;

public class Verbruik {
    private final static String DEFAULT_MAAND = "Onbekend";

    private String maand;
    private int hoeveelheidMB;
    private double kosten;

    public Verbruik(String maand, int hoeveelheidMB) {
    }

    public Verbruik(String maand) {
    }

    public Verbruik() {
    }

    public void berekenKosten() {
    }

    public void toonVerbruik() {
    }

    public String getMaand() {
        return "";
    }

    public void setHoeveelheidMB(int hoeveelheidMB) {
    }

    public double getKosten(){
        return 0;
    }
}
