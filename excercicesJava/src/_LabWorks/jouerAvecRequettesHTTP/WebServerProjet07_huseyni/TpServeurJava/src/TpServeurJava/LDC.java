package TpServeurJava;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class LDC {

	private Path dir;
	private TreeSet<Path> matchFilesPaths;
	private TreeSet<String> matchFilesNames;

	public LDC(Path d) {
		dir = d;
		matchFilesPaths = new TreeSet<Path>();
		matchFilesNames = new TreeSet<String>();
	}

	public TreeSet<Path> searchFilePath(Path dir, String s) {
		
			if ((Files.isDirectory(dir)))
				try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
					for (Path file : stream) {

						if (file.getFileName().toString().replaceAll(" ", "").compareToIgnoreCase(s.replaceAll(" ", "")) == 0)
							matchFilesPaths.add(file.getParent().resolve(file.getFileName()));
						else if (Files.isDirectory(file))
							searchFilePath(file.getParent().resolve(file.getFileName()), s);
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
		 else {
			matchFilesPaths.add(dir.getParent().resolve(dir.getFileName()));
			
		}
		
		return matchFilesPaths;
		/*
		Path p = Paths.get("");
		if (!(matchFilesPaths.isEmpty())) {
			Object[] oTab = matchFilesPaths.toArray();
			Path[] pTab = new Path[oTab.length];

			for (int i = 0; i < oTab.length; i++) {
				pTab[i] = (Path) oTab[i];
			}
			
			p = pTab[0];
			
			if (pTab.length >= 2)
				for (int i = 0; i < pTab.length - 1; i++) {
					if ((pTab[i].getNameCount() < pTab[i + 1].getNameCount()) && (pTab[i].getNameCount() < p.getNameCount()))
						p = pTab[i];
					else if ((pTab[i + 1].getNameCount() < pTab[i].getNameCount()) && (pTab[i + 1].getNameCount() < p.getNameCount()))
						p = pTab[i + 1];
				}
				
		}
		Collections.sort(matchFilesPaths);
		return p;*/

	}

	
	
	
	
	public TreeSet<Path> getMatchFilesPaths() {
		return matchFilesPaths;
	}

	public TreeSet<String> getMatchFilesNames(){
		return matchFilesNames;
	}
	
	
	public TreeSet<String> collectPathContentName(Path p){
		
		Map<Integer,String> l = new TreeMap<Integer,String>();
		l.put(1,"a");l.put(2,"b");l.put(3,"c");l.put(4,"d");l.put(5,"e");l.put(6,"f");l.put(7,"g");
		l.put(8,"h");l.put(9,"i");l.put(10,"j");l.put(11,"k");l.put(12,"l");l.put(13,"m");l.put(14,"n");
		l.put(15,"o");l.put(16,"p");l.put(17,"q");l.put(18,"r");l.put(19,"s");l.put(20,"t");l.put(21,"u");
		l.put(22,"v");l.put(23,"w");l.put(24,"x");l.put(25,"y");l.put(26,"z");
		
			matchFilesNames.add(""+p.getFileName());
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(p)) {
				for (Path file : stream) {
					String s =""+file.getFileName();
					String c =""+ s.charAt(0);
					//c = c.toLowerCase();
					if(l.containsValue(c))
						matchFilesNames.add(s);
				if (Files.isDirectory(file))
					//System.out.println(file.getParent().resolve(file.getFileName()));
					collectPathContentName(file.getParent().resolve(file.getFileName()));
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return matchFilesNames;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path dir = Paths.get("/home/ousseini/Desktop");
		//String s = "Test";
		
		while(true){
			if(!(dir.isAbsolute())){
				System.out.println(dir+" n'est pas un chemin absolue");
				break;
			}
			else{
				LDC ldc = new LDC(dir);
				//ldc.searchFilePath(dir, s);
				/*
				 * Iterator it = c.iterator();
				 * 
				 * while (it.hasNext()) { System.out.println(((Path)it.next())); }
				 */
				//System.out.println("\nLe chemin pour le fichier/dossier " + s + " : " + c);
				//System.out.println("Liste des chemins : "+ldc.getMatchFilesPaths());
				System.out.println("Liste des noms : "+ldc.collectPathContentName(dir));
				break;
			}
		}
	}
}
