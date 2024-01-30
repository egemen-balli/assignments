//Egemen Ballı 19 Mar 2023

public class Demo {
    public static void main(String[] args) {
        Hero game = new Hero();
        game.fillGameArea();
        game.assignMonsters();
        Coordinate pos = game.assignHero();
        game.printGameArea();
        game.solve(pos);
    }
}
