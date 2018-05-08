package com.Alpha.Space.Shooter;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

/**
 * @author Henry Gray and Alec McDaugale 
 *  Class that creates and launches the main menu and any following scenes
 */

public class MainMenu extends Application 
{
	Stage menu;

    final int WINDOW_WIDTH = 1000;
    final int WINDOW_HEIGHT = 800;


    MediaPlayer soundTrack;
    String soundTrackFileArray[] = {
            "Sounds/Songs/Tentacle Wedding.mp3",
            "Sounds/Songs/424976__erokia__tilted-synth-1-140bpm.wav",
            "Sounds/Songs/Upbeat Melody.mp3"
    };

    int dificulty;
    int backgroundSelection;
    int shipSelection;
    int ammoSelection1;
    int ammoSelection2;


    /**
     * Scene for the game user will play
     * @return created scene
     */
    public Scene spaceShooter()
    {
        GameObject gameObject = new GameObject(dificulty, backgroundSelection, shipSelection, ammoSelection1, ammoSelection2);
        Button keepPlaying;
        Button returnToMain;
        keepPlaying = getKeepPlaying(gameObject.getScore(), gameObject.getShip());
        returnToMain = getReturnToMain();
        gameObject.spaceShooter(keepPlaying, returnToMain);


        soundTrack = SoundTool.getMediaPlayer(soundTrackFileArray[(int)(Math.random()* 3)]);



        soundTrack.play();
        runGameManager(gameObject.getScore(), keepPlaying, returnToMain);


        return gameObject.spaceShooter(keepPlaying, returnToMain);
    }

    /**
     * The manager is a timeline which calls the method manage.
     * @param score the score object.
     * @param keepPlaying button keep playing.
     * @param returnToMain button return to main.
     */
    public void runGameManager(Score score, Button keepPlaying, Button returnToMain)
    {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(20),
                ae ->  {
                    manage(score, keepPlaying, returnToMain);
                } ));


        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * Manages when the buttons keep playing and return to main appear.
     * @param score score object.
     * @param keepPlaying keep playing button.
     * @param returnToMain return to main button.
     */
    public void manage(Score score, Button keepPlaying, Button returnToMain)
    {
        if (score.getHitPoints() <= 0 && score.getLives() >= 1) {

            keepPlaying.setVisible(true);
        }else if(score.getLives() == 0){
            returnToMain.setVisible(true);
        }
    }

    /**
     * returns a button and actions to define the keep playing button.
     * @param score the score object.
     * @param ship the ship object.
     * @return returns a button.
     */
    public Button getKeepPlaying(Score score, UserShip ship)
    {
        Button keepPlaying = StylingTool.buttonCreator("CONTINUE");
        keepPlaying.setLayoutY(( WINDOW_HEIGHT/ 2) + 100);
        keepPlaying.setLayoutX( WINDOW_WIDTH/ 2 - 100);
        keepPlaying.setOnMouseClicked(e -> {
            score.setHitPoints(ship.getHitPoints());
            score.setYouDiedVisible(false);
            keepPlaying.setVisible(false);
            ship.setDefault();

        });

        keepPlaying.setVisible(false);
        return keepPlaying;
    }

    /**
     * Method to get the return to main menue button with action.
     * @return returnToMain button.
     */
    public Button getReturnToMain()
    {
        Button returnToMain = StylingTool.buttonCreator("RETURN TO MENUE");
        returnToMain.setLayoutY(( WINDOW_HEIGHT/ 2) + 100);
        returnToMain.setLayoutX( WINDOW_WIDTH/ 2 - 100);
        returnToMain.setOnMouseClicked(e -> {
            menu.setScene(menu());
        });

        returnToMain.setVisible(false);
        return returnToMain;
    }


    /**
	 * The main menu. Allows user to switch to other scenes
	 * @return created scene
	 */
	public Scene menu()
	{
		Text titleMain = StylingTool.textCreator("ALPHA SPACE SHOOTER");

		Button playButton = StylingTool.buttonCreator("PLAY");
		playButton.setOnAction(e -> menu.setScene(levelSelect()));

		//Button settingsButton = StylingTool.buttonCreator("SETTINGS");
		//settingsButton.setOnAction(e -> menu.setScene(settings()));

		Button creditsButton = StylingTool.buttonCreator("CREDITS");
		creditsButton.setOnAction(e -> menu.setScene(credits()));
		
		Button exit = StylingTool.buttonCreator("EXIT");
		exit.setOnAction(e -> System.exit(0));

		VBox layout = new VBox(20);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		layout.getChildren().addAll(titleMain, playButton, creditsButton, exit);
		
		return new Scene(layout, 1000, 800);
		
	}

    /**
     * A scene that allows you to adjust the settings.
     * @return returns the settings Scene.
     */
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

		Button ship1 = StylingTool.imageButtonCreator("EASY", "Sprite/Gods-and-Idols-2012-04-11-21-40-17-86.jpg", 150);
		ship1.setOnAction(e -> {
			backgroundSelection = 0;
			dificulty = 4;
			menu.setScene(hangar());
		});

		Button ship2 = StylingTool.imageButtonCreator("MEDIUM", "Sprite/Space-Background-2.jpg", 150);
		ship2.setOnAction(e -> {
			backgroundSelection = 1;
			dificulty = 5;
            menu.setScene(hangar());
		});

		Button ship3 = StylingTool.imageButtonCreator("HARD", "Sprite/Space-Background-3.jpg", 150);
		ship3.setOnAction(e -> {
			backgroundSelection = 2;
			dificulty = 7;
            menu.setScene(hangar());
		});

		Button ship4 = StylingTool.imageButtonCreator("BEZERK", "Sprite/Space-Background-4.jpg", 150);
		ship4.setOnAction(e -> {
			backgroundSelection = 3;
            dificulty = 16;
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
	 * Scene that allows user to select their ship before game play. sets the shipSelection int to pass to the game
     * object.
	 * @return created scene
	 */
	public Scene hangar()
	{
		Text select = StylingTool.textCreator("SELECT YOUR SHIP");

		Button ship1 = StylingTool.imageButtonCreator("Sprite/Spaceship_tut/Spaceship_tut.png",150);
		ship1.setOnAction(e -> {
		    shipSelection = 0;
		    menu.setScene(selectAmmo());
        });

		Button ship2 = StylingTool.imageButtonCreator("Sprite/batWingShip/batwingGreen.png", 150);
		ship2.setOnAction(e -> {
		    shipSelection = 1;
		    menu.setScene(selectAmmo());
        });

		Button ship3 = StylingTool.imageButtonCreator("Sprite/Titan.png", 150);
		ship3.setOnAction(e -> {
		    shipSelection = 2;
		    menu.setScene(selectAmmo());
        });

		Button ship4 = StylingTool.imageButtonCreator("Sprite/cartoonshipPurple.png", 150);
		ship4.setOnAction(e -> {
		    shipSelection = 3;
		    menu.setScene(selectAmmo());
        });

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
     * Allows the user to select the ammo for their ship. This method sets the value to the int ammoSelection1 and
     * ammoSelection2 to pass to the game object.
     * @return The selectAmmo scene.
     */
	public Scene selectAmmo()
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
		play.setOnAction(e -> {
		        ammoSelection1 = ammoSelection(ammoChoices.getValue());
		        ammoSelection2 = ammoSelection(ammoChoices2.getValue());
		        menu.setScene(spaceShooter());
		    });

		Button back = StylingTool.buttonCreator("BACK");
		back.setOnAction(e -> menu.setScene(hangar()));
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #000000");
		layout.getChildren().addAll(selectAmmo, ammoChoices, ammoChoices2, play, back);

		return new Scene(layout,1000,800);

	}
	/**
	 * Method to select ammo type. Converts a string to an int value which gets passed to the gameObject.
	 * @param ammoChoices index to select different ammo types
	 * @return An int value which represents the ammo selected
	 */
	public int ammoSelection(String ammoChoices)
	{

		int ammoSelection = 0;
		switch (ammoChoices)
		{
			case "Fifty Caliber" :
				ammoSelection = 0;
				break;
			case "Phaser":
				ammoSelection = 1;
				break;
			case "Missile":
				ammoSelection = 2;
				break;
			case "Shot Gun":
				ammoSelection = 3;
				break;
		}

		return ammoSelection;
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
