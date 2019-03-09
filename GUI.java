import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class GUI extends Application implements EventHandler<ActionEvent> {
    private final int SIZE = 25;
    Scene firstScene, secondScene, thirdScene;
    private Stage window;
    private TextField nameInput;
    private Button easy, medium, difficult, goBack;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.window = primaryStage;

        // Game Board
        BorderPane gameBoard = new BorderPane();
        // Create name and Player Score
        HBox top = new HBox();
        Label player1 = new Label("Player 1: Egor Ushakov");
        Label player2 = new Label("Player 2: AI");
        Label score = new Label("Score: 0-0");
        Label time = new Label("Time: 00:00");
        top.getChildren().addAll(player1, player2, score, time);
        top.setSpacing(20.0);


        // Create the actual board:
        GridPane board = new GridPane();
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                board.add(new Button("1"), i, j);
            }
        }

        gameBoard.setTop(top);
        gameBoard.setCenter(board);
        window.setTitle("Hello World");
        thirdScene = new Scene(gameBoard, SIZE*SIZE + 50, SIZE*SIZE + 50);

        ///////////////////////////////////////////////////////////////////////////////
        BorderPane settings = new BorderPane();
        VBox items = new VBox();
        items.setSpacing(2.0);
        Label title = new Label("Settings");
        Label choice = new Label("Choose the Level of Difficulty");
        Button easy = new Button("Easy");
        Button medium = new Button("Medium");
        Button difficult = new Button("Difficult");
        Button goBack = new Button("Back");

        // Set the functionality of the buttons
        easy.setOnAction(e -> window.setScene(thirdScene));
        medium.setOnAction(e -> window.setScene(thirdScene));
        difficult.setOnAction(e -> window.setScene(thirdScene));
        goBack.setOnAction(e -> window.setScene(firstScene));

        items.getChildren().addAll(title, choice, easy, medium, difficult, goBack);
        settings.setCenter(items);
        secondScene = new Scene(settings, 200, 200);

        //////////////////////////////////////////////////////////////////////////////
        BorderPane input = new BorderPane();
        Label welcome = new Label("Welcome to Minesweepr");

        HBox info = new HBox();
        info.setSpacing(5.0);
        Label nameLabel = new Label("Please enter player name:");
        nameInput = new TextField();
        nameInput.setOnAction(e-> window.setScene(secondScene));
        info.getChildren().addAll(nameLabel, nameInput);
        input.setTop(welcome);
        input.setCenter(info);

        // Initialize Scene
        firstScene = new Scene(input, 350, 50);
        window.setScene(firstScene);
        window.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
