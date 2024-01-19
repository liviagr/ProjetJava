package org.example;

import java.util.ArrayList;
import java.util.List;

public class Projet {

    protected String nom;
    protected List<Tache> tache = new ArrayList<Tache>();

    public Projet(String nom) {
        this.nom = nom;
    }

    public List<Tache> getTache() {
        return tache;
    }

    public void ajouterTache(Tache new_tache){
        tache.add(new_tache);
    }


}
