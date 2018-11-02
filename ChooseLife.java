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

	//BorderPane that holds start menu items
	private BorderPane startMenu = new BorderPane();
	
	//GridPane that holds the start menu buttons
	private GridPane startButtonGrid = new GridPane();
	
	//BorderPane that holds the items shown in game
	private static BorderPane gameWindow = new BorderPane();
	
	//GridPane that holds the in-game buttons
	private static GridPane buttonGrid = new GridPane();

	@Override
	public void start(Stage primaryStage) {
		//Code for title on start menu
		HBox h = new HBox();
		Label topStartLabel = new Label("Welcome to Choose Life!\n\n\n");
		topStartLabel.setFont(topStartLabel.getFont().font("Arial",24.0));
		h.getChildren().addAll(topStartLabel);
		h.setAlignment(Pos.CENTER);
		startMenu.setTop(h);

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
		Button startButton = createStartButton();
		Button startMenuExitButton = createExitButton();
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
	}
	
	/**
	 * Creates a start button for the start menu
	 * @return returns the start button
	 */
	public Button createStartButton(){
	    Button startButton = new Button("START"); //creates new button
	    startButton.setOnAction(new StartButtonHandler());
	    startButton.setMinHeight(50);
	    startButton.setMinWidth(50);
	    startButton.setFont(startButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 15.0));
	    startButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
	    startButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));
	    return startButton;
	}
	
	/**
	 * Class StartButtonHandler deals with the action that occurs when the start button is clicked
	 * Implements EventHandler
	 */
	public class StartButtonHandler implements EventHandler<ActionEvent>{
		
		/**
	     * Overrides the handle method in EventHandler
	     * Deals with what occurs during a button click
	     * @param e represents the ActionEvent that occurs
	     */ 
		@Override
		public void handle(ActionEvent e) {
			openGame();
		}
	}
	
	/**
	 * Opens new window that contains the game Choose Life.
	 */
	public static void openGame() {
		
		Stage primaryStage = new Stage();
		
		//create and display button grid
		createButtonGrid(buttonGrid);
		gameWindow.setBottom(buttonGrid);
		gameWindow.setAlignment(buttonGrid, Pos.CENTER);
		
		//create and display left side of game display
		GridPane leftPane = new GridPane();
		Button leftButton = createLeftButton();
		HBox leftTextBox = new HBox();
		Label leftGameText = new Label("This is where option 1\n will be displayed.\n\n\n\n\n");
		leftTextBox.getChildren().addAll(leftGameText);
		leftPane.add(leftTextBox, 0, 0);
		leftPane.add(leftButton, 0, 1);
		gameWindow.setLeft(leftPane);
		gameWindow.setAlignment(leftPane, Pos.CENTER);
		
		//create and display right side of game display
		GridPane rightPane = new GridPane();
		Button rightButton = createRightButton();
		HBox rightTextBox = new HBox();
		Label rightGameText = new Label("This is where option 2\n will be displayed.\n\n\n\n\n");
		rightTextBox.getChildren().addAll(rightGameText);
		rightPane.add(rightTextBox, 0, 0);
		rightPane.add(rightButton, 0, 1);
		gameWindow.setRight(rightPane);
		gameWindow.setAlignment(rightPane, Pos.CENTER);
		
		//create and display progress bar
		ProgressBar pb = new ProgressBar();
		gameWindow.setTop(pb);
		gameWindow.setAlignment(pb, Pos.CENTER);
		
		//create and display middle of game display
		HBox centerTextBox = new HBox();
		Label centerGameText = new Label("This is where \nthe question will be asked.\n\n\n\n\n");
		centerTextBox.getChildren().addAll(centerGameText);
		centerTextBox.setAlignment(Pos.CENTER);
		gameWindow.setCenter(centerTextBox);
		
		//finalize in-game window
		Scene scene = new Scene(gameWindow);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("CHOOSE LIFE");
		primaryStage.setMinHeight(400);
		primaryStage.setMinWidth(500);
	}
	
	/**
	 * Creates the button grid for in-game window
	 * @param buttonGrid represents the button grid to be created
	 */
	public static void createButtonGrid(GridPane buttonGrid) {
		Button rewindButton = createRewindBonusButton();
		Button exitButton = createExitButton();
		buttonGrid.add(rewindButton,0,0);
		buttonGrid.add(exitButton, 1, 0);
		buttonGrid.setAlignment(Pos.CENTER);
	}
	
	/**
	 * Creates an exit button
	 * @return returns the exit button
	 */
	public static Button createExitButton(){
	    Button startButton = new Button("EXIT"); //creates new button
	    startButton.setOnAction(new ExitButtonHandler());
	    startButton.setMinHeight(50);
	    startButton.setMinWidth(50);
	    startButton.setFont(startButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 15.0));
	    startButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
	    startButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));
	    return startButton;
	}
	
	/**
	 * Creates the rewind bonus button
	 * @return returns the rewind bonus button
	 */
	public static Button createRewindBonusButton(){
	    Button startButton = new Button("REWIND BONUS"); //creates new button
	    startButton.setOnAction(new ExitButtonHandler()); //will be different handler in game
	    startButton.setMinHeight(50);
	    startButton.setMinWidth(50);
	    startButton.setFont(startButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 15.0));
	    startButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
	    startButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));
	    return startButton;
	}
	
	/**
	 * Creates the Option 1 button
	 * @return returns the Option 1 button
	 */
	public static Button createLeftButton(){
	    Button startButton = new Button("OPTION 1"); //creates new button
	    startButton.setOnAction(new ExitButtonHandler()); //will be different handler in game
	    startButton.setMinHeight(50);
	    startButton.setMinWidth(50);
	    startButton.setFont(startButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 15.0));
	    startButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
	    startButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));
	    return startButton;
	}
	
	/**
	 * Creates the Option 2 button
	 * @return returns the Option 2 button
	 */
	public static Button createRightButton(){
	    Button startButton = new Button("OPTION 2"); //creates new button
	    startButton.setOnAction(new ExitButtonHandler()); //will be different handler in game
	    startButton.setMinHeight(50);
	    startButton.setMinWidth(50);
	    startButton.setFont(startButton.getFont().font("Arial", FontWeight.EXTRA_BOLD, 15.0));
	    startButton.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(10.0),BorderStroke.MEDIUM)));
	    startButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10.0), new Insets(.1))));
	    return startButton;
	}
	
	/**
	 * Class ExitButtonHandler deals with the action that occurs when the Exit button is clicked
	 * Implements EventHandler
	 */
	public static class ExitButtonHandler implements EventHandler<ActionEvent>{
		
		/**
	     * Overrides the handle method in EventHandler
	     * Deals with what occurs during a button click
	     * @param e represents the ActionEvent that occurs
	     */ 
		@Override
		public void handle(ActionEvent e) {
			Button b = (Button)e.getSource();
			Window stage = b.getScene().getWindow();
			stage.hide();
		}
	}
	
	/**
	 * Launches game
	 * @param args should be empty
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}

