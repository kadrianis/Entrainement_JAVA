/*
 * �couter sur port 8080
TANT QUE (vrai) FAIRE
accepter connexion
r�cup�rer flux d'entr�e et flux de sortie
lire la premi�re ligne sur flux d'entr�e
SI (m�thode get) ALORS
r�cup�rer le chemin dans la premi�re ligne
SI (CHEMIN est un r�pertoire) ALORS
construire r�ponse affichant le contenu du r�pertoire
SINON SI (CHEMIN est un fichier)
construire r�ponse avec le contenu du fichier
SINON
envoyer erreur 404
FIN SI
fermer la connexion
FIN TANT QUE
 */

package _LabWorks.jouerAvecRequettesHTTP.WebServerProjet06;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AfficheRequetesHttp {
	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(8030);
		while (true) {
			Socket c = s.accept();
			// on recupere
			BufferedReader r = new BufferedReader(new InputStreamReader(c.getInputStream()));
			
			String line = null;
			System.out.println("----DEBUT REQUETE----");
			// On arr�te � la fin des ent�te qui est d�finie comme une ligne vide
			line = r.readLine();
			System.out.println(line);
			String racine = "C:\\Users\\KADRI\\eclipse-workspace\\Tphttp\\src\\Tphttp";
			String chemin = "";
			String methode = line.substring(0, 4);
			System.out.println(line);
			System.out.println(methode);
			String su = new String("GET");

			if (!methode.equals(su)) {
				chemin = line.split(" ")[1];
				String cheminComplet = racine + chemin;
				Path p = Paths.get(chemin);
				File file = new File(cheminComplet);
				System.out.println(file);
				if (file.isDirectory()) {
					// lister l'ensemble des fichiers contenus dans le repertoire

				} else if (file.isFile()) {

					try {
						File f = new File(cheminComplet);
						FileInputStream fIS = new FileInputStream(f);
						System.out.println("file content: ");
						//PrintWriter rr = new PrintWriter(c.getOutputStream());
						
						/* BufferedWriter os;
						 os = new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
						*/
						PrintWriter writer = new PrintWriter(c.getOutputStream(), true);
						
						int r1 = 0;
						while ((r1 = fIS.read()) != -1) {
							writer.println((char) r1);
							//writer.write();
							//rr.print((char) r1);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} else {
				System.out.println("erreure 404");
			}

			/*
			 * InputStream in = null; in = Files.newInputStream(p); in.
			 */

			// System.out.println(chemin);
			// System.out.println(line);
			/*
			 * while (!"".equals(line)) { System.out.println(line); line = r.readLine(); }
			 */
			System.out.println("----FIN REQUETE----");
			System.out.println();
			r.close();
			c.close();
		}
	}
}