package org.example;

import java.util.List;

public class GestionTache {

    protected Projet projet;

    public GestionTache(Projet projet) {
        this.projet = projet;
    }

    public void ajouterTache(String titre, String description, int duree){
        Tache tache = new Tache(titre, description, duree);
        projet.ajouterTache(tache);

    }

    public void completerTache(String titre) {
        List<Tache> listeTache = projet.getTache();
        for (Tache tache : listeTache) {
            if (tache.getTitre().equals(titre)) {
                int indexOfTache = listeTache.indexOf(tache);
                tache.setEtat(true);
                listeTache.set(indexOfTache, tache);
            }
        }
    }

    public boolean verifierTache(String titre){
        List<Tache> listeTache = projet.getTache();
        for (Tache tache : listeTache) {
            if (tache.getTitre().equals(titre)) {
                return tache.getEtat();
            }

        }
        return false;


    }


}
