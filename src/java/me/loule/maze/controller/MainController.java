package me.loule.maze.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import me.loule.maze.model.MazeGenerator;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private GridPane mazeGrid;

    @FXML
    private Button btnRight;

    @FXML
    private Button btnLeft;

    @FXML
    private Button btnUp;

    @FXML
    private Button btnDown;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int x = 8;
        int y = 8;
        MazeGenerator maze = new MazeGenerator(x, y);

        try {
            System.out.println("Generating maze...");
            String generatedMaze[] = maze.display().toArray(new String[0]);

            System.out.println(Arrays.toString(generatedMaze));

            int rows = 0;
            int cols = 0;

            int[] playerPosition = {0, 1};
            System.out.println("Player position: " + playerPosition[0] + ", " + playerPosition[1]);


            System.out.println();

            for (int i = 0; i < generatedMaze.length; i++) {
                // Bottom row
                if (generatedMaze[i].equals("➖➖➖➖")) {
                    var myPane = new Pane();
                    myPane.setStyle("-fx-background-color: #000;");
                    myPane.setMaxHeight(2);
                    GridPane.setValignment(myPane, VPos.BOTTOM);

                    mazeGrid.add(myPane, cols, rows);
                }

                // Left row

                else if (generatedMaze[i].equals("⬛   ") || generatedMaze[i].equals("⬛")) {
                    var myPane = new Pane();
                    myPane.setStyle("-fx-background-color: #000;");
                    myPane.setMaxWidth(2);

                    GridPane.setHalignment(myPane, HPos.LEFT);
                    mazeGrid.add(myPane, cols, rows);
                }

                // Left Center row

                else if (generatedMaze[i].equals("+") || generatedMaze[i].equals("➖   ")) {
                    var myPane = new Pane();
                    myPane.setStyle("-fx-background-color: #000;");
                    myPane.setMaxWidth(2);
                    myPane.setMaxHeight(2);
                    GridPane.setHalignment(myPane, HPos.LEFT);
                    GridPane.setValignment(myPane, VPos.CENTER);
                    mazeGrid.add(myPane, cols, rows);
                }

                if (cols == 8) {
                    cols = 0;
                    rows++;
                } else
                    cols++;

            }

            mazeGrid.add(new Label("▩"), 0, 1);

            btnRight.setOnMouseClicked(event -> {
                mazeGrid.getChildren().remove(mazeGrid.getChildren().size() - 1);
                mazeGrid.add(new Label("▶"), playerPosition[0], playerPosition[1]);

                playerPosition[0]++;

                mazeGrid.add(new Label("▩"), playerPosition[0], playerPosition[1]);
            });

            btnLeft.setOnMouseClicked(event -> {
                mazeGrid.getChildren().remove(mazeGrid.getChildren().size() - 1);
                mazeGrid.add(new Label("◀"), playerPosition[0], playerPosition[1]);


                playerPosition[0]--;

                mazeGrid.add(new Label("▩"), playerPosition[0], playerPosition[1]);
            });

            btnUp.setOnMouseClicked(event -> {
                mazeGrid.getChildren().remove(mazeGrid.getChildren().size() - 1);
                mazeGrid.add(new Label("▲"), playerPosition[0], playerPosition[1]);


                playerPosition[1]--;

                mazeGrid.add(new Label("▩"), playerPosition[0], playerPosition[1]);
            });

            btnDown.setOnMouseClicked(event -> {
                mazeGrid.getChildren().remove(mazeGrid.getChildren().size() - 1);
                mazeGrid.add(new Label("▼"), playerPosition[0], playerPosition[1]);


                playerPosition[1]++;

                mazeGrid.add(new Label("▩"), playerPosition[0], playerPosition[1]);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}