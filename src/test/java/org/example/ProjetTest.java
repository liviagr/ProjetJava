package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProjetTest {

//    Test intégration : ajout des tâches
//    Les tâches sont identiques quelles soient ajoutées par projet ou par le gestionnaire de tâche
    @Test
    public void ajouterTache(){

//        créer la partie "expected"
        Projet projet = new Projet("projet1");
        projet.ajouterTache(new Tache("titre1", "description1", 2));

        Tache tacheExpected = projet.getListeTache().get(0);

//        créer la partie "test"
        Projet projet2 = new Projet("projet2");
        GestionTache gestionTache = new GestionTache(projet2);
        gestionTache.ajouterTache("titre1", "description1", 2);
        Tache tacheTest = projet2.getListeTache().get(0);

        Assertions.assertTrue(tacheExpected.getTitre().equals(tacheTest.getTitre()) && tacheExpected.getDescription().equals(tacheTest.getDescription()) &&
                tacheExpected.getEtat()==tacheTest.getEtat());

    }

//    cas commun : liste pleine et durées positives
    @Test
    public void calculerDureeTotaleTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);

        gestionTache.ajouterTache("titre1", "description1", 3);
        gestionTache.ajouterTache("titre2", "description2", 4);

        int dureeTotale = projet.calculerDureeTotale();

        Assertions.assertEquals(7, dureeTotale);
    }

//    Cas : liste des tâches vides
    @Test
    public void calculerDureeTotaleVideTest(){
        Projet projet = new Projet("projet1");

        int dureeTotale = projet.calculerDureeTotale();

        Assertions.assertEquals(0, dureeTotale);
    }

//    Cas : durées négatives
    @Test
    public void calculerDureeTotaleNegativeTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);

        gestionTache.ajouterTache("titre1", "description1", -3);
        gestionTache.ajouterTache("titre2", "description2", -4);

        int dureeTotale = projet.calculerDureeTotale();

        Assertions.assertEquals(0, dureeTotale);

    }
}
