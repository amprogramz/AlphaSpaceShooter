package com.Alpha.Space.Shooter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu extends Application 
{
	Stage menu;
	Scene mainMenu, play, settings, hangar;
	final double maxFont = 60.0;
	//method to create main menu layout
	public VBox menuLayout()
	{
		VBox layout = new VBox(20);
		//Creating and styling text
		Text titleMain = new Text("ALPHA SPACE SHOOTER");
		titleMain.setFont(new Font(maxFont));
		titleMain.setFill(Color.LIGHTGRAY);
		
		//creating, styling  and setting action for play button
		Button playButton = new Button("PLAY");
		playButton.setOnAction(e -> menu.setScene(play));
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
		Button keyboard = new Button("KEYBOARD");
		keyboard.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");
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
