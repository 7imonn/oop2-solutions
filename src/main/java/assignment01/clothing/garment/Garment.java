package assignment01.clothing.garment;

/**
 * textile material worn on the body
 */
public abstract class Garment {

    private final String name;
    private float price;

    /**
     * creates a new Garment
     *
     * @param name the name of the Garment
     * @param price the price of the Garmet
     */
    public Garment(String name, float price) {
        this.name = name;
        this.price = price;
    }

    /**
     * returns the name of this Garment
     *
     * @return the name of this Garment
     */
    public String getName() {
        return name;
    }

    /**
     * returns the price of the Garment
     *
     * @return the price of the Garment
     */
    public float getPrice() {
        return price;
    }

    /**
     * sets the price of the Garment
     *
     * @param price the price of the Garment
     */
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return getClass().equals(obj.getClass());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
