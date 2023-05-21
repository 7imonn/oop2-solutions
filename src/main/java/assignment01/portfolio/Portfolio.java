package assignment01.portfolio;

import assignment01.portfolio.anlage.Anlage;

import java.util.ArrayList;
import java.util.List;

public class Portfolio<T extends Anlage> {

    private List<T> anlagen = new ArrayList<>();

    public boolean enthalten(T a) {
        return anlagen.contains(a);
    }

    public void kaufen(T anlage) {
        T bestehendeAnlage = null;
        for (T a : anlagen) {
            if (anlage.equals(a)) {
                bestehendeAnlage = a;
                break;
            }
        }

        if (bestehendeAnlage != null) {
            bestehendeAnlage.setAnzahl(bestehendeAnlage.getAnzahl() + anlage.getAnzahl());
        } else {
            anlagen.add(anlage);
        }
    }

    public T getAnlage(String titel) {
        for (T a : anlagen) {
            if (a.getTitel().equals(titel)) {
                return a;
            }
        }
        return null;
    }

    public void verkaufen(String titel, int anzahl) {
        T anlage = getAnlage(titel);
        if (anlage != null) {
            anlage.setAnzahl(anlage.getAnzahl() - anzahl);
            if (anlage.getAnzahl() <= 0) {
                anlagen.remove(anlage);
            }
        }
    }

}
