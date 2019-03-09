/**
 * Subclass of GameObject
 * @author Rex J. Leniczek
 * @version 0.1
 * @since 2019-02-16
 */

public class Player {
	protected int storePoints = 0;
	protected int topScore = 0;
	protected String playerName = "";
	protected PlayerController playerController;
	protected Game currentGame;

    public Player() {
		this.playerController = new PlayerController(currentGame, this);
	}

    public Player(Game currentGame, Player playerToCopy) {
		this(currentGame);
		this.storePoints = playerToCopy.getPoints();
		this.topScore = playerToCopy.getTopScore();
		this.playerName = playerToCopy.getPlayerName();
	}

	public Player(Game currentGame) {
		this();
		this.currentGame = currentGame;
	}

	public int getPoints() {
		return storePoints;
	}

	public int getTopScore() {
		return topScore;
	}

	public String getPlayerName() {
		return new String(playerName);
	}

	public PlayerController getPlayerController() {
		return new PlayerController(currentGame, this);
	}
}
