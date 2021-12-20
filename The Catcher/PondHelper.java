public class PondHelper {
    private Fish fish;

    private int quantity;

    public PondHelper() {
    }

    public PondHelper(Fish fish, int quantity) {
        this.fish = fish;
        this.quantity = quantity;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
