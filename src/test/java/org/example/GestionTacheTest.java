package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.util.ArrayList;
import java.util.List;

public class GestionTacheTest {


    @Test
    public void ajouterTacheTest(){
        Projet projet = new Projet("projet1");
        GestionTache gestionTache = new GestionTache(projet);
        gestionTache.ajouterTache("titre1", "description1", 5);

        List<Tache> listeTache = projet.getTache();
        Tache expected = new Tache("titre1", "description1", 5);

        Assertions.assertEquals(expected.getTitre(), listeTache.get(listeTache.size() -1).getTitre());
        Assertions.assertEquals(expected.getDescription(), listeTache.get(listeTache.size() -1).getDescription());
        Assertions.assertEquals(expected.getDuree(), listeTache.get(listeTache.size() -1).getDuree());

    }



}
