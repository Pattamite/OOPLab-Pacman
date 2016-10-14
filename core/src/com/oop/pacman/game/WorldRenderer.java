package com.oop.pacman.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
	public static final int BLOCK_SIZE = 40;
	
	private PacmanGame pacmanGame;
	private World world;
	private Texture pacmanImg;
	private SpriteBatch batch;
	private MazeRenderer mazeRenderer;
	
	public WorldRenderer(PacmanGame pacmanGame, World world){
		this.pacmanGame = pacmanGame;
		batch = pacmanGame.batch;
		this.world = world;
		this.mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
		pacmanImg = new Texture("pacman.png");
	}
	
	public void render(float delta){
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		mazeRenderer.render();
		batch.begin();
		Vector2 pos = world.getPacman().getPosition();
		batch.draw(pacmanImg, pos.x - (BLOCK_SIZE / 2) ,pos.y - (BLOCK_SIZE / 2));
		batch.end();
	}
}
