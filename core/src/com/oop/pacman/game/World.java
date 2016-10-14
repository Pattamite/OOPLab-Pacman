package com.oop.pacman.game;

public class World {
	private Pacman pacman;
	private PacmanGame pacmanGame;
	private Maze maze;
	
	public World(PacmanGame pacmanGame){
		this.pacmanGame = pacmanGame;
		pacman = new Pacman(100, 100);
		maze = new Maze();
	}
	
	Pacman getPacman(){
		return pacman;
	}
	
	Maze getMaze(){
		return maze;
	}
}
