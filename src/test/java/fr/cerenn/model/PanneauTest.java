package fr.cerenn.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PanneauTest {
    private static final Logger logger = LoggerFactory.getLogger(PanneauTest.class);
    private Panneau panneauValide;
    private Panneau panneauInvalide;

    @Before
    public void setUp() {
        logger.info("Initialisation des tests Panneau");
        
        // Panneau valide avec toutes les contraintes respectées
        panneauValide = new Panneau(
            1000, // hf
            1000, // lf
            Math.sqrt(1000*1000 + 1000*1000), // diagonale plié
            2000, // hb
            2000, // lb
            Math.sqrt(2000*2000 + 2000*2000)  // diagonale déplié
        );
        logger.debug("Panneau valide créé : hf={}, lf={}, hb={}, lb={}", 
                    1000, 1000, 2000, 2000);

        // Panneau invalide (hb < 320)
        panneauInvalide = new Panneau(
            1000, // hf
            1000, // lf
            Math.sqrt(1000*1000 + 1000*1000), // diagonale plié
            300,  // hb < 320
            2000, // lb
            Math.sqrt(300*300 + 2000*2000)    // diagonale déplié
        );
        logger.debug("Panneau invalide créé : hf={}, lf={}, hb={}, lb={}", 
                    1000, 1000, 300, 2000);
    }

    @Test
    public void testVerifierDimensions_PanneauValide() {
        logger.info("Test vérification dimensions panneau valide");
        boolean resultat = panneauValide.verifierDimensions();
        logger.debug("Résultat vérification : {}", resultat);
        assertTrue("Le panneau valide devrait passer la vérification", resultat);
    }

    @Test
    public void testVerifierDimensions_PanneauInvalide() {
        logger.info("Test vérification dimensions panneau invalide");
        boolean resultat = panneauInvalide.verifierDimensions();
        logger.debug("Résultat vérification : {}", resultat);
        assertFalse("Le panneau invalide ne devrait pas passer la vérification", resultat);
    }

    @Test
    public void testVerifierContraintesMin() {
        logger.info("Test vérification contraintes minimales");
        Panneau panneau = new Panneau(
            1000, // hf
            1000, // lf
            Math.sqrt(1000*1000 + 1000*1000), // diagonale plié
            300,  // hb < 320
            300,  // lb < 320
            Math.sqrt(300*300 + 300*300)       // diagonale déplié
        );
        logger.debug("Panneau test contraintes min créé : hf={}, lf={}, hb={}, lb={}", 
                    1000, 1000, 300, 300);
        boolean resultat = panneau.verifierDimensions();
        logger.debug("Résultat vérification : {}", resultat);
        assertFalse("Les dimensions minimales ne sont pas respectées", resultat);
    }

    @Test
    public void testVerifierContraintesMax() {
        logger.info("Test vérification contraintes maximales");
        Panneau panneau = new Panneau(
            3200, // hf > 3100
            1000, // lf
            Math.sqrt(3200*3200 + 1000*1000), // diagonale plié
            3200, // hb > 3150
            3200, // lb > 3150
            Math.sqrt(3200*3200 + 3200*3200)  // diagonale déplié
        );
        logger.debug("Panneau test contraintes max créé : hf={}, lf={}, hb={}, lb={}", 
                    3200, 1000, 3200, 3200);
        boolean resultat = panneau.verifierDimensions();
        logger.debug("Résultat vérification : {}", resultat);
        assertFalse("Les dimensions maximales ne sont pas respectées", resultat);
    }

    @Test
    public void testVerifierDiagonales() {
        logger.info("Test vérification diagonales");
        Panneau panneau = new Panneau(
            1000, // hf
            1000, // lf
            1500, // diagonale plié incorrecte
            2000, // hb
            2000, // lb
            3000  // diagonale déplié incorrecte
        );
        logger.debug("Panneau test diagonales créé : hf={}, lf={}, hb={}, lb={}", 
                    1000, 1000, 2000, 2000);
        boolean resultat = panneau.verifierDimensions();
        logger.debug("Résultat vérification : {}", resultat);
        assertFalse("Les diagonales ne correspondent pas aux dimensions", resultat);
    }
} 