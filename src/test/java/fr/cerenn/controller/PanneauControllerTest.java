package fr.cerenn.controller;

import fr.cerenn.model.Panneau;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PanneauControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(PanneauControllerTest.class);
    private PanneauController controller;

    @Before
    public void setUp() {
        logger.info("Initialisation des tests PanneauController");
        controller = new PanneauController();
    }

    @Test
    public void testCreerPanneau() {
        logger.info("Test création panneau");
        controller.creerPanneau(
            1000, // hf
            1000, // lf
            Math.sqrt(1000*1000 + 1000*1000), // diagonale plié
            2000, // hb
            2000, // lb
            Math.sqrt(2000*2000 + 2000*2000)  // diagonale déplié
        );

        Panneau panneau = controller.getPanneau();
        logger.debug("Panneau créé : hf={}, lf={}, hb={}, lb={}", 
                    1000, 1000, 2000, 2000);
        assertNotNull("Le panneau devrait être créé", panneau);
        assertEquals(1000, panneau.getHauteurPlié(), 0.001);
        assertEquals(2000, panneau.getHauteurDéplié(), 0.001);
    }

    @Test
    public void testVerifierDimensionsPanneau_PanneauValide() {
        logger.info("Test vérification dimensions panneau valide");
        controller.creerPanneau(
            1000, // hf
            1000, // lf
            Math.sqrt(1000*1000 + 1000*1000), // diagonale plié
            2000, // hb
            2000, // lb
            Math.sqrt(2000*2000 + 2000*2000)  // diagonale déplié
        );

        boolean resultat = controller.verifierDimensionsPanneau();
        logger.debug("Résultat vérification : {}", resultat);
        assertTrue("Les dimensions devraient être valides", resultat);
    }

    @Test
    public void testVerifierDimensionsPanneau_PanneauInvalide() {
        logger.info("Test vérification dimensions panneau invalide");
        controller.creerPanneau(
            1000, // hf
            1000, // lf
            Math.sqrt(1000*1000 + 1000*1000), // diagonale plié
            300,  // hb < 320
            2000, // lb
            Math.sqrt(300*300 + 2000*2000)    // diagonale déplié
        );

        boolean resultat = controller.verifierDimensionsPanneau();
        logger.debug("Résultat vérification : {}", resultat);
        assertFalse("Les dimensions ne devraient pas être valides", resultat);
    }

    @Test(expected = IllegalStateException.class)
    public void testVerifierDimensionsPanneau_SansPanneau() {
        logger.info("Test vérification dimensions sans panneau");
        controller.verifierDimensionsPanneau();
    }
} 