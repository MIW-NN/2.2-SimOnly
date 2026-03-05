package sim_only.project.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VerbruikTest {

    // @BeforeEach: maak gedeelde objecten aan vóór elke test
    private Verbruik verbruikBinnenBundel;
    private Verbruik verbruikBuitenBundel;

    @BeforeEach
    void setUp() {
        verbruikBinnenBundel = new Verbruik("Oktober", 2000);
        verbruikBuitenBundel = new Verbruik("Augustus", 4000);
    }

    // --- berekenKosten ---

    @Test
    void berekenKosten_binnenBundel_geeftBasisprijs() {
        verbruikBinnenBundel.berekenKosten();
        assertEquals(9.95, verbruikBinnenBundel.getKosten(), 0.001);
    }

    @Test
    void berekenKosten_buitenBundel_geeftBasisprijsPlusOpslag() {
        // 9.95 + (4000 - 3000) * 0.025 = 9.95 + 25.00 = 34.95
        verbruikBuitenBundel.berekenKosten();
        assertEquals(34.95, verbruikBuitenBundel.getKosten(), 0.001);
    }

    @Test
    void berekenKosten_preciesOpBundelgrens_geeftBasisprijs() {
        Verbruik verbruik = new Verbruik("Januari", 3000);
        verbruik.berekenKosten();
        assertEquals(9.95, verbruik.getKosten(), 0.001);
    }

    @Test
    void berekenKosten_grootVerbruik_geeftJuistBedrag() {
        // 9.95 + (5000 - 3000) * 0.025 = 9.95 + 50.00 = 59.95
        Verbruik verbruik = new Verbruik("December", 5000);
        verbruik.berekenKosten();
        assertEquals(59.95, verbruik.getKosten(), 0.001);
    }

    // --- setHoeveelheidMB ---

    @Test
    void setHoeveelheidMB_aanpassenEnHerberekenen_geeftJuistBedrag() {
        verbruikBinnenBundel.setHoeveelheidMB(5000);
        verbruikBinnenBundel.berekenKosten();
        // 9.95 + (5000 - 3000) * 0.025 = 9.95 + 50.00 = 59.95
        assertEquals(59.95, verbruikBinnenBundel.getKosten(), 0.001);
    }

    // --- getMaand ---

    @Test
    void getMaand_naConstructor_geeftJuisteMaand() {
        assertEquals("Oktober", verbruikBinnenBundel.getMaand());
    }
}
