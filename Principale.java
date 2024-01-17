/**
 * Classe principale de la SAÉ
 * @author Étienne André Sergueï Lenglet
 * @since 2021-11-04
 *
 */


public class Principale{

    private static final String[] ELEMENTS_DE_DEBUT
	= {"ABITEBOUL", "ADLEMAN", "AL-KINDI", "ALUR", "BERNERS-LEE",
	"BOOLE", "BUCHI", "BUTLER", "CLARKE", "CURRY"};
    private static final String[] ELEMENTS_DE_FIN
	= {"RABIN", "RIVEST", "SHAMIR", "SIFAKIS", "TORVALDS",
	"TURING", "ULLMAN", "VALIANT", "WIRTH", "YAO"};
    
    // NOTE: pour fichier 10 000
    // 	private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABBADI", "ABERGEL", "ALIAS", "ALIOUI", "AKKUS", "ALAZARD",
    // "ALLA", "AIDARA", "ABRANTES", "AARAB"};
    // NOTE: pour fichier 1 000
    //private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABADIE", "ABDALLAH", "ABRAHAM", "ADAM", "AFONSO",
    // "ALBERT", "ALEXANDRE", "ALI", "ALIX", "ALLAIN"};
    // NOTE: pour fichier 10 000
    //private static final String[] ELEMENTS_DE_FIN_SUPPR
    // = {"WEIS", "ZANIN", "WERQUIN", "YAGOUBI", "WERNERT",
    // "WAWRZYNIAK", "ZULIANI", "ZAIRE", "WAVRANT", "VILLAR"}; //
    // NOTE: pour fichier 1 000
    //private static final String[] ELEMENTS_DE_FIN_SUPPR
    //= {"WEBER", "WEISS", "WINTERSTEIN", "WOLFF", "YANG",
    //"YILDIRIM", "YILDIZ", "YILMAZ", "ZIEGLER", "ZIMMERMANN"}; //
	
    // Type des listes, peut etre utile pour factoriser les tests
    private static final int CONTIGUE	       = 1;
    private static final int CHAINEE	       = 2;
    private static final int CHAINEE_PLIBRES   = 3;
	
    // Exemple d'utilisation de LectureFichier et remplissage d'une liste
    public static void remplir_liste(ListeTriee liste, String nom_fichier){
	LectureFichier lf = new LectureFichier(nom_fichier);
	// 		
	String[] liste_noms = lf.lireFichier();
	for (int i = 0; i < liste_noms.length; i++) {
	    liste.adjlisT(liste_noms[i]);
	}
    }
		
    public static void main(String [] args){
	System.out.println("Bienvenue !");

	//Exemple d'utilisation de la classe EcritureFichier
	EcritureFichier fichier = new EcritureFichier("resultats.csv");
	fichier.ouvrirFichier();
	fichier.ecrireLigne("liste;operation;emplacement;duree");
	fichier.fermerFichier();
    
    LectureFichier lf = new LectureFichier("noms10000.txt");
    ListeChainee lc = new ListeChainee(10000);
    ListeTriee lt = new ListeTriee(lc);
    String[] noms = lf.lireFichier();
    for (int i = 0; i < noms.length; i++) {
        lt.adjlisT(noms[i]);        
    }

    // ==========Mesure ListeChainee==========
    // 1)
    //Debut chronometre
    long date_debut = System.nanoTime();
    
    //Action à mesurer
    for (int i = 0; i < ELEMENTS_DE_DEBUT.length; i++) {
        lt.adjlisT(ELEMENTS_DE_DEBUT[i]);
    }
    //Fin chronometre
    long date_fin = System.nanoTime();
    long duree = date_fin - date_debut;

    // 2)
    //Debut chronometre
    long date_debut2 = System.nanoTime();

    //Action à mesurer
    for (int i = 0; i < ELEMENTS_DE_FIN.length; i++) {
        lt.adjlisT(ELEMENTS_DE_FIN[i]);
    }
    //Fin chronometre


    // ==========Mesure ListeChaineePlaceLibres==========
    //1)
    ListeChaineePlacesLibres l2 = new ListeChaineePlacesLibres(10000);
    ListeTriee lt2 = new ListeTriee(l2);
    for (int i = 0; i < noms.length; i++) {
        lt2.adjlisT(noms[i]);        
    }
    //Debut chronometre
    long date_debut3 = System.nanoTime();

    //Action à mesurer
    for (int i = 0; i < ELEMENTS_DE_DEBUT.length; i++) {
        lt2.adjlisT(ELEMENTS_DE_DEBUT[i]);
    }
    //Fin chronometre
    long date_fin3 = System.nanoTime();

    //2)
    //Debut chronometre
    long date_debut4 = System.nanoTime();

    //Action à mesurer
    for (int i = 0; i < ELEMENTS_DE_FIN.length; i++) {
        lt2.adjlisT(ELEMENTS_DE_FIN[i]);
    }
    //Fin chronometre
    long date_fin4 = System.nanoTime();

    // ==========Mesure ListeContigues==========
    //1)
    ListeContigue l3 = new ListeContigue(10000);
    ListeTriee lt3 = new ListeTriee(l3);
    for (int i = 0; i < noms.length; i++) {
        lt3.adjlisT(noms[i]);        
    }
    //Debut chronometre
    long date_debut5 = System.nanoTime();

    //Action à mesurer
    for (int i = 0; i < ELEMENTS_DE_DEBUT.length; i++) {
        lt3.adjlisT(ELEMENTS_DE_DEBUT[i]);
    }
    //Fin chronometre
    long date_fin5 = System.nanoTime();

    //2)
    //Debut chronometre
    long date_debut6 = System.nanoTime();

    //Action à mesurer
    for (int i = 0; i < ELEMENTS_DE_FIN.length; i++) {
        lt3.adjlisT(ELEMENTS_DE_FIN[i]);
    }
    //Fin chronometre
    long date_fin6 = System.nanoTime();
    }
}


//Q9) La methode cherche si l'element existe dans la liste.
// Si l'élément n'est pas trouvé, la boucle se terminera normalement sans effectuer de suppression.
// Ce qui prends le plus de temps c'est le parcours et non la suppression. cela prendra donc autant de temps si l'element existe ou non.
//