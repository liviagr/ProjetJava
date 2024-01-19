package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class GestionTacheTest {


//  Vérifie que la tâche a bien été ajoutée à la liste des tâches
    @Test
    public void ajouterTacheTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);
        gestionTache.ajouterTache("titre1", "description1", 5);

//        on récupère la tâche qu'on vient de créer (il n'y a qu'un seul élément donc 0)
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

//        complète la tâche qui vient d'être ajoutée
        gestionTache.completerTache("titre1");
        Tache tache = projet.getListeTache().get(0);

//        comme elle a été complétée, sont état devrait être true
        Assertions.assertTrue(tache.getEtat());

    }

    //  Test quand on veut compléter une tâche non présente
    @Test
    public void completerTacheNonPresenteTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);
        gestionTache.ajouterTache("titre1", "description1", 5);

//        il n'y a pas d'erreur quand on complète une tâche inexistante (géré dans le code)
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

        //tâche non complétée : état = false
        Assertions.assertFalse(etat_tache);
    }

    // Vérifie tâche est bien complétée
    @Test
    public void verifierTacheCompleteTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);
        gestionTache.ajouterTache("titre1", "description1", 5);

//        on complète la tache
        gestionTache.completerTache("titre1");
        boolean etat_tache = gestionTache.verifierTache("titre1");

//        l'état de la tâche doit être à true
        Assertions.assertTrue(etat_tache);
    }


    //    Vérifie complétion tâche inexistante
    @Test
    public void verifierTacheNonExistanteTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);
        gestionTache.ajouterTache("titre1", "description1", 5);

//        si tâche inexistante, renvoie false
        boolean etat_tache = gestionTache.verifierTache("titr1");

        Assertions.assertFalse(etat_tache);
    }

}
