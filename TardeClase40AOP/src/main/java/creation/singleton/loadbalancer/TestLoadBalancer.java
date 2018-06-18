package creation.singleton.loadbalancer;
public class TestLoadBalancer {
    public static void main(String[] args) {
        Server s1=LoadBalancer.getInstance().getServer();
        System.out.println(s1.getAddress());
        Server s2=LoadBalancer.getInstance().getServer();
        System.out.println(s2.getAddress());
    }
}
