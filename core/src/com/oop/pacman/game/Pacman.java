package com.oop.pacman.game;

import com.badlogic.gdx.math.Vector2;

public class Pacman {
	private Vector2 position;
	
	public static final int DIRECTION_UP = 1;
	public static final int DIRECTION_DOWN = 2;
	public static final int DIRECTION_LEFT = 3;
	public static final int DIRECTION_RIGHT = 4;
	public static final int DIRECTION_STILL = 0;
	
	private int speed = 5;
	private int currentDirection;
	private int nextDirection;
	private Maze maze;
	
	public Pacman(int x, int y, Maze maze){
		position = new Vector2(x, y);
		currentDirection = DIRECTION_STILL;
		nextDirection = DIRECTION_STILL;
		
		this.maze = maze;
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public void move(int dir){
		switch(dir)
		{
		case DIRECTION_UP:
			position.y += speed;
			break;
		case DIRECTION_DOWN:
			position.y -= speed;
			break;
		case DIRECTION_LEFT:
			position.x -= speed;
			break;
		case DIRECTION_RIGHT:
			position.x += speed;
			break;
		}
	}
	
	public void setNextDirection(int dir){
		nextDirection = dir;
	}
	
	public void update(){
		if(isAtCenter()){
			if(canMoveInDirection(nextDirection)){
				currentDirection = nextDirection;
			}
			else{
				currentDirection = DIRECTION_STILL;
			}
		}
		move(currentDirection);
	}
	
	public boolean isAtCenter(){
		int blockSize = WorldRenderer.BLOCK_SIZE;
		
		return ((((int)position.x - blockSize/2)% blockSize) == 0) && ((((int)position.y - blockSize/2)% blockSize) == 0);
	}
	
	private boolean canMoveInDirection(int dir){
		int newRow = getRow();
		int newCol = getCol();
		int deltaRow = 0;
		int deltaCol = 0;
		
		
		return true;
	}
	
	private int getRow(){
		return  ((PacmanGame.HEIGHT / WorldRenderer.BLOCK_SIZE)) - (((int)position.y) / WorldRenderer.BLOCK_SIZE) - 1; 
	}
	
	private int getCol(){
		return ((int)position.x) / WorldRenderer.BLOCK_SIZE; 
	}
	
}
