package sim_only.project.model;

public class Verbruik {

    private final static String STANDAARD_MAAND = "Onbekend";

    private final static double BASIS_KOSTEN = 9.95;
    private final static int VERBRUIK_ABONNEMENT = 3000;
    private final static double MEERPRIJS_MB = 0.025;

    private String maand;
    private int hoeveelheidMB;
    private double kosten;

    public Verbruik(String maand, int hoeveelheidMB) {
        this.maand = maand;
        this.hoeveelheidMB = hoeveelheidMB;
    }

    public Verbruik(String maand) {
        this(maand, 0);
    }

    public Verbruik() {
        this(STANDAARD_MAAND);
    }

    public void berekenKosten() {
        // Berekening: in elk geval Basis kosten, eventueel meerprijs
        kosten = BASIS_KOSTEN;
        if (hoeveelheidMB > VERBRUIK_ABONNEMENT) {
            kosten += (hoeveelheidMB - VERBRUIK_ABONNEMENT) * MEERPRIJS_MB;
        }
    }

    public void toonVerbruik() {
        String info = "";
        if (hoeveelheidMB > VERBRUIK_ABONNEMENT) {
            info = "buiten je bundel!";
        }
        System.out.printf("%-14s%5d%7.2f %20s
", maand, hoeveelheidMB, kosten, info );
    }

    public String getMaand() {
        return maand;
    }

    public void setHoeveelheidMB(int hoeveelheidMB) {
        this.hoeveelheidMB = hoeveelheidMB;
    }

    public double getKosten(){
        return kosten;
    }
}
