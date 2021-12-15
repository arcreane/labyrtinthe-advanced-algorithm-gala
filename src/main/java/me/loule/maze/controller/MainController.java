package me.loule.maze.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import me.loule.maze.model.MazeGenerator;

import java.net.URL;
import java.io.*;
import java.util.*;

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
                mazeGrid.add(new Label(generatedMaze[i]), cols, rows);
                cols++;

                if (cols == 8) {
                    cols = 0;
                    rows++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}