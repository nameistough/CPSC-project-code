/**
 * Subclass of GameObject
 * @author Rex J. Leniczek
 * @version 0.1
 * @since 2019-02-16
 */

public class Human extends Player {
	private String accountPassword;

    public Human() {
        while (playerName == "") {
			System.out.print("Please enter your playername: ");
			this.playerName = playerController.getPlayerInput();
		}
		System.out.println("Welcome," + playerName + "!");
    }
	/**
	 * Anytime a new Human Player is created, they are asked to provide a non-empty playername.
	 * @TODO: Create a save and load mechanism that stores playernames, player highscores,
	 * in-game points, and a password associated with each playername, required to access
	 * account save. Should recognize when a playername already exists and prompt for the
	 * respective account password.
	 */
	public Human(Game currentGame) {
        super(currentGame);
		while (playerName == "") {
			System.out.print("Please enter your playername: ");
			this.playerName = playerController.getPlayerInput();
		}
		System.out.println("Welcome," + playerName + "!");
	}
}
