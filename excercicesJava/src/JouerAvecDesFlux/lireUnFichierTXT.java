package JouerAvecDesFlux;
import java.io.*;
public class lireUnFichierTXT {


	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		// lire a partir d'un fichier dans le meme repertoire de mon fichier de travail
		
		File f = new File("C:\\Users\\KADRI\\Desktop\\fic.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr); // prend un reader en paramettre
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = br.readLine())!=null){
				sb=sb.append(line);
				sb.append("\n");
			}
			fr.close();
			//System.out.println(" voila !!");
			System.out.println(sb.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
