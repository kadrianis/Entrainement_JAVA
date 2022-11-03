package _LabWorks.jouerAvecRequettesHTTP.WebServerProjet05;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AfficheRequetesHttp4 {

	public AfficheRequetesHttp4() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.err.println("Usage: java " + AfficheRequetesHttp4.class.getName() + "  portnumber directory");
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
			System.err.println("Usage: java " + AfficheRequetesHttp4.class.getName() + "portnumber directory");
			System.exit(2);
		}

		try (ServerSocket s = new ServerSocket(portNumber);) {

			while (true) {

				try (Socket c = s.accept();) {

					Scanner sc = new Scanner(c.getInputStream());
					System.out.println("----DEBUT REQUETE----");

					if (sc.hasNextLine()) {
						String PremiereChaine = sc.nextLine();
						System.out.println(PremiereChaine);
						if (PremiereChaine.startsWith("GET ")) { // on r�cupere la premiere ligne de la requete Http
							String pathEnString = PremiereChaine.substring(4, PremiereChaine.indexOf(' ', 4));

							Path p = Paths.get("." + pathEnString);
							Path root = Paths.get(args[1]);
							Path fileToSend = root.resolve(p);
							OutputStream os = c.getOutputStream();
							String mimeType = Files.probeContentType(fileToSend);

							if (Files.notExists(fileToSend)) {
								Writer w = new OutputStreamWriter(os);
								PrintWriter pw = new PrintWriter(w);
								pw.println("HTTP/1.1 200 OK");
								pw.println("Content-Type: " + mimeType);
								pw.println();// ligne vide pour signaler la fin des entree

								pw.println("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">");
								pw.println("<html><body>");
								pw.println("<h1>ERROR 404</h1>");
								pw.println("Le fichier ou repertoire n'exisite pas ");
						    	pw.println("</body></html>");
								pw.flush();
								
							}
							
							else if( Files.isRegularFile(fileToSend)) {
								Writer w = new OutputStreamWriter(os);
								PrintWriter pw = new PrintWriter(w);
								pw.println("HTTP/1.1 200 OK");
								pw.println("Content-Type: " + mimeType);
								pw.println();// ligne vide pour signaler la fin des entêtes
								pw.flush();// il faut vider le buffer pour que le contenu soit envoyé.

								Files.copy(fileToSend, os); // ici pas besoin de vider le buffer os n'est pas buffeurisé
							}

							else if (Files.isDirectory(fileToSend)) {
								Writer w = new OutputStreamWriter(os);
								PrintWriter pw = new PrintWriter(w);
								pw.println("HTTP/1.1 200 OK");
								pw.println("Content-Type: " + mimeType);
								pw.println();// ligne vide pour signaler la fin des entêtes

								pw.println("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">");
								pw.println("<html><body>");
								pw.println("<h1> Contenu du r�pertoire </h1>");
								pw.println("<ul>");
								for (Path x : Files.newDirectoryStream(fileToSend)) {
									pw.println("<li><a href=" + fileToSend + "/" + x.getFileName() + ">"
											+ x.getFileName() + "</a></li>");
								}
								pw.println("<ul>");
								pw.println("</body></html>");
								pw.flush();// il faut vider le buffer pour que le contenu soit envoyé.
								//Files.copy(fileToSend, os);

							}

						}
					}

					;

					while (sc.hasNextLine()) {
						String line = sc.nextLine();
						// on sort de la boucle si on arrive sur la ligne vide de fin des headers
						if ("".equals(line)) {
							break;
						}

						System.out.println("-" + line + "-");
					}
					System.out.println("----FIN REQUETE----");

					/*
					 * OutputStream os = c.getOutputStream();
					 * 
					 * // exemple d'envoi d'un contenu html /* Writer w = new
					 * OutputStreamWriter(os); PrintWriter pw = new PrintWriter(w);
					 * pw.println("HTTP/1.1 200 OK"); pw.println("Content-Type: text/html");
					 * pw.println();// ligne vide pour signaler la fin des entêtes
					 * pw.println("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">");
					 * pw.println("<html><body>"); pw.println("<h1>Hello DCISS !</h1>");
					 * pw.println("</body></html>"); pw.flush(); // il faut vider le buffer pour que
					 * le contenu soit envoyé.
					 */

					// exemple d'envoi de fichier

					// Files.copy(fileToSend, os); // ici pas besoin de vider le buffer os n'est pas
					// buffeurisé

				}
			}

		} catch (IOException e) {
			System.err.println("IO error: ");
			e.printStackTrace();
			System.exit(10);
		}
	}
}
