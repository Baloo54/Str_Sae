import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe ListeTriee
 * fonctionne correctement
 */
public class TestListeTriee {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestListeTriee(), args);
	}	
	public static void verifie(Liste l, String[] resultat){
		// verification
		int p = l.tete();
		for (int i=0;i<resultat.length;i++){
			// teste pas en fin de liste
			assertEquals("liste non vide etape("+i+")",false,l.finliste(p));

			// verifie la valeur
			assertEquals("mauvaise valeur position("+i+")",resultat[i],l.val(p));
			
			// decale place
			p = l.suc(p);
		} 
		// verification liste finie
		assertEquals("mauvaise fin de liste", true, l.finliste(p));
	}
	/**
	 * methode verifiant si une liste contient les memes elements qu'un tableau de chaines
         *
         * @param lT liste triee a tester
         * @param resultat contenu attendu de la liste
         */
	public static void verifie(ListeTriee lT, String[] resultat){
		// verification
		int p = lT.tete();
		for (int i=0;i<resultat.length;i++){

			// verifie la valeur
			assertEquals("liste trop courte taille="+i,false,lT.finliste(p));


			// verifie la valeur
			assertEquals("mauvaise valeur",resultat[i],lT.val(p));
			
			// decale place
			p = lT.suc(p);
		} 
		// verification liste finie
		assertEquals("liste plus grnde que prevue",true,lT.finliste(p));
	}

	// #####################################
	// Ajouts dans liste Triee (debute par 0)
	// #####################################

	
	/**
	 * test d'ajouts 
	 */
	public void test_01_ajoutTrie() {
	    ListeTriee lT = new ListeTriee(new ListeProf());

	    String[] mots= {"a","b","c"};
	    String[] resultat= {"a","b","c"};
	    for (int i = 0; i < mots.length; i++){
		lT.adjlisT(mots[i]);
	    }    	
	    
	    // verification
	    verifie(lT, resultat);
	}


	/**
	 * test d'ajouts 
	 */
	public void test_02_ajoutInverse() {
	    ListeTriee lT = new ListeTriee(new ListeProf());
	    
	    String[] mots= {"c","b","a"};
	    String[] resultat= {"a","b","c"};
	    for (int i = 0; i < mots.length; i++){
		lT.adjlisT(mots[i]);
	    }    	
	    
	    // verification
	    verifie(lT, resultat);
	}

	/**
	 * test d'ajouts quelconque
	 */
	public void test_03_ajoutQuelconque() {
	    ListeTriee lT = new ListeTriee(new ListeProf());
	    
	    String[] mots= {"c","d","b","e","a","f"};
	    String[] resultat= {"a","b","c","d","e","f"};
	    for (int i = 0; i < mots.length; i++){
		lT.adjlisT(mots[i]);
	    }    	
	    
	    // verification
	    verifie(lT, resultat);
	}

	/**
	 * test d'ajouts en tete
	 */
	public void test_04_ajoutTestTete() {
	    ListeTriee lT = new ListeTriee(new ListeProf());

	    // ajoute a en dernier
	    String[] mots= {"b","c","d","a"};
	    String[] resultat= {"a","b","c","d"};
	    for (int i = 0; i < mots.length; i++){
		lT.adjlisT(mots[i]);
	    }    	
	    
	    // verification
	    verifie(lT, resultat);
	}

        /**
	 * test d'ajouts en queue
	 */
	public void test_05_ajoutTestQueue() {
	    ListeTriee lT = new ListeTriee(new ListeProf());

	    // ajoute e en dernier
	    String[] mots= {"b","c","d","a","e"};
	    String[] resultat= {"a","b","c","d","e"};
	    for (int i = 0; i < mots.length; i++){
		lT.adjlisT(mots[i]);
	    }
	    
	    // verification
	    verifie(lT, resultat);
	}

   /**
	 * test d'ajouts 
	 */
	public void test_06_ajoutEgal() {
	    ListeTriee lT = new ListeTriee(new ListeProf());

	    String[] mots= {"a","a"};
	    String[] resultat= {"a","a"};
	    for (int i = 0; i < mots.length; i++){
		lT.adjlisT(mots[i]);
	    }    	
	    
	    // verification
	    verifie(lT, resultat);
	}
		
	/**
	 * Test supprimer elements d'une liste triee
	 */
	public void test_07_suplisT() {
		ListeTriee lT = new ListeTriee(new ListeProf());

		// ajouter elements a la liste
		String[] mots = {"a", "b", "c", "d", "e"};
		for (int i = 0; i < mots.length; i++) {
			lT.adjlisT(mots[i]);
		}

		// supprimer elements de la liste
		String[] element = {"b", "d"};
		String[] resultat = {"a", "c", "e"};
		for (int i = 0; i < element.length; i++) {
			lT.suplisT(element[i]);
		}
		// Verification
		verifie(lT, resultat);
	}

	/**
	 * Test supprimer elements d'une liste triee vide
	 */
	public void test_08_suplisT_EmptyList() {
		ListeTriee lT = new ListeTriee(new ListeProf());

		// supprimer elements de la liste
		String[] element = {"a", "b", "c"};
		String[] resultat = {};
		for (int i = 0; i < element.length; i++) {
			lT.suplisT(element[i]);
		}

		// Verification
		verifie(lT, resultat);
	}

	/**
	 * Test suppression d'elements non presents dans une liste triee
	 */
	public void test_09_suplisT_ElementNotPresent() {
		ListeTriee lT = new ListeTriee(new ListeProf());

		// ajouter elements a la liste
		String[] mots = {"a", "b", "c"};
		for (int i = 0; i < mots.length; i++) {
			lT.adjlisT(mots[i]);
		}

		// supprimer elements de la liste qui ne sont pas presents
		String[] element = {"d", "e"};
		String[] resultat = {"a", "b", "c"};
		for (int i = 0; i < element.length; i++) {
			lT.suplisT(element[i]);
		}

		// Verification
		verifie(lT, resultat);
	}
}
