package cine;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Seance {
    private final Salle salle;
    private final Support support;
    private final LocalDate date;
    private final double tarifDeBase;
    private final List<Billet> billets;

    public Seance(Salle salle, Support support, LocalDate date, double tarifDeBase) {
        this.salle = salle;
        this.support = support;
        this.date = date;
        this.tarifDeBase = tarifDeBase;
        this.billets = new ArrayList<>();
    }

    public LocalDate getDate() { return date; }
    public Salle getSalle() { return salle; }
    public Support getSupport() { return support; }
    public double getTarifDeBase() { return tarifDeBase;}
    public List<Billet> getBilletsVendus() { return billets; }

    public void vendre(Billet billet) {
        if (billets.size() >= salle.getCapacite()) {
            throw new IllegalStateException("la séance est complète (" + salle.getCapacite() + " places)");
        }
        billets.add(billet);
    }

    public void debut() {
        if (salle.getEtat() != EtatSalle.LIBRE) {
            throw new IllegalStateException("la Salle " + salle.getNumero() + " n'est pas libre (état : " + salle.getEtat() + ")");
        }
        support.verifierCompatibilite(salle.getProjecteur(), date);
        salle.setEtat(EtatSalle.ENCOURS);
    }

    public void fin() {
        salle.setEtat(EtatSalle.NETTOYAGE);
        if (support instanceof Copie35mm) {
            Copie35mm copie = (Copie35mm) support;
            copie.ajouterProjection();
        }
    }

    public int getPlacesRestantes() {
        return salle.getCapacite() - billets.size();
    }

    public int getTauxRemplissage() {
        return (int) ((billets.size() * 100.0) / salle.getCapacite());
    }

    public double getRecette() {
        double recetteTotale = 0;
        for (Billet billet : billets) {
            recetteTotale += billet.calculerPrix(tarifDeBase);
        }
        return recetteTotale;
    }

}
