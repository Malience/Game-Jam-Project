package com.base.engine.components;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_A;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_S;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_W;

import com.base.engine.core.Input;
import com.base.engine.core.Vector3f;


public class Controller extends GameComponent
{
	private float speed;
	private int forwardKey;
	private int backKey;
	private int leftKey;
	private int rightKey;

	public Controller(float speed)
	{
		this(speed, GLFW_KEY_W, GLFW_KEY_S, GLFW_KEY_A, GLFW_KEY_D);
	}

	public Controller(float speed, int forwardKey, int backKey, int leftKey, int rightKey)
	{
		this.speed = speed;
		this.forwardKey = forwardKey;
		this.backKey = backKey;
		this.leftKey = leftKey;
		this.rightKey = rightKey;
	}

	@Override
	public void input(float delta)
	{
		float movAmt = speed * delta;

		if(Input.getKey(forwardKey))
			move(new Vector3f(0,0,1), movAmt);
		if(Input.getKey(backKey))
			move(new Vector3f(0,0,1), -movAmt);
		if(Input.getKey(leftKey))
			move(new Vector3f(1,0,0), movAmt);
		if(Input.getKey(rightKey))
			move(new Vector3f(1,0,0), -movAmt);
	}

	private void move(Vector3f dir, float amt)
	{
		getTransform().setPos(getTransform().getPos().add(dir.mul(amt)));
	}
}
