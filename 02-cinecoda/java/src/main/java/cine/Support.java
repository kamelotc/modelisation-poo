package cine;
import java.time.LocalDate;

public class Support {
    private final Film film;
    public Support (Film film){
        this.film=film;
    }
    public Film getFilm(){
        return film;
    }
    public abstract void verifierCompatibilite(Projecteur projecteur, LocalDate dateSeance);
}
