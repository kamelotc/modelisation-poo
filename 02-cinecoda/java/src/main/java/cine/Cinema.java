package cine;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private final String nom;
    private final List<Salle> salles;
    private final List<Seance> historiqueSeances;

    public Cinema(String nom) {
        this.nom = nom;
        this.salles = new ArrayList<>();
        this.historiqueSeances = new ArrayList<>();
    }

    public void ajouterSalle (Salle salle){
        salles.add(salle);
    }

    public Seance programmer(int numeroSalle, Support support, LocalDate date, double tarif){
        Salle salleTrouvee= null;

        for (Salle salle : salles) {
            if (salle.getNumero() == numeroSalle) {
                salleTrouvee = salle;
                break;
            }
        }
        Seance nouvelleSeance = new Seance(salleTrouvee, support, date, tarif);
        historiqueSeances.add(nouvelleSeance);
        return nouvelleSeance;
    }

    public List<Seance> getSeancesDuJour(LocalDate date) {
        List<Seance> seancesDuJour = new ArrayList<>();
        for (Seance seance : historiqueSeances) {
            if (seance.getDate().equals(date)) {
                seancesDuJour.add(seance);
            }
        }
        return seancesDuJour;
    }

    public double getRecetteDuJour(LocalDate date) {
        double total = 0;
        for (Seance seance : getSeancesDuJour(date)) {
            total += seance.getRecette();
        }
        return total;
    }

}
