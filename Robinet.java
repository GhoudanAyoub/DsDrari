package robinet;

public class Robinet extends Thread{
	public void debite(int d) {
		for(;;)
			if (Baignoire.contenu.volume < Baignoire.maxv){
				Baignoire.contenu.volume+=d;
				System.out.println("==>"+Baignoire.contenu.volume);
			}
			else {
				System.out.println("Baignoire Plainne");
				break;
			}
	}
}
