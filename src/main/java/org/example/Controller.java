package org.example;

import java.util.List;

public class Controller {

    public String afficherListeTaches(List<Tache> listeTache){
        String resultat = "";
        if(listeTache.size()>0){
            for (Tache tache : listeTache) {
                resultat += "\nTitre : " + tache.getTitre() + "\nDesciption : " + tache.getDescription() + "\nComplétée : " + tache.getEtat() + "\nDurée : " + tache.getDuree();

            }
        }else{
            resultat = "Il n'y a pas de tâches dans la liste";
        }

        return resultat;
    }
}
