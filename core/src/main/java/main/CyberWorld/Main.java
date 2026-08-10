package main.CyberWorld;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Screens.MenuScreen;
import Screens.ScreenManager;


public class Main extends Game {
    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        
        ScreenManager.init_screen(this);
        
        ScreenManager.getInstance().setScreen(new MenuScreen());
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
