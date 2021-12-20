public class InventoryBaitHelper {
    private Bait bait;

    private int quantity;

    public InventoryBaitHelper() {
    }

    public InventoryBaitHelper(Bait bait, int quantity) {
        this.bait = bait;
        this.quantity = quantity;
    }

    public Bait getBait() {
        return bait;
    }

    public void setBait(Bait bait) {
        this.bait = bait;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
