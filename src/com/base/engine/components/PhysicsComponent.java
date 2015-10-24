package com.base.engine.components;

import com.base.engine.physics.Collider;
import com.base.engine.physics.PhysicsEngine;

public class PhysicsComponent extends GameComponent
{
	public Collider collider;
	public boolean density;
	
	public PhysicsComponent(Collider c, boolean d)
	{
		collider = c;
		density = d;
	}
	
	@Override
	public void update(float delta, PhysicsEngine physicsEngine)
	{
		//physicsEngine.simulate(delta);
		physicsEngine.handleCollisions(this);
	}
	
	public Collider getCollider()
	{
		return collider;
	}
	
	public boolean getDensity()
	{
		return density;
	}
	
}