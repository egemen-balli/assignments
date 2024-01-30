//Egemen Ballı 19 Mar 2023

import java.util.ArrayList;

public class Result {
    private int gold;
    private String path;
    private ArrayList<Coordinate> slayed = new ArrayList<>();

    public Result(String path, int gold, ArrayList<Coordinate> slayed){
        this.gold = gold;
        this.path = path;
        this.slayed = slayed;

        int[][] arr = new int[Hero.FIRST_DIMENSION][Hero.SECOND_DIMENSION];
        for (Coordinate i:slayed) {
            arr[i.getX()][i.getY()]++;
        }
        for (int i = 0; i < Hero.FIRST_DIMENSION; i++){
            for (int j = 0; j < Hero.SECOND_DIMENSION; j++){
                if (arr[i][j] > 1){
                    this.gold -= (arr[i][j] - 1) * 5;
                }
            }
        }

    }

    public int getGold() {
        return gold;
    }

    public String getPath() {
        return path;
    }
}
