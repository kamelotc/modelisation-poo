package cine;

import java.time.LocalDate;
import java.util.logging.Logger;
import java.util.Locale;

public class Main {
    private static Logger log;

    public static void main(String[] args) {
        log = ConsoleLogger.create("cine.scenario");
        LocaleDate aujourdHui = LocalDate.of(2026,10,18);

        log.info("création de CineCoda ");
        Cinema cineCoda = new Cinema("CineCoda");

        log.info("création des 2 salles");
        Salle salle1 = new Salle(1, 100, new ProjecteurNumerique());
        Salle salle2 = new Salle(2, 3, new ProjecteurArgentique());
        cineCoda.ajouterSalle(salle1);
        cineCoda.ajouterSalle(salle2);

        log.info("films - supports");
        Film dune = new Film("Dune 3", 166);
        FichierNumerique dcpDune = new FichierNumerique(dune, LocalDate.of(2026, 10, 30));
        Film avengers = new Film("Avengers:Doomsday", 119);
        FichierNumerique dcpavengers = new FichierNumerique(avengers, LocalDate.of(2026, 10, 14));
        Film rocky = new Film("I play Rocky", 103);
        Copie35mm copieRocky = new Copie35mm(rocky, 49);



        // Rejouez ici le scénario de l'énoncé, en affichant chaque étape avec log.info(...)
    }
}
