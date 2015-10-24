package com.base.engine.components;

import com.base.engine.physics.Collider;
import com.base.engine.physics.PhysicsEngine;

public class PhysicsComponent extends GameComponent
{
	private PhysicsEngine engine;
	private Collider collider;
	public boolean density;
	
	
	public PhysicsComponent(Collider c, boolean density)
	{
		collider = c;
		this.density = density;
	}
	
	@Override
	public void update(float delta, PhysicsEngine physicsEngine)
	{
		physicsEngine.handleCollisions(this, density);
		//collider.update(delta, getTransform());
	}
	
	public Collider getCollider()
	{
		return collider;
	}
	
}
