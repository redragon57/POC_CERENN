package fr.cerenn.controller;

import fr.cerenn.model.Panneau;

public class PanneauController {
    private Panneau panneau;

    public PanneauController() {
        this.panneau = null;
    }

    public void creerPanneau(double hauteurPlié, double largeurPlié, double diagonalePlié,
                           double hauteurDéplié, double largeurDéplié, double diagonaleDéplié) {
        this.panneau = new Panneau(hauteurPlié, largeurPlié, diagonalePlié,
                                 hauteurDéplié, largeurDéplié, diagonaleDéplié);
    }

    public boolean verifierDimensionsPanneau() {
        if (panneau == null) {
            throw new IllegalStateException("Aucun panneau n'a été créé");
        }
        return panneau.verifierDimensions();
    }

    public Panneau getPanneau() {
        return panneau;
    }
} 