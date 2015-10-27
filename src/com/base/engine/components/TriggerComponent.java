package com.base.engine.components;

import com.base.engine.physics.PhysicsEngine;

import game.interfaces.InterfaceTrigger;

public class TriggerComponent extends GameComponent
{
	InterfaceTrigger trigger;
	
	public TriggerComponent(InterfaceTrigger trigger)
	{
		this.trigger = trigger;
	}
	
	public void update(float delta, PhysicsEngine physicsEngine)
	{
		if(physicsEngine.getCollision(trigger.getCollider()).getDoesIntersect())
		{
			trigger.trigger(delta);
		}
		else
		{
			trigger.detrigger();
		}
	}
	
}