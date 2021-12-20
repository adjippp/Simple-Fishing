import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fish{
    private String name;

    private String type;

    private String rarity;

    private int price;

    public Fish() {
    }

    public Fish(String name, String type, String rarity, int price) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Fish> fishLoader(){
        List<Fish> generateFish=new ArrayList<>();

        String[] fish={"Crystalfish","Dawncatcher","Snowstrider","Venomspine","Raimei","Angelfish","Pufferfish","Clownfish"};
        String[] type={"Tiny","Tiny","Long","Long","Flat","Flat","Marine","Marine"};
        String[] rarity={"Common","Common","Rare","Rare","Rare","Rare","Legendary","Legendary"};
        int[] price={250,500,750,1000,1250,1500,1750,2000};

        for(int i=0;i<fish.length;i++){
            Fish fishTemp=new Fish(fish[i],type[i],rarity[i],price[i]);
            generateFish.add(fishTemp);
        }
        return generateFish;
    }

    public List<Fish> fishLoader2(){
        List<Fish> generateFish=new ArrayList<>();

        String[] fish={"Crystalfish","Dawncatcher","Snowstrider","Venomspine","Raimei","Angelfish","Pufferfish","Clownfish","Garbage"};
        String[] type={"Tiny","Tiny","Long","Long","Flat","Flat","Marine","Marine","-"};
        String[] rarity={"Common","Common","Rare","Rare","Rare","Rare","Legendary","Legendary","-"};
        int[] price={250,500,750,1000,1250,1500,1750,2000,100};

        for(int i=0;i<fish.length;i++){
            Fish fishTemp=new Fish(fish[i],type[i],rarity[i],price[i]);
            generateFish.add(fishTemp);
        }
        return generateFish;
    }

    public Fish fishRandomizer(List<Fish> fishData){
        int max=8;
        Random r=new Random();
        int getFishNumber=r.nextInt(max);
        Fish result=fishData.get(getFishNumber);

        return result;
    }
}