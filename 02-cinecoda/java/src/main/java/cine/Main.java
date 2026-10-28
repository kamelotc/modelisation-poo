package cine;

import java.time.LocalDate;
import java.util.logging.Logger;
import java.util.Locale;

public class Main {
    private static Logger log;

    public static void main(String[] args) {
        log = ConsoleLogger.create("cine.scenario");
        LocaleDate aujourdHui = LocalDate.of(2026,10,18);

        log.info("=== 1. Création du cinéma CinéCoda ===");
        Cinema cineCoda = new Cinema("CinéCoda");

        log.info("création des 2 salles");
        Salle salle1 = new Salle(1, 100, new ProjecteurNumerique());
        Salle salle2 = new Salle(2, 3, new ProjecteurArgentique());
        cineCoda.ajouterSalle(salle1);
        cineCoda.ajouterSalle(salle2);
        log.info("Salle 1 : 100 places, projecteur numérique");
        log.info("Salle 2 : 3 places, projecteur argentique");
        log.info("Salles libres : Salle 1, Salle 2");

        log.info("=== 2. Films et supports ===");
        Film dune = new Film("Dune 3", 166);
        FichierNumerique dcpDune = new FichierNumerique(dune, LocalDate.of(2026, 10, 30));
        Film avengers = new Film("Avengers:Doomsday", 119);
        FichierNumerique dcpavengers = new FichierNumerique(avengers, LocalDate.of(2026, 10, 14));
        Film rocky = new Film("I play Rocky", 103);
        Copie35mm copieRocky = new Copie35mm(rocky, 49);
        log.info("Dune 3 (166 min) : fichier numérique, clé valable jusqu'au 30/10/2026");
        log.info("Avengers: Doomsday (119 min) : fichier numérique, clé valable jusqu'au 14/10/2026");
        log.info("I Play Rocky (103 min) : copie 35 mm, 49 projections");

        log.info("=== 3. Dune 3 en Salle 1 le 15/10/2026 (tarif de base 10,00 €) ===");
        Seance seance1 = cineCoda.programmer(1, dcpDune, aujourdHui, 10.00);
        vendreBillet(seance1, new BilletPleinTarif(), "billet plein tarif vendu");
        vendreBillet(seance1, new BilletPleinTarif(), "billet plein tarif vendu");
        vendreBillet(seance1, new BilletEtudiant(), "billet etudiant vendu");
        vendreBillet(seance1, new BilletEnfant(), "billet enfant vendu");
        log.info("Places restantes : " + seance1.getPlacesRestantes());
        log.info("Taux de remplissage : " + seance1.getTauxRemplissage() + " %");
        log.info(String.format(Locale.FRANCE, "Recette : %.2f €", seance1.getRecette()));

        log.info("=== 4. Avengers: Doomsday en Salle 1 le 15/10/2026 (tarif de base 10,00 €) ===");
        Seance seance2 = cineCoda.programmer(1, dcpavengers, aujourdHui, 10.00);
        tenterDemarrage(seance2);

        log.info("=== 5. I Play Rocky en Salle 1 le 15/10/2026 (tarif de base 10,00 €) ===");
        Seance seance3 = cineCoda.programmer(1, copieRocky, aujourdHui, 10.00);
        tenterDemarrage(seance3);
        log.info("État de la Salle 1 : " + salle1.getEtat());

        log.info("=== 6. I Play Rocky en Salle 2 le 15/10/2026 (tarif de base 8,00 €) ===");
        Seance seance4 = cineCoda.programmer(2, copieRocky, aujourdHui, 10.00);
        vendreBillet(seance4, new BilletEtudiant(), "billet etudiant vendu");
        vendreBillet(seance4, new BilletEtudiant(), "billet etudiant vendu");
        vendreBillet(seance4, new BilletEtudiant(), "billet etudiant vendu");

        try{
            seance4.vendre(new BilletEtudiant());
        }catch(IllegalStateException e){
            log.info("Vente refusée : " + e.getMessage());
        }
        log.info("Place restantes: " + seance4.getPlaceRestantes());
        log.info("Taux de remplissage : " + seance4.getTauxRemplissage() + " %");
        seance4.debut();
        log.info("Séance démarrée");
        seance4.fin();
        log.info("Séance terminée");
        log.info("État de la Salle 2 : " + salle2.getEtat());
        log.info("Salles libres : Salle 1");
        log.info("Projections de la copie de « I Play Rocky » : " + copieRocky.getNbProjections());






        // Rejouez ici le scénario de l'énoncé, en affichant chaque étape avec log.info(...)
    }
}
