package assignment01.clothing.garment;

/**
 * clothing worn from the waist to the ankles
 */
public class Trousers extends Garment {

    private final int waistSize;
    private final int length;

    /**
     * creates new Trousers
     *
     * @param name the name of the Trousers
     * @param price the price of the Trousers
     * @param waistSize the waist size of the Trousers
     * @param length the length of the Trousers
     */
    public Trousers(String name, float price, int waistSize, int length) {
        super(name, price);
        this.waistSize = waistSize;
        this.length = length;
    }

    /**
     * Copy constructor
     *
     * @param original the original Trousers
     */
    public Trousers(Trousers original) {
        this(original.getName(), original.getPrice(),
                original.getWaistSize(), original.getLength());
    }

    /**
     * returns the waist size of the Trousers
     *
     * @return the waist size of the Trousers
     */
    public int getWaistSize() {
        return waistSize;
    }

    /**
     * returns the length of the Trousers
     *
     * @return the length of the Trousers
     */
    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return getName() + " (price: " + getPrice() + ", waist size: "
                + getWaistSize() + ", length: " + getLength() + ")";
    }
}

