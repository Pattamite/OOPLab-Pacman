package com.oop.pacman.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter{
	private PacmanGame pacmanGame;
	private Texture pacmanImg;
	private World world;
	private WorldRenderer worldRenderer;
	private boolean isPacmanMove;
	
	public GameScreen(PacmanGame pacmanGame){
		this.pacmanGame = pacmanGame;
		pacmanImg = new Texture("pacman.png");
		world = new World(pacmanGame);
		worldRenderer = new WorldRenderer(pacmanGame, world);
	}
	
	@Override
	public void render(float delta){
		update(delta);
		
		worldRenderer.render(delta);
	}
	
	private void update(float delta){
		updatePacmanDirection();
		world.update(delta);
	}
	
	private void updatePacmanDirection(){
		isPacmanMove = false;
		
		if(Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)){
			world.getPacman().setNextDirection (Pacman.DIRECTION_LEFT);
			isPacmanMove = true;
		}
		if(Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)){
			world.getPacman().setNextDirection (Pacman.DIRECTION_RIGHT);
			isPacmanMove = true;
		}
		if(Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP)){
			world.getPacman().setNextDirection (Pacman.DIRECTION_UP);
			isPacmanMove = true;
		}
		if(Gdx.input.isKeyPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.DOWN)){
			world.getPacman().setNextDirection (Pacman.DIRECTION_DOWN);
			isPacmanMove = true;
		}
		if(!isPacmanMove) world.getPacman().setNextDirection (Pacman.DIRECTION_STILL);
	}
}
