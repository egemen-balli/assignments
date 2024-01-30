//Egemen Balli 21 Feb 2023

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    ArrayList<Rocket> loadU1(ArrayList<Item> itemList){
        ArrayList<Rocket> listU1 = new ArrayList();
        Rocket U1 = new U1();
        for (Item i : itemList) {
            if (U1.canCarry(i.getWeight())) {
                listU1.add(U1);
                U1.carry(i.getWeight());
            } else {
                U1 = new U1();
                listU1.add(U1);
            }
        }
        return listU1;
    }

    ArrayList<Rocket> loadU2(ArrayList<Item> itemList) {

        ArrayList<Rocket> listU2 = new ArrayList();
        Rocket U2 = new U2();
        for (Item i : itemList) {
            if (U2.canCarry(i.getWeight())) {
                listU2.add(U2);
                U2.carry(i.getWeight());
            } else {
                U2 = new U2();
                listU2.add(U2);
            }
        }
        return listU2;
    }

    ArrayList<Item> loadItems(String path) throws Exception{
        ArrayList<Item> loadedItems = new ArrayList<>();
        Scanner fileScanner = new Scanner(new File(path));
        while (fileScanner.hasNextLine()) {
            Item item = new Item();
            String[] itemA = fileScanner.nextLine().split("=");
            item.setName(itemA[0]);
            item.setWeight(Double.parseDouble(itemA[1]));
            loadedItems.add(item);
        }
        return loadedItems;
    }

    int runSimulation(ArrayList<Rocket> rocketList) {
        int totalCost = 0;
        for (Rocket i : rocketList) {
            totalCost += i.getRocketCost();
            if(!i.launch()){
                totalCost += i.getRocketCost();
                i.launch();
            }else{
                totalCost += i.getRocketCost();
            }
            if(!i.land()){
                totalCost += i.getRocketCost();
                i.launch();
            }else{
                totalCost += i.getRocketCost();
            }
        }

        return totalCost;
    }
}
