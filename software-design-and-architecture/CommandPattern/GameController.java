//Egemen BALLI 27 Nov 2023
import java.util.ArrayList;
import java.util.List;

public class GameController {
    List<Command> commandList = new ArrayList<Command>();
    
    public void setCommand(Command command) {
        commandList.add(command);
    }

    public boolean performCommand(String commandKey) {
        switch (commandKey) {
            case "w":
                commandList.get(3).execute();
                return false;
                
            case "a":
                commandList.get(5).execute();
                return false;
                
            case "s":
                commandList.get(2).execute();
                return false;
                
            case "d":
                commandList.get(4).execute();
                return false;
                
            case "j":
                commandList.get(1).execute();
                return false;
                
            case "k":
                commandList.get(0).execute();
                return false;
                
            case "q":
                return true;
            default:
                return true;
        }
    }
}
