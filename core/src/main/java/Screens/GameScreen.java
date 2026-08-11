package Screens;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import Board.Board;
import Board.BoardInput;
import Board.BoardRenderer;
import Turns.TurnsManager;
import Turns.TurnsRenderer;
import Unit.CyberBot;
import Unit.Unit;
import main.CyberWorld.Main;

public class GameScreen implements Screen{
	private SpriteBatch batch;
	private Stage uiStage;
	
	private InputMultiplexer input_multiplexer = new InputMultiplexer();
	
	private Board board;
	private BoardRenderer board_renderer;
	private BoardInput board_input;
	
	private TurnsManager turns_manager;
	private TurnsRenderer turns_renderer;
	private List<Unit> all_units = new ArrayList<>();
	
	public GameScreen() {
		batch = ((Main) Gdx.app.getApplicationListener()).batch;
		uiStage = new Stage(new ScreenViewport());
		
		board = new Board(7, 7, 64, 10, 10);
		board_input = new BoardInput(board);
		CyberBot alpa = new CyberBot.Builder().name("alpa").atack(30).velocity(100).armor(20).build();
		CyberBot beta = new CyberBot.Builder().name("beta").atack(30).velocity(4).armor(20).build();
		CyberBot omega = new CyberBot.Builder().name("omega").atack(30).velocity(30).armor(20).build();
		CyberBot sili = new CyberBot.Builder().name("sili").atack(30).velocity(30).armor(20).build();
		
		input_multiplexer.addProcessor(uiStage);
		input_multiplexer.addProcessor(board_input);
		
		all_units.add(alpa);
		all_units.add(beta);
		all_units.add(omega);
		all_units.add(sili);
		
		board_renderer = new BoardRenderer(board);
		
		board.addUnit(alpa, 6, 6);
		board.addUnit(beta, 2, 4);
		board.addUnit(omega, 0, 0);
		board.addUnit(sili, 2, 1);
		//board.moveUnit(alpa, 3, 3);
		initTurns();
		addTable();
	}
	private void initTurns() {
		  turns_manager = new TurnsManager(all_units);
		  turns_renderer = new TurnsRenderer(turns_manager);
		  turns_renderer.buildTurns();
	}
	private void addTable() {
		Table table = new Table();
		table.setFillParent(true);
		table.setOrigin(0f,0f);
		table.add(turns_renderer).right();
		table.setDebug(true);
		uiStage.addActor(table);
	}
	
	public void draw(SpriteBatch batch,float delta) {
		board_renderer.render(batch, delta);
	}
	
	private void update() {
		
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		Gdx.input.setInputProcessor(input_multiplexer);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0.2f, 0.1f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		update();
		
		batch.begin();
		  draw(batch,delta);
		batch.end();
		
		uiStage.act();
		uiStage.draw();
		if(Gdx.input.isKeyPressed(Input.Keys.C)) {
			if(turns_manager.getTurnQueue().isEmpty()) return;
			turns_manager.getTurn();
			turns_renderer.buildTurns();
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
