import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class HiloRepro implements Runnable{
	
	public static void main(String[] args) throws Exception {
		String mp3 = "res/High and Mighty Color - Ichirin no Hana.mp3";
		new Player(new FileInputStream(mp3)).play();
	}
	
	@Override
	public void run() {
		String mp3 = "res/High and Mighty Color - Ichirin no Hana.mp3";
		try {
			new Player(new FileInputStream(mp3)).play();
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
