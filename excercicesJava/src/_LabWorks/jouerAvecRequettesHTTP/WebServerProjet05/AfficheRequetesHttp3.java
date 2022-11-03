package _LabWorks.jouerAvecRequettesHTTP.WebServerProjet05;


import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.Scanner;

public class AfficheRequetesHttp3 {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.err.println("Usage: java " + AfficheRequetesHttp3.class.getName() + "portnumber directory");
			System.exit(1);
		}

		int portNumber = 0;
		try {
			portNumber = Integer.parseInt(args[0]);
			if (portNumber < 0) {
				System.err.println(args[0] + " is not a positive integer");
			}
		} catch (NumberFormatException e) {
			System.err.println(args[0] + " is not an integer");
			System.err.println("Usage: java " + AfficheRequetesHttp3.class.getName() + "portnumber directory");
			System.exit(2);
		}

		// que est ce qu'on fait
		
		try (ServerSocket s = new ServerSocket(portNumber);) {
			
		// que est ce qu'on fait

			while (true) {
				
		// que est ce qu'on fait

				try (Socket c = s.accept();) {
					Scanner sc = new Scanner(c.getInputStream());
					
		// que est ce qu'on fait

					System.out.println("----DEBUT REQUETE----");
					while (sc.hasNextLine()) {
						String line = sc.nextLine();
						// on sort de la boucle si on arrive sur la ligne vide de fin des headers
						if ("".equals(line)) {
							break;
						}
						System.out.println("-" + line + "-");
					}
					System.out.println("----FIN REQUETE----");

					OutputStream os = c.getOutputStream();

					// exemple d'envoi d'un contenu html
					/*Writer w = new OutputStreamWriter(os);
					PrintWriter pw = new PrintWriter(w);
					pw.println("HTTP/1.1 200 OK");
					pw.println("Content-Type: text/html");
					pw.println();// ligne vide pour signaler la fin des entêtes
					pw.println("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">");
					pw.println("<html><body>");
					pw.println("<h1>Hello DCISS !</h1>");
					pw.println("</body></html>");
					pw.flush(); // il faut vider le buffer pour que le contenu soit envoyé.
					*/
					
					// exemple d'envoi de fichier
					Path fileToSend = Paths.get("image.png");
					String mimeType = Files.probeContentType(fileToSend);

					Writer w = new OutputStreamWriter(os);
					PrintWriter pw = new PrintWriter(w);
					pw.println("HTTP/1.1 200 OK");
					pw.println("Content-Type: " + mimeType);
					pw.println();// ligne vide pour signaler la fin des entêtes
					pw.flush();// il faut vider le buffer pour que le contenu soit envoyé.

					Files.copy(fileToSend, os); // ici pas besoin de vider le buffer os n'est pas buffeurisé

				}

			}
		} catch (IOException e) {
			System.err.println("IO error: ");
			e.printStackTrace();
			System.exit(10);
		}

	}
}
