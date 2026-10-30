package cine;

public class BilletEtudiant implements Billet{
    @Override
    public double calculerPrix(double tarifDeBase) {
        return tarifDeBase * 0.75;
    }
}
