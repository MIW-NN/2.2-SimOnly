package sim_only.project.model;

import org.junit.Assert;
import org.junit.Test;

public class VerbruikTest {

    @Test
    public void geefJuisteMaandnaam() {
        var maand = "13de maand";

        var verbruik = new Verbruik(maand);

        Assert.assertEquals(maand,verbruik.getMaand());
    }

    @Test
    public void berekenKostenOpBasisVanInitieelVerbruik() {
        var verbruik = new Verbruik("13de maand", 3040);

        verbruik.berekenKosten();

        Assert.assertEquals(10.95,verbruik.getKosten(),0.001);
    }

    @Test
    public void berekenKostenOpBasisVanLaterVerbruik() {
        var verbruik = new Verbruik("13de maand");

        verbruik.berekenKosten();
        verbruik.setHoeveelheidMB(3080);
        verbruik.berekenKosten();

        Assert.assertEquals(11.95,verbruik.getKosten(),0.001);
    }
}