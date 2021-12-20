import java.util.ArrayList;
import java.util.List;

public class Shop {
    List<Bait> bait;

    List<Fish> fish;

    public Shop() {
    
    }

    public Shop(List<Bait> bait, List<Fish> fish) {
        this.bait = bait;
        this.fish = fish;
    }

    public List<Bait> getBait() {
        return bait;
    }

    public void setBait(List<Bait> bait) {
        this.bait = bait;
    }

    public List<Fish> getFish() {
        return fish;
    }

    public void setFish(List<Fish> fish) {
        this.fish = fish;
    }

    public Fisher buyFishFromFisher(Fisher fisher, int quantity, Fish fish){
        Fisher fisherTemp=fisher;
        Fish garbage=new Fish();
        garbage.setName("Garbage");
        garbage.setPrice(100);
        garbage.setRarity("-");
        garbage.setType("-");
        this.fish.add(garbage);

        if(this.fish.contains(fish)){
            int index=this.fish.indexOf(fish);
            int price=this.fish.get(index).getPrice();
            
            InventoryFishHelper inventoryFishHelpers=new InventoryFishHelper();
            for(int i=0;i<fisherTemp.getInventory().getFish().size();i++){
                if(fisherTemp.getInventory().getFish().get(i).getFish().equals(fish)){
                    inventoryFishHelpers=fisherTemp.getInventory().getFish().get(i);
                    if(quantity>fisherTemp.getInventory().getFish().get(i).getQuantity()){
                        System.out.println("Jumlah ikan tidak mencukupi");
                        return fisherTemp;
                    }else{
                        int temp=fisherTemp.getInventory().getFish().indexOf(inventoryFishHelpers);
                        int quantityFromFisher=fisherTemp.getInventory().getFish().get(temp).getQuantity()-quantity;
                        inventoryFishHelpers.setQuantity(quantityFromFisher);
                        fisherTemp.getInventory().getFish().set(temp, inventoryFishHelpers);
                        if(quantityFromFisher==0){
                            System.out.println("Kamu berhasil menjual ikan "+fisherTemp.getInventory().getFish().get(temp).getFish().getName()+" sebanyak "+quantity);
                            System.out.println("Mendapatkan uang sebanyak "+price*quantity);
                            fisherTemp.getInventory().getFish().remove(temp);
                            fisherTemp.setMoney(fisherTemp.getMoney()+(price*quantity));
                        }else{
                            fisherTemp.setMoney(fisherTemp.getMoney()+(price*quantity));
                            System.out.println("Kamu berhasil menjual ikan "+fisherTemp.getInventory().getFish().get(temp).getFish().getName()+" sebanyak "+quantity);
                            System.out.println("Mendapatkan uang sebanyak "+price*quantity);
                        }
                        return fisherTemp;
                    }
                }
            }
        }

        return fisherTemp;
    }

    public String baitList(){
        String result="";
        for(int i=0;i<bait.size();i++){
                if(i==0){
                    result+="|  No. |  Bait Name  |  Price  |"+"\n";
                    result+="|  "+(i+1)+"  |  "+bait.get(i).getName()+"  |  "+bait.get(i).getPrice()+"  |"+"\n";
                }else{
                    result+="|  "+(i+1)+"  |  "+bait.get(i).getName()+"  |  "+bait.get(i).getPrice()+"  |"+"\n";
                }
            }
        return result;
    }

    public String fishOfFisherList(Fisher fisher){
        String result="";
        for(int i=0;i<fisher.getInventory().getFish().size();i++){
                if(i==0){
                    result+="|  No. |  Fish Name  |  Price  |  Qty  |"+"\n";
                    String fishName=fisher.getInventory().getFish().get(i).getFish().getName();
                    int fishPrice=fisher.getInventory().getFish().get(i).getFish().getPrice();
                    int quantity=fisher.getInventory().getFish().get(i).getQuantity();
                    result+="|  "+(i+1)+"  |  "+fishName+"  |  "+fishPrice+"  |  "+quantity+"  |\n";
                }else{
                    String fishName=fisher.getInventory().getFish().get(i).getFish().getName();
                    int fishPrice=fisher.getInventory().getFish().get(i).getFish().getPrice();
                    int quantity=fisher.getInventory().getFish().get(i).getQuantity();
                    result+="|  "+(i+1)+"  |  "+fishName+"  |  "+fishPrice+"  |  "+quantity+"  |\n";
                }
            }
        return result;
    }

    public Fisher sellBaitToFisher(Fisher fisher, Bait bait, int quantity){
        Fisher fisherTemp=fisher;
        if(this.bait.contains(bait)){
            int index=this.bait.indexOf(bait);
            int price=this.bait.get(index).getPrice();
            int totalTemp=fisherTemp.getMoney()-(price*quantity);
            if(totalTemp>=0){
                fisherTemp.setMoney(totalTemp);
                List<InventoryBaitHelper> checker=checkBaitExist(fisher, bait);
                if(!checker.isEmpty()){                    
                    int indexTemp=fisherTemp.getInventory().getBait().indexOf(checker.get(0));
                    InventoryBaitHelper inventoryBaitHelper=fisherTemp.getInventory().getBait().get(indexTemp);
                    inventoryBaitHelper.setBait(bait);
                    inventoryBaitHelper.setQuantity(fisherTemp.getInventory().getBait().get(indexTemp).getQuantity()+quantity);
                    fisherTemp.getInventory().getBait().set(indexTemp, inventoryBaitHelper);
                }else{
                    InventoryBaitHelper inventoryBaitHelper=new InventoryBaitHelper(bait,quantity);
                    fisherTemp.getInventory().getBait().add(inventoryBaitHelper);
                    System.out.println("Sukses membeli "+bait.getName()+" sebanyak "+quantity+" dengan harga "+price);
                    return fisherTemp;
                }
            }else{
                System.out.println("Uang tidak mencukupi");
                return fisherTemp;
            }
        }
        return fisherTemp;
    }

    public List<InventoryBaitHelper> checkBaitExist(Fisher fisher, Bait bait){
        List<InventoryBaitHelper> result=new ArrayList<>();
        for(int i=0;i<fisher.getInventory().getBait().size();i++){
            if(fisher.getInventory().getBait().get(i).getBait().equals(bait)){
                result.add(fisher.getInventory().getBait().get(i));
            }
        }

        return result;
    }
}
