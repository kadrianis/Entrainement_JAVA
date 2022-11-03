package _LabWorks.Coocurrences02;

import java.io.*;

	public class WordReader extends FilterReader {
		/**
		* Repr�sente le mot en cours de construction.
		* un caract�re est ajout� en utilisant la m�thode append(char c)
		* de StringBuilder.
		* Attention, append(int i) existe aussi.
		*/
		
		//-----------------------Attribut -----------------------//

		private StringBuilder sb;
		
		
		//-----------------------constructeur -----------------------//


		protected WordReader(Reader in) {
			super(in);
			//sb =new StringBuilder(); --> pas besoin // pourquoi on a pas fait �a ??
		}
	
		public String readWord() throws IOException {
			//return le dernier mot lu dans le flux ou null si on est arriv� � la fin
			// faut s'accrocher au premier mot
			
			
			//cas : 01 --> vide
			int  c =in.read();
			if(c==-1 || !Character.isLetterOrDigit(c)) // on cherche le premier mot
				c = in.read();
				
			//cas : 02 --> non vide 
			if (c==-1)
				return "fin";
			
			sb=new StringBuilder();
			while(Character.isLetterOrDigit(c)){ // TODO :  a verifier avec les autres
				sb=sb.append((char)c);
				c =(char)in.read();
			}
			
			return sb.toString();
		}

		
	
		
		
		public static void main(String[] args) {
			
		}
	
	}


