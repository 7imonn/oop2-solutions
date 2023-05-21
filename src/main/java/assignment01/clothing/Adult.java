package assignment01.clothing;

import assignment01.clothing.garment.Garment;
import assignment01.clothing.garment.Raincoat;
import assignment01.clothing.garment.Trousers;

import java.util.HashSet;
import java.util.Set;


public class Adult {
    private final Set<Garment> allGarments = new HashSet<>();

    public int numberOfGarments() {
        return allGarments.size();
    }

    public void putOn(Garment garment) {
        allGarments.add(garment);
    }

    public boolean wears(Garment garment) {
        return allGarments.contains(garment);
    }

    public Trousers getTrousers() {
        for (Garment g : allGarments){
            if(g instanceof Trousers){
                return (Trousers) g;
            }
        }
        return null;
    }

    public void takeOffRaincoat() {
        allGarments.remove(new Raincoat("", 0, 0));
    }

    public void takeOffTrousers() {
        //alternative implementation
        for(Garment g : allGarments){
            if(g instanceof Trousers){
                allGarments.remove(g);
                return;
            }
        }
    }
}
