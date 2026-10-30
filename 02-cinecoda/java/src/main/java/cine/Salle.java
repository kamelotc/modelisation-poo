package cine;

public class Salle {
    private int numero;
    private int capacite;
    private Projecteur projecteur;
    private EtatSalle etat;

    public Salle(int numero, int capacite, Projecteur projecteur) {
        this.numero = numero;
        this.capacite = capacite;
        this.projecteur = projecteur;
        this.etat = EtatSalle.LIBRE;
    }

    public int getNumero() { return numero; }
    public int getCapacite() { return capacite; }
    public Projecteur getProjecteur() { return projecteur; }
    public EtatSalle getEtat() { return etat; }

    public void setEtat(EtatSalle etat) {
        this.etat = etat;
    }

    public void finNettoyage() {
        if (this.etat != EtatSalle.NETTOYAGE) {
            throw new IllegalStateException("La salle n'est pas en nettoyage.");
        }
        this.etat = EtatSalle.LIBRE;
    }
}