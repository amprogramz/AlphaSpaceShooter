package com.Alpha.Space.Shooter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
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
	private static final Font FONT = Font.font("", FontWeight.BOLD, 18);
	
	private VBox menuList;
	
	private int currentItem = 0;
	
	private ScheduledExecutorService backgroundThread = Executors.newSingleThreadScheduledExecutor();
	
	private Parent createContent()
	{
		Pane menu = new Pane();
		menu.setPrefSize(1000, 800);
		Rectangle background = new Rectangle(1000, 800);
		
		MenuItem itemExit = new MenuItem("EXIT");
		//MenuItem itemStart = new MenuItem("START");
		
		itemExit.setOnActivate(() -> System.exit(0));
		//itemStart.setOnActivate(() -> SpaceShooter.start());
		menuList = new VBox(10,
				   new MenuItem("START"),
				   new MenuItem("SETTINGS"),
				   new MenuItem("SAVES"),
				   new MenuItem("SELECT LEVEL"),
				   new MenuItem("SHIP HANGAR"),
				   itemExit);
		menuList.setAlignment(Pos.TOP_CENTER);
		menuList.setTranslateX(400);
		menuList.setTranslateY(300);
		
		Text title = new Text("ALPHA SPACE SHOOTER");
		title.setTranslateX(400);
		title.setTranslateY(100);
		title.setFill(Color.WHITE);
		title.setFont(FONT);
		
		getMenuItem(0).setActive(true);
		
		menu.getChildren().addAll(background,menuList,title);
		return menu;
		
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
			text.setFont(FONT);
			
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
	public void start(Stage primaryStage) throws Exception 
	{
		Scene scene = new Scene(createContent());
		scene.setOnKeyPressed(event ->
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
