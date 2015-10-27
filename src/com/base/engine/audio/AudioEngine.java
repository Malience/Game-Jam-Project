package com.base.engine.audio;

import org.lwjgl.openal.*;

public class AudioEngine 
{
	ALContext context;
	ALDevice device;
	
	public void start()
	{
		context = ALContext.create();
		device = context.getDevice();
		
		context.makeCurrent();
	}
	
	public void stop()
	{
		cleanUp();
	}
	
	public void run()
	{

	}
	
	public void cleanUp()
	{
		context.destroy();
		device.destroy();
	}
	
}
