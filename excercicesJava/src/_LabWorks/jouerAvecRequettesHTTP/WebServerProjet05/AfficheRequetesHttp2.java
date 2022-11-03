package _LabWorks.jouerAvecRequettesHTTP.WebServerProjet05;

import java.io.*;
import java.net.*;

public class AfficheRequetesHttp2 {
	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(8080);
		while (true) {
			Socket c = s.accept();
			BufferedReader r = new BufferedReader(new InputStreamReader(c.getInputStream()));
			String line = null;
			System.out.println("----DEBUT REQUETE----");
			
// On arr�te � la fin des ent�te qui est d�finie comme une ligne vide
			line = r.readLine();
			while (!"".equals(line)) {
				System.out.println(line);
				line = r.readLine();
			}
			
			System.out.println("----FIN REQUETE----");
			System.out.println();
			r.close();
			c.close();
			
			
		}
	}
}