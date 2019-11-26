package robinet;

public class Baignoire {
	public static final int maxv=1000;
	public static Eau contenu=new Eau(0);
	public void fuite(int d) {
		for(;;)
			if (Baignoire.contenu.volume<=0){
				System.out.println("Bainoire vide");
				break;
			}
			else if (Baignoire.contenu.volume>=Baignoire.maxv) {
				System.out.println("Hi from Debite: Bainoire au Max");
				break;
			}
				
			else {
				Baignoire.contenu.volume-=d;
				System.out.println("<=="+Baignoire.contenu.volume);
			}
	}

}
