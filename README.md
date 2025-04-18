# Panneau MVC

[![CI/CD Pipeline](https://github.com/[VOTRE_USERNAME]/panneau-mvc/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/[VOTRE_USERNAME]/panneau-mvc/actions/workflows/ci-cd.yml)
[![SonarQube](https://sonarcloud.io/api/project_badges/measure?project=panneau-mvc&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=panneau-mvc)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=panneau-mvc&metric=coverage)](https://sonarcloud.io/summary/new_code?id=panneau-mvc)

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
- Tests unitaires avec rapport de couverture
- Analyse de code avec SonarQube
- Création automatique de release

Le pipeline se déclenche :
- À chaque push sur la branche main
- À chaque pull request sur la branche main

## Tests

Pour exécuter les tests :
```bash
mvn test
```

Les rapports de test et de couverture sont disponibles dans :
- `target/surefire-reports/` pour les résultats des tests
- `target/site/jacoco/` pour le rapport de couverture

## Licence

Ce projet est sous licence MIT. 