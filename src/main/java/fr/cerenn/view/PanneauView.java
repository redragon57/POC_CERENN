package fr.cerenn.view;

import fr.cerenn.controller.PanneauController;
import java.util.Scanner;

public class PanneauView {
    private PanneauController controller;
    private Scanner scanner;

    public PanneauView() {
        this.controller = new PanneauController();
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        System.out.println("\n=== Gestion des dimensions de panneau ===");
        System.out.println("1. Créer un nouveau panneau");
        System.out.println("2. Vérifier les dimensions");
        System.out.println("3. Afficher les contraintes");
        System.out.println("4. Quitter");
        System.out.print("Choix : ");
    }

    public void afficherContraintes() {
        System.out.println("\n=== Contraintes de dimensions ===");
        System.out.println("1. Largeur déplié (lb) > 320 mm");
        System.out.println("2. Hauteur déplié (hb) > 320 mm");
        System.out.println("3. √(hf² + lb²) < 3200 mm");
        System.out.println("4. √(hb² + lf²) < 3200 mm");
        System.out.println("5. Hauteur déplié (hb) < 3150 mm");
        System.out.println("6. Largeur déplié (lb) < 3150 mm");
        System.out.println("7. Hauteur plié (hf) < 3100 mm");
    }

    public void saisirDimensions() {
        System.out.println("\nSaisie des dimensions du panneau (en mm) :");
        
        System.out.print("Hauteur plié (hf) : ");
        double hauteurPlié = scanner.nextDouble();
        
        System.out.print("Largeur plié (lf) : ");
        double largeurPlié = scanner.nextDouble();
        
        System.out.print("Diagonale plié : ");
        double diagonalePlié = scanner.nextDouble();
        
        System.out.print("Hauteur déplié (hb) : ");
        double hauteurDéplié = scanner.nextDouble();
        
        System.out.print("Largeur déplié (lb) : ");
        double largeurDéplié = scanner.nextDouble();
        
        System.out.print("Diagonale déplié : ");
        double diagonaleDéplié = scanner.nextDouble();

        controller.creerPanneau(hauteurPlié, largeurPlié, diagonalePlié,
                              hauteurDéplié, largeurDéplié, diagonaleDéplié);
    }

    public void verifierDimensions() {
        try {
            boolean valide = controller.verifierDimensionsPanneau();
            if (valide) {
                System.out.println("\n✅ Toutes les dimensions sont valides !");
            } else {
                System.out.println("\n❌ Certaines dimensions ne sont pas valides !");
                System.out.println("Veuillez vérifier les contraintes suivantes :");
                afficherContraintes();
            }
        } catch (IllegalStateException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void executer() {
        boolean continuer = true;
        while (continuer) {
            afficherMenu();
            int choix = scanner.nextInt();
            
            switch (choix) {
                case 1:
                    saisirDimensions();
                    break;
                case 2:
                    verifierDimensions();
                    break;
                case 3:
                    afficherContraintes();
                    break;
                case 4:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        PanneauView view = new PanneauView();
        view.executer();
    }
} 