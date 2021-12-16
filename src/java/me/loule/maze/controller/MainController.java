package me.loule.maze.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import me.loule.maze.model.MazeGenerator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private GridPane mazeGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int x = 8;
        int y = 8;
        MazeGenerator maze = new MazeGenerator(x, y);

        try {
            System.out.println("Generating maze...");
            String generatedMaze[] = maze.display().toArray(new String[0]);

//            System.out.println(Arrays.toString(generatedMaze));

            int rows = 0;
            int cols = 0;

            for (int i = 0; i < generatedMaze.length; i++) {
                if (generatedMaze[i].equals("➖➖➖➖") ) {
                    var myPane = new Pane();
                    myPane.setStyle("-fx-background-color: RED;");
                    myPane.setMaxHeight(2);
                    GridPane.setValignment(myPane, VPos.BOTTOM);

                    mazeGrid.add(myPane, cols, rows);
                } else if (generatedMaze[i].equals("⬛   ") || generatedMaze[i].equals("⬛")) {
                    var myPane = new Pane();
                    myPane.setStyle("-fx-background-color: GREEN;");
                    myPane.setMaxWidth(2);

                    GridPane.setHalignment(myPane, HPos.LEFT);
                    mazeGrid.add(myPane, cols, rows);
                }
                else if(generatedMaze[i].equals("+")  || generatedMaze[i].equals("➖   ")) {
                    var myPane = new Pane();
                    myPane.setStyle("-fx-background-color: BLUE;");
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}