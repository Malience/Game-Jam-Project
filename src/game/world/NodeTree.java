package game.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.base.engine.core.Vector3f;

import game.GObject;

public class NodeTree 
{
	private static HashMap<Node,ArrayList<Node>> nodes = new HashMap<Node,ArrayList<Node>>();
	
	public static Node setNode(float x, float y, float z)
	{
		Node n = new Node(x,y,z);
		nodes.put(n, new ArrayList<Node>());
		return n;
	}
	
	public static void connect(Node n1, Node n2)
	{
		nodes.get(n1).add(n2);
		nodes.get(n2).add(n1);
	}
	
	public static Node getRandomConnected(Node n)
	{
		Random r = new Random();
		ArrayList<Node> k = nodes.get(n);
		if(k.size()!=0)
		{
			int i = r.nextInt(k.size());
			return k.get(i);
		}
		return null;
	}
	
	public static float getDistance(GObject object, Node n)
	{
		Vector3f v = object.getThis().getTransform().getPos().sub(n.getPos());
		v = v.mul(v);
		return (float)Math.sqrt(v.length());
	}
}
