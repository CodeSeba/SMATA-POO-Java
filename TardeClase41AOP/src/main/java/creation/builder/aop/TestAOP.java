package creation.builder.aop;

public class TestAOP {
	public void metodo1() { }
	public void metodo2() { }
	public void metodo3() {
		try { System.out.println(10/0);	} catch (Exception e) {	}
	}
}
