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

    LectureFichier lf = new LectureFichier("noms10000.txt");
    String[] noms = lf.lireFichier();

    String[] type = {"ListeChainee", "ListeChaineePlacesLibres", "ListeContigue"};
    String[] operation = {"ajout", "suppression"};
    String[] emplacement = {"debut", "fin"};

    long duree[] = new long[12];

    for(int h = 0; h < 100; h++ ){
        ListeChainee lc = new ListeChainee(10022);
        ListeChaineePlacesLibres l2 = new ListeChaineePlacesLibres(10022);
        ListeContigue l3 = new ListeContigue(10022);

        ListeTriee[] listes = {new ListeTriee(lc), new ListeTriee(l2), new ListeTriee(l3)};
        // ajouter les noms dans les listes
        for (int i = 0; i < listes.length; i++) {
            for (int j = 0; j < noms.length; j++) {
                listes[i].adjlisT(noms[j]);        
            }
        }
        
        // tester les listes en ajoutant et supprimant des nomsœ
        for (int i = 0; i < 12; i++) {
            // ==========Mesure ListeChainee==========Mesure ListeChaineePlaceLibres==========Mesure ListeContigues==========
            int X = i < 6 ? i%3 : (i-6)%3;
            int Y = i < 6 ? 0 : 1;
            int Z = i%6 < 3 ? 0 : 1;
            // si i < 6 alors ajouter sinon supprimer
            // si i est pair alors element de debut sinon element de fin
            // 1)
            //Debut chronometre
            long date_debut = System.nanoTime();
            //Action à mesurer
            for (int j = 0; j < ELEMENTS_DE_DEBUT.length; j++) {            
                if(Z == 0){
                    if ((Y == 0)) listes[X].adjlisT(ELEMENTS_DE_DEBUT[j]);
                    else listes[X].suplisT(ELEMENTS_DE_DEBUT[j]);                
                }else{
                    if (Y == 0) listes[X].adjlisT(ELEMENTS_DE_FIN[j]);
                    else listes[X].suplisT(ELEMENTS_DE_FIN[j]);
                }
            }
            //Fin chronometre
            long date_fin = System.nanoTime();
            duree[i] += (date_fin - date_debut);
        }
    }
    for (int i = 0; i < 12; i++) {
        int X = i < 6 ? i%3 : (i-6)%3;
        int Y = i < 6 ? 0 : 1;
        int Z = i%6 < 3 ? 0 : 1;
        fichier.ecrireLigne(type[X]+";"+operation[Y]+";"+emplacement[Z]+";"+duree[i]/100);
    }
    fichier.fermerFichier();
    }
}


//Q9) La methode cherche si l'element existe dans la liste.
// Si l'élément n'est pas trouvé, la boucle se terminera normalement sans effectuer de suppression.
// Ce qui prends le plus de temps c'est le parcours et non la suppression. cela prendra donc autant de temps si l'element existe ou non.
//