package JouerAvecDesFlux;

import java.io.File;

public class Listcontenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File rep = new File("C:\\Users\\KADRI\\Desktop\\ANIS");
		File[] lesFichiers = rep.listFiles();
		for (int i = 0; i < lesFichiers.length; ++i) {
			File f = lesFichiers[i];
			if (!f.isDirectory())
				System.out.println(lesFichiers[i].getAbsolutePath());
		}

		for (int i = 0; i < lesFichiers.length; ++i) {
			File f = lesFichiers[i];
			if (f.isDirectory())
				System.out.println("REP : " + lesFichiers[i].getAbsolutePath());
		}
	}

}
