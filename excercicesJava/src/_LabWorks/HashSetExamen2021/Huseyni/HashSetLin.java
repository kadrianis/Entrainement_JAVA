package examen23Juin2021;

import java.util.Arrays;

public class HashSetLin<T> {
	
	private EntreeAbstraite<T>[] rep;
	private int nbEntrees;
	
	
	public HashSetLin(int n){
		this.rep = new EntreeAbstraite[n];
		nbEntrees = 0;
		for(int i = 0; i < this.rep.length; ++i){
			this.rep[i] = EntreeLibre.getInstance();
		}
	}
	
	
	private void reHash(){
	if (nbEntrees == rep.length){
		// on fait une copie des element de rep
		Entree<T>[] tmp = new Entree[rep.length];
		for(int i = 0; i < rep.length; ++i){
			tmp[i] = ((Entree<T>)rep[i]);
			
		}
		
		// on cree le nouveau tableau
		int newTabLength = (int)(rep.length*1.5);
		this.rep = new EntreeAbstraite[newTabLength];
		//on l'initialise à EntreeLibre
		for(int i = 0; i < this.rep.length; ++i){
			this.rep[i] = EntreeLibre.getInstance();
		}
		
		// on recopie les elements dans rep
		for(int i = 0; i < tmp.length; ++i){
			rep[i] = tmp[i];
		}
	}
	
	
	}
	
	public boolean add(T t){
		
		boolean estPresent = false;
		
		
		// verifier si l'element est déjà présent
		for(int i = 0; i < rep.length; ++i){
			//on compare quand c'est pas une EntreeLibre
			if(!(rep[i] instanceof EntreeLibre)){
				T te = ((Entree<T>)rep[i]).get();
				if(te.equals(t)){
					estPresent = true;
					break;
				}
			}
				
		}
		
		if(estPresent){
			return false;
		}
		//estPresent = false
		else{
			
			// si la table est pleine on augmente la taille
			if (nbEntrees >= rep.length){
				reHash();
			}
			//obtenir une place de hashsage
			int index = indexOf(t);
				
				// recherche d'une EntreeLibre
				while(index < rep.length ){ // boucle infini cachée
					// si la place proposée n'est pas une EntreeLibre on va voir la suivante
						if(!(rep[index] == EntreeLibre.getInstance()))
							index = (index+1)%rep.length;// permet d'aller voir au debut si on a pas commencé par le debut					
						else
							break;//EntreeLibre trouvé
					}
				// ajout proprement
				Entree<T> e = new Entree<T>(t);
				rep[index] = e;
				// on n'oublie pas d'incrementer
				nbEntrees++;
				return true;
			}
	}
	
	//pour le calcul des positions d'insertion dans la table
	// previent les indexOutOfBoundException
	private  int indexOf(T t){
		return Math.abs(t.hashCode())%rep.length;	
	}
	

	
	public boolean remove(T t){
		boolean estPresent = false;
		
		// verifier d'abord si l'element est présent
		for(int i = 0; i < rep.length; ++i){
			//on compare quand c'est pas une EntreeLibre
			if(!(rep[i] instanceof EntreeLibre)){
				// on fait un transtypage pour etre sur que get() renvoie un T
				T te = ((Entree<T>)rep[i]).get();
				if(te.equals(t)){
					estPresent = true;
					break;
				}
			}
				
		}
		// pas present => estPresent = false
		if(!estPresent){
			return false;
		}
		
		// estPresent = true
		else{
			// rechercher sa position
			int index = indexOf(t);
			// remplacer cette derniere par une EntreeLibre
			rep[index] = EntreeLibre.getInstance();
			//on n'oublie pas de decrementer nbEntrees
			nbEntrees--;
			return true;
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(EntreeAbstraite<T> e : rep){
				sb.append(e);
				sb.append(",");
			}
		sb.setCharAt(sb.length()-1,']');
		
		return sb.toString();	
	}
	
	
}
