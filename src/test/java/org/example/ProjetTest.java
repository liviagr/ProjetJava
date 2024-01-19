package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProjetTest {



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
