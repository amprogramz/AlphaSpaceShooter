package com.Alpha.Space.Shooter;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu extends Application 
{
	Stage menu;
	Scene mainMenu, play, settings, hangar;
	final double maxFont = 60.0;
	//method to create main menu layout
	
	public Scene spaceShooter()
	{
		 final int WINDOW_WIDTH = 1000;
		 final int WINDOW_HEIGHT = 800;
		 //String background1 = "sprite/Space-Background-1.jpg";
		 String background2 = "sprite/Gods-and-Idols-2012-04-11-21-40-17-86.jpg";

		 Background background = new Background(background2, 3000, 2400);
		 Ship ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT);
		 EnemyArray enemies = new EnemyArray(6);


		 Score score = new Score(5, ship.getHitPoints());
	
		 //private Score score = new Score(5);
		 MediaPlayer soundTrack = SoundTool.getMediaPlayer("Sounds/Songs/Tentacle Wedding.mp3");
		
		 Group gameGroup = new Group();
	     ObservableList gameList = gameGroup.getChildren();
	     gameList.add(background.getBackground());
	     gameList.addAll(ship.getShip(WINDOW_WIDTH, WINDOW_HEIGHT));
	     gameList.addAll(ship.getAmmo());
	     gameList.addAll(enemies.getEnemies());
	     gameList.addAll(enemies.getAllAmmo());
	     // gameList.addAll()


	     gameList.addAll(score.getScoreLivesOut());




	     Scene scene = new Scene(gameGroup, WINDOW_WIDTH, WINDOW_HEIGHT);
	     Controls controls = new Controls(scene, ship, enemies, score, WINDOW_WIDTH, WINDOW_HEIGHT);

	     soundTrack.play();
	     enemies.animateMovement(WINDOW_WIDTH, WINDOW_HEIGHT, ship, score);

	     background.moveForward();
		 //return play;
		 //return gameGroup;
	     return scene;
	}
	
	public VBox menuLayout()
	{
		VBox layout = new VBox(20);
		//Creating and styling text
		Text titleMain = new Text("ALPHA SPACE SHOOTER");
		titleMain.setFont(new Font(maxFont));
		titleMain.setFill(Color.LIGHTGRAY);
		
		//creating, styling  and setting action for play button
		Button playButton = new Button("PLAY");
		playButton.setOnAction(e -> menu.setScene(spaceShooter()));
		playButton.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");
		
		//creating, styling and setting action for settings button
		Button settingsButton = new Button("SETTINGS");
		settingsButton.setOnAction(e -> menu.setScene(settings));
		settingsButton.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");
		
		//creating, styling and setting action for hangar button
		Button hangarButton = new Button("HANGAR");
		hangarButton.setOnAction(e -> menu.setScene(hangar));
		hangarButton.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");
		
		//creating, styling and setting action for exit button
		Button exit = new Button("EXIT");
		exit.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");
		exit.setOnAction(e -> System.exit(0));
		
		//setting alignment and background color for vbox
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		layout.getChildren().addAll(titleMain, playButton, settingsButton, hangarButton, exit);
		
		return layout;
		
	}
	//method to create settings layout
	public VBox settingsLayout()
	{
		VBox layout = new VBox(20);
		//Creating and styling text
		Text options = new Text("MOUSE OR KEYBOARD");
		options.setFont(new Font(maxFont));
		options.setFill(Color.LIGHTGRAY);
		Button mouse = new Button("MOUSE");
		mouse.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");
		mouse.setOnAction(Controls.setKeyBoard(false));
		Button keyboard = new Button("KEYBOARD");
		keyboard.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");
		keyboard.setOnAction(Controls.setKeyBoard(true));
		Button back = new Button("BACK");
		back.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");
		back.setOnAction(e -> menu.setScene(mainMenu));
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		layout.getChildren().addAll(options, mouse, keyboard,back);
		return layout;
	}
	//method to create hangar layout
	public VBox hangarLayout()
	{
		VBox layout = new VBox(10);
		//creating HBox for ship image
		HBox ships = new HBox(10);
		ships.setAlignment(Pos.CENTER);
		
		//Creating and styling text
		Text select = new Text("SELECT YOUR SHIP");
		select.setFont(new Font(maxFont));
		select.setFill(Color.LIGHTGRAY);
		
		//creates buttons and adds ship image to buttons
		//freight cruizer image is set to all buttons as placeholder
		Button ship1 = new Button("");
		Image ship1Image = new Image(getClass().getResourceAsStream("sprite/Spaceship_tut/Spaceship_tut.png"));
		ship1.setGraphic(new ImageView(ship1Image));
		
		Button ship2 = new Button("");
		Image ship2Image = new Image(getClass().getResourceAsStream("sprite/Spaceship_tut/Spaceship_tut.png"));
		ship2.setGraphic(new ImageView(ship2Image));
		
		Button ship3 = new Button("");
		Image ship3Image = new Image(getClass().getResourceAsStream("sprite/Spaceship_tut/Spaceship_tut.png"));
		ship3.setGraphic(new ImageView(ship3Image));
		
		Button ship4 = new Button("");
		Image ship4Image = new Image(getClass().getResourceAsStream("sprite/Spaceship_tut/Spaceship_tut.png"));
		ship4.setGraphic(new ImageView(ship4Image));
		
		//creating  and styling back button to return to main menu
		Button back = new Button("BACK");
		back.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");
		back.setOnAction(e -> menu.setScene(mainMenu));
		
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		//add ships to hbox
		ships.getChildren().addAll(ship1, ship2, ship3, ship4);
		//add title, hbox and back button to scene
		layout.getChildren().addAll(select, ships ,back);
		return layout;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		menu = primaryStage;
		//play = spaceShooter();
		mainMenu = new Scene(menuLayout(), 1000, 800);
		settings = new Scene(settingsLayout(),1000,800);	
		hangar = new Scene(hangarLayout(),1000,800);
		menu.setScene(mainMenu);
		menu.show();
		
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}

}
