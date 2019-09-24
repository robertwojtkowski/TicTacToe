package company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    private Button[][] plansza;
    private GridPane gridPane;
    private Label textLicznik;
    private Label textX;
    private Label textY;
    private Button buttonReset;
    private Button buttonNewGame;
    private Scene scene;
    private final int W = 10;
    private final int K = 11;
    private Alert alert;
    private char tab[][];
    private int licznikX = 0;
    private int licznikY = 0;
    private String [] symbol = {"X", "O"};
    private int player = 0;
    private  int counter = 0;


    @Override
    public void start(Stage primaryStage) throws Exception {

        gridPane = new GridPane();
        gridPane.getStyleClass().add("grid-pane");

        plansza = new Button[3][3];


        for(int w = 0; w < plansza.length; w++){
            for(int k = 0; k < plansza.length; k++){
                plansza[w][k] = new Button("");
                plansza[w][k].setId("plansza-pole");
                plansza[w][k].setPrefSize(100,100);
                gridPane.add(plansza[w][k], w+W, k+K);
                gridPane.setHgap(10);
                gridPane.setVgap(10);
            }
        }



        textLicznik = new Label("Wygrane:");
        gridPane.add(textLicznik, 2,8);

        textX = new Label("X -> 0");
        gridPane.add(textX, 2,9);

        textY = new Label("O -> 0");
        gridPane.add(textY, 2,10);



        buttonNewGame = new Button("Nowa \n  Gra");
        gridPane.add(buttonNewGame, W+1,K+4);
        buttonNewGame.setId("button-new-game");

        // Zdefiniowanie sceny.
        scene = new Scene(gridPane, 650, 650);
        scene.getStylesheets().add("./com/company/style.css");
        // Wyswietlenie okna.
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.show();



        plansza[0][0].setOnAction(action -> {
            click(0,0);
        });

        plansza[1][1].setOnAction(action -> {
            click(1,1);
        });

        plansza[2][2].setOnAction(action -> {
            click(2,2);
        });


        plansza[0][1].setOnAction(action -> {
            click(0,1);
        });

        plansza[0][2].setOnAction(action -> {
            click(0,2);
        });

        plansza[1][0].setOnAction(action -> {
            click(1,0);
        });

        plansza[1][2].setOnAction(action -> {
            click(1,2);
        });

        plansza[2][1].setOnAction(action -> {
            click(2,1);
        });

        plansza[2][0].setOnAction(action -> {
            click(2,0);
        });

        buttonNewGame.setOnAction(action -> {
            for(int w = 0; w<3; w++){
                for(int k =0; k<3; k++){
                    plansza[w][k].setText("");
                    plansza[w][k].setDisable(false);
                }
            }
            player = 0;
            textX.setText("X -> " + licznikX);
            textY.setText("O -> " + licznikY);
            counter = 0;
        });

    }

    public void click(int i, int j){
        if(!plansza[i][j].isDisable()){
            plansza[i][j].setText(symbol[player]);
            plansza[i][j].setDisable(true);
            checkIfPlayerWon();
            player = (player + 1) % 2;
            counter++;
        }
        // ruch komputera:
        if(player == 1 && counter < 10){
            Random generator = new Random();
            int min = 0;
            int max = 2;
            int randComputerI = generator.nextInt((max - min) + 1) + min;
            int randComputerJ = generator.nextInt((max - min) + 1) + min;
            click(randComputerI, randComputerJ);
        }
    }


    public void  checkIfPlayerWon(){
        if(plansza[0][0].getText().equals(symbol[player]) && plansza[1][1].getText().equals(symbol[player])&& plansza[2][2].getText().equals(symbol[player]) ){
            if(plansza[0][0].getText().equals("X")){
                textX.setText("X -> " + ++licznikX);
            }else if(plansza[0][0].getText().equals("O")){
                textY.setText("O -> " + ++licznikY);
            }
            alert();
        }
        else if(plansza[0][0].getText().equals(symbol[player]) && plansza[0][1].getText().equals(symbol[player])&&
                plansza[0][2].getText().equals(symbol[player]) ){
            if(plansza[0][0].getText().equals("X")){
                textX.setText("X -> " + ++licznikX);
            }else if(plansza[0][0].getText().equals("O")){
                textY.setText("O -> " + ++licznikY);
            }
            alert();
        }
        else if(plansza[1][0].getText().equals(symbol[player]) && plansza[1][1].getText().equals(symbol[player])&&
                plansza[1][2].getText().equals(symbol[player]) ){
            if(plansza[1][0].getText().equals("X")){
                textX.setText("X -> " + ++licznikX);
            }else if(plansza[1][0].getText().equals("O")){
                textY.setText("O -> " + ++licznikY);
            }
            alert();
        }
        else if(plansza[2][0].getText().equals(symbol[player]) && plansza[2][1].getText().equals(symbol[player])&&
                plansza[2][2].getText().equals(symbol[player]) ){
            if(plansza[2][0].getText().equals("X")){
                textX.setText("X -> " + ++licznikX);
            }else if(plansza[2][0].getText().equals("O")){
                textY.setText("O -> " + ++licznikY);
            }
            alert();
        }
        else if(plansza[0][0].getText().equals(symbol[player]) && plansza[1][0].getText().equals(symbol[player])&&
                plansza[2][0].getText().equals(symbol[player]) ){
            if(plansza[0][0].getText().equals("X")){
                textX.setText("X -> " + ++licznikX);
            }else if(plansza[0][0].getText().equals("O")){
                textY.setText("O -> " + ++licznikY);
            }
            alert();
        }
        else if(plansza[0][1].getText().equals(symbol[player]) && plansza[1][1].getText().equals(symbol[player])&&
                plansza[2][1].getText().equals(symbol[player]) ){
            if(plansza[1][1].getText().equals("X")){
                textX.setText("X -> " + ++licznikX);
            }else if(plansza[1][1].getText().equals("O")){
                textY.setText("O -> " + ++licznikY);
            }
            alert();
        }
        else if(plansza[2][0].getText().equals(symbol[player]) && plansza[1][1].getText().equals(symbol[player])&&
                plansza[0][2].getText().equals(symbol[player]) ){
            if(plansza[2][0].getText().equals("X")){
                textX.setText("X -> " + ++licznikX);
            }else if(plansza[2][0].getText().equals("O")){
                textY.setText("O -> " + ++licznikY);
            }
            alert();
        }
    }
    public void alert(){
        for(int i =0; i<3; i++){
            for(int j =0; j<3; j++){
                plansza[i][j].setDisable(true);
            }
        }
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Gratulacje");
        alert.setHeaderText(null);
        alert.setContentText("Wygrana: " + symbol[player]);
        player = -1;
        alert.showAndWait();
    }

}