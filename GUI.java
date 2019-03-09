

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    private final int SIZE = 25;
    private Stage window;
    Scene firstScene, secondScene, thirdScene, fourthScene;
    private TextField nameInput;
    private Button easy, medium, difficult, goBack, enterButton, unlockArt, pointBalance, backToMain;
    private Minesweeper myGame;
    private GridPane board;

    public class GameHandle implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent){
            if ((Button) actionEvent.getSource() == easy) {
                window.setScene(thirdScene);
            }
            else if ((Button) actionEvent.getSource() == medium ){
                window.setScene(thirdScene);
            }

            else if ((Button) actionEvent.getSource() == difficult){
                window.setScene(thirdScene);
            }

            else if ((Button) actionEvent.getSource() == goBack){
                window.setScene(firstScene);
            }

            else if ((Button) actionEvent.getSource() == goBack){
                window.setScene(firstScene);
            }

            else if ((Button) actionEvent.getSource() == enterButton) {
                window.setScene(secondScene);
                nameInput.setText("");
            }

            else if ((Button) actionEvent.getSource() == backToMain) {
                window.setScene(secondScene);
                nameInput.setText("");
            }

            else {
                Label item = new Label("1");
                int idx = board.getChildren().indexOf(actionEvent.getSource());
                System.out.println(idx);
            }
        }
    }




    @Override
    public void start(Stage primaryStage) throws Exception{
        this.window = primaryStage;

        // Create Store menu
        VBox storeOptions = new VBox();
        Label titleStore = new Label("Game Store");
        unlockArt = new Button("Unlock Art");
        pointBalance = new Button("Point Balance");
        backToMain = new Button("Back"); // Repetition of code. Code reviewers please fix
        storeOptions.getChildren().addAll(titleStore, unlockArt, pointBalance, backToMain);
        unlockArt.setOnAction(new GameHandle());
        pointBalance.setOnAction(new GameHandle());
        backToMain.setOnAction(new GameHandle());
        storeOptions.setSpacing(2.0);
        fourthScene = new Scene(storeOptions, 350, 150);







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
        board = new GridPane();
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                Button btts = new Button();
                board.add(btts, i, j);
                btts.setOnAction(new GameHandle());
            }
        }


        gameBoard.setTop(top);
        gameBoard.setCenter(board);
        window.setTitle("Minesweeper");
        thirdScene = new Scene(gameBoard, SIZE*SIZE + 50, SIZE*SIZE + 50);

        ///////////////////////////////////////////////////////////////////////////////
        BorderPane settings = new BorderPane();
        VBox items = new VBox();
        items.setSpacing(2.0);
        Label title = new Label("Settings");
        Label choice = new Label("Choose the Level of Difficulty");
        easy = new Button("Easy");
        medium = new Button("Medium");
        difficult = new Button("Difficult");
        goBack = new Button("Back");
        // Set the functionality of the buttons
        items.getChildren().addAll(title, choice, easy, medium, difficult, goBack);
        easy.setOnAction(new GameHandle());
        medium.setOnAction(new GameHandle());
        difficult.setOnAction(new GameHandle());
        goBack.setOnAction(new GameHandle());


        settings.setCenter(items);
        secondScene = new Scene(settings, 200, 200);

        //////////////////////////////////////////////////////////////////////////////
        BorderPane input = new BorderPane();
        Label welcome = new Label("Welcome to Minesweeper");

        HBox info = new HBox();
        info.setSpacing(5.0);
        Label nameLabel = new Label("Please enter player name:");
        nameInput = new TextField();
        VBox infoProcess = new VBox(); // Receives the user's input
        enterButton = new Button("Enter");
        enterButton.setOnAction(new GameHandle());
        infoProcess.getChildren().add(enterButton);
        info.getChildren().addAll(nameLabel, nameInput);
        input.setTop(welcome);
        input.setCenter(info);
        input.setBottom(infoProcess);

        // Initialize Scene
        firstScene = new Scene(input, 350, 100);
        window.setScene(firstScene);
        window.show();

    }


    public static void main(String[] args) {
        launch(args);
    }


}
