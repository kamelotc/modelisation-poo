package cine;

import java.time.LocalDate;

public class FichierNumerique {
    private final LocalDate dateExpiration;
    public FichierNumerique(Film film, LocalDate dateExpiration);{
        super(film);
        this.dateExpiration=dateExpiration;
    }
    @Override
    public void verifierCompatibilite(Projecteur projecteur, LocalDate dateSeance) {
        if (!(projecteur instanceof ProjecteurNumerique)) {
            throw new IllegalStateException("projecteur argentique ne peux pas lire fichier numerique");
        }
        if (dateSeance.isAfter(dateExpiration)) {
            throw new IllegalStateException("la clé de lecture de « " + getFilm().getTitre() + " » a expiré");
        }
    }
}