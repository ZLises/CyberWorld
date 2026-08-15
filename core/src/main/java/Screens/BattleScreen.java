package Screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import Abilitys.AbilityUI;
import Abilitys.SetAbilitys.DamageLine;
import Abilitys.SetAbilitys.HealthHeart;
import Board.Board;
import Board.BoardInput;
import Board.BoardRenderer;
import Controllers.BattleController;
import Controllers.BattleState;
import Turns.TurnsManager;
import Turns.TurnsUI;
import Unit.CyberBot;
import Unit.Unit;
import main.CyberWorld.Main;

public class BattleScreen implements Screen{
	private SpriteBatch batch;
	private Stage uiStage;
	
	private InputMultiplexer input_multiplexer = new InputMultiplexer();
	
	private Board board = new Board(7, 7, 64, 10, 10);;
	private BoardRenderer board_renderer;
	private BoardInput board_input;
	
	private TurnsManager turns_manager;
	private TurnsUI turns_ui;
	
	private BattleController battle_controller;
	//----------------------------------
	private List<Unit> all_units = new ArrayList<>();//viene de otra screen
	private CyberBot alpa = new CyberBot.Builder().name("alpa").atack(30).velocity(100).armor(20).build();//de otra
	private CyberBot beta = new CyberBot.Builder().name("beta").atack(30).velocity(4).armor(20).build();//de otra
	private CyberBot omega = new CyberBot.Builder().name("omega").atack(30).velocity(30).armor(20).build();//de otra
	private CyberBot sili = new CyberBot.Builder().name("sili").atack(30).velocity(20).armor(20).build();//de otra
	//---------------------------------
	//private Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
	
	
	private AbilityUI ability_ui;//esto inicializa con la habilidades del primero del turn manager
	
	public BattleScreen() {
		
		batch = ((Main) Gdx.app.getApplicationListener()).batch;
		uiStage = new Stage(new ScreenViewport());
		
		board.addUnit(alpa, 6, 6);
		board.addUnit(beta, 2, 4);
		board.addUnit(omega, 0, 0);
		board.addUnit(sili, 2, 1);
		board.moveUnit(alpa, 3, 3);
		
		all_units.add(alpa);
		all_units.add(beta);
		all_units.add(omega);
		all_units.add(sili);
		
		//aniadirAbilitys();
		alpa.addAbility(new DamageLine());
		alpa.addAbility(new DamageLine());
		alpa.addAbility(new DamageLine());
		alpa.addAbility(new HealthHeart());
		beta.addAbility(new DamageLine());
		omega.addAbility(new DamageLine());
		sili.addAbility(new DamageLine());
		
		turns_manager = new TurnsManager(all_units);
		
		battle_controller = new BattleController(board,turns_manager);
		
		turns_ui = new TurnsUI(turns_manager,battle_controller);
		turns_ui.rendererTurns();
		
		board_input = new BoardInput(board,battle_controller);
		board_renderer = new BoardRenderer(board,battle_controller);
		ability_ui = new AbilityUI(battle_controller);
		
		input_multiplexer.addProcessor(uiStage);
		input_multiplexer.addProcessor(board_input);
		
		battle_controller.initNextTurn();
		turns_ui.rendererTurns();
		
		
		addTable();
	}
	
	private void addTable() {
		Table table = new Table();
		table.setFillParent(true);
		table.right().top();
		table.add(turns_ui).right();
		table.row();
		table.add(ability_ui).right();
		table.row();
		table.setDebug(true);
		uiStage.addActor(table);
	}
	
	public void draw(SpriteBatch batch,float delta) {
		board_renderer.render(batch, delta);

		if(battle_controller.getBattle_state() == BattleState.ANIMATING_ABILITY) {
			battle_controller.getAbility_selected().render(batch,battle_controller.getUnit_turn(),board);
		}
	}
	
	private void update(float delta) {
		battle_controller.update(delta);
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
		
		
		update(delta);
		
		batch.begin();
		  draw(batch,delta);
		batch.end();
		
		uiStage.act();
		uiStage.draw();
		/*
		if(Gdx.input.isKeyPressed(Input.Keys.C)) {
			if(turns_manager.getTurnQueue().isEmpty()) return;
			turns_manager.getTurn();
			turns_renderer.buildTurns();
		}
		*/
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
