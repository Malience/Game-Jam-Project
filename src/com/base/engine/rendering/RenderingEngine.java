package com.base.engine.rendering;

import com.base.engine.components.BaseLight;
import com.base.engine.components.Camera;
import com.base.engine.core.GameObject;
import com.base.engine.core.Transform;
import com.base.engine.core.Vector3f;
import com.base.engine.rendering.MeshLoading.ResourceManagement.MappedValues;

import java.util.ArrayList;
import java.util.HashMap;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL32.*;

public class RenderingEngine extends MappedValues
{
	private Camera mainCamera;

	private ArrayList<BaseLight> lights;
	private BaseLight activeLight;

	private HashMap<String, Integer> samplerMap;
	private Shader forwardAmbient;
//	private Shader shadowShader;
	
//	public static DirectionalLight dlight;
	
	public RenderingEngine()
	{
		super();
		lights = new ArrayList<BaseLight>();
		samplerMap = new HashMap<String, Integer>();
		samplerMap.put("diffuse", 0);
		
		addVector3f("ambient", new Vector3f(0.1f,0.1f,0.1f));
		
		forwardAmbient = new Shader("forward-ambient");
//		shadowShader = new Shader("shadowShader");
		
		glClearColor(0.0f, 1.0f, 1.0f, 0.0f);

		glFrontFace(GL_CW);
		glCullFace(GL_BACK);
		glEnable(GL_CULL_FACE);
		glEnable(GL_DEPTH_TEST);

		glEnable(GL_DEPTH_CLAMP);

		glEnable(GL_TEXTURE_2D);
	}

	public void updateUniformStruct(Transform transform, Material material, RenderingEngine renderingEngine, String uniformName, String uniformType)
	{
		throw new IllegalArgumentException(uniformName + " is not a supported type in Rendering Engine");
	}
	
	public void render(GameObject object)
	{
		
//		int framebuffer = glGenFramebuffers();
//		
//		glBindFramebuffer(GL_FRAMEBUFFER, framebuffer);
//		
//		int depthTexture = glGenTextures();
//		glBindTexture(GL_TEXTURE_2D, depthTexture);
//		glTexImage2D(GL_TEXTURE_2D, 0, GL_DEPTH_COMPONENT16, 1024, 1024, 0, GL_DEPTH_COMPONENT, GL_FLOAT, 0);
//		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
//		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
//		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
//		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
//		
//		glFramebufferTexture(GL_FRAMEBUFFER, GL_DEPTH_ATTACHMENT, depthTexture, 0);
//		
//		glDrawBuffer(GL_NONE);
//		
//		Vector3f lightInvDir = dlight.getDirection();
//		
//		Matrix4f depthProjectionMatrix = new Matrix4f().initOrthographic(-10, 10, -10, 10, -10, 20);
//		Matrix4f depthViewMatrix = new Transform().getLookAtRotation(lightInvDir, new Vector3f(0,1,0)).toRotationMatrix();
//		//Matrix4f depthModelMatrix = new Matrix4f().initIdentity(); //Doesn't matter
//		Matrix4f depthMVP = depthProjectionMatrix.mul(depthViewMatrix);
//		dlight.setMVP(depthMVP);
//		
//		activeLight = dlight;
//		object.renderAll(shadowShader, this);
//		
//		samplerMap.put("shadowMap", depthTexture);
		
		
		
		//Window.bindRenderTarget(Texture.renderToTexture());
		Window.bindAsRenderTarget();
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		object.renderAll(forwardAmbient, this);

		glEnable(GL_BLEND);
		glBlendFunc(GL_ONE, GL_ONE);
		glDepthMask(false);
		glDepthFunc(GL_EQUAL);

		for(BaseLight light : lights)
		{
			activeLight = light;
			object.renderAll(light.getShader(), this);
		}

		glDepthFunc(GL_LESS);
		glDepthMask(true);
		glDisable(GL_BLEND);
		
//		glDeleteTextures(depthTexture);
//		glDeleteBuffers(depthTexture);
//		glDeleteBuffers(framebuffer);
	}
	

//	private static void clearScreen()
//	{
//		//TODO: Stencil Buffer
//		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
//	}
	
	public static String getOpenGLVersion()
	{
		return glGetString(GL_VERSION);
	}

	public void addLight(BaseLight light)
	{
		lights.add(light);
	}

	public void addCamera(Camera camera)
	{
		mainCamera = camera;
	}

	public int getSamplerSlot(String samplerName)
	{
		return samplerMap.get(samplerName);
	}
	
	public BaseLight getActiveLight()
	{
		return activeLight;
	}

	public Camera getMainCamera()
	{
		return mainCamera;
	}

	public void setMainCamera(Camera mainCamera)
	{
		this.mainCamera = mainCamera;
	}
}
