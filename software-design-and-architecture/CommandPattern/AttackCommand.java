//Egemen BALLI 27 Nov 2023
public class AttackCommand implements Command {
   private GameCharacter character;

   public AttackCommand(GameCharacter character){
      this.character = character;
   }

   public void execute() {
      character.Attack();
   }
}
