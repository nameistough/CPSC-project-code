/**
 * Subclass of GameObject
 * @author Rex J. Leniczek
 * @version 0.1
 * @since 2019-02-20
 */

import java.util.*;

public class PlayerController {
	private Game currentGame;
	private Player ownerPlayer;
	private Scanner scanner = new Scanner(System.in);
	private Board gameBoard;

	public PlayerController(Game currentGame, Player player) {
		this.currentGame = currentGame;
		this.ownerPlayer = player;
	}

	public String getPlayerInput() {
		return scanner.next();
	}

	public Boolean gameTurn() {
		String userInput[];
		//Fix to be a boolean (right now is int to accomodate mineScan method return type)
		int mineCount;
		System.out.print(ownerPlayer.getPlayerName() + ", enter your guess: ");
		userInput = this.getPlayerInput().split(":");
		int row = this.toInteger(userInput[0]);
		int col = this.toInteger(userInput[1]);
		if (row != -1 && col != -1) {
			mineCount = currentGame.getGameBoard().mineScan(col, col, row, row);
			currentGame.getGameBoard().getObjectAtCoords(col, row).setRevealedBoolean(true);
		}
		System.out.println(currentGame.getGameBoard().display());
		return false;
		//if (isMine = true) ;
	}

	private int toInteger(String str) {
		int num;
		try {
			num = Integer.parseInt(str);
		}
		catch(NumberFormatException nfe) {
			return -1;
		}
		return num;
	}
}
