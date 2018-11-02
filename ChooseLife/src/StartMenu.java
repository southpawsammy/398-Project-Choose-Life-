import java.awt.Insets;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//This is a Draft which have been created for testing purposes

public class StartMenu extends Application{
	public static void main(String[] args) {
        launch(args);
    }
	
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Choose Life");
        Text title = new Text("Choose Life");
        Button start_btn = new Button();
        start_btn.setText("Start a new game");
        Button help_btn = new Button();
        help_btn.setText("Help");
        Button exit_btn = new Button();
        exit_btn.setText("Exit");
        
        start_btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				openGame();
			}
        	
        });
        exit_btn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                
            }
        });
        
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(240, 420);
        gridPane.setVgap(5); 
        gridPane.setHgap(5); 
        gridPane.setAlignment(Pos.CENTER); 
        gridPane.add(title, 1, 0);
        gridPane.add(start_btn, 1, 1);
        gridPane.add(help_btn, 1, 2);
        gridPane.add(exit_btn, 1, 3);
        
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public void openGame() {
    	Stage game = new Stage();
    	game.setTitle("Choose Life");
        Text title = new Text("Question");
        
        Button opt1 = new Button();
        opt1.setText("Option 1");
        Button opt2 = new Button();
        opt2.setText("Option 2");
        Button back_btn = new Button();
        back_btn.setText("Back");
        Button bonus_btn = new Button();
        bonus_btn.setText("Rewind Bonus");
        
        back_btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				game.close();
			}
        	
        });
        
        
    	GridPane gridPane = new GridPane();
        gridPane.setMinSize(240, 420);
        gridPane.setVgap(5); 
        gridPane.setHgap(5); 
        gridPane.setAlignment(Pos.CENTER); 
        gridPane.add(title, 1, 0);
        gridPane.add(opt1, 0, 2);
        gridPane.add(opt2, 2, 2);
        gridPane.add(back_btn, 2, 3);
        gridPane.add(bonus_btn, 0, 3);
        
        Scene scene = new Scene(gridPane);
        game.setScene(scene);
        game.show();
        
    }

    
    /* public void nextQuestion(){
     * 
     * }
     */
}
