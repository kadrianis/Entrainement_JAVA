package _LabWorks.jouerAvecRequettesHTTP.WebServerProjet06;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServerAllassan {
	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(8040);
		while (true) {
			Socket c = s.accept();
			// on recupere
			BufferedReader r = new BufferedReader(new InputStreamReader(c.getInputStream()));
			
			String line = null;
			System.out.println("----DEBUT REQUETE----");
			// On arr�te � la fin des ent�te qui est d�finie comme une ligne vide
			line = r.readLine();
			System.out.println(line);
			String racine = "C:\\Users\\KADRI\\eclipse-workspace\\Requete_Http\\src\\Tphttp";
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
						//PrintWriter out = new PrintWriter(c.getOutputStream());
						
						/* BufferedWriter os;
						 os = new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
						*/
						//PrintWriter writer = new PrintWriter(c.getOutputStream(), true);
						
						 DataOutputStream out = new DataOutputStream(c.getOutputStream());
						int r1 = 0;
						String test = "";
						while ((r1 = fIS.read()) != -1) {
							
							
							test += (char) r1;
							//writer.println(r1);
							//writer.write();
						 
							System.out.print((char) r1);
						}
						
						out.writeBytes("HTTP/1.1 200 OK\r\n"); // dit au navigateur que la reponse est valide
						 
					    out.writeBytes("Content-Type: text/html\r\n\r\n"); // informe le navigateur qu'il s'agit d'un 
					                                                      // d'un fichier Html
						    /* out.writeBytes("<html><head></head><body><h1>Hello</h1></body></html>");
                            */
					    out.writeBytes(test);
							out.flush(); // envoi dans le flux de sortie
							out.close();
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
