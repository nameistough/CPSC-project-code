/**
 * Subclass of GameObject
 * @author Rex J. Leniczek
 * @version 0.1
 * @since 2019-02-16
 *
 * @TODO: There is need to determine whether each menu subtype should simply be a
 * subclass of this Menu class...
 */

public class Menu {
	private Player player1;

	public Menu() {
		this.player1 = new Human();
		this.mainMenu();
	}

	public void mainMenu() {
		System.out.println("~Main Menu~\n[N]ew Game\n[S]tore\n[Q]uit");
		String userInput = "";
		do {
			System.out.print("Selection: ");
			userInput = player1.getPlayerController().getPlayerInput();
			switch (userInput.toUpperCase()) {
				case "Q":
					System.exit(0);
					break;
				case "S":
					this.storeMenu();
					break;
				case "N":
					Game newGame = new Game(player1);
					break;
				default:
					System.out.println("Invalid selection...");
					break;
			}
		} while (!(userInput.equalsIgnoreCase("Q")));
	}

	public void storeMenu() {
		System.out.println("~Game Store~\n[U]nlock Art\n[P]oint Balance\n[B]ack");
		String userInput = "";
		do {
			System.out.print("Selection: ");
			userInput = player1.getPlayerController().getPlayerInput();
			switch (userInput.toUpperCase()) {
				case "U":
					this.artMenu();
					break;
				case "P":
					System.out.println("Your current balance is: " + player1.getPoints() + " points");
					break;
				case "B":
					System.out.println("~Main Menu~\n[N]ew Game\n[S]tore\n[Q]uit");
					return;
				default:
					System.out.println("Invalid selection...");
					break;
			}
		} while (!(userInput.equalsIgnoreCase("B")));
	}

	public void artMenu() {
	}
}
