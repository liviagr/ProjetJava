package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class GestionTacheTest {


//  Vérifie que la tâche a bien été ajoutée
    @Test
    public void ajouterTacheTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);
        gestionTache.ajouterTache("titre1", "description1", 5);

        Tache tacheTest = projet.getListeTache().get(0);

        Tache expected = new Tache("titre1", "description1", 5);


//      On teste que chaque attribut de expected et tacheTest sont bien identiques
        Assertions.assertTrue(tacheTest.getTitre().equals(expected.getTitre()) && tacheTest.getDescription().equals(expected.getDescription()) &&
                tacheTest.getEtat()==expected.getEtat());
    }

//  Test que la tâche présente dans la liste a bien été complétée
    @Test
    public void completerTacheTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);
        gestionTache.ajouterTache("titre1", "description1", 5);

        gestionTache.completerTache("titre1");
        Tache tache = projet.getListeTache().get(0);

        Assertions.assertTrue(tache.getEtat());

    }

    //  Test quand on veut compléter une tâche non présente
    @Test
    public void completerTacheNonPresenteTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);
        gestionTache.ajouterTache("titre1", "description1", 5);

        gestionTache.completerTache("titr1");
        Tache tache = projet.getListeTache().get(0);

        Assertions.assertFalse(tache.getEtat());

    }

//    Vérifie tâche Non complétée
    @Test
    public void verifierTacheNonCompleteTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);
        gestionTache.ajouterTache("titre1", "description1", 5);

        boolean etat_tache = gestionTache.verifierTache("titre1");

        Assertions.assertFalse(etat_tache);
    }

    //    Vérifie tâche complétée
    @Test
    public void verifierTacheCompleteTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);
        gestionTache.ajouterTache("titre1", "description1", 5);

        gestionTache.completerTache("titre1");
        boolean etat_tache = gestionTache.verifierTache("titre1");

        Assertions.assertTrue(etat_tache);
    }

    //    Vérifie complétion tâche inexistante
    @Test
    public void verifierTacheNonExistanteTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);
        gestionTache.ajouterTache("titre1", "description1", 5);

        boolean etat_tache = gestionTache.verifierTache("titr1");

        Assertions.assertFalse(etat_tache);
    }

}
