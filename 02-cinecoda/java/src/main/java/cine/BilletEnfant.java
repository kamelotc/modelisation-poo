package cine;

public class BilletEnfant implements Billet{
    @Override
    public double calculerPrix(double tarifDeBase) {
        return 5.00;
    }
}
