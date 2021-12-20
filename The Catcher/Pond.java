import java.util.ArrayList;
import java.util.List;
public class Pond {
    private List<PondHelper> fishInsidePond;

    private Fish fishGenerator;

    public Pond() {
        this.fishGenerator=new Fish();
    }

    public Pond(List<PondHelper> fishInsidePond) {
        this.fishInsidePond = fishInsidePond;
    }

    public List<PondHelper> getFishInsidePond() {
        return fishInsidePond;
    }

    public void setFishInsidePond(List<PondHelper> fishInsidePond) {
        this.fishInsidePond = fishInsidePond;
    }
    
    public Pond pondLoader(List<Fish> fishData, int randomGenerator){
        Pond pondResult=new Pond();
        List<PondHelper> fishInsidePond=new ArrayList<>();
        int fishCounter=0;
        while(fishCounter<randomGenerator){
            PondHelper pondFish=new PondHelper();
            
            if(fishInsidePond.contains(pondFish)){
                int i=fishInsidePond.indexOf(pondFish);
                fishInsidePond.get(fishCounter).setQuantity(fishInsidePond.get(fishCounter).getQuantity()+1);
                // fishInsidePond.add(pondFish);
            }else{
                pondFish.setFish(fishGenerator.fishRandomizer(fishData));
                pondFish.setQuantity(1);
                fishInsidePond.add(pondFish);
            }
            fishCounter++;
        }
        pondResult.setFishInsidePond(fishInsidePond);
        return pondResult;
    }

    public Pond removeFishFromPond(Pond pond,Fish fish){
        Pond result=pond;
        if(result.getFishInsidePond().contains(fish)){
            int indexFish=result.getFishInsidePond().indexOf(fish);
            if(result.getFishInsidePond().get(indexFish).getQuantity()>0){
                result.getFishInsidePond().get(indexFish).setQuantity(result.getFishInsidePond().get(indexFish).getQuantity()-1);
            }else{
                result.getFishInsidePond().remove(fish);
            }
        }

        return result;
    }
}
