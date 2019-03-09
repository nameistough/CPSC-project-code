/**
 * Subclass of GameObject
 * @author Rex J. Leniczek
 * @version 0.1
 * @since 2019-02-16
 *
 * @TODO: There is need to determine whether each menu subtype should simply be a
 * subclass of this Menu class...
 */

public class Game {
	private Settings gameSettings;
	private Board gameBoard;
	private Player player1;
	private Player player2;
	private Boolean gameOver = false;

	public Game(Player player1) {
		this.player1 = new Player(this, player1);
		gameSettings = new Settings(this);
		gameBoard = new Board(this);
		while (gameOver = false) {
			gameOver = player1.playerController.gameTurn();
		}
	}

	public Settings getSettings() {
		return new Settings(this, gameSettings);
	}

	public Player getPlayer1() {
		return new Player(this, player1);
	}

	public Board getGameBoard() {
		return new Board(this, gameBoard);
	}
}
