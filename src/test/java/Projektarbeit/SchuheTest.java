package Projektarbeit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchuheTest {

    @org.junit.jupiter.api.Test
    void applyDiscounttest() {
        // Arrange (Vorbereiten)
        Schuhe schuhe = new Schuhe("Nike", 40, 100, true);

        // Act (Methode ausführen)
        schuhe.applyDiscount(0.8); // 20 % Rabatt

        // Assert (Ergebnis prüfen)
        assertEquals(80.0, schuhe.getPreis());

    }

    @Test
    void testToString() {
        Schuhe schuhe = new Schuhe("Nike", 40, 100, true);

        assertEquals("Marke: Nike\nGröße: 40\nPreis: 100,00 €\nIst wasserdicht", schuhe.toString());
    }
}
