import java.util.ArrayList;
import java.util.List;

public class FishList {
    private Fish fish;
    private String obtained;
    
    public FishList() {
    }
    public FishList(Fish fish, String obtained) {
        this.fish = fish;
        this.obtained = obtained;
    }
    public Fish getFish() {
        return fish;
    }
    public void setFish(Fish fish) {
        this.fish = fish;
    }
    public String getObtained() {
        return obtained;
    }
    public void setObtained(String obtained) {
        this.obtained = obtained;
    }

    public List<FishList> fishListGenerator(List<Fish> fishData){
        List<FishList> fishList=new ArrayList<>();
        for(int i=0;i<fishData.size();i++){
            FishList fishListTemp=new FishList();
            fishListTemp.setFish(fishData.get(i));
            fishListTemp.setObtained("-");
            fishList.add(fishListTemp);
        }

        return fishList;
    }

    public String printFishList(List<FishList> fishList){
        String result="All Fish Footprint \n";
        result+="|  No.  |     Fish Name     |     Type     |     Rarity     |     Price     |     Obtained     |\n";
        
        if(fishList.isEmpty()){
            result+="                                          empty                                            \n";
        }else{
            for(int i=0;i<fishList.size();i++){
                result+="|  "+(i+1)+"  |     "+fishList.get(i).getFish().getName()+"     |     "+fishList.get(i).getFish().getType()+"     |     "+fishList.get(i).getFish().getRarity()+"     |     "+fishList.get(i).getFish().getPrice()+"     |     "+fishList.get(i).getObtained()+"     |\n";
            }
        }

        return result;
    }

    public boolean changeObtainedStatus(String fishName, List<FishList> fishLists){
        boolean result=false;
            for(int i=0;i<fishLists.size();i++){
                if(fishLists.get(i).fish.getName().equals(fishName)){
                    fishLists.get(i).obtained="V";
                }else{
                    fishLists.get(i).obtained="-";
                }
            }
        return result;
    }
}
