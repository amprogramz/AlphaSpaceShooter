package com.Alpha.Space.Shooter;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
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

	final int WINDOW_WIDTH = 1000;
	final int WINDOW_HEIGHT = 800;
	Ship ship;

	public Scene spaceShooter()
	{

		 //String background1 = "sprite/Space-Background-1.jpg";
		 String background2 = "sprite/Gods-and-Idols-2012-04-11-21-40-17-86.jpg";

		 Background background = new Background(background2, 3000, 2400);
		  //ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT);
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



	     gameList.addAll(score.getScoreLivesOut());




	     Scene scene = new Scene(gameGroup, WINDOW_WIDTH, WINDOW_HEIGHT);
	     Controls controls = new Controls(scene, ship, enemies, score, WINDOW_WIDTH, WINDOW_HEIGHT);

	     soundTrack.play();
	     enemies.animateMovement(WINDOW_WIDTH, WINDOW_HEIGHT, ship, score);

	     background.moveForward();

	     return scene;
	}

	
	public Scene menu()
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
		settingsButton.setOnAction(e -> menu.setScene(settings()));
		settingsButton.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");
		
		//creating, styling and setting action for hangar button
		Button hangarButton = new Button("HANGAR");
		hangarButton.setOnAction(e -> menu.setScene(hangar()));
		hangarButton.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");
		
		//creating, styling and setting action for exit button
		Button exit = new Button("EXIT");
		exit.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");
		exit.setOnAction(e -> System.exit(0));
		
		//setting alignment and background color for vbox
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		layout.getChildren().addAll(titleMain, playButton, settingsButton, hangarButton, exit);
		
		return new Scene(layout, 1000, 800);
		
	}
	//method to create settings layout
	public Scene settings()
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
		back.setOnAction(e -> menu.setScene(menu()));
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		layout.getChildren().addAll(options, mouse, keyboard,back);
		return new Scene(layout,1000,800);
	}
	//method to create hangar layout
	public Scene hangar()
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
		ship1.setOnAction(e -> menu.setScene(selectAmmo(1)));
			//ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT));
		ship1.setStyle("-fx-background-color: #000000");

		
		Button ship2 = new Button("");
		Image ship2Image = new Image(getClass().getResourceAsStream("sprite/DurrrSpaceShip.png"));
		ship2.setGraphic(new ImageView(ship2Image));
		ship2.setStyle("-fx-background-color: #000000");
		
		Button ship3 = new Button("");
		Image ship3Image = new Image(getClass().getResourceAsStream("sprite/Spaceship_tut/Spaceship_tut.png"));
		ship3.setGraphic(new ImageView(ship3Image));
		ship3.setStyle("-fx-background-color: #000000");
		
		Button ship4 = new Button("");
		Image ship4Image = new Image(getClass().getResourceAsStream("sprite/Spaceship_tut/Spaceship_tut.png"));
		ship4.setGraphic(new ImageView(ship4Image));
		ship4.setStyle("-fx-background-color: #000000");
		//creating  and styling back button to return to main menu
		Button back = new Button("BACK");
		back.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");
		back.setOnAction(e -> menu.setScene(menu() ));
		
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		//add ships to hbox
		ships.getChildren().addAll(ship1, ship2, ship3, ship4);
		//add title, hbox and back button to scene
		layout.getChildren().addAll(select, ships ,back);
		return new Scene(layout,1000,800);
	}

	public Scene selectAmmo(int shipChoice)
	{
		int ammoSelection1 = 0;
		int ammoSelection2 = 0;
		VBox layout = new VBox(10);

//		HBox ships = new HBox(10);
//		ships.setAlignment(Pos.CENTER);

		Text selectAmmo = new Text("SELECT AMMO");
		selectAmmo.setFont(new Font(maxFont));
		selectAmmo.setFill(Color.LIGHTGRAY);

		ComboBox<String> ammoChoices = new ComboBox<>();
		ObservableList<String> choices = FXCollections.observableArrayList("Fifty Caliber", "Phaser", "Missile", "Shot Gun");
		ammoChoices.getItems().addAll(choices);
		ammoChoices.setValue("Ammo 1");

		ComboBox<String> ammoChoices2 = new ComboBox<>();
		ammoChoices2.getItems().addAll(choices);
		ammoChoices2.setValue("Ammo 2");



		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");


//		switch (ammoChoices.getValue())
//		{
//			case "Fifty Caliber" :
//				ammoSelection1 = 1;
//				break;
//			case "Phaser":
//				ammoSelection1 = 2;
//				break;
//			case "Missile":
//				ammoSelection1 = 3;
//				break;
//			case "Shot Gun":
//				ammoSelection1 = 4;
//				break;
//		}
//		switch (ammoChoices2.getValue())
//		{
//			case "Fifty Caliber" :
//				ammoSelection2 = 1;
//				break;
//			case "Phaser":
//				ammoSelection2 = 2;
//				break;
//			case "Missile":
//				ammoSelection2 = 3;
//				break;
//			case "Shot Gun":
//				ammoSelection2 = 4;
//				break;
//		}

		Button play = new Button("Ok");
		play.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");
		play.setOnAction(e -> setShipAndAmmo(shipChoice, ammoSelection(ammoChoices.getValue()), ammoSelection(ammoChoices2.getValue())));

		layout.getChildren().addAll(selectAmmo, ammoChoices, ammoChoices2, play);



		return new Scene(layout,1000,800);


	}
	public int ammoSelection(String ammoChoices)
	{

		int ammoSelection = 0;
		switch (ammoChoices)
		{
			case "Fifty Caliber" :
				ammoSelection = 1;
				break;
			case "Phaser":
				ammoSelection = 2;
				break;
			case "Missile":
				ammoSelection = 3;
				break;
			case "Shot Gun":
				ammoSelection = 4;
				break;
		}

		return ammoSelection;
	}

	public void setShipAndAmmo(int shipSelection, int ammoSelection1, int ammoSelection2)
	{


		if(shipSelection == 1)
		{
			if(ammoSelection1 == 1)
			{
				if(ammoSelection2 == 1)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new FiftyCaliber());
				}else if(ammoSelection2 == 2)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new Phaser());
				}else if(ammoSelection2 == 3)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new Missile());
				}else if(ammoSelection2 == 4)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new ShotGun());
				}
			}else if(ammoSelection1 == 2)
			{
				if(ammoSelection2 == 1)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new FiftyCaliber());
				}else if(ammoSelection2 == 2)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new Phaser());
				}else if(ammoSelection2 == 3)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new Missile());
				}else if(ammoSelection2 == 4)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new ShotGun());
				}

			}else if(ammoSelection1 == 3)
			{
				if(ammoSelection2 == 1)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new FiftyCaliber());
				}else if(ammoSelection2 == 2)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new Phaser());
				}else if(ammoSelection2 == 3)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new Missile());
				}else if(ammoSelection2 == 4)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new ShotGun());
				}
			}else if(ammoSelection1 == 4)
			{
				if(ammoSelection2 == 1)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new FiftyCaliber());
				}else if(ammoSelection2 == 2)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new Phaser());
				}else if(ammoSelection2 == 3)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new Missile());
				}else if(ammoSelection2 == 4)
				{
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new ShotGun());
				}
			}
		}


		menu.setScene(spaceShooter());
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		menu = primaryStage;
		menu.setScene(menu());
		menu.show();
		
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}

}
