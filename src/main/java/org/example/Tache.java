package org.example;

public class Tache {

    protected String titre;
    protected String description;

    // indique si la tâche est complétée ou non
    protected boolean complete = false;

    protected int duree;

    public Tache(String titre, String description, int duree) {
        this.titre = titre;
        this.description = description;
        this.duree = duree;
    }


    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public boolean getEtat() {
        return complete;
    }

    public int getDuree() {
        return duree;
    }

    public void setEtat(boolean complete) {
        this.complete = complete;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}


