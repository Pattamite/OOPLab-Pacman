package com.oop.pacman.game;

import com.badlogic.gdx.math.Vector2;

public class Pacman {
	private Vector2 position;
	
	public static final int DIRECTION_UP = 1;
	public static final int DIRECTION_DOWN = 2;
	public static final int DIRECTION_LEFT = 3;
	public static final int DIRECTION_RIGHT = 4;
	public static final int DIRECTION_STILL = 0;
	
	private int speed = 10;
	
	public Pacman(int x, int y)
	{
		position = new Vector2(x, y);
	}
	
	public Vector2 getPosition()
	{
		return position;
	}
	
	public void move(int dir)
	{
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
}
