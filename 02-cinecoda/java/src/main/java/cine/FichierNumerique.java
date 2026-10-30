package cine;

import java.time.LocalDate;

public class FichierNumerique extends Support {
    private final LocalDate dateExpiration;
    public FichierNumerique(Film film, LocalDate dateExpiration);{
        super(film);
        this.dateExpiration=dateExpiration;
    }
    @Override
    public void verifierCompatibilite(Projecteur projecteur, LocalDate dateSeance) {
        if (!(projecteur instanceof ProjecteurNumerique)) {
            throw new IllegalStateException("un fichier numérique ne peut pas être lu par un projecteur argentique");
        }
        if (dateSeance.isAfter(dateExpiration)) {
            throw new IllegalStateException("la clé de lecture de « " + getFilm().getTitre() + " » a expiré");
        }
    }
}