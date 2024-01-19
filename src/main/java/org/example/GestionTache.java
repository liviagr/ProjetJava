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
        List<Tache> listeTache = projet.getListeTache();
        for (Tache tache : listeTache) {
            if (tache.getTitre().equals(titre)) {
                tache.setEtat(true);
            }
        }
    }

//    Vérifie si une tache est complétée
//    Return l'état de la tâche si elle est trouvée
//    Return false si la tâche n'est pas trouvée
    public boolean verifierTache(String titre){
        List<Tache> listeTache = projet.getListeTache();
        for (Tache tache : listeTache) {
            if (tache.getTitre().equals(titre)) {
                return tache.getEtat();
            }

        }
        return false;


    }


}
