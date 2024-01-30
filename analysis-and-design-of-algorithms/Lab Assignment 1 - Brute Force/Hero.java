//Egemen Ballı 19 Mar 2023

import java.util.ArrayList;
import java.util.Random;

public class Hero {
    private char emptySymbol = ' ';
    private char heroSymbol = 'H';
    private char monsterSymbol = 'M';
    private int STAMINA = 10;
    private int MONSTER_REWARD = 5;

    static int FIRST_DIMENSION = 8;
    static int SECOND_DIMENSION = 8;

    private char[][] gameArea = new char[FIRST_DIMENSION][SECOND_DIMENSION];
    Random rnd = new Random();
    private ArrayList<Result> resultArray = new ArrayList<>();

    void fillGameArea(){
        for(int i = 0; i < gameArea.length; i++){
            for (int j = 0; j < gameArea.length; j++){
                gameArea[i][j] = emptySymbol;
            }
        }
    }

    void assignMonsters(){
        int row, column; int monsterCount = 0;
        while(monsterCount != 5){
            row = rnd.nextInt(FIRST_DIMENSION);
            column = rnd.nextInt(SECOND_DIMENSION);
            if(validMonsterPosition(row, column)){
                gameArea[row][column] = monsterSymbol;
                monsterCount++;
            }
        }
    }

    boolean isValidCoordinate(int row, int column){
        return row < FIRST_DIMENSION && column < SECOND_DIMENSION && 0 <= row && 0 <= column;
    }

    boolean validMonsterPosition(int row, int column){
        boolean validRange = true;
        for(int i = -2; i <= 2; i++){
            for(int j = -2; j <= 2; j++){
                if(isValidCoordinate(row + i, column + j)){
                    if(gameArea[row + i][column + j] == monsterSymbol){
                        validRange = false;
                    }
                }
            }
        }

        return isValidCoordinate(row, column) && gameArea[row][column] == emptySymbol && validRange;
    }

    void printGameArea(){
        System.out.print(" ");
        for(int i = 0; i < gameArea.length; i++){
            System.out.print("  " + i);
        }
        System.out.println();
        for(int i = 0; i < gameArea.length; i++){
            System.out.print(i + " ");
            for (int j = 0; j < gameArea.length; j++){
                System.out.print("[" + gameArea[i][j] + "]");
            }
            System.out.println();
        }
    }

    Coordinate assignHero(){
        int x = 0, y = 0;
        boolean w = true;
        while (w){
            x = rnd.nextInt(FIRST_DIMENSION);
            y = rnd.nextInt(SECOND_DIMENSION);
            if(gameArea[x][y] == emptySymbol){
                gameArea[x][y] = heroSymbol;
                w = false;
            }
        }
        return new Coordinate(x, y);
    }

    void solve(Coordinate hero){
        int mostProfitSolutionGold = 0;
        String mostProfitSolutionPath = "";

        int x = hero.getX();
        int y = hero.getY();

        move(0, new ArrayList<>(), x, y, "", 0, STAMINA);
        move(1, new ArrayList<>(), x, y, "", 0, STAMINA);
        move(2, new ArrayList<>(), x, y, "", 0, STAMINA);
        move(3, new ArrayList<>(), x, y, "", 0, STAMINA);

        for (Result i:resultArray) {
            if(i.getGold() > mostProfitSolutionGold){
                mostProfitSolutionGold = i.getGold();
                mostProfitSolutionPath = i.getPath();
            }
        }

        System.out.println("Maximum possible gold : " + mostProfitSolutionGold);
        System.out.println("Best path : " + mostProfitSolutionPath);
    }

    boolean canMove(int dir, int x, int y){
        boolean result = false;
        switch (dir){
            case 0:
                result = 0 <= x-1;
                break;
            case 1:
                result = FIRST_DIMENSION > y+1;
                break;
            case 2:
                result = SECOND_DIMENSION > x+1;
                break;
            case 3:
                result = 0 <= y-1;
                break;
        }
        return result;
    }

    ArrayList<Coordinate> addListToList(ArrayList<Coordinate> list1, ArrayList<Coordinate> list2){
        for (Coordinate i:list1) {
            list2.add(i);
        }
        return list2;
    }

    void move(int move, ArrayList<Coordinate> slayed, int x, int y, String path, int gold, int stamina){
        if(stamina != 0 && canMove(move, x, y)){
            switch (move){
                case 0:
                    stamina--;
                    x--;
                    if(gameArea[x][y] == monsterSymbol){
                        gold += MONSTER_REWARD;
                        slayed.add(new Coordinate(x,y));
                    }
                    path += "-U";
                    break;
                case 1:
                    stamina--;
                    y++;
                    if(gameArea[x][y] == monsterSymbol){
                        gold += MONSTER_REWARD;
                        slayed.add(new Coordinate(x,y));
                    }
                    path += "-R";
                    break;
                case 2:
                    stamina--;
                    x++;
                    if(gameArea[x][y] == monsterSymbol){
                        gold += MONSTER_REWARD;
                        slayed.add(new Coordinate(x,y));
                    }
                    path += "-D";
                    break;
                case 3:
                    stamina--;
                    y--;
                    if(gameArea[x][y] == monsterSymbol){
                        gold += MONSTER_REWARD;
                        slayed.add(new Coordinate(x,y));
                    }
                    path += "-L";
                    break;
            }

            move(0, addListToList(slayed, new ArrayList<Coordinate>()), x, y, path, gold, stamina);
            move(1, addListToList(slayed, new ArrayList<Coordinate>()), x, y, path, gold, stamina);
            move(2, addListToList(slayed, new ArrayList<Coordinate>()), x, y, path, gold, stamina);
            move(3, addListToList(slayed, new ArrayList<Coordinate>()), x, y, path, gold, stamina);
        }
        else if(stamina == 0){
            resultArray.add(new Result(path, gold, slayed));
        }
    }
}
