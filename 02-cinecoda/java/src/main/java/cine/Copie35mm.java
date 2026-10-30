package cine;
import java.time.LocalDate;

public class Copie35mm extends Support{
    private int nbProjections;

    public Copie35mm(Film film, int nbProjections){
        super(film);
        this.nbProjections = nbProjections;
    }
    public int getNbProjections() {
        return nbProjections;
    }
    public void ajouterProjection() {
        this.nbProjections++;
    }
    @Override
    public void verifierCompatibilite(Projecteur projecteur, LocalDate dateSeance){
        if (!(projecteur instanceof ProjecteurArgentique)) {
            throw new IllegalStateException("une copie 35 mm ne peut pas être lue par un projecteur numérique");
        }
        if (nbProjections >= 50) {
            throw new IllegalStateException("la copie 35 mm de « " + getFilm().getTitre() + " » est usée (50 projections)");
        }
    }

}
