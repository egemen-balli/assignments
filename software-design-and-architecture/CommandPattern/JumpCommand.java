//Egemen BALLI 27 Nov 2023
public class JumpCommand implements Command {
   private GameCharacter character;

   public JumpCommand(GameCharacter character){
      this.character = character;
   }

   public void execute() {
      character.Jump();
   }
}
