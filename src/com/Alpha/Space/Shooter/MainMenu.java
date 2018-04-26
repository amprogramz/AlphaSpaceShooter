package com.Alpha.Space.Shooter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

public class MainMenu extends Application implements EventHandler<KeyEvent> 
{
	private Stage stage;
	private static final Font font = Font.font("", FontWeight.BOLD, 30);
	private static final Font titleFont = Font.font("", FontWeight.BOLD, 60);
	private VBox menuList;
	private int currentItem = 0;
	
	public Scene setting = new Scene(settings());
	
	private ScheduledExecutorService backgroundThread = Executors.newSingleThreadScheduledExecutor();
	//creates method to create Main Menu
	private Parent createMenu()
	{
		Pane menu = new Pane();
		menu.setPrefSize(1000, 800);
		Rectangle background = new Rectangle(1000, 800);
		//creating items for menu list
		MenuItem itemExit = new MenuItem("EXIT");
		MenuItem itemSettings = new MenuItem("SETTINGS");
		MenuItem itemHangar = new MenuItem("SHIP HANGAR");
		//setting actions for menuItems
		itemSettings.setOnActivate(() -> stage.setScene(setting));
		itemHangar.setOnActivate(() -> stage.setScene(hangar()));
		itemExit.setOnActivate(() -> System.exit(0));
		//setting up menuList
		menuList = new VBox(10,
				   new MenuItem("START"),
				   itemSettings,	   
				   itemHangar,
				   itemExit);
		menuList.setAlignment(Pos.TOP_CENTER);
		menuList.setTranslateX(381);
		menuList.setTranslateY(300);
		//setting up main title
		Text title = new Text("ALPHA SPACE SHOOTER");
		title.setTranslateX(150);
		title.setTranslateY(100);
		title.setFill(Color.WHITE);
		title.setFont(titleFont);
		//sets currently selected item to true
		getMenuItem(0).setActive(true);
		
		
		menu.getChildren().addAll(background,menuList,title);
		return menu;
		
	}
	public Parent settings()
	{
		Pane settings = new Pane();
		settings.setPrefSize(1000, 800);
		Rectangle background = new Rectangle(1000, 800);
		//creating menuItems for settings
		MenuItem mouse = new MenuItem("Mouse input");
		MenuItem keyboard = new MenuItem("Keyboard input");
		MenuItem itemExit = new MenuItem("EXIT");
		//settings actions for menu item
		itemExit.setOnActivate(() -> System.exit(0));
		menuList = new VBox(10,
				   mouse,
				   keyboard,
				   itemExit);
		menuList.setAlignment(Pos.TOP_CENTER);
		menuList.setTranslateX(400);
		menuList.setTranslateY(300);
		//creating settings title
		Text title = new Text("SETTINGS");
		title.setTranslateX(400);
		title.setTranslateY(100);
		title.setFill(Color.WHITE);
		title.setFont(titleFont);
		
		getMenuItem(0).setActive(true);
		
		settings.getChildren().addAll(background,menuList,title);
		
		settings.setOnKeyPressed(this);
		return settings;
		//return new Scene(settings);
	}
	public Scene hangar() 
	{
		Pane hangar = new Pane();
		Text title = new Text("SHIP HANGAR");
		hangar.setPrefSize(1000, 800);
		//creating rectangles to showcase ship choices
		Rectangle background = new Rectangle(1000, 800);
		title.setTranslateX(275);
		title.setTranslateY(100);
		title.setFill(Color.WHITE);
		title.setFont(titleFont);
		Rectangle rectangle1 = new Rectangle(150,150);


		rectangle1.setTranslateX(200);
		rectangle1.setTranslateY(200);
		rectangle1.setStroke(Color.WHITE);
		Text ship1 = new Text("ship 1");
		ImageView freightCruizerImage = SpriteTool.getImage("sprite/Spaceship_tut/Spaceship_tut.png",
				rectangle1.getTranslateX(),
				rectangle1.getTranslateY(),
				rectangle1.getWidth(),
				rectangle1.getHeight(),
				true);
		ship1.setTranslateX(200);
		ship1.setTranslateY(300);
		ship1.setFill(Color.WHITE);
		ship1.setFont(font);
		Rectangle rectangle2 = new Rectangle(150,150);
		rectangle2.setTranslateX(400);
		rectangle2.setTranslateY(200);
		rectangle2.setStroke(Color.WHITE);
		Rectangle rectangle3 = new Rectangle(150,150);
		rectangle3.setTranslateX(600);
		rectangle3.setTranslateY(200);
		rectangle3.setStroke(Color.WHITE);
		
		
		
		hangar.getChildren().addAll(background, title, rectangle1, rectangle2, rectangle3, ship1, freightCruizerImage);
		
		
		
		return new Scene(hangar);
	}
	
	//constructor for MenuItem
	private static class MenuItem extends HBox
	{
		private Text text;
		private Runnable script;
		
		public MenuItem(String name)
		{
			super(15);
			setAlignment(Pos.CENTER);
			
			text = new Text(name);
			text.setFont(font);
			
			getChildren().addAll(text);
			setActive(false);
			
			
		}
		//takes current menuItem and highlights it white. If not selected stays grey
		public void setActive(boolean b) 
		{
			// "? :" shorthand for if then statement 
			text.setFill(b ? Color.WHITE : Color.GREY);
		}
		//activates menuItem action
		public void setOnActivate(Runnable r)
		{
			script = r;
		}
		//if menuItem action is not null runs the action
		public void activate()
		{
			if(script != null)
				script.run();
		}
	}
	//gets menuItem index
	private MenuItem getMenuItem(int index)
	{
		return(MenuItem)menuList.getChildren().get(index);
	}
	//event handler for keys
	@Override
	public void handle(KeyEvent event)
	{
		switch(event.getCode())
		{
		case UP:
			if(currentItem > 0)
			{
				getMenuItem(currentItem).setActive(false);
				getMenuItem(--currentItem).setActive(true);
			}
			break;
		case DOWN:
			if(currentItem < menuList.getChildren().size()-1)
			{
				getMenuItem(currentItem).setActive(false);
				getMenuItem(++currentItem).setActive(true);
			}
			break;
		case ENTER:
			getMenuItem(currentItem).activate();
			break;
			
		}
	}
	 
	        	
	      

	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		stage = primaryStage;
		Scene menu = new Scene(createMenu());
		menu.setOnKeyPressed(this);
		
		setting.setOnKeyPressed(this);
		
		primaryStage.setScene(menu);
		primaryStage.setOnCloseRequest(event ->
		{
			backgroundThread.shutdownNow();
		});
		primaryStage.show();
		
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}

}
