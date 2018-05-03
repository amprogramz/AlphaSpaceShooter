package com.Alpha.Space.Shooter;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Henry Gray and Alec McDaugale 
 *  Class that creates and launches the main menu and any following scenes
 */

public class MainMenu extends Application 
{
	Stage menu;

	final int WINDOW_WIDTH = 1000;
	final int WINDOW_HEIGHT = 800;

	Ship ship;
	Background background;
	/**
	 * Scene for the game user will play
	 * @return created scene
	 */
	public Scene spaceShooter()
	{

//		 //String background1 = "sprite/Space-Background-1.jpg";
//		 String background2 = "sprite/Gods-and-Idols-2012-04-11-21-40-17-86.jpg";

//		Background background = new Background(background2, 3000, 2400);
		EnemyArray enemies = new EnemyArray(6);
		Score score = new Score(5, ship.getHitPoints(), WINDOW_WIDTH, WINDOW_HEIGHT);
		MediaPlayer soundTrack = SoundTool.getMediaPlayer("Sounds/Songs/Tentacle Wedding.mp3");
		
		Group gameGroup = new Group();
		ObservableList gameList = gameGroup.getChildren();
		gameList.add(background.getBackground());
		gameList.addAll(ship.getShip(WINDOW_WIDTH, WINDOW_HEIGHT));
		gameList.addAll(ship.getAmmo());
		gameList.addAll(enemies.getEnemies());
		gameList.addAll(enemies.getAllAmmo());
		gameList.addAll(score.getScoreLivesOut());
		gameList.addAll((ship.getKeepPlaying(score )));

		Scene scene = new Scene(gameGroup, WINDOW_WIDTH, WINDOW_HEIGHT);
		Controls controls = new Controls(scene, ship, enemies, score, WINDOW_WIDTH, WINDOW_HEIGHT);

		soundTrack.play();
		enemies.animateMovement(WINDOW_WIDTH, WINDOW_HEIGHT, ship, score);

		background.moveForward();

		return scene;
	}

	/**
	 * Scene for the main menu. allows user to switch to other scenes
	 * @return created scene
	 */
	public Scene menu()
	{
		Text titleMain = StylingTool.textCreator("ALPHA SPACE SHOOTER");

		Button playButton = StylingTool.buttonCreator("PLAY");
		playButton.setOnAction(e -> menu.setScene(levelSelect()));

		Button settingsButton = StylingTool.buttonCreator("SETTINGS");
		settingsButton.setOnAction(e -> menu.setScene(settings()));

		Button creditsButton = StylingTool.buttonCreator("CREDITS");
		creditsButton.setOnAction(e -> menu.setScene(credits()));
		
		Button exit = StylingTool.buttonCreator("EXIT");
		exit.setOnAction(e -> System.exit(0));

		VBox layout = new VBox(20);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		layout.getChildren().addAll(titleMain, playButton, settingsButton, creditsButton, exit);
		
		return new Scene(layout, 1000, 800);
		
	}

	
	public Scene settings()
	{
		Text options = StylingTool.textCreator("MOUSE OR KEYBOARD");

		Button mouse = StylingTool.buttonCreator("MOUSE");
		mouse.setOnAction(Controls.setKeyBoard(false));

		Button keyboard = StylingTool.buttonCreator("KEYBOARD");
		keyboard.setOnAction(Controls.setKeyBoard(true));

		Button back = StylingTool.buttonCreator("BACK");
		back.setOnAction(e -> menu.setScene(menu()));

		VBox layout = new VBox(20);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		layout.getChildren().addAll(options, mouse, keyboard,back);

		return new Scene(layout,1000,800);
	}
	/**
	 * Scene that allows user to select level before game play
	 * @return created scene
	 */
	public Scene levelSelect()
	{
		Text select = StylingTool.textCreator("SELECT LEVEL");

		Button ship1 = StylingTool.imageButtonCreator("sprite/Gods-and-Idols-2012-04-11-21-40-17-86.jpg", 150);
		ship1.setOnAction(e -> {
			background = new Background("sprite/Gods-and-Idols-2012-04-11-21-40-17-86.jpg", 3000, 2400);
			menu.setScene(hangar());
		});

		Button ship2 = StylingTool.imageButtonCreator("Sprite/Space-Background-2.jpg", 150);
		ship2.setOnAction(e -> {
			background = new Background("Sprite/Space-Background-2.jpg", 3000, 2400);
			menu.setScene(hangar());
		});

		Button ship3 = StylingTool.imageButtonCreator("Sprite/Space-Background-3.jpg", 150);
		ship3.setOnAction(e -> {
			background = new Background("Sprite/Space-Background-3.jpg", 3000, 2400);
			menu.setScene(hangar());
		});

		Button ship4 = StylingTool.imageButtonCreator("Sprite/Space-Background-4.jpg", 150);
		ship4.setOnAction(e -> {
			background = new Background("Sprite/Space-Background-4.jpg", 3000, 2400);
			menu.setScene(hangar());
		});

		Button back = StylingTool.buttonCreator("BACK");
		back.setOnAction(e -> menu.setScene(menu() ));

		HBox ships = new HBox(10);
		ships.setAlignment(Pos.CENTER);
		ships.getChildren().addAll(ship1, ship2, ship3, ship4);

		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		layout.getChildren().addAll(select, ships ,back);

		return new Scene(layout,1000,800);
	}
	/**
	 * Scene that is displayed when player dies in game and allows the user to return to the menu
	 * @return created scene
	 */
	public Scene playerDeath()
	{
		Text death = StylingTool.textCreator("YOU HAVE DIED");
		death.setFill(Color.RED);
		VBox layout = new VBox(10);
		Button returnMenu = StylingTool.buttonCreator("MAIN MENU");
		returnMenu.setOnAction(e -> menu.setScene(menu()));
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		layout.getChildren().addAll(death, returnMenu);
		return new Scene(layout,1000,800);
	}

	/**
	 * Scene that allows user to select their ship before gameplay
	 * @return created scene
	 */
	public Scene hangar()
	{
		Text select = StylingTool.textCreator("SELECT YOUR SHIP");

		Button ship1 = StylingTool.imageButtonCreator("sprite/Spaceship_tut/Spaceship_tut.png",150);
		ship1.setOnAction(e -> menu.setScene(selectAmmo(1)));

		Button ship2 = StylingTool.imageButtonCreator("sprite/batWingShip/batwingGreen.png", 150);
		ship2.setOnAction(e -> menu.setScene(selectAmmo(2)));

		Button ship3 = StylingTool.imageButtonCreator("sprite/Titan.png", 150);
		ship3.setOnAction(e -> menu.setScene(selectAmmo(3)));

		Button ship4 = StylingTool.imageButtonCreator("sprite/cartoonshipPurple.png", 150);
		ship4.setOnAction(e -> menu.setScene(selectAmmo(4)));

		Button back = StylingTool.buttonCreator("BACK");
		back.setOnAction(e -> menu.setScene(levelSelect() ));

		HBox ships = new HBox(10);
		ships.setAlignment(Pos.CENTER);
		ships.getChildren().addAll(ship1, ship2, ship3, ship4);

		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		layout.getChildren().addAll(select, ships ,back);

		return new Scene(layout,1000,800);
	}
	/**
	 * Scene that displays credits for third party resources in the game
	 * @return created scene
	 */
	public Scene credits()
	{
		VBox layout = new VBox(10);
		Text credits = StylingTool.textCreator("CREDITS");
		Text freightCredits = StylingTool.textCreator("Spaceship-tut_thin.png by Skorpio",20);
		Text titanCredits = StylingTool.textCreator("Titan.png by Skorpio for the kit and Kanadaj for the design",20);
		Text batwingCredits = StylingTool.textCreator("Batwing sprites by Skorpio",20);
		Text starShipCredits = StylingTool.textCreator("StarShip sprites by Skorpio",20);
		Text missleCredits = StylingTool.textCreator("Missile sprites by Kenney Vleugels",20);
		Button returnMenu = StylingTool.buttonCreator("MAIN MENU");
		returnMenu.setOnAction(e -> menu.setScene(menu()));
		
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		layout.getChildren().addAll(credits, freightCredits, titanCredits, batwingCredits, starShipCredits, missleCredits, returnMenu);
		return new Scene(layout,1000,800);
	}

	/**
	 * Scene that allows user to add different ammo to their ship
	 * @param shipChoice selects which ship to add ammo to
	 * @return created scene
	 */
	public Scene selectAmmo(int shipChoice)
	{
		Text selectAmmo = StylingTool.textCreator("SELECT AMMO");

		ComboBox<String> ammoChoices = new ComboBox<>();
		ObservableList<String> choices = FXCollections.observableArrayList("Fifty Caliber", "Phaser", "Missile", "Shot Gun");
		ammoChoices.getItems().addAll(choices);
		ammoChoices.setValue("Ammo 1");

		ComboBox<String> ammoChoices2 = new ComboBox<>();
		ammoChoices2.getItems().addAll(choices);
		ammoChoices2.setValue("Ammo 2");

		Button play = StylingTool.buttonCreator("PLAY");
		play.setOnAction(e -> setShipAndAmmo(shipChoice, ammoSelection(ammoChoices.getValue()), ammoSelection(ammoChoices2.getValue())));

		Button back = StylingTool.buttonCreator("BACK");
		back.setOnAction(e -> menu.setScene(hangar()));
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		layout.getChildren().addAll(selectAmmo, ammoChoices, ammoChoices2, play, back);

		return new Scene(layout,1000,800);

	}
	/**
	 * method to select ammo type
	 * @param ammoChoices index to select different ammo types
	 * @return ammo selected 
	 */
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
	/**
	 * Method that sets player ship and ammo types before game
	 * @param shipSelection index for ship selection
	 * @param ammoSelection1 index for ammo 1 selection
	 * @param ammoSelection2 index for ammo 2 selection
	 */
	//Obnoxious if statement
	public void setShipAndAmmo(int shipSelection, int ammoSelection1, int ammoSelection2) {
		if (shipSelection == 1) {
			if (ammoSelection1 == 1) {
				if (ammoSelection2 == 1) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new ShotGun());
				}
			} else if (ammoSelection1 == 2) {
				if (ammoSelection2 == 1) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new ShotGun());
				}

			} else if (ammoSelection1 == 3) {
				if (ammoSelection2 == 1) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new ShotGun());
				}
			} else if (ammoSelection1 == 4) {
				if (ammoSelection2 == 1) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new ShotGun());
				}
			}

		}else if (shipSelection == 2) {
			if (ammoSelection1 == 1) {
				if (ammoSelection2 == 1) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new FiftyCaliber(), new FiftyCaliber(), new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new FiftyCaliber(), new Phaser(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new FiftyCaliber(), new Missile(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new FiftyCaliber(), new ShotGun(), new ShotGun());
				}
			} else if (ammoSelection1 == 2) {
				if (ammoSelection2 == 1) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new Phaser(), new FiftyCaliber(), new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new Phaser(), new Phaser(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new Phaser(), new Missile(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new Phaser(), new ShotGun(), new ShotGun());
				}

			} else if (ammoSelection1 == 3) {
				if (ammoSelection2 == 1) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new Missile(), new FiftyCaliber(),new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new Missile(), new Phaser(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new Missile(), new Missile(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new Missile(), new ShotGun(), new ShotGun());
				}
			} else if (ammoSelection1 == 4) {
				if (ammoSelection2 == 1) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new ShotGun(), new FiftyCaliber(),new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new ShotGun(), new Phaser(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new ShotGun(), new Missile(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new ShotGun(), new ShotGun(), new ShotGun());
				}
			}

		}else if (shipSelection == 3) {
			if (ammoSelection1 == 1) {
				if (ammoSelection2 == 1) {
					ship = new Dreadnought (WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new ShotGun());
				}
			} else if (ammoSelection1 == 2) {
				if (ammoSelection2 == 1) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new ShotGun());
				}

			} else if (ammoSelection1 == 3) {
				if (ammoSelection2 == 1) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new ShotGun());
				}
			} else if (ammoSelection1 == 4) {
				if (ammoSelection2 == 1) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new ShotGun());
				}
			}
		}else if (shipSelection == 4) 
		{
			if (ammoSelection1 == 1) {
				if (ammoSelection2 == 1) {
					ship = new StarShip (WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new FiftyCaliber(), new ShotGun());
				}
			} else if (ammoSelection1 == 2) {
				if (ammoSelection2 == 1) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new Phaser(), new ShotGun());
				}

			} else if (ammoSelection1 == 3) {
				if (ammoSelection2 == 1) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new ShotGun());
				}
			} else if (ammoSelection1 == 4) {
				if (ammoSelection2 == 1) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new FiftyCaliber());
				} else if (ammoSelection2 == 2) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new Phaser());
				} else if (ammoSelection2 == 3) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new Missile());
				} else if (ammoSelection2 == 4) {
					ship = new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, new ShotGun(), new ShotGun());
				}
			}

		}

		menu.setScene(spaceShooter());
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		menu = primaryStage;
		Image icon = new Image(getClass().getResourceAsStream("Sprite/Squid.png"));
		menu.getIcons().add(icon);
		menu.setScene(menu());
		menu.show();
		
		
		
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}

}
