//imports all necessary javafx extensions
import javafx.beans.value.ChangeListener ;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.control.ProgressBar;

/**
 * Stores all variables and methods needed to run the Choose Life game
 */
public class ChooseLifeStartMenu extends Application{
	static Questions questions = new Questions();
	//Global Variables
	public static int[] position = {0,0};
	public static int progress = 0;
	public static int[] prevposition = {0,0};
	//BorderPane that holds start menu items
	private BorderPane startMenu = new BorderPane();
	
	//GridPane that holds the start menu buttons
	private GridPane startButtonGrid = new GridPane();
	
	//BorderPane that holds the items shown in game
	private static BorderPane gameWindow = new BorderPane();
	
	//GridPane that holds the in-game buttons
	private static GridPane buttonGrid = new GridPane();
	
	//BorderPane that holds the game over window
	private static BorderPane GameOverWindow = new BorderPane();
	
	static Label leftGameText;
	static Label rightGameText;
	static Label centerGameText;
	
	@Override
	public void start(Stage primaryStage) {
		//Code for title on start menu
		HBox h = new HBox();
		Label topStartLabel = new Label("Welcome to Choose Life!\n\n\n");
		topStartLabel.setFont(topStartLabel.getFont().font("Arial",24.0));
		h.getChildren().addAll(topStartLabel);
		h.setAlignment(Pos.CENTER);
		startMenu.setTop(h);
		
		Stage secondaryStage = new Stage();
		Stage lostStage = new Stage();
		
		//Code for instructions text
		HBox h2 = new HBox();
		Label centerStartLabel = new Label("Every decision you make will trigger a new decision to be made.\n"
				+ "Throughout your journey, you may come across Critical Questions.\n"
				+ "Answer these correctly and you will recieve a Rewind Bonus, allowing you\n"
				+ "to go back one question at any point in your journey.\n\n\n\n\n\n");
		centerStartLabel.setFont(centerStartLabel.getFont().font("Arial",15.0));
		h2.getChildren().addAll(centerStartLabel);
		h2.setAlignment(Pos.CENTER);
		startMenu.setCenter(h2);
		
		//creates start menu buttons
		Button startButton = new Button("START"); //creates new button
	    startButton.setMinHeight(50);
	    startButton.setMinWidth(50);
	    startButton.setFont(startButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 15.0));
	    startButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
	    startButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));
	    
		Button startMenuExitButton = new Button("EXIT"); //creates new button
		startMenuExitButton.setMinHeight(50);
		startMenuExitButton.setMinWidth(50);
		startMenuExitButton.setFont(startMenuExitButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 15.0));
		startMenuExitButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
		startMenuExitButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));

		startButtonGrid.add(startButton, 0, 0);
		startButtonGrid.add(startMenuExitButton, 1, 0);
		startButtonGrid.setAlignment(Pos.CENTER);
		startMenu.setBottom(startButtonGrid);
		startMenu.setAlignment(h, Pos.CENTER);
		startMenu.setAlignment(startButtonGrid, Pos.CENTER);
		
		Scene scene = new Scene(startMenu);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("CHOOSE LIFE");
		primaryStage.sizeToScene();
		
		
		//Creating Game window
		
		String[][] kidlife = questions.init_Questions();
		
		//create and display button grid
		
		//Rewind button
		Button rewindButton = new Button("REWIND BONUS"); //creates new button
		rewindButton.setMinHeight(50);
		rewindButton.setMinWidth(50);
		rewindButton.setFont(rewindButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 15.0));
		rewindButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
		rewindButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));
		
		//Exit Button
		Button exitButton = new Button("EXIT"); //creates new button
		exitButton.setMinHeight(50);
		exitButton.setMinWidth(50);
		exitButton.setFont(exitButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 15.0));
		exitButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
		exitButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));
		
	    
		buttonGrid.add(rewindButton,0,0);
		buttonGrid.add(exitButton, 1, 0);
		buttonGrid.setAlignment(Pos.CENTER);
		gameWindow.setBottom(buttonGrid);
		gameWindow.setAlignment(buttonGrid, Pos.CENTER);
		
		//create and display left side of game display
		GridPane leftPane = new GridPane();
		
		//Left button
		Button leftButton = new Button("OPTION 1"); //creates new button
		leftButton.setMinHeight(50);
		leftButton.setMinWidth(50);
		leftButton.setFont(leftButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 15.0));
		leftButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
		leftButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));

		
		HBox leftTextBox = new HBox();
		Label leftGameText = new Label(questions.printOptions(position[0], position[1])[0]);
		leftTextBox.getChildren().addAll(leftGameText);
		leftPane.add(leftTextBox, 0, 0);
		leftPane.add(leftButton, 0, 1);
		leftPane.setAlignment(Pos.BOTTOM_CENTER);
		gameWindow.setLeft(leftPane);
		
		//create and display right side of game display
		GridPane rightPane = new GridPane();
		//Right Button
		Button rightButton = new Button("OPTION 2"); //creates new button
		rightButton.setMinHeight(50);
		rightButton.setMinWidth(50);
		rightButton.setFont(rightButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 15.0));
		rightButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
		rightButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));
		
		HBox rightTextBox = new HBox();
		Label rightGameText = new Label(questions.printOptions(position[0], position[1])[1]);
		rightTextBox.getChildren().addAll(rightGameText);
		rightPane.add(rightTextBox, 0, 0);
		rightPane.add(rightButton, 0, 1);
		rightPane.setAlignment(Pos.BOTTOM_CENTER);
		gameWindow.setRight(rightPane);
		
		//create and display progress bar
		ProgressBar pb = new ProgressBar(0);
		gameWindow.setTop(pb);
		gameWindow.setAlignment(pb, Pos.CENTER);
		
		//create and display middle of game display
		HBox centerTextBox = new HBox();
		Label centerGameText = new Label(questions.printQuestion(kidlife, position[0], position[1]));
		centerTextBox.getChildren().addAll(centerGameText);
		centerTextBox.setAlignment(Pos.CENTER);
		gameWindow.setCenter(centerTextBox);
		
		//finalize in-game window
		Scene scene2 = new Scene(gameWindow);
		secondaryStage.setScene(scene2);
		secondaryStage.setTitle("CHOOSE LIFE");
		secondaryStage.setMinHeight(400);
		secondaryStage.setMinWidth(500);
		
		//Game Over window
		HBox GameOverTopBox = new HBox();
		Label GameOverLabel = new Label("GAME OVER\n\n\n");
		GameOverLabel.setFont(GameOverLabel.getFont().font("Arial",48.0));
		GameOverTopBox.getChildren().addAll(GameOverLabel);
		GameOverTopBox.setAlignment(Pos.CENTER);
		GameOverWindow.setTop(GameOverTopBox);
		
		HBox GameOverCenterBox = new HBox();
		Label GameOverDescriptionLabel = new Label("You lived a long life\n\n\n");
		GameOverDescriptionLabel.setFont(GameOverDescriptionLabel.getFont().font("Arial",20.0));
		GameOverCenterBox.getChildren().addAll(GameOverDescriptionLabel);
		GameOverCenterBox.setAlignment(Pos.CENTER);
		GameOverWindow.setTop(GameOverCenterBox);

		Button restartButton = new Button("RESTART GAME"); //creates new button
	    restartButton.setMinHeight(100);
	    restartButton.setMinWidth(100);
	    restartButton.setFont(restartButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 25.0));
	    restartButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
	    restartButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));
	    GameOverWindow.setBottom(restartButton);
	    GameOverWindow.setAlignment(restartButton, Pos.CENTER);
	    Scene LostScene = new Scene(GameOverWindow);
		lostStage.setScene(LostScene);
		lostStage.setMinHeight(400);
		lostStage.setMinWidth(500);
		
		//Events
		//Start Button
	    startButton.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent event) {
	        	secondaryStage.show();
	        }
	      });
	    
	    //Exit button
		startMenuExitButton.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent event) {
	          primaryStage.close();
	          secondaryStage.close();
	          lostStage.close();
	        }
	      });
	    
		//Left Button Action
		leftButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	if(position[0]==2&&position[1]==2) {
    				secondaryStage.hide();
    				GameOverDescriptionLabel.setText("At the amusement park, none of your friends show up and you life a boring, uneventful life alone….");
    				lostStage.show();
    			}
	    			if(position[0]==0) {
	    				position[1]++;
	    			}else {
	    				position[0]++;
	    				position[1]++;
	    			}
	    			
	    			progress++;
	    			if(progress==3) {
	    				position[0] = 0;
	    				position[1] = 4;
	    			}
	    			if(position[0]==2&&position[1]==2) {
	    				leftGameText.setText(questions.printOptions(position[0], position[1])[0]);
	    				leftButton.setStyle("-fx-background-color: #ff6347");
	    				rightGameText.setText(questions.printOptions(position[0], position[1])[1]);
	    				rightButton.setStyle("-fx-background-color: #ff6347");
	    				centerGameText.setText(questions.printQuestion(kidlife, position[0], position[1]));
	    				centerGameText.setTextFill(Color.RED);
	    			}else {
	    				leftGameText.setText(questions.printOptions(position[0], position[1])[0]);
	    				leftButton.setStyle("");
	    				rightGameText.setText(questions.printOptions(position[0], position[1])[1]);
	    				rightButton.setStyle("");
	    				centerGameText.setText(questions.printQuestion(kidlife, position[0], position[1]));
	    				centerGameText.setTextFill(Color.BLACK);
	    			}
	    			pb.setProgress((.33F)*progress);

	        }
	      });
		
		//Right Button Action
		rightButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	
	    			if(position[0]==0) {
	    				position[0]++;
	    				position[1]++;
	    			}else {
	    				position[0] = 2*(position[0]+1)-1;
	    				position[1]++;
	    			}
	    			progress++;
	    			if(progress==3) {
	    				position[0] = 0;
	    				position[1] = 4;
	    			}
	    				leftGameText.setText(questions.printOptions(position[0], position[1])[0]);
	    				leftButton.setStyle("");
	    				rightGameText.setText(questions.printOptions(position[0], position[1])[1]);
	    				rightButton.setStyle("");
	    				centerGameText.setText(questions.printQuestion(kidlife, position[0], position[1]));
	    				centerGameText.setTextFill(Color.BLACK);
	    			pb.setProgress((.33F)*progress);
	    			
	        }
	      });
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent event) {
	        	secondaryStage.hide();
	        	reset();
	        	leftGameText.setText(questions.printOptions(position[0], position[1])[0]);
	        	leftButton.setStyle("");
				rightGameText.setText(questions.printOptions(position[0], position[1])[1]);
				rightButton.setStyle("");
				centerGameText.setText(questions.printQuestion(kidlife, position[0], position[1]));
				centerGameText.setTextFill(Color.BLACK);
				pb.setProgress((.33F)*progress);
	        }
	      });
		
		rewindButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	secondaryStage.hide();
		    }
	      });
		
		restartButton.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent event) {
	        	lostStage.hide();
	        	reset();
	        	leftGameText.setText(questions.printOptions(position[0], position[1])[0]);
	        	leftButton.setStyle("");
				rightGameText.setText(questions.printOptions(position[0], position[1])[1]);
				rightButton.setStyle("");
				centerGameText.setText(questions.printQuestion(kidlife, position[0], position[1]));
				centerGameText.setTextFill(Color.BLACK);
				pb.setProgress((.33F)*progress);
				secondaryStage.show();
	        }
	      });
		
	}
		
	
	public static void reset() {
    	position[0] = 0;
    	position[1] = 0;
    	prevposition[0] = 0;
    	prevposition[1] = 0;
    	progress = 0;
	}

/*
	*/
	/**
	 * Launches game
	 * @param args should be empty
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}