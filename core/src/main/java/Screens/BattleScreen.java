package Screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import Abilitys.Ability;
import Abilitys.AbilityManager;
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
	
	private BattleController batlle_controller;
	//----------------------------------
	private List<Unit> all_units = new ArrayList<>();//viene de otra screen
	private CyberBot alpa = new CyberBot.Builder().name("alpa").atack(30).velocity(100).armor(20).build();//de otra
	private CyberBot beta = new CyberBot.Builder().name("beta").atack(30).velocity(4).armor(20).build();//de otra
	private CyberBot omega = new CyberBot.Builder().name("omega").atack(30).velocity(30).armor(20).build();//de otra
	private CyberBot sili = new CyberBot.Builder().name("sili").atack(30).velocity(20).armor(20).build();//de otra
	//---------------------------------
	private Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
	private TextButton button_confirm = new TextButton("Next Turn",skin);
	private TextButton button_execute_ability = new TextButton("Execute",skin);
	
	private AbilityUI ability_ui = new AbilityUI();//esto inicializa con la habilidades del primero del turn manager
	
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
	//	alpa.addAbility(new DamageLine());
		
		initTurns();
		initButtonConfirm();
		initButtonExecute();
		
		
		batlle_controller = new BattleController(board,turns_manager);
		
		board_input = new BoardInput(board,batlle_controller);
		board_renderer = new BoardRenderer(board);
		
		input_multiplexer.addProcessor(uiStage);
		input_multiplexer.addProcessor(board_input);
		
		batlle_controller.initNextTurn();
		turns_ui.rendererTurns();
		ability_ui.buildAbilityUI(turns_manager.getUnitTurn().getList_ability());
		addTable();
	}
	
	private void initButtonConfirm() {
		button_confirm.addListener(new ClickListener() {
			public void clicked(InputEvent e,float x,float y) {
				//if(turns_manager.getTurnQueue().isEmpty()) return;
				//turns_manager.getTurn();
				//turns_renderer.buildTurns();
				
				batlle_controller.initNextTurn();
				//batlle_controller.ejectuarHabilidad();//mas adelante
				turns_ui.updateTurnsLabel();
				ability_ui.buildAbilityUI(turns_manager.getUnitTurn().getList_ability());
			}
		} );
		
	}
	private void initButtonExecute() {
		//button_execute_ability.setDisabled(true);
		button_execute_ability.addListener(new ClickListener() {
			public void clicked(InputEvent e,float x,float y) {
				//if(turns_manager.getTurnQueue().isEmpty()) return;
				//turns_manager.getTurn();
				//turns_renderer.buildTurns();
				
				//batlle_controller.initNextTurn();
				//batlle_controller.ejectuarHabilidad();//mas adelante
				//turns_ui.updateTurnsLabel();
				//ability_ui.buildAbilityUI(turns_manager.getUnitTurn().getList_ability());
				AbilityManager.getAbilityInstance().getAbility_selected().execute(board, turns_manager.getUnitTurn());
				//System.out.println("execute");
			}
		} );
		
	}
	
	private void initTurns() {
		  turns_manager = new TurnsManager(all_units);
		  turns_ui = new TurnsUI(turns_manager);
		  turns_ui.rendererTurns();
	}
	
	private void addTable() {
		Table table = new Table();
		table.setFillParent(true);
		table.right().top();
		//table.setOrigin(0f,0f);
		table.add(turns_ui).right();
		table.row();
		table.add(ability_ui).right();
		table.row();
		table.add(button_confirm).width(120).height(40).padLeft(20).row();
		table.add(button_execute_ability).width(120).height(40).padLeft(20);
		table.setDebug(true);
		uiStage.addActor(table);
	}
	
	public void draw(SpriteBatch batch,float delta) {
		board_renderer.render(batch, delta);
	}
	
	private void update() {
		batlle_controller.update();
		if(batlle_controller.getBattle_state() == BattleState.HABILITY_SELECTED) {
			button_execute_ability.setDisabled(false);
		}else {
			button_execute_ability.setDisabled(true);
		}
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
