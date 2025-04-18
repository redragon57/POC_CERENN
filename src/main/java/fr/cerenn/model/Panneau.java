package fr.cerenn.model;

public class Panneau {
    private static final double CONTRAINTE_MIN = 320;
    private static final double CONTRAINTE_MAX = 3200;
    private static final double CONTRAINTE_HAUTEUR_MAX = 3150;
    private static final double CONTRAINTE_HAUTEUR_FINI_MAX = 3100;

    private double hauteurPlié;
    private double largeurPlié;
    private double diagonalePlié;
    private double hauteurDéplié;
    private double largeurDéplié;
    private double diagonaleDéplié;

    public Panneau(double hauteurPlié, double largeurPlié, double diagonalePlié,
                  double hauteurDéplié, double largeurDéplié, double diagonaleDéplié) {
        this.hauteurPlié = hauteurPlié;
        this.largeurPlié = largeurPlié;
        this.diagonalePlié = diagonalePlié;
        this.hauteurDéplié = hauteurDéplié;
        this.largeurDéplié = largeurDéplié;
        this.diagonaleDéplié = diagonaleDéplié;
    }

    public boolean verifierDimensions() {
        // Vérification des dimensions pliées
        boolean dimensionsPliéesValides = verifierDimensionsPliées();
        
        // Vérification des dimensions dépliées
        boolean dimensionsDépliéesValides = verifierDimensionsDépliées();
        
        // Vérification des contraintes spécifiques
        boolean contraintesValides = verifierContraintes();
        
        return dimensionsPliéesValides && dimensionsDépliéesValides && contraintesValides;
    }

    private boolean verifierDimensionsPliées() {
        double diagonaleCalculée = Math.sqrt(Math.pow(hauteurPlié, 2) + Math.pow(largeurPlié, 2));
        return Math.abs(diagonaleCalculée - diagonalePlié) < 0.001;
    }

    private boolean verifierDimensionsDépliées() {
        double diagonaleCalculée = Math.sqrt(Math.pow(hauteurDéplié, 2) + Math.pow(largeurDéplié, 2));
        return Math.abs(diagonaleCalculée - diagonaleDéplié) < 0.001;
    }

    private boolean verifierContraintes() {
        // lb > 320 et hb > 320
        boolean dimensionsMinValides = largeurDéplié > CONTRAINTE_MIN && hauteurDéplié > CONTRAINTE_MIN;
        
        // sqrt(hf^2+lb^2) < 3200
        boolean diagonale1Valide = Math.sqrt(Math.pow(hauteurPlié, 2) + Math.pow(largeurDéplié, 2)) < CONTRAINTE_MAX;
        
        // sqrt(hb^2+lf^2) < 3200
        boolean diagonale2Valide = Math.sqrt(Math.pow(hauteurDéplié, 2) + Math.pow(largeurPlié, 2)) < CONTRAINTE_MAX;
        
        // hb < 3150 et lb < 3150
        boolean dimensionsMaxValides = hauteurDéplié < CONTRAINTE_HAUTEUR_MAX && largeurDéplié < CONTRAINTE_HAUTEUR_MAX;
        
        // hf < 3100
        boolean hauteurFiniValide = hauteurPlié < CONTRAINTE_HAUTEUR_FINI_MAX;

        return dimensionsMinValides && diagonale1Valide && diagonale2Valide && 
               dimensionsMaxValides && hauteurFiniValide;
    }

    // Getters et Setters
    public double getHauteurPlié() {
        return hauteurPlié;
    }

    public void setHauteurPlié(double hauteurPlié) {
        this.hauteurPlié = hauteurPlié;
    }

    public double getLargeurPlié() {
        return largeurPlié;
    }

    public void setLargeurPlié(double largeurPlié) {
        this.largeurPlié = largeurPlié;
    }

    public double getDiagonalePlié() {
        return diagonalePlié;
    }

    public void setDiagonalePlié(double diagonalePlié) {
        this.diagonalePlié = diagonalePlié;
    }

    public double getHauteurDéplié() {
        return hauteurDéplié;
    }

    public void setHauteurDéplié(double hauteurDéplié) {
        this.hauteurDéplié = hauteurDéplié;
    }

    public double getLargeurDéplié() {
        return largeurDéplié;
    }

    public void setLargeurDéplié(double largeurDéplié) {
        this.largeurDéplié = largeurDéplié;
    }

    public double getDiagonaleDéplié() {
        return diagonaleDéplié;
    }

    public void setDiagonaleDéplié(double diagonaleDéplié) {
        this.diagonaleDéplié = diagonaleDéplié;
    }
} 