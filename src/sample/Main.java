package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        root.setGridLinesVisible(true);
        final int numCols = 50 ;
        final int numRows = 50 ;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            colConst.setFillWidth(true);
            colConst.setHgrow(Priority.ALWAYS);
            root.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            rowConst.setFillHeight(true);
            rowConst.setVgrow(Priority.ALWAYS);
            root.getRowConstraints().add(rowConst);
        }
        Label label = new Label("");
        label.setStyle("-fx-background-color: red; -fx-max-width: infinity; -fx-max-height: infinity");
        root.add(label,0,0,1,1);
        primaryStage.setScene(new Scene(root, 1600, 1200));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
