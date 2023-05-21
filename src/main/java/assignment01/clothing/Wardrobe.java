package assignment01.clothing;

import assignment01.clothing.garment.Garment;
import assignment01.clothing.garment.Raincoat;
import assignment01.clothing.garment.Trousers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Wardrobe {
    private final Map<Person, List<Garment>> content = new HashMap<>();

    public int totalNumberOfGarments() {
        int count = 0;
        for(List<Garment> garments : content.values()){
            count += garments.size();
        }
        return count;
    }

    public int getGarmentCount(Person person) {
        List<Garment> garments = content.get(person);
        return garments == null ? 0 : garments.size();
    }

    public void addGarment(Person person, Garment garment) {
        content.putIfAbsent(person, new ArrayList<>());
        content.get(person).add(garment);
    }

    public boolean containsRaincoat(Person person) {
        List<Garment> garments = content.get(person);
        if(garments == null){
            return false;
        }

        for(Garment g : garments){
            if(g instanceof Raincoat){
                return true;
            }
        }

        return false;
    }

    public boolean containsTrousers(Person person) {
        content.putIfAbsent(person, new ArrayList<>());

        for(Garment g : content.get(person)){
            if(g instanceof Trousers){
                return true;
            }
        }

        return false;
    }

    public void removeGarment(Person person, Garment garment) {
        List<Garment> garments = content.get(person);
        if(garments == null){
            return;
        }

        for(Garment g : garments){
            if(g == garment){
                garments.remove(g);
                return;
            }
        }
    }

    public double totalValue() {
        double total = 0;
        for(Map.Entry<Person, List<Garment>> entry : content.entrySet()){
            for(Garment g : entry.getValue()){
                total += g.getPrice();
            }
        }
        return total;
    }
}
