package Projektarbeit;

import static org.junit.jupiter.api.Assertions.*;

class SchuheTest {

    @org.junit.jupiter.api.Test
    void applyDiscount() {
        // Arrange (Vorbereiten)
        Schuhe schuhe = new Schuhe("Nike", 40, 100, true);

        // Act (Methode ausführen)
        schuhe.applyDiscount(0.8); // 20 % Rabatt

        // Assert (Ergebnis prüfen)
        assertEquals(80.0, schuhe.getPreis());

    }
}