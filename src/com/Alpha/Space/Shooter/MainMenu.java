package com.Alpha.Space.Shooter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
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
	
	private ScheduledExecutorService backgroundThread = Executors.newSingleThreadScheduledExecutor();
	
	private Parent createContent()
	{
		Pane menu = new Pane();
		menu.setPrefSize(1000, 800);
		Rectangle background = new Rectangle(1000, 800);
		MenuItem itemExit = new MenuItem("EXIT");
		MenuItem itemSettings = new MenuItem("SETTINGS");
		MenuItem itemHangar = new MenuItem("SHIP HANGAR");
		
		itemExit.setOnActivate(() -> System.exit(0));
		//itemStart.setOnActivate(() -> 
		itemSettings.setOnActivate(() -> stage.setScene(settings()));
		itemHangar.setOnActivate(() -> stage.setScene(hangar()));
		menuList = new VBox(10,
				   new MenuItem("START"),
				   itemSettings,	   
				   itemHangar,
				   itemExit);
		menuList.setAlignment(Pos.TOP_CENTER);
		menuList.setTranslateX(381);
		
		menuList.setTranslateY(300);
		
		Text title = new Text("ALPHA SPACE SHOOTER");
		title.setTranslateX(150);
		title.setTranslateY(100);
		title.setFill(Color.WHITE);
		title.setFont(titleFont);
		
		getMenuItem(0).setActive(true);
		
		
		menu.getChildren().addAll(background,menuList,title);
		return menu;
		
	}
	public Scene settings()
	{
		Pane settings = new Pane();
		settings.setPrefSize(1000, 800);
		Rectangle background = new Rectangle(1000, 800);
		MenuItem mouse = new MenuItem("Mouse input");
		MenuItem keyboard = new MenuItem("Keyboard input");
		MenuItem itemExit = new MenuItem("EXIT");
		
		itemExit.setOnActivate(() -> System.exit(0));
		menuList = new VBox(10,
				   mouse,
				   keyboard,
				   itemExit);
		menuList.setAlignment(Pos.TOP_CENTER);
		menuList.setTranslateX(400);
		menuList.setTranslateY(300);
		
		Text title = new Text("SETTINGS");
		title.setTranslateX(400);
		title.setTranslateY(100);
		title.setFill(Color.WHITE);
		title.setFont(titleFont);
		
		getMenuItem(0).setActive(true);
		
		settings.getChildren().addAll(background,menuList,title);
		
		settings.setOnKeyPressed(this);
		
		return new Scene(settings);
	}
	public Scene hangar() 
	{
		Pane hangar = new Pane();
		Text title = new Text("SHIP HANGAR");
		hangar.setPrefSize(1000, 800);
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
		
		
		
		hangar.getChildren().addAll(background, title, rectangle1, rectangle2, rectangle3, ship1);
		
		
		
		return new Scene(hangar);
	}
	
	
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
			setOnActivate(() -> System.out.println(name + "activated"));
			
		}

		public void setActive(boolean b) 
		{
			// "? :" shorthand for if then statement 
			text.setFill(b ? Color.WHITE : Color.GREY);
		}
		public void setOnActivate(Runnable r)
		{
			script = r;
		}
		public void activate()
		{
			if(script != null)
				script.run();
		}
	}

	private MenuItem getMenuItem(int index)
	{
		return(MenuItem)menuList.getChildren().get(index);
	}
	
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
		Scene scene = new Scene(createContent());
		scene.setOnKeyPressed(this);
		
		
		/*stage.getScene().setOnKeyPressed(event ->
		{
			if(event.getCode() == KeyCode.UP)
			{
				if(currentItem > 0)
				{
					getMenuItem(currentItem).setActive(false);
					getMenuItem(--currentItem).setActive(true);
				}
			}
			if(event.getCode() == KeyCode.DOWN)
			{
				if(currentItem < menuList.getChildren().size()-1)
				{
					getMenuItem(currentItem).setActive(false);
					getMenuItem(++currentItem).setActive(true);
				}
			}
			if(event.getCode() == KeyCode.ENTER)
			{
				getMenuItem(currentItem).activate();
			}	
		});
		
		
		*/
		primaryStage.setScene(scene);
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
