package sample;

public class Grid {
    public final int rows;
    public final int columns;
    public boolean[][] grid;

    public Grid(int RowsNum, int ColumnsNum) {
        rows = RowsNum;
        columns = ColumnsNum;
        grid = new boolean[rows][columns];
        grid[0][0] = true;
        grid[0][2] = true;
        grid[1][1] = true;
        grid[1][2] = true;
        grid[2][1] = true;
    }

    public Grid(boolean[][] grid) {
        rows = grid.length;
        columns = grid[0].length;
        this.grid = grid;
    }

    public void showGrid() {
        for(int i=0; i<rows; i++) {
            System.out.print("|");
            for(int j=0; j<columns; j++) {
                if(grid[i][j]) {
                    System.out.print(" X |");
                } else {
                    System.out.print("   |");
                }
                //System.out.print(" " + getCellAliveNeighbours(i,j) + " |");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    private int getCellAliveNeighbours(int row, int col) {
        int aliveNeigh = 0;
        if(row>0 && col>0 && grid[row-1][col-1]) {
            ++aliveNeigh;
        }
        if(row>0 && grid[row-1][col]) {
            ++aliveNeigh;
        }
        if(row>0 && col<columns-1 && grid[row-1][col+1]) {
            ++aliveNeigh;
        }
        if(col<columns-1 && grid[row][col+1]) {
            ++aliveNeigh;
        }
        if(row<rows-1 && col<columns-1 && grid[row+1][col+1]) {
            ++aliveNeigh;
        }
        if(row<rows-1 && grid[row+1][col]) {
            ++aliveNeigh;
        }
        if(row<rows-1 && col>0 && grid[row+1][col-1]) {
            ++aliveNeigh;
        }
        if(col>0 && grid[row][col-1]) {
            ++aliveNeigh;
        }

        return aliveNeigh;
    }
    private boolean[][] nextGrid() {
        boolean[][] newGrid = new boolean[rows][columns];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                int aliveNeigh = getCellAliveNeighbours(i,j);
                if(aliveNeigh<2 && grid[i][j]) {
                    newGrid[i][j] = false;
                } else if( aliveNeigh>1 && aliveNeigh<4 && grid[i][j]) {
                    newGrid[i][j] = true;
                } else if(aliveNeigh>3 && grid[i][j]) {
                    newGrid[i][j] = false;
                } else if(aliveNeigh==3 && !grid[i][j]) {
                    newGrid[i][j] = true;
                }
            }
        }
        return newGrid;
    }
    public void nextStep(){
        grid = nextGrid();
    }
}

