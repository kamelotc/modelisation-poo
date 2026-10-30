package cine;

public class BilletPleinTarif implements Billet {
        @Override
        public double calculerPrix(double tarifDeBase) {
            return tarifDeBase;
        }
}