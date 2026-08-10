package Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class ScreenManager {
	
	private static ScreenManager current_instance;
	private Game game;
	private Screen previous_screen;
	
	public ScreenManager(Game game) {
		this.game = game;
	}
	
	public static void init_screen(Game game) {
		if(current_instance == null) {
			current_instance = new ScreenManager(game);
		}
	}
	
	public static ScreenManager getInstance() {
		return current_instance;
	}
	
	public void setScreen(Screen screen) {
		if(game.getScreen() != null) {
			previous_screen = game.getScreen();
			game.getScreen().dispose();
		}
			game.setScreen(screen);
	}
		
	public void goBack() {
		if(previous_screen != null) {
			game.setScreen(previous_screen);
		}
	}
}
