//Egemen BALLI 27 Nov 2023
public class MoveDownCommand implements Command {
   private GameCharacter character;

   public MoveDownCommand(GameCharacter character){
      this.character = character;
   }

   public void execute() {
      character.MoveDown();
   }
}
