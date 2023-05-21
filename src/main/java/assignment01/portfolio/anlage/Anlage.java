package assignment01.portfolio.anlage;

import java.util.Objects;

public abstract class Anlage {
    private String titel;
    private String land;
    private double einzelPreis;
    private double anzahl;

    public Anlage(String titel) {
        this.titel       = titel;
        this.land        = "Schweiz";
        this.anzahl      = 1.0;
        this.einzelPreis = 1.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Anlage anlage = (Anlage) o;

        return Objects.equals(getTitel(), anlage.getTitel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitel());
    }

    // alle Getter und Setter gemäss der üblichen Konvention
    public String getTitel() {
        return titel;
    }

    public double getEinzelPreis() {
        return einzelPreis;
    }

    public void setEinzelPreis(double einzelPreis) {
        this.einzelPreis = einzelPreis;
    }

    public double getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(double anzahl) {
        this.anzahl = anzahl;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

}
