package Screens;

import com.badlogic.gdx.Screen;

import Utils.Assets;

public class LoadingScreen implements Screen{
	
	public LoadingScreen() {
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		Assets.manager_asset.load("images/img_cell.png", com.badlogic.gdx.graphics.Texture.class);
		Assets.manager_asset.load("images/img_unit.png", com.badlogic.gdx.graphics.Texture.class);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		 if (Assets.manager_asset.update()) {
	            ScreenManager.getInstance().setScreen(new BattleScreen());
	            return;
	     }
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
