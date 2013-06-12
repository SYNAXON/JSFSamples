package de.synaxon.jsfsamples;

/**
 *
 * @author Karl Spies
 */
public class Item {

    private int value;
    private int limit;

    @Override
    public String toString() {
        return super.toString() + String.format(" [Value=%d, Limit=%d]", getValue(), getLimit());
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }
}
