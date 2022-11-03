 
/*
 * écouter sur port 8080
 * TANT QUE (vrai) FAIRE
 * accepter connexion
 * récupérer flux d'entrée et flux de sortie
 * lire la première ligne sur flux d'entrée
 * SI (méthode get) ALORS
 * récupérer le chemin dans la première ligne
 * SI (CHEMIN est un répertoire) ALORS
 * construire réponse affichant le contenu du répertoire
 * SINON SI (CHEMIN est un fichier)
 * construire réponse avec le contenu du fichier
 * SINON
 * envoyer erreur 404
 * FIN SI
 * fermer la connexion
 * FIN TANT QUE
 */


package server;

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
			 DataOutputStream out = new DataOutputStream(c.getOutputStream());
			
			String line = null;
			System.out.println("----DEBUT REQUETE----");
			// On arrête à la fin des entête qui est définie comme une ligne vide
			line = r.readLine();
			System.out.println(line);
			String racine = "D:\\ProjetServer\\server-web\\src\\server\\";
			//String racine = "C:\\Users\\KADRI\\Desktop";
			String chemin = "";
			String methode = line.substring(0, 4);
			System.out.println(line);
			System.out.println(methode);
			String su = new String("GET");

			if (!methode.equals(su)) {
				chemin = line.split(" ")[1];
				String cheminComplet = racine + chemin;
				File file = new File(cheminComplet);
				System.out.println(file);
				System.out.println(file.isDirectory());
				if (file.isDirectory()) {
					// lister l'ensemble des fichiers contenus dans le repertoire
					String[] liste;
					liste = file.list();
					out.writeBytes("HTTP/1.1 200 OK\r\n"); // dit au navigateur que la reponse est valide
					out.writeBytes("Content-Type: text/html\r\n\r\n"); // informe le navigateur qu'il s'agit d'un 
					   
					for(String file1 : liste) {
						String html = "<p>"+file1+"</p>";
						out.writeBytes(html);
						out.flush(); // envoi dans le flux de sortie
						
					}
					
					out.close();

				} else if (file.isFile()) {

					try {
						File f = new File(cheminComplet);
						FileInputStream fIS = new FileInputStream(f);
						//PrintWriter out = new PrintWriter(c.getOutputStream());
						
						/* BufferedWriter os;
						 os = new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
						*/
						//PrintWriter writer = new PrintWriter(c.getOutputStream(), true);
						
						
						int r1 = 0;
						String test = "";
						while ((r1 = fIS.read()) != -1) {
							
							
							test += (char) r1;
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
				out.writeBytes("HTTP/1.1 201 ok\r\n"); // dit au navigateur que la reponse n'est pas valide
				 
			    out.writeBytes("Content-Type: text/html\r\n\r\n"); // informe le navigateur qu'il s'agit d'un 
			                                                      // d'un fichier Html
			    out.writeBytes("<html><head></head><body><h1>Hello</h1></body></html>");
			    out.flush(); // envoi dans le flux de sortie
			    out.close();  
			}

			System.out.println("----FIN REQUETE----");
			System.out.println();
			r.close();
			c.close();
		}
	}
}









