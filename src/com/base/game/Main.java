package com.base.game;

import com.base.engine.core.CoreEngine;

import game.world.MainGame;

public class Main
{
	
	public static void main(String[] args)
	{
		//Testing.testAll();
		
		//CoreEngine engine = new CoreEngine(800, 600, "Test", 60, new TestGame());
		CoreEngine engine = new CoreEngine(MainGame.SCREEN_WIDTH, MainGame.SCREEN_HEIGHT, MainGame.NAME, 60, new MainGame());
//		engine.createWindow("3D Game Engine");
//		engine.start();
	}
}
