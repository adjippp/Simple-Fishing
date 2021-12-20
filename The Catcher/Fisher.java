import java.util.List;

public class Fisher {
    private int money;

    private Inventory inventory;

    private List<FishList> fishList;

    private String rank;

    private Bait baitUsed;

    public Fisher() {
    }

    public Fisher(int money, Inventory inventory) {
        this.money = money;
        this.inventory = inventory;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<FishList> getFishList() {
        return fishList;
    }

    public void setFishList(List<FishList> fishList) {
        this.fishList = fishList;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Bait getBaitUsed() {
        return baitUsed;
    }

    public void setBaitUsed(Bait baitUsed) {
        this.baitUsed = baitUsed;
    }

    
}
