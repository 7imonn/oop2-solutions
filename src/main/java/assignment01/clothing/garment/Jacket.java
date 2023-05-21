package assignment01.clothing.garment;

/**
 * mid-stomach–length garment for the upper body
 */
public class Jacket extends Top {

    private final int size;

    /**
     * creates a new Jacket
     *
     * @param name the name of the Jacket
     * @param price the price of the Jacket
     * @param size the size of the Jacket
     */
    public Jacket(String name, float price, int size) {
        super(name, price);
        this.size = size;
    }

    /**
     * Copy constructor
     * @param original the original Jacket
     */
    public Jacket(Jacket original) {
        this(original.getName(), original.getPrice(), original.getSize());
    }

    /**
     * returns the size of the Jacket
     *
     * @return the size of the Jacket
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " (price: " + getPrice() + ", size: " + size + ')';
    }
}
