package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ControllerTest {

//    Cas normal avec 2 tâches à afficher dans la liste
    @Test
    public void afficherListeTacheTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);
        Controller controller = new Controller();

//        ajout des tâches
        gestionTache.ajouterTache("titre1", "description1", 2);
        gestionTache.ajouterTache("titre2", "description2", 3);

//        change le statut d'une pour vérifier le changement de l'affichage
        gestionTache.completerTache("titre2");

//        Résultat de la fonction (à tester)
        String res = controller.afficherListeTaches(projet.getListeTache());

//        Création de la chaîne expected
        String expected = "\nTitre : titre1\nDesciption : description1\nComplétée : false\nDurée : 2";
        expected += "\nTitre : titre2\nDesciption : description2\nComplétée : true\nDurée : 3";

//        Les deux chaînes sont égales
        Assertions.assertTrue(expected.equals(res));
    }

//    Cas si liste vide
    @Test
    public void afficherListeTacheVideTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);
        Controller controller = new Controller();

        String res = controller.afficherListeTaches(projet.getListeTache());

//        Résultat égale au message en cas de liste vide
        Assertions.assertTrue(res.equals("Il n'y a pas de tâches dans la liste"));

    }

}
