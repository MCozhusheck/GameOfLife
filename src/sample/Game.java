package sample;

import java.util.Random;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Game {
    public Grid grid;
    public Game() {
        boolean[][] grid = randomArray(50,50);
        this.grid = new Grid(grid);
    }

    public void showSteps(int stepCount) {
        for(int i=0; i<stepCount; i++) {
            grid.showGrid();
            grid.nextStep();
        }
    }

    public void nextPattern(){
        grid = new Grid(randomArray(50,50));
    }

    public GridPane displaySteps(GridPane gridPane) {
        gridPane.getChildren().clear();
        for (int i=0; i<grid.rows; i++) {
            for (int j=0; j<grid.columns; j++) {
                Label label = new Label("");
                if(grid.grid[i][j]) {
                    label.setStyle("-fx-background-color: red; -fx-max-width: infinity; -fx-max-height: infinity");
                } else {
                    label.setStyle("-fx-background-color: white; -fx-max-width: infinity; -fx-max-height: infinity");
                }
                gridPane.add(label,i,j,1,1);
            }
        }
        grid.nextStep();
        return gridPane;
    }
    public boolean[][] testGrid1() {
        boolean[][] grid = new boolean[50][50];
        grid[10][10] = true;
        grid[10][11] = true;
        grid[11][12] = true;
        grid[12][13] = true;
        grid[13][13] = true;
        grid[14][13] = true;
        grid[15][12] = true;
        grid[16][11] = true;
        grid[16][10] = true;
        return grid;
    }

    public boolean[][] randomArray(int rows, int cols) {
        boolean[][] array = new boolean[rows][cols];
        boolean alternating = false;
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int k = random.nextInt(i * cols + j + 1);
                int swapRow = k / cols;
                int swapCol = k % cols;
                boolean tmp = array[swapRow][swapCol];
                array[swapRow][swapCol] = alternating;
                array[i][j] = tmp;
                alternating = !alternating;
            }
        }

        return array;
    }

}
