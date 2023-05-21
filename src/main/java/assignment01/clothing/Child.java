package assignment01.clothing;

import assignment01.clothing.garment.Garment;
import assignment01.clothing.garment.Trousers;

import java.util.ArrayList;
import java.util.List;


public class Child {
    private final List<Garment> allGarments = new ArrayList<>();


    public int numberOfGarments() {
        return allGarments.size();
    }


    public void putOn(Garment garment) {
        allGarments.add(garment);
    }


    public boolean wears(Garment garment) {
        return allGarments.contains(garment);
    }


    public void takeOff(Garment garment) {
        allGarments.remove(garment);
    }


    public boolean wearsSomeTrousers() {
        for(Garment g : allGarments){
            if(g instanceof Trousers){
                return true;
            }
        }
        return false;
    }

    public float totalPrice() {
        float total = 0;
        for (Garment g : allGarments) {
            total += g.getPrice();
        }

        return total;
    }
}
