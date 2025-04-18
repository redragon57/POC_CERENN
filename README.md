# Panneau MVC

Application Java pour la gestion des dimensions de panneaux avec vérification des contraintes.

## Prérequis

- Java 11 ou supérieur
- Maven 3.6 ou supérieur
- SonarQube (pour l'analyse de code)

## Installation

1. Cloner le repository :
```bash
git clone [URL_DU_REPO]
cd panneau-mvc
```

2. Configurer SonarQube :
   - Créer un compte sur SonarQube
   - Générer un token d'authentification
   - Configurer les secrets GitHub :
     - `SONAR_TOKEN` : Token d'authentification SonarQube
     - `SONAR_HOST_URL` : URL de votre instance SonarQube

## Utilisation

1. Compiler le projet :
```bash
mvn clean install
```

2. Exécuter l'application :
```bash
mvn exec:java -Dexec.mainClass="fr.cerenn.view.PanneauView"
```

## Contraintes de dimensions

Les contraintes suivantes sont vérifiées :
1. Largeur déplié (lb) > 320 mm
2. Hauteur déplié (hb) > 320 mm
3. √(hf² + lb²) < 3200 mm
4. √(hb² + lf²) < 3200 mm
5. Hauteur déplié (hb) < 3150 mm
6. Largeur déplié (lb) < 3150 mm
7. Hauteur plié (hf) < 3100 mm

## CI/CD

Le projet utilise GitHub Actions pour :
- Compilation automatique
- Tests unitaires
- Analyse de code avec SonarQube

## Tests

Pour exécuter les tests :
```bash
mvn test
```

## Licence

Ce projet est sous licence MIT. 