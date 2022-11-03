package TpServeurJava;

import java.awt.Desktop;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

public class ServerHttp {

	private int portNumber;
	private Path root;

//********************************************************************************************************************************************************************************	
	public static void constructPageResult(int lineToInsert, TreeSet<Path> filesPaths, String fileName, Path filePath,
			boolean resultProvideFromSearch) {
		List<String> resultToAdd = new LinkedList<String>();
		TreeSet<Path> matchFilesPaths = filesPaths;

		Map<String, String> img = new HashMap<String, String>();
		img.put(".txt", "<img src=\"https://img.icons8.com/dusk/48/000000/txt.png\"/>");
		img.put(".c", "<img src=\"https://img.icons8.com/stickers/48/000000/c.png\"/>");
		img.put(".cpp", "<img src=\"https://img.icons8.com/color/48/000000/c-plus-plus-logo.png\"/>");
		img.put(".csharp", "<img src=\"https://img.icons8.com/color/48/000000/c-sharp-logo-2.png\"/>");
		img.put(".css", "<img src=\"https://img.icons8.com/color/48/000000/css3.png\"/>");

		img.put("other", "<svg xmlns=\"http://www.w3.org/2000/svg\" x=\"0px\" y=\"0px\"" + "width=\"48\" height=\"48\""
				+ "viewBox=\"0 0 172 172\""
				+ "style=\" fill:#000000;\"><g fill=\"none\" fill-rule=\"nonzero\" stroke=\"none\" stroke-width=\"1\" "
				+ "stroke-linecap=\"butt\" stroke-linejoin=\"miter\" stroke-miterlimit=\"10\" stroke-dasharray=\"\" "
				+ "stroke-dashoffset=\"0\" font-family=\"none\" font-weight=\"none\" font-size=\"none\" text-anchor=\"none\" "
				+ "style=\"mix-blend-mode: normal\"><path d=\"M0,172v-172h172v172z\" fill=\"none\"></path><g><path "
				+ "d=\"M143.33333,161.25h-114.66667v-150.5h78.83333l35.83333,35.83333z\" fill=\"#3498db\"></path>"
				+ "<path d=\"M137.95833,50.16667h-34.04167v-34.04167z\" fill=\"#e1f5fe\"></path></g></g></svg>");

		img.put("folder", "<svg xmlns=\"http://www.w3.org/2000/svg\" x=\"0px\" y=\"0px\"\n"
				+ "width=\"48\" height=\"48\"\n" + "viewBox=\"0 0 226 226\"\n"
				+ "style=\" fill:#000000;\"><defs><linearGradient x1=\"113\" y1=\"136.83829\" x2=\"113\" y2=\"42.67163\" "
				+ "gradientUnits=\"userSpaceOnUse\" id=\"color-1_c2AXPLZ3iVEU_gr1\"><stop offset=\"0.472\" stop-color=\"#62b4ee\">"
				+ "</stop><stop offset=\"0.533\" stop-color=\"#62b4ee\"></stop><stop offset=\"0.667\" stop-color=\"#62b4ee\">"
				+ "</stop><stop offset=\"0.793\" stop-color=\"#62b4ee\"></stop><stop offset=\"0.907\" stop-color=\"#62b4ee\">"
				+ "</stop><stop offset=\"1\" stop-color=\"#62b4ee\"></stop></linearGradient><linearGradient x1=\"113\" y1=\"188.33333\" "
				+ "x2=\"113\" y2=\"65.91667\" gradientUnits=\"userSpaceOnUse\" id=\"color-2_c2AXPLZ3iVEU_gr2\"><stop offset=\"0\" "
				+ "stop-color=\"#2496d9\"></stop><stop offset=\"0.142\" stop-color=\"#2496d9\"></stop><stop offset=\"0.361\" "
				+ "stop-color=\"#2496d9\"></stop><stop offset=\"0.578\" stop-color=\"#2496d9\"></stop><stop offset=\"0.793\" "
				+ "stop-color=\"#2496d9\"></stop><stop offset=\"1\" stop-color=\"#2496d9\"></stop></linearGradient></defs><g fill=\"none\" "
				+ "fill-rule=\"nonzero\" stroke=\"none\" stroke-width=\"1\" stroke-linecap=\"butt\" stroke-linejoin=\"miter\" "
				+ "stroke-miterlimit=\"10\" stroke-dasharray=\"\" stroke-dashoffset=\"0\" font-family=\"none\" font-weight=\"none\" "
				+ "font-size=\"none\" text-anchor=\"none\" style=\"mix-blend-mode: normal\"><path d=\"M0,226v-226h226v226z\" "
				+ "fill=\"none\"></path><g><g><path d=\"M23.54167,131.83333v-75.7665c-0.00528,-2.7866 0.81381,-5.5125 2.35417,-7.83467l4.2375,"
				+ "-6.37038c1.75149,-2.62863 4.70423,-4.20401 7.86292,-4.19512h37.05458c3.16342,0.00369 6.11362,1.59552 7.8535,4.2375l3.76667,"
				+ "5.68767c1.73988,2.64198 4.69008,4.23381 7.8535,4.2375h98.51717c5.20068,0 9.41667,4.21599 9.41667,9.41667v70.58733z\" "
				+ "fill=\"url(#color-1_c2AXPLZ3iVEU_gr1)\"></path><path d=\"M193.04167,188.33333h-160.08333c-5.20068,0 -9.41667,-4.21599 "
				+ "-9.41667,-9.41667v-89.45833c0,-5.20068 4.21599,-9.41667 9.41667,-9.41667h42.0925c3.16342,-0.00369 6.11362,-1.59552 7.8535,"
				+ "-4.2375l3.76667,-5.68767c1.73988,-2.64198 4.69008,-4.23381 7.8535,-4.2375h98.51717c5.20068,0 9.41667,4.21599 9.41667,9.41667v103.621c0,5.20068 "
				+ "-4.21599,9.41667 -9.41667,9.41667z\" fill=\"url(#color-2_c2AXPLZ3iVEU_gr2)\"></path></g></g></g></svg>");

		img.put(".html", "<img src=\"https://img.icons8.com/fluency/48/000000/source-code.png\"/>");
		img.put(".png", "<img src=\"https://img.icons8.com/fluency/48/000000/image.png\"/>");
		img.put(".jpg", "<img src=\"https://img.icons8.com/fluency/48/000000/image.png\"/>");
		img.put(".jpeg", "<img src=\"https://img.icons8.com/fluency/48/000000/image.png\"/>");
		img.put(".java", "<img src=\"https://img.icons8.com/color/48/000000/java-coffee-cup-logo--v1.png\"/>");
		img.put(".js", "<img src=\"https://img.icons8.com/color/48/000000/javascript--v1.png\"/>");
		img.put("mp3", "<img src=\"https://img.icons8.com/color/48/000000/itunes.png\"/>");
		img.put(".pdf", "<img src=\"https://img.icons8.com/fluency/48/000000/adobe-acrobat.png\"/>");
		img.put(".php", "<img src=\"https://img.icons8.com/officexs/48/000000/php-logo.png\"/>");
		img.put(".python", "<img src=\"https://img.icons8.com/color/48/000000/python--v1.png\"/>");
		img.put(".R",
				"<img src=\"https://img.icons8.com/external-becris-flat-becris/48/000000/external-r-data-science-becris-flat-becris.png\"/>");
		img.put(".mp4", "<img src=\"https://img.icons8.com/fluency/48/000000/video.png\"/>");
		img.put(".avi", "<img src=\"https://img.icons8.com/fluency/48/000000/video.png\"/>");
		img.put(".docx", "<img src=\"https://img.icons8.com/color/48/000000/microsoft-word-2019--v2.png\"/>");
		img.put(".doc", "<img src=\"https://img.icons8.com/color/48/000000/microsoft-word-2019--v2.png\"/>");
		img.put(".xlsx", "<img src=\"https://img.icons8.com/color/48/000000/microsoft-excel-2019--v1.png\"/>");
		img.put(".pptx", "<img src=\"https://img.icons8.com/color/48/000000/microsoft-powerpoint-2019--v1.png\"/>");
		img.put(".sql",
				"<img src=\"https://img.icons8.com/external-outline-juicy-fish/48/000000/external-sql-coding-and-development-outline-outline-juicy-fish.png\"/>");
		img.put(".zip",
				"<img src=\"https://img.icons8.com/external-flat-juicy-fish/48/000000/external-zip-data-organisation-flat-flat-juicy-fish.png\"/>");
		img.put(".xz",
				"<img src=\"https://img.icons8.com/external-flat-juicy-fish/48/000000/external-zip-data-organisation-flat-flat-juicy-fish.png\"/>");
		img.put(".rar", "<img src=\"https://img.icons8.com/color/48/000000/winrar.png\"/>");
		img.put(".exe", "<img src=\"https://img.icons8.com/ultraviolet/48/000000/exe.png\"/>");

		for (Path p : matchFilesPaths) {
			if (Files.isDirectory(p)) {
				String str = "<li>" + img.get("folder") + "<a href=\"" + p + "\">&ensp;" + p.getFileName() + "</a>";// &ensp;<span>"
																													// +
																													// p
																													// +
																													// "</span></li>";
				resultToAdd.add(str);
			} else {
				if ((p.getFileName() + "").contains(".")) {
					String key = (p.getFileName() + "").substring((p.getFileName() + "").lastIndexOf("."));
					if (img.get(key) != null) {
						String str = "<li>" + img.get(key) + "<a href=\"" + p + "\"" + ">&ensp;" + p.getFileName()
								+ "</a>";// &ensp;<span>" + p + "</span></li>";
						resultToAdd.add(str);
					} else {
						String str = "<li>" + img.get("other") + "<a href=\"" + p + "\">&ensp;" + p.getFileName()
								+ "</a>";// &ensp;<span>" + p + "</span></li>";
						resultToAdd.add(str);

					}
				}
			}
		}

		Path fileToAddResult3 = Paths
				.get("/home/ousseini/Desktop/Programmation JAVA/TpServeurJava/resultBisPage.html");
		Path fileToInsert3 = Paths.get("/home/ousseini/Desktop/Programmation JAVA/TpServeurJava/resultPage.html");

		constructPage(lineToInsert, resultToAdd, false, fileToAddResult3, fileToInsert3);

		resultToAdd.clear();
		if (resultProvideFromSearch) {
			resultToAdd.add("<div id=\"search-title\"><h2>Search result for <span>" + fileName + "</span></h2></div>");
		} else if (filePath.getParent() != null)
			resultToAdd.add("<a href=\"" + filePath.getParent() + "\">"
					+ "<svg id=\"back-icon\" xmlns=\"http://www.w3.org/2000/svg\" x=\"0px\" y=\"0px\""
					+ "	width=\"48\" height=\"48\"" + "	viewBox=\"0 0 172 172\""
					+ "	style=\" fill:#000000;\"><g fill=\"none\" fill-rule=\"nonzero\" stroke=\"none\" stroke-width=\"1\" "
					+ "stroke-linecap=\"butt\" stroke-linejoin=\"miter\" stroke-miterlimit=\"10\" stroke-dasharray=\"\" stroke-dashoffset=\"0\" "
					+ "font-family=\"none\" font-weight=\"none\" font-size=\"none\" text-anchor=\"none\" style=\"mix-blend-mode: normal\"><path "
					+ "d=\"M0,172v-172h172v172z\" fill=\"none\"></path><g fill=\"#3498db\"><path d=\"M37.41,0c-0.76594,0.08063 -1.49156,0.43 "
					+ "-2.0425,0.9675l-34.4,34.4c-0.67187,0.645 -1.04812,1.54531 -1.04812,2.4725c0,0.92719 0.37625,1.8275 1.04813,2.4725l34.4,34.4c1.37063,1.37063 "
					+ "3.57438,1.37063 4.945,0c1.37063,-1.37062 1.37063,-3.57437 0,-4.945l-28.4875,-28.4875h101.695c28.39344,0 51.6,23.20656 51.6,51.6c0,28.21875 "
					+ "-22.91094,51.30438 -51.0625,51.6c-0.17469,0 -0.36281,0 -0.5375,0h-58.48v2.365c-0.20156,0.67188 -0.20156,1.37063 0,2.0425v2.4725h58.48c0.1075,0 "
					+ "0.215,0 0.3225,0c0.04031,0 0.06719,0 0.1075,0c0.18813,0 0.34938,-0.1075 0.5375,-0.1075c31.69906,-0.5375 57.5125,-26.5525 57.5125,-58.3725c0,"
					+ "-31.82 -25.81344,-57.835 -57.5125,-58.3725c-0.13437,-0.04031 -0.28219,-0.08062 -0.43,-0.1075c-0.18812,0 -0.34937,0 -0.5375,0h-101.695l28.4875,"
					+ "-28.4875c1.11531,-1.03469 1.41094,-2.67406 0.73906,-4.03125c-0.65844,-1.37062 -2.15,-2.12312 -3.64156,-1.88125zM0,144.48v6.88h6.88v-6.88zM13.76,"
					+ "144.48v6.88h6.88v-6.88zM27.52,144.48v6.88h6.88v-6.88zM41.28,144.48v6.88h6.88v-6.88z\"></path></g></g></svg>\n"
					+ "</a><div id=\"search-title\"><h2 align=\"center\" >Contents of <span>" + fileName
					+ "</span></h2></div>");

		constructPage(297, resultToAdd, false, fileToInsert3, fileToInsert3);
	}

//*******************************************************************************************************************************************************************************
	public static void constructPage(int lineToInsert, Collection<String> resultToInsert, boolean isForJsSugestion,
			Path fileToAddResult, Path fileToInsert) {

		List<String> resultToAdd = new LinkedList<String>();
		try {
			resultToAdd = Files.readAllLines(fileToAddResult);
		} catch (IOException e) {
			System.out.println("error occured ");
			e.printStackTrace();
		}
		if (!(resultToAdd.isEmpty())) {
			if (isForJsSugestion) {
				for (String s : resultToInsert) {
					// add at index between lineToInsert and lineToInsert + 1
					resultToAdd.add(lineToInsert, "\"" + s + "\",");
				}
			} else {
				for (String s : resultToInsert) {
					// add at index between lineToInsert and lineToInsert + 1
					resultToAdd.add(lineToInsert, s);
				}
			}
			try {
				Files.write(fileToInsert, resultToAdd);
			} catch (IOException e) {
				System.out.println("error occured ");
				e.printStackTrace();
			}
		}
	}

//********************************************************************************************************************************************************************************

	public static void main(String[] args) throws IOException {

		// public ServerHttp(int port, Path directory) {

//#########################################################################################################################
//        PORTNUMBER && SERVER'S ROOT PATH && CONNECTION ESTABLISHED
//##########################################################################################################################

		// Need 2 arguments ; port and root

		if (args.length != 2) {
			System.err.println("Usage: java " + ServerHttp.class.getName() + " portNumber realPathDirectory");
			System.exit(1);
		}

		// Port Number
		int portNumber = 0;
		try {
			portNumber = Integer.parseInt(args[0]);
			if (portNumber < 0) {
				System.err.println(args[0] + " is not a positive integer");
			}
		} catch (NumberFormatException e) {
			System.err.println(args[0] + " is not an integer");
			System.err.println("Usage: java " + ServerHttp.class.getName() + " portNumber realPathDirectory");
			System.exit(2);
		}

		// Server's path root
		Path root = Paths.get(args[1]);

		try {
			root.toRealPath();
		} catch (IOException e) {
			System.err.println(args[1] + " is not a real path");
			System.err.println("Usage: java " + ServerHttp.class.getName() + " portNumber realPathDirectory");
			System.exit(2);
		}

//		this.portNumber = port;
//		this.root = directory;
//		int portNumber = 7070;
//		Path root = Paths.get("/home/ousseini/Desktop");

		System.out.println(" portNumber : " + portNumber + "" + "\n root : " + root);

		// search for files names and construct home page
		LDC ldc1 = new LDC(root);
		TreeSet<String> filesNamesOnTheServerPath = ldc1.collectPathContentName(root);
		Path fileToAddResult1 = Paths
				.get("/home/ousseini/Desktop/Programmation JAVA/TpServeurJava/homeAbstractPage.html");
		Path fileToInsert1 = Paths.get("/home/ousseini/Desktop/Programmation JAVA/TpServeurJava/homePage.html");
		constructPage(264, filesNamesOnTheServerPath, true, fileToAddResult1, fileToInsert1);

		Path fileToAddResult2 = Paths
				.get("/home/ousseini/Desktop/Programmation JAVA/TpServeurJava/resultAbstractPage.html");
		Path fileToInsert2 = Paths
				.get("/home/ousseini/Desktop/Programmation JAVA/TpServeurJava/resultBisPage.html");
		constructPage(328, filesNamesOnTheServerPath, true, fileToAddResult2, fileToInsert2);

		// img.put(,);

		// Connected to client
		try (ServerSocket s = new ServerSocket(portNumber);) {
			// Desktop d = Desktop.getDesktop();

			// open navigator
			//Runtime.getRuntime().exec(new String[] { "firefox", "http://localhost:" + portNumber + "/" });

			while (true) {

				try (Socket c = s.accept();) {
					Scanner sc = new Scanner(c.getInputStream());

//#########################################################################################################################
//            CLIENT REQUEST  
//##########################################################################################################################

					System.out.println("----DEBUT REQUETE----");
					String line = sc.nextLine();
					System.out.println("-" + line + "-");

					String fileName = "";
					Path filePath = Paths.get("");
					boolean resultIsForSearch = false;
					// Recuperons le texte dans la premiere ligne de la requete
					if (line.contains("?search=")) {
						fileName = "/" + line.substring(line.indexOf("?search="), line.lastIndexOf(" "));
						fileName = URLDecoder.decode(fileName, "UTF-8");

						// if (fileName.length() > 1) {
						// Pour une requete via le formulaire de search
						// if (fileName.startsWith("/?search=")) {
						// resultIsForSearch = true;
						// if (fileName.length() > 8)
						fileName = fileName.substring(9);
						resultIsForSearch = true;
					}
					// resultIsForSearch = true;
					// fileName = line.substring(4, line.lastIndexOf(" "));
					else {
						// Texte commençant aprés le GET
						// Et decodons le texte de l'URL recupéré vers du UTF-8
						String sTemp = line.substring(4, line.lastIndexOf(" "));
						sTemp = URLDecoder.decode(sTemp, "UTF-8");
						filePath = Paths.get(sTemp);
						fileName = sTemp;
					}

					// recuperons le nom du fichier à chercher
					// si > 1 c à d la page demandé n'est pas la home page

					// Pour une requete dans l'URL

					// else
					// fileName = fileName.substring(1);
					System.out.println("fileName : " + fileName);
					System.out.println("filePath : " + filePath);

					// On continue l'affichage du reste de la requete
					while (sc.hasNextLine()) {

						line = sc.nextLine();

						// on sort de la boucle si on arrive sur la ligne vide de fin des headers
						if ("".equals(line)) {
							break;
						}
						System.out.println("-" + line + "-");
					}
					System.out.println("----FIN REQUETE----");

					OutputStream os = c.getOutputStream();

//#########################################################################################################################
//            SERACHING THE REQUESTED FILE NAME IN THE SERVER'S ROOT 
//##########################################################################################################################

					final int HOMEPAGE = 0, PAGEFOUND = 1, PAGENOTFOUND = 2;
					LDC ldc2 = new LDC(root);
					int page = -1;
					if (fileName.equals("/"))
						page = HOMEPAGE;
					else {
						if (resultIsForSearch && !(fileName.equals(""))) {
							ldc2.searchFilePath(root, fileName);

							if (ldc2.getMatchFilesPaths().isEmpty()) {

								page = PAGENOTFOUND;

								Path fileToAddResult4 = Paths.get(
										"/home/ousseini/Desktop/Programmation JAVA/TpServeurJava/errorAbstractPage.html");
								Path fileToInsert4 = Paths.get(
										"/home/ousseini/Desktop/Programmation JAVA/TpServeurJava/errorPage.html");

								List<String> resultToAdd = new LinkedList<String>();

								String sentenceToAdd = "<p>Sorry but the document you are looking for, corresponding to <span>\""
										+ fileName
										+ "\"</span> does not exist,<br>have been removed. name changed or is temporarily";

								resultToAdd.add(sentenceToAdd);

								constructPage(160, resultToAdd, false, fileToAddResult4, fileToInsert4);
							}

							else {
								page = PAGEFOUND;
								// System.out.println(ldc2.getMatchFilesPaths());
								// for search results

								constructPageResult(303, ldc2.getMatchFilesPaths(), fileName, null, true);

							}
						} else {
							while (true) {
								try {
									filePath.toRealPath();
								} catch (IOException e) {
									page = PAGENOTFOUND;
									break;
								}
								break;
							}
							if (page == PAGENOTFOUND) {

								page = PAGENOTFOUND;

								Path fileToAddResult4 = Paths.get(
										"/home/ousseini/Desktop/Programmation JAVA/TpServeurJava/errorAbstractPage.html");
								Path fileToInsert4 = Paths.get(
										"/home/ousseini/Desktop/Programmation JAVA/TpServeurJava/errorPage.html");

								List<String> resultToAdd = new LinkedList<String>();

								String sentenceToAdd = "<p>Sorry but the document you are looking for, corresponding to <span>\""
										+ filePath
										+ "\"</span> does not exist, have been removed, name changed or is temporarily unavailable</p>";

								resultToAdd.add(sentenceToAdd);

								constructPage(160, resultToAdd, false, fileToAddResult4, fileToInsert4);
							}

							else {
								page = PAGEFOUND;
								if ((Files.isDirectory(filePath))) {
									resultIsForSearch = true;

									TreeSet<Path> ts = new TreeSet<Path>();
									try (DirectoryStream<Path> stream = Files.newDirectoryStream(filePath)) {
										for (Path file : stream) {
											ts.add(file.getParent().resolve(file.getFileName()));
										}
										// resultProvideFromSearch = false;
										constructPageResult(303, ts, filePath.getFileName() + "", filePath, false);

									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							}
						}

					}
// #########################################################################################################################
//			SENDING FILE 
//##########################################################################################################################
					switch (page) {

					// ********************** HOME PAGE
					case HOMEPAGE: {
						Path fileToSend = Paths
								.get("/home/ousseini/Desktop/Programmation JAVA/TpServeurJava/homePage.html");
						String mimeType = Files.probeContentType(fileToSend);
						Writer w = new OutputStreamWriter(os);
						PrintWriter pw = new PrintWriter(w);
						pw.println("HTTP/1.1 200 OK");
						pw.println("Content-Type: " + mimeType);
						pw.println();// ligne vide pour signaler la fin des entêtes
						pw.flush();// il faut vider le buffer pour que le contenu soit envoyé.
						Files.copy(fileToSend, os); // ici pas besoin de vider le buffer os n'est pas buffeurisé
						break;
					}

					// ********************** PAGE IN REQUEST
					case PAGEFOUND: {

						if (resultIsForSearch) {
							Path fileToSend = Paths
									.get("/home/ousseini/Desktop/Programmation JAVA/TpServeurJava/resultPage.html");
							// Path fileToSend = fileNamePath;
							String mimeType = Files.probeContentType(fileToSend);
							Writer w = new OutputStreamWriter(os);
							PrintWriter pw = new PrintWriter(w);
							pw.println("HTTP/1.1 200 OK");
							pw.println("Content-Type: " + mimeType);
							pw.println();// ligne vide pour signaler la fin des entêtes
							pw.flush();// il faut vider le buffer pour que le contenu soit envoyé.
							Files.copy(fileToSend, os); // ici pas besoin de vider le buffer os n'est pas buffeurisé
							// resultIsForSearch = false;
						}

						else {

							// System.out.println(fileName);
							// Path fileToSend = Paths.get("/home/ousseini/Desktop/COURS MIASHS/Semestre
							// 2/Mathématique 2/coursMPI_langage.pdf");
							Path fileToSend = filePath;
							String mimeType = Files.probeContentType(fileToSend);
							Writer w = new OutputStreamWriter(os);
							PrintWriter pw = new PrintWriter(w);
							pw.println("HTTP/1.1 200 OK");
							pw.println("Content-Type: " + mimeType);
							pw.println();// ligne vide pour signaler la fin des entêtes
							pw.flush();// il faut vider le buffer pour que le contenu soit envoyé.
							Files.copy(fileToSend, os); // ici pas besoin de vider le buffer os n'est pas buffeurisé

						}

						break;
						/*
						 * Writer w = new OutputStreamWriter(os); PrintWriter pw = new PrintWriter(w);
						 * pw.println("HTTP/1.1 200 OK"); pw.println("Content-Type: text/html");
						 * pw.println();// ligne vide pour signaler la fin des entêtes
						 * pw.println("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">");
						 * pw.println("<html><body>");
						 * pw.println("<h1>HELLO I FOUND THE PAGE :) !</h1>");
						 * pw.println("</body></html>"); pw.flush(); // il faut vider le buffer pour que
						 * le contenu soit envoyé. break;
						 */
					}

					// ********************** NOT FOUND PAGE : ERROR 404
					case PAGENOTFOUND: {
						Path fileToSend = Paths
								.get("/home/ousseini/Desktop/Programmation JAVA/TpServeurJava/errorPage.html");
						String mimeType = Files.probeContentType(fileToSend);
						Writer w = new OutputStreamWriter(os);
						PrintWriter pw = new PrintWriter(w);
						pw.println("HTTP/1.1 200 OK");
						pw.println("Content-Type: " + mimeType);
						pw.println();// ligne vide pour signaler la fin des entêtes
						pw.flush();// il faut vider le buffer pour que le contenu soit envoyé.
						Files.copy(fileToSend, os); // ici pas besoin de vider le buffer os n'est pas buffeurisé
						break;
						/*
						 * Writer w = new OutputStreamWriter(os); PrintWriter pw = new PrintWriter(w);
						 * pw.println("HTTP/1.1 200 OK"); pw.println("Content-Type: text/html");
						 * pw.println();// ligne vide pour signaler la fin des entêtes
						 * pw.println("<!DOCTYPE html PUBLIC \"-//IETF//DTD HTML 2.0//EN\">");
						 * pw.println("<html><body>"); pw.println("<h1>ERROR 404 NOT FOUND !</h1>");
						 * pw.println("</body></html>"); pw.flush(); // il faut vider le buffer pour que
						 * le contenu soit envoyé. break;
						 */

					}

					}

				} catch (IOException e) {
					System.err.println("IO error: ");
					e.printStackTrace();
					System.exit(10);
				}

			}

		} catch (IOException e) {
			System.err.println("IO error: ");
			e.printStackTrace();
			System.exit(10);
		}

	}
}
