//imports all necessary javafx extensions
import javafx.application.Application;
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
	//Global Variables
	public static int[] position = {0,0};
	public static int progress = 0;
	public static boolean gameover = false;
	public static int[] prevposition;
	public static int critNum;
	
	//BorderPane that holds start menu items
	private BorderPane startMenu = new BorderPane();
	
	//GridPane that holds the start menu buttons
	private GridPane startButtonGrid = new GridPane();
	
	//BorderPane that holds the items shown in game
	private static BorderPane gameWindow = new BorderPane();
	
	//GridPane that holds the in-game buttons
	private static GridPane buttonGrid = new GridPane();

	static Questions questions = new Questions();
	
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
	    startButton.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent event) {
	        	secondaryStage.show();
	        }
	      });
	    
		Button startMenuExitButton = new Button("EXIT"); //creates new button
		startMenuExitButton.setMinHeight(50);
		startMenuExitButton.setMinWidth(50);
		startMenuExitButton.setFont(startMenuExitButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 15.0));
		startMenuExitButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
		startMenuExitButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));
		startMenuExitButton.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent event) {
	          primaryStage.close();
	        }
	      });
		startButtonGrid.add(startButton, 0, 0);
		startButtonGrid.add(startMenuExitButton, 1, 0);
		startButtonGrid.setAlignment(Pos.CENTER);
		startMenu.setBottom(startButtonGrid);
		
		//finalizes start menu
		startMenu.setAlignment(h, Pos.CENTER);
		startMenu.setAlignment(startButtonGrid, Pos.CENTER);
		Scene scene = new Scene(startMenu);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("CHOOSE LIFE");
		primaryStage.sizeToScene();
		
		String[][] life = questions.init_Questions();
		//create and display button grid
		
		//Rewind button
		Button rewindButton = new Button("REWIND BONUS"); //creates new button
		rewindButton.setMinHeight(50);
		rewindButton.setMinWidth(50);
		rewindButton.setFont(rewindButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 15.0));
		rewindButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
		rewindButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));
		rewindButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	secondaryStage.hide();
		    }
	      });
		
		//Exit Button
		Button exitButton = new Button("EXIT"); //creates new button
		exitButton.setMinHeight(50);
		exitButton.setMinWidth(50);
		exitButton.setFont(exitButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 15.0));
		exitButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
		exitButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent event) {
	        	secondaryStage.hide();
	        }
	      });
	    
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
		gameWindow.setLeft(leftPane);
		gameWindow.setAlignment(leftPane, Pos.CENTER);
		
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
		gameWindow.setRight(rightPane);
		gameWindow.setAlignment(rightPane, Pos.CENTER);
		
		//create and display progress bar
		ProgressBar pb = new ProgressBar(0);
		gameWindow.setTop(pb);
		gameWindow.setAlignment(pb, Pos.CENTER);
		
		//create and display middle of game display
		HBox centerTextBox = new HBox();
		Label centerGameText = new Label(questions.printQuestion(life, position[0], position[1]));
		centerTextBox.getChildren().addAll(centerGameText);
		centerTextBox.setAlignment(Pos.CENTER);
		gameWindow.setCenter(centerTextBox);
		
		//Left Button Action
		leftButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	if(gameover==false) {
	    			prevposition = position;
	    			if(position[0]==0) {
	    				position[1]++;
	    			}else {
	    				position[0]++;
	    				position[1]++;
	    			}
	    			progress++;
	    			if(progress==4) {
	    				gameover = true;
	    			}else {
	    				leftGameText.setText(questions.printOptions(position[0], position[1])[0]);
	    				rightGameText.setText(questions.printOptions(position[0], position[1])[1]);
	    				centerGameText.setText(questions.printQuestion(life, position[0], position[1]));
	    			}
	    			pb.setProgress((.33F)*progress);
	    			}
	        }
	      });
		
		//Right Button Action
		rightButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	if(gameover==false) {
	    			prevposition = position;
	    			if(position[0]==0) {
	    				position[0]++;
	    				position[1]++;
	    			}else {
	    				position[0] = 2*(position[0]+1)-1;
	    				position[1]++;
	    			}
	    			progress++;
	    			if(progress==4) {
	    				gameover = true;
	    			}else {
	    				leftGameText.setText(questions.printOptions(position[0], position[1])[0]);
	    				rightGameText.setText(questions.printOptions(position[0], position[1])[1]);
	    				centerGameText.setText(questions.printQuestion(life, position[0], position[1]));
	    			}
	    			pb.setProgress((.33F)*progress);
	    			}
	        }
	      });
		
		//finalize in-game window
		Scene scene2 = new Scene(gameWindow);
		secondaryStage.setScene(scene2);
		secondaryStage.setTitle("CHOOSE LIFE");
		secondaryStage.setMinHeight(400);
		secondaryStage.setMinWidth(500);
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
