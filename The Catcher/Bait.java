import java.util.ArrayList;
import java.util.List;

public class Bait{
    private String name;

    private String type;

    private int price;

    public Bait() {
    }

    public Bait(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Bait> baitLoader(){
        List<Bait> generatedBait=new ArrayList<>();

        String[] name={"Fruit","Redrot","Worm","Fly"};
        String[] type={"Yellow","Red","Orange","Purple"};
        int[] price={25,50,75,100};

        for(int i=0;i<name.length;i++){
            Bait baitTemp=new Bait(name[i],type[i],price[i]);
            generatedBait.add(baitTemp);
        }

        return generatedBait;
    }
}