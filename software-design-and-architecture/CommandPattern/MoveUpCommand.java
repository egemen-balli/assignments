//Egemen BALLI 27 Nov 2023
public class MoveUpCommand implements Command {
   private GameCharacter character;

   public MoveUpCommand(GameCharacter character){
      this.character = character;
   }

   public void execute() {
      character.MoveUp();
   }
}