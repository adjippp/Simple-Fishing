import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        

        //base loader
        Fish fishLoader=new Fish();
        Bait baitLoader=new Bait();
        FishList fishListLoader=new FishList();
        List<Fish> loadFishData=fishLoader.fishLoader();
        List<Fish> loadFishData2=fishLoader.fishLoader2();
        List<Bait> loadBaitData=baitLoader.baitLoader();
        List<FishList> loadFisherFishList=fishListLoader.fishListGenerator(loadFishData);
        Pond pondLoader=new Pond();
        Pond pondForGame=new Pond();
        Random r=new Random();
        int jmlIkan=r.nextInt(6-3)+4;
        int currentFishInsidePond=jmlIkan;
        pondForGame=pondLoader.pondLoader(loadFishData,jmlIkan);

        //shop loader
        Shop shop=new Shop();
        shop.setBait(loadBaitData);
        shop.setFish(loadFishData2);

        //player loader
        Fisher fisher=new Fisher();
        Inventory inventory=new Inventory();

        //inventory loader
        inventory.setBait(new ArrayList<>());
        inventory.setFish(new ArrayList<>());
        
        fisher.setMoney(500);
        fisher.setInventory(inventory);
        fisher.setFishList(loadFisherFishList);
        fisher.setRank("Beginner");
        fisher.setBaitUsed(new Bait("","",0));

        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("The Catch");
            System.out.println("============");
            System.out.println("1. Play");
            System.out.println("2. How to Play");
            System.out.println("3. exit");
            int request=Integer.parseInt(sc.nextLine());
            int fisherExperience=0;
            switch(request){
                case 1:{
                    boolean ingameMenu=true;
                    while(ingameMenu){
                        System.out.println("Welcome, Traveller ( "+fisher.getRank()+" )");
                        System.out.println("1. Shop");
                        System.out.println("2. View All Archive");
                        System.out.println("3. Go Fishing");
                        System.out.println("4. Exit");
                        System.out.print("Choose >> ");
                        int inputShop=Integer.parseInt(sc.nextLine());
                        switch(inputShop){
                            case 1:{
                                System.out.println("Welcome, Traveller ( "+fisher.getRank()+" )");
                                System.out.println("1. Buy bait");
                                System.out.println("2. Sell Fish");
                                System.out.println("3. Exit");
                                System.out.print("Choose >> ");
                                int inputShop2=Integer.parseInt(sc.nextLine());
                                switch(inputShop2){
                                    case 1:{
                                        System.out.println("My Money : "+fisher.getMoney());
                                        System.out.println("Bait List");
                                        System.out.print(shop.baitList());
                                        String requestBait="";
                                        while(!requestBait.equals("exit")){
                                            System.out.println("[input 'exit' to back]");
                                            System.out.print("Choose >> ");
                                            requestBait=sc.nextLine();
                                            if(isNumeric(requestBait)==true){
                                                int temp=Integer.parseInt(requestBait)-1;
                                        
                                                if(temp>=0 && temp<5){
                                                    Bait tempBait=loadBaitData.get(temp);
                                                    System.out.println("[input 'exit' to back]");
                                                    System.out.println("how many bait do you want to buy? [1..10]");
                                                    requestBait=sc.nextLine();
                                                    int manyBaitTemp=Integer.parseInt(requestBait);
                                                    if(manyBaitTemp>0 && manyBaitTemp<=10){
                                                        fisher=shop.sellBaitToFisher(fisher, tempBait, manyBaitTemp);
                                                        System.out.println("Press enter to continue . . . ");
                                                        requestBait=sc.nextLine();
                                                        break;
                                                    }
                                                }
                                            }else{
                                                requestBait="exit";
                                            }
                                        }
                                        break;  
                                    }
                                    case 2:{
                                        if(fisher.getInventory().getFish().isEmpty()){
                                            System.out.println("You don't have any fish");
                                            System.out.println("let's catch some");
                                            System.out.println("Press enter to continue . . .");
                                            String inputUser2=sc.nextLine();
                                            if(inputUser2.isEmpty()){
                                                ingameMenu=false;
                                                break;
                                            }
                                        }else{
                                            System.out.println("My Money : "+fisher.getMoney());
                                            System.out.println("My Fish");
                                            System.out.print(shop.fishOfFisherList(fisher));
                                            String requestSellFish="";
                                            while(!requestSellFish.equals("exit")){
                                                System.out.println("[input 'exit' to back]");
                                                System.out.print("Choose >> ");
                                                requestSellFish=sc.nextLine();
                                                if(isNumeric(requestSellFish)==true){
                                                    int temp=Integer.parseInt(requestSellFish)-1;
                                                    if(temp>=0 && temp<fisher.getInventory().getFish().size()){
                                                        Fish tempFish=fisher.getInventory().getFish().get(temp).getFish();
                                                        System.out.println("[input 'exit' to back]");
                                                        System.out.print("how many do you want to sell ? [1..2] ");
                                                        requestSellFish=sc.nextLine();
                                                        if(isNumeric(requestSellFish)==true){
                                                            int tempManyFish=Integer.parseInt(requestSellFish);
                                                            if(tempManyFish>0 && tempManyFish<=2){
                                                                fisher=shop.buyFishFromFisher(fisher, tempManyFish,tempFish);
                                                                System.out.println("Press enter to continue . . .");
                                                                requestSellFish=sc.nextLine();
                                                                break;
                                                            }
                                                        }else{
                                                            requestSellFish="exit";
                                                        }
                                                    }
                                                }else{
                                                    requestSellFish="exit";
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case 3:{
                                        break;
                                    }                                    
                                }
                                break;
                            }
                            case 2:{
                                boolean insideInventoryMenu=true;
                                while(insideInventoryMenu){
                                    System.out.println("Inventory");
                                    System.out.println("=========");
                                    System.out.println("1. My Fish");
                                    System.out.println("2. My Bait");
                                    System.out.println("3. All Fish List");
                                    System.out.println("4. Exit");
                                    int inputInventoryMenu=Integer.parseInt(sc.nextLine());
                                    switch(inputInventoryMenu){
                                        case 1:{
                                            //my fish
                                            String fishTemp=fisher.getInventory().printMyFish(fisher.getInventory().getFish());
                                            String fishListInput="";
                                            if(fishTemp.contains("You don't have any fish")){
                                                System.out.println(fishTemp);
                                                System.out.println("Press enter to continue . . .");
                                                fishListInput=sc.nextLine();
                                                insideInventoryMenu=false;
                                            }else{
                                                System.out.print(fishTemp);
                                                System.out.println("Press enter to continue . . .");
                                                fishListInput=sc.nextLine();
                                                insideInventoryMenu=false;               
                                            }
                                            break;
                                        }
                                        case 2:{
                                            //my bait
                                            String inputCheckBait="";
                                            String baitResult=fisher.getInventory().printMyBaitList(fisher.getInventory().getBait());
                                            if(baitResult.contains("You don't have")){
                                                System.out.println(baitResult);
                                                System.out.println("Press enter to continue");
                                                inputCheckBait=sc.nextLine();
                                                if(inputCheckBait.isEmpty()){
                                                    insideInventoryMenu=false;
                                                }
                                            }else{
                                                System.out.println(baitResult);
                                                while(!inputCheckBait.equals("exit")){
                                                    System.out.println("[input 'exit' to back]");
                                                    System.out.print("Choose Bait >> ");
                                                    inputCheckBait=sc.nextLine();
                                                    if(isNumeric(inputCheckBait)==true){
                                                        int baitNumber=Integer.parseInt(inputCheckBait)-1;
                                                        int baitQuantity=fisher.getInventory().getBait().get(baitNumber).getQuantity();
                                                        Bait baitForFishing=fisher.getInventory().getBait().get(baitNumber).getBait();
                                                        if(baitNumber>=0 && baitQuantity>0){
                                                            fisher.setBaitUsed(baitForFishing);
                                                        }
                                                        System.out.println("Bait "+baitForFishing.getName()+" successfully used");
                                                        System.out.println("Press enter to continue . . .");
                                                        inputCheckBait=sc.nextLine();
                                                        break;
                                                }else{
                                                    inputCheckBait="exit";
                                                }
                                                }
                                            }
                                            break;
                                        }
                                        case 3:{
                                            //all fish list
                                            System.out.print(fishListLoader.printFishList(fisher.getFishList()));
                                            System.out.println("Press enter to continue . . .");
                                            String inputInventoryMenu3=sc.nextLine();
                                            if(inputInventoryMenu3.isEmpty()){
                                                insideInventoryMenu=false;
                                                break;
                                            }
                                            break;
                                        }
                                        case 4:{
                                            insideInventoryMenu=false;
                                            break;
                                        }
                                    }
                                    break;
                                }
                                break;
                            }
                            case 3:{
                                if(fisher.getBaitUsed().getPrice()==0){
                                    System.out.println("There is no bait");
                                    System.out.println("Set the bait first!\n");
                                    break;
                                }
                                boolean inFishingMenu=true;
                                while(inFishingMenu){
                                    if(currentFishInsidePond<=0){
                                        jmlIkan=r.nextInt(3)+4;
                                        pondForGame=pondLoader.pondLoader(loadFishData,jmlIkan);
                                    }

                                    String fishing=r.nextDouble()<=0.8?"fish":"garbage";
                                    int baitIndex=getBaitIndex(fisher);
                                    if(fishing.equals("fish")){
                                        fisher.getInventory().getBait().get(baitIndex).setQuantity(fisher.getInventory().getBait().get(baitIndex).getQuantity()-1);
                                        if(fisher.getInventory().getBait().get(baitIndex).getQuantity()==0){
                                            fisher.getInventory().getBait().remove(baitIndex);
                                        }
                                        String baitType=fisher.getBaitUsed().getType();
                                        if(baitType.equals("Yellow")){
                                            List<Fish> fishListInsidePond=getFishListFromPondByType(pondForGame, "Tiny");
                                            if(fishListInsidePond.isEmpty()){
                                                System.out.println("That's strange, you didn't catch anything");
                                                System.out.println("Let's try another bait\n");
                                                break;
                                            }else{
                                                System.out.println("This will take a moment . . .");
                                                int randomFish=r.nextInt(fishListInsidePond.size());
                                                Fish theFishYouCaught=fishListInsidePond.get(randomFish);
                                                if(fisher.getRank().equalsIgnoreCase("Beginner")){
                                                    fisher.getInventory().addFishToInventory(theFishYouCaught, fisher, 1);
                                                    System.out.println("You just caught ("+1+"x) "+theFishYouCaught.getName());
                                                }else if(fisher.getRank().equalsIgnoreCase("Master")){
                                                    fisher.getInventory().addFishToInventory(theFishYouCaught, fisher, 2);
                                                    System.out.println("You just caught ("+2+"x) "+theFishYouCaught.getName());
                                                }else{
                                                    fisher.getInventory().addFishToInventory(theFishYouCaught, fisher, 3);
                                                    System.out.println("You just caught ("+3+"x) "+theFishYouCaught.getName());
                                                }
                                                
                                                pondForGame=pondLoader.removeFishFromPond(pondForGame, theFishYouCaught);
                                                currentFishInsidePond-=1;
                                                for(int i=0;i<fisher.getFishList().size();i++){
                                                    if(fisher.getFishList().get(i).getFish().getName().equals(theFishYouCaught.getName())){
                                                        fisher.getFishList().get(i).changeObtainedStatus(theFishYouCaught.getName(), fisher.getFishList());
                                                    }
                                                }
                                                int randomExp1=r.nextInt(6)+1;
                                                fisherExperience+=randomExp1;
                                                System.out.println("You got "+randomExp1+" exp");
                                                if(fisherExperience>=0 && fisherExperience<=15){
                                                    fisher.setRank("Beginner");
                                                }else if(fisherExperience>=16 && fisherExperience<=50){
                                                    fisher.setRank("Master");
                                                }else{
                                                    fisher.setRank("Expert");
                                                }
                                                break;
                                            }
                                        }else if(baitType.equals("Red")){
                                            List<Fish> fishListInsidePond=getFishListFromPondByType(pondForGame, "Long");
                                            if(fishListInsidePond.isEmpty()){
                                                System.out.println("That's strange, you didn't catch anything");
                                                System.out.println("Let's try another bait\n");
                                                break;
                                            }else{
                                                System.out.println("This will take a moment . . .");
                                                int randomFish=r.nextInt(fishListInsidePond.size());
                                                Fish theFishYouCaught=fishListInsidePond.get(randomFish);
                                                if(fisher.getRank().equalsIgnoreCase("Beginner")){
                                                    fisher.getInventory().addFishToInventory(theFishYouCaught, fisher, 1);
                                                    System.out.println("You just caught ("+1+"x) "+theFishYouCaught.getName());
                                                }else if(fisher.getRank().equalsIgnoreCase("Master")){
                                                    fisher.getInventory().addFishToInventory(theFishYouCaught, fisher, 2);
                                                    System.out.println("You just caught ("+2+"x) "+theFishYouCaught.getName());
                                                }else{
                                                    fisher.getInventory().addFishToInventory(theFishYouCaught, fisher, 3);
                                                    System.out.println("You just caught ("+3+"x) "+theFishYouCaught.getName());
                                                }

                                                pondForGame=pondLoader.removeFishFromPond(pondForGame, theFishYouCaught);
                                                currentFishInsidePond-=1;
                                                for(int i=0;i<fisher.getFishList().size();i++){
                                                    if(fisher.getFishList().get(i).getFish().getName().equals(theFishYouCaught.getName())){
                                                        fisher.getFishList().get(i).changeObtainedStatus(theFishYouCaught.getName(), fisher.getFishList());
                                                    }
                                                }
                                                int randomExp2=r.nextInt(11)+6;
                                                fisherExperience+=randomExp2;
                                                System.out.println("You got "+randomExp2+" exp");
                                                if(fisherExperience>=0 && fisherExperience<=15){
                                                    fisher.setRank("Beginner");
                                                }else if(fisherExperience>=16 && fisherExperience<=50){
                                                    fisher.setRank("Master");
                                                }else{
                                                    fisher.setRank("Expert");
                                                }
                                                break;
                                            }
                                        }else if(baitType.equals("Orange")){
                                            List<Fish> fishListInsidePond=getFishListFromPondByType(pondForGame, "Flat");
                                            if(fishListInsidePond.isEmpty()){
                                                System.out.println("That's strange, you didn't catch anything");
                                                System.out.println("Let's try another bait\n");
                                                break;
                                            }else{
                                                System.out.println("This will take a moment . . .");
                                                int randomFish=r.nextInt(fishListInsidePond.size());
                                                Fish theFishYouCaught=fishListInsidePond.get(randomFish);
                                                if(fisher.getRank().equalsIgnoreCase("Beginner")){
                                                    fisher.getInventory().addFishToInventory(theFishYouCaught, fisher, 1);
                                                    System.out.println("You just caught ("+1+"x) "+theFishYouCaught.getName());
                                                }else if(fisher.getRank().equalsIgnoreCase("Master")){
                                                    fisher.getInventory().addFishToInventory(theFishYouCaught, fisher, 2);
                                                    System.out.println("You just caught ("+2+"x) "+theFishYouCaught.getName());
                                                }else{
                                                    fisher.getInventory().addFishToInventory(theFishYouCaught, fisher, 3);
                                                    System.out.println("You just caught ("+3+"x) "+theFishYouCaught.getName());
                                                }

                                                pondForGame=pondLoader.removeFishFromPond(pondForGame, theFishYouCaught);
                                                currentFishInsidePond-=1;
                                                for(int i=0;i<fisher.getFishList().size();i++){
                                                    if(fisher.getFishList().get(i).getFish().getName().equals(theFishYouCaught.getName())){
                                                        fisher.getFishList().get(i).changeObtainedStatus(theFishYouCaught.getName(), fisher.getFishList());
                                                    }
                                                }
                                                int randomExp3=r.nextInt(11)+6;
                                                fisherExperience+=randomExp3;
                                                System.out.println("You got "+randomExp3+" exp");
                                                if(fisherExperience>=0 && fisherExperience<=15){
                                                    fisher.setRank("Beginner");
                                                }else if(fisherExperience>=16 && fisherExperience<=50){
                                                    fisher.setRank("Master");
                                                }else{
                                                    fisher.setRank("Expert");
                                                }
                                                break;
                                                
                                            }
                                        }else{
                                            List<Fish> fishListInsidePond=getFishListFromPondByType(pondForGame, "Marine");
                                            if(fishListInsidePond.isEmpty()){
                                                System.out.println("That's strange, you didn't catch anything");
                                                System.out.println("Let's try another bait\n");
                                                break;
                                            }else{
                                                System.out.println("This will take a moment . . .");
                                                int randomFish=r.nextInt(fishListInsidePond.size());
                                                Fish theFishYouCaught=fishListInsidePond.get(randomFish);
                                                if(fisher.getRank().equalsIgnoreCase("Beginner")){
                                                    fisher.getInventory().addFishToInventory(theFishYouCaught, fisher, 1);
                                                    System.out.println("You just caught ("+1+"x)"+theFishYouCaught.getName());
                                                }else if(fisher.getRank().equalsIgnoreCase("Master")){
                                                    fisher.getInventory().addFishToInventory(theFishYouCaught, fisher, 2);
                                                    System.out.println("You just caught ("+2+"x)"+theFishYouCaught.getName());
                                                }else{
                                                    fisher.getInventory().addFishToInventory(theFishYouCaught, fisher, 3);
                                                    System.out.println("You just caught ("+3+"x)"+theFishYouCaught.getName());
                                                }

                                                pondForGame=pondLoader.removeFishFromPond(pondForGame, theFishYouCaught);
                                                currentFishInsidePond-=1;
                                                for(int i=0;i<fisher.getFishList().size();i++){
                                                    if(fisher.getFishList().get(i).getFish().getName().equals(theFishYouCaught.getName())){
                                                        fisher.getFishList().get(i).changeObtainedStatus(theFishYouCaught.getName(), fisher.getFishList());
                                                    }
                                                }
                                                int randomExp4=r.nextInt(16)+11;
                                                fisherExperience+=randomExp4;
                                                System.out.println("You got "+randomExp4+" exp");
                                                if(fisherExperience>=0 && fisherExperience<=15){
                                                    fisher.setRank("Beginner");
                                                }else if(fisherExperience>=16 && fisherExperience<=50){
                                                    fisher.setRank("Master");
                                                }else{
                                                    fisher.setRank("Expert");
                                                }

                                                break;
                                            }
                                        }
                                    }else{
                                        fisher.getInventory().getBait().get(baitIndex).setQuantity(fisher.getInventory().getBait().get(baitIndex).getQuantity()-1);
                                        Fish getGarbage=new Fish();
                                        getGarbage.setName("Garbage");
                                        getGarbage.setType("-");
                                        getGarbage.setRarity("-");
                                        getGarbage.setPrice(100);
                                        if(fisher.getInventory().getFish().contains(getGarbage)){
                                            int garbageIndex=fisher.getInventory().getFish().indexOf(getGarbage);
                                            fisher.getInventory().getFish().get(garbageIndex).setQuantity(fisher.getInventory().getFish().get(garbageIndex).getQuantity()+1);
                                        }else{
                                            InventoryFishHelper inventoryFishHelper=new InventoryFishHelper();
                                            inventoryFishHelper.setFish(getGarbage);
                                            inventoryFishHelper.setQuantity(1);
                                            fisher.getInventory().getFish().add(inventoryFishHelper);
                                        }
                                        System.out.println("Oops, it's garbage . . .");
                                        break;
                                    }
                                }
                                break;
                            }
                            case 4:{
                                ingameMenu=false;
                                break;
                            }
                            
                        }
                    }
                    break;
                }
                case 2:{
                    System.out.println("masuk menu how to play");
                    String input=sc.nextLine();
                    break;
                }
                case 3:{
                    System.exit(0);
                }
            }
        
        }
      
    }

    public static boolean isNumeric(String string) {
        int intValue;
            
        String.format("Parsing string: \"%s\"", string);
            
        if(string == null || string.equals("")) {
            return false;
        }
        
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            
        }
        return false;
    }

    public static List<Fish> getFishListFromPondByType(Pond pond, String type){
        List<Fish> result=new ArrayList<>();
        for(int i=0;i<pond.getFishInsidePond().size();i++){
            if(pond.getFishInsidePond().get(i).getFish().getType().equalsIgnoreCase(type)){
                result.add(pond.getFishInsidePond().get(i).getFish());
            }
        }
        return result;
    }

    public static int getBaitIndex(Fisher fisher){
        int result=0;
        for(int i=0;i<fisher.getInventory().getBait().size();i++){
            if(fisher.getInventory().getBait().get(i).getBait().equals(fisher.getBaitUsed())){
                result=i;
            }
        }

        return result;
    }
}