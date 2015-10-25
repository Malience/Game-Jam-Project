package com.base.engine.components;

import com.base.engine.physics.Collider;
import com.base.engine.physics.PhysicsEngine;

import game.interfaces.InterfaceTrigger;
import game.mob.Worker;

public class MovementComponent extends GameComponent
{
	Worker w;
	
	public MovementComponent(Worker w)
	{
		this.w = w;
	}
	
	public void update(float delta, PhysicsEngine physicsEngine)
	{
		w.move(delta);
	}
	
}