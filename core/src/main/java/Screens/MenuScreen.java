package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import main.CyberWorld.Main;

public class MenuScreen implements Screen{
	
	private SpriteBatch batch;
	private Stage uiStage;
	
	public MenuScreen() {
		batch = ((Main) Gdx.app.getApplicationListener()).batch;
		
		uiStage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(uiStage);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	 
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
			  goLoadingScreen();
		}
	  
		update();
		batch.begin();
		  draw(batch,delta);
		batch.end();
	
		uiStage.act(delta);
		uiStage.draw();
	}

	private void goLoadingScreen() {
		// TODO Auto-generated method stub
		ScreenManager.getInstance().setScreen(new LoadingScreen());
	}

	private void draw(SpriteBatch batch2, float delta) {
	
	}

	private void update() {

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
