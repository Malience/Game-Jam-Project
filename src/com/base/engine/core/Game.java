package com.base.engine.core;

import java.util.ArrayList;

import com.base.engine.physics.PhysicsEngine;
import com.base.engine.rendering.RenderingEngine;

public abstract class Game
{
	//private GameObject root;
	private Octree tree;

	public void init() {}

	public void input(float delta)
	{
		input(delta, new Vector3f(-1000000000,-1000000000,-1000000000), new Vector3f(1000000000,1000000000,1000000000));
	}
	
	public void input(float delta, Vector3f bmin, Vector3f bmax)
	{
		//getRootObject().inputAll(delta);
		ArrayList<GameObject> results = new ArrayList<GameObject>();
		getTree().getPointsInsideBox(bmin, bmax, results);
		for(GameObject object : results)
			object.inputAll(delta);
	}

	public void update(float delta, PhysicsEngine physicsEngine)
	{
		update(delta, physicsEngine, new Vector3f(-1000000000,-1000000000,-1000000000), new Vector3f(1000000000,1000000000,1000000000));
	}
	
	public void update(float delta, PhysicsEngine physicsEngine, Vector3f bmin, Vector3f bmax)
	{
		//getRootObject().updateAll(delta, physicsEngine);
		ArrayList<GameObject> results = new ArrayList<GameObject>();
		getTree().getPointsInsideBox(bmin, bmax, results);
		for(GameObject object : results)
			object.updateAll(delta, physicsEngine);
	}

	public void render(RenderingEngine renderingEngine)
	{
		render(renderingEngine, new Vector3f(-1000000000,-1000000000,-1000000000), new Vector3f(1000000000,1000000000,1000000000));
	}
	
	public void render(RenderingEngine renderingEngine, Vector3f bmin, Vector3f bmax)
	{
		//renderingEngine.render(getRootObject());
		ArrayList<GameObject> results = new ArrayList<GameObject>();
		getTree().getPointsInsideBox(bmin, bmax, results);
		for(GameObject object : results)
			renderingEngine.render(object);
	}

	//!--- Printing object number was used to debug which object crashed the game --!
	//static int i = 0;
	public void addObject(GameObject object)
	{
		//i++;
		//System.out.println("Object " + i + " added!");
		//getRootObject().addChild(object);
		getTree().insert(object);
	}

	private Octree getTree()
	{
		if(tree == null)
		{
			tree = new Octree();
		}
		
		return tree;
	}
	
//	private GameObject getRootObject()
//	{
//		if(root == null)
//			root = new GameObject();
//
//		return root;
//	}
	
	public void setEngine(CoreEngine engine)
	{
		setEngine(engine, new Vector3f(-1000000000,-1000000000,-1000000000), new Vector3f(1000000000,1000000000,1000000000));
	}
	
	public void setEngine(CoreEngine engine, Vector3f bmin, Vector3f bmax)
	{
		//getRootObject().setEngine(engine);
		ArrayList<GameObject> results = new ArrayList<GameObject>();
		getTree().getPointsInsideBox(bmin, bmax, results);
		for(GameObject object : results)
			object.setEngine(engine);
	}
}
