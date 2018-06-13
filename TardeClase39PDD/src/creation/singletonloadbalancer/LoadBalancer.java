package creation.singletonloadbalancer;

import java.util.LinkedList;
import java.util.List;

public final class LoadBalancer {
	private List<Server> servers = new LinkedList();
	private static LoadBalancer instance = null;
	
	private LoadBalancer() {
		servers.add(new Server("192.168.1.2"));
		servers.add(new Server("192.168.1.3"));
		servers.add(new Server("192.168.1.4"));
		servers.add(new Server("192.168.1.5"));
		servers.add(new Server("192.168.1.6"));
	}
	
	public Server getServer() {
		return servers.get((int)(Math.random()*4.9999));
	}
	
	public static LoadBalancer getInstance() {
		synchronized(new Object()) {
			if(instance == null) instance = new LoadBalancer();
		}
		return instance;
	}
	
}
