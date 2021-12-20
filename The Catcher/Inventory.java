
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<InventoryBaitHelper> bait;

    private List<InventoryFishHelper> fish;

    public Inventory() {
    }

    public Inventory(List<InventoryFishHelper> fish, List<InventoryBaitHelper> bait) {
        this.fish = fish;
        this.bait = bait;
    }

    public List<InventoryFishHelper> getFish() {
        return fish;
    }

    public void setFish(List<InventoryFishHelper> fish) {
        this.fish = fish;
    }

    public List<InventoryBaitHelper> getBait() {
        return bait;
    }

    public void setBait(List<InventoryBaitHelper> bait) {
        this.bait = bait;
    }

    public void addFishToInventory(Fish fish, Fisher fisher, int quantity){
        if(fisher.getInventory().getFish().isEmpty()){
            InventoryFishHelper inventoryFishHelper=new InventoryFishHelper(fish, quantity);
            fisher.getInventory().getFish().add(inventoryFishHelper);
        }else{
            List<InventoryFishHelper> checker=checkFishExist(fish, fisher);
            if(!checker.isEmpty()){
                int indexTemp=fisher.getInventory().getFish().indexOf(checker.get(0));
                InventoryFishHelper inventoryFishHelper=fisher.getInventory().getFish().get(indexTemp);
                inventoryFishHelper.setFish(fish);
                inventoryFishHelper.setQuantity(fisher.getInventory().getFish().get(indexTemp).getQuantity()+quantity);
                fisher.getInventory().getFish().set(indexTemp, inventoryFishHelper);
            }else{
                InventoryFishHelper inventoryFishHelper=new InventoryFishHelper(fish,quantity);
                fisher.getInventory().getFish().add(inventoryFishHelper);
            }
        }
    }

    public List<InventoryFishHelper> checkFishExist(Fish fish, Fisher fisher){
        List<InventoryFishHelper> result=new ArrayList<>();
        for(int i=0;i<fisher.getInventory().getFish().size();i++){
            if(fisher.getInventory().getFish().get(i).getFish().equals(fish)){
                result.add(fisher.getInventory().getFish().get(i));
            }
        }

        return result;
    }

    public String printMyBaitList(List<InventoryBaitHelper> bait){
        String result="My Bait List \n";
        result+="|  No. |  Bait Name  |  Bait Type  |  Qty  |"+"\n";
        if(bait.isEmpty()){
            result="You don't have any bait \nLet's buy some";
        }else{
            for(int i=0;i<bait.size();i++){
                String baitName=bait.get(i).getBait().getName();
                String baitType=bait.get(i).getBait().getType();
                int quantity=bait.get(i).getQuantity();
                result+="|  "+(i+1)+"  |  "+baitName+"  |  "+baitType+"  |  "+quantity+"  |\n";
            }
        }
        return result;
    }

    public String printMyFish(List<InventoryFishHelper> fish){
        String result="My Fish List \n";
        result+="|  No.  |     Fish Name     |     Type     |     Rarity     |     Price     |     Qty     |\n";
        if(fish.isEmpty()){
            result="You don't have any fish \nLet's catch some";
        }else{
            for(int i=0;i<fish.size();i++){
                String fishName=fish.get(i).getFish().getName();
                String fishType=fish.get(i).getFish().getType();
                String fishRarity=fish.get(i).getFish().getRarity();
                int fishPrice=fish.get(i).getFish().getPrice();
                int quantity=fish.get(i).getQuantity();
                result+="|  "+(i+1)+"  |     "+fishName+"     |     "+fishType+"     |     "+fishRarity+"     |     "+fishPrice+"     |     "+quantity+"     |\n";
            }
        }
        return result;
    }
}
