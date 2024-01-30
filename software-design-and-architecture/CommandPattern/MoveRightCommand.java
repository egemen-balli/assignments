//Egemen BALLI 27 Nov 2023
public class MoveRightCommand implements Command {
   private GameCharacter character;

   public MoveRightCommand(GameCharacter character){
      this.character = character;
   }

   public void execute() {
      character.MoveRight();
   }
}
