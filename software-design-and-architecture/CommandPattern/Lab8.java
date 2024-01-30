//Egemen BALLI 27 Nov 2023
import java.util.Scanner;

public class Lab8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
                
        GameCharacter character = new GameCharacter();

        AttackCommand attackCommand = new AttackCommand(character);
        JumpCommand jumpCommand = new JumpCommand(character);
        MoveDownCommand moveDownCommand = new MoveDownCommand(character);
        MoveUpCommand moveUpCommand = new MoveUpCommand(character);
        MoveRightCommand moveRightCommand = new MoveRightCommand(character);
        MoveLeftCommand moveLeftCommand = new MoveLeftCommand(character);

        GameController gameController = new GameController();
        gameController.setCommand(attackCommand);
        gameController.setCommand(jumpCommand);
        gameController.setCommand(moveDownCommand);
        gameController.setCommand(moveUpCommand);
        gameController.setCommand(moveRightCommand);
        gameController.setCommand(moveLeftCommand);
        
        
        
        while(true){
            System.out.println("Select an action:");
            System.out.println("w - Move Up");
            System.out.println("a - Move Left");
            System.out.println("s - Move Down");
            System.out.println("d - Move Right");
            System.out.println("j - Jump");
            System.out.println("k - Attack");
            System.out.println("q - Quit\n");
            System.out.println("Enter your choice:");
            String input = scanner.next();
            if(gameController.performCommand(input)){
                break;
            }
        }
    }
    
}
