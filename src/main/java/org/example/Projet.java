package org.example;

import java.util.ArrayList;
import java.util.List;

public class Projet {

    protected String nom;
    protected List<Tache> listeTache = new ArrayList<>();

    public Projet(String nom) {
        this.nom = nom;
    }

    public List<Tache> getListeTache() {
        return listeTache;
    }

    public void ajouterTache(Tache new_tache){
        listeTache.add(new_tache);
    }

    public int calculerDureeTotale(){
        int dureeTotale = 0;
        for (Tache tache : listeTache){
            int duree = tache.getDuree();
            if(duree>=0){
                dureeTotale += duree;

            }

        }

        return dureeTotale;
    }


}
