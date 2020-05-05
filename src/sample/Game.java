package sample;

import java.util.Random;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Game {
    public Grid grid;
    private int currentPattern = 0;
    public Game() {
        boolean[][] grid = randomArray(50,50);
        this.grid = new Grid(grid);
    }
    public void nextPattern(){ //iterate through patterns
        currentPattern++; // use variable to remember current pattern
        if(currentPattern >= 3)
            currentPattern = 0;
        if(currentPattern==0) {
            grid = new Grid(randomArray(50,50));
        } else if(currentPattern==1) {
            grid = new Grid((theQueenBeeShuttlePattern()));
        } else if (currentPattern==2) {
            grid = new Grid(tumblerPattern());
        }
    }
    public void displaySteps(GridPane gridPane) { // fills given grid with colours according to grid
        gridPane.getChildren().clear(); // clear grid with previous objects to prevent stack overflow
        for (int i=0; i<grid.rows; i++) {
            for (int j=0; j<grid.columns; j++) {
                Label label = new Label("");
                if(grid.grid[i][j]) { // if is alive color cell red
                    label.setStyle("-fx-background-color: red; -fx-max-width: infinity; -fx-max-height: infinity");
                } else { // if is dead color cell white
                    label.setStyle("-fx-background-color: white; -fx-max-width: infinity; -fx-max-height: infinity");
                }
                gridPane.add(label,i,j,1,1);
            }
        }
        grid.nextStep(); //after displaying grid prepare for next render
    }
    private boolean[][] theQueenBeeShuttlePattern() {
        boolean[][] grid = new boolean[50][50];
        grid[20][20] = true;
        grid[20][21] = true;
        grid[21][22] = true;
        grid[22][23] = true;
        grid[23][23] = true;
        grid[24][23] = true;
        grid[25][22] = true;
        grid[26][21] = true;
        grid[26][20] = true;
        return grid;
    }
    private boolean[][] tumblerPattern() {
        boolean[][] grid = new boolean[50][50];
        grid[20][20] = true;
        grid[20][21] = true;
        grid[21][20] = true;
        grid[21][21] = true;
        grid[22][21] = true;
        grid[23][21] = true;
        grid[24][21] = true;
        grid[25][20] = true;
        grid[25][19] = true;
        grid[24][19] = true;
        grid[23][19] = true;
        grid[22][19] = true;

        grid[20][23] = true;
        grid[20][24] = true;
        grid[21][23] = true;
        grid[21][24] = true;
        grid[22][23] = true;
        grid[23][23] = true;
        grid[24][23] = true;
        grid[25][24] = true;
        grid[25][25] = true;
        grid[24][25] = true;
        grid[23][25] = true;
        grid[22][25] = true;
        return grid;
    }
    private boolean[][] randomArray(int rows, int cols) {
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
