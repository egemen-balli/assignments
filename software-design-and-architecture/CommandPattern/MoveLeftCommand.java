//Egemen BALLI 27 Nov 2023
public class MoveLeftCommand implements Command {
   private GameCharacter character;

   public MoveLeftCommand(GameCharacter character){
      this.character = character;
   }

   public void execute() {
      character.MoveLeft();
   }
}
