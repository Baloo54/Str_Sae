/**
 * Classe ListeTriee
 * @author Étienne André
 * @since 2021-11-12
 *
 */



public class ListeTriee{

    // Attribut de liste sous-jacente
    private Liste liste;
    
    public ListeTriee(Liste listevide){
	// Affectation de la liste vide à l'attribut privé
	liste = listevide;
    }
    
    /**
     * retourne la premiere place de la liste
     * @return tete de liste
     */
    public int tete(){
        return liste.tete();
    }
	
    /**
     * permet de connaitre la place suivante dans la liste
     * @param p place en cours
     * @return place derriere p dans la liste
     */
    public int suc(int p){
        return liste.suc(p);
    }
    
    /**
     * retourne la valeur associee a la place p
     * @param p place de la liste
     * @return la valeur associee  p
     */
    public String val(int p){
        return liste.val(p);
    }
 
    /**
     * indique si la place p est a la fin de la liste ou non
     * @param p place de la liste
     * @return vrai si p est a la fin de la liste, faux sinon
     */   
    public boolean finliste(int p){
        return liste.finliste(p);
    }
	
    public void adjlisT(String chaine) {
        int p = liste.tete();
        boolean insere = false;
        int pPre = -1;
        while (!insere && !liste.finliste(p)) {
            if (liste.val(p).compareTo(chaine) > 0) {
                if (p == liste.tete()) {
                    liste.adjtlis(chaine);
                } else {
                    liste.adjlis(pPre, chaine);
                }
                insere = true;
            } else {
                pPre = p;
                p = liste.suc(p);
            }
        }
        if (!insere) {
            liste.adjlis(pPre, chaine);
        }
    }
	
    /**
     * permet de supprimer un element d'une liste. Supprime le premier element dont la valeur est egale a "chaine" ; ne fait rien si "chaine" n'appartient pas a la liste.
     * @param chaine l'element a supprimer 
     */
    public void suplisT(String chaine){
        int p = liste.tete();
        boolean trouve = false;
        int pPre = -1;
        while (!trouve && !liste.finliste(p)) {
            if (liste.val(p).equals(chaine)) {
                trouve = true;
            } else {
                pPre = p;
                p = liste.suc(p);
            }
        }
        if (trouve) {
            if (p == liste.tete()) {
                liste.tete();
            } else {
                liste.suplis(pPre);
            }
        }
    }
		
    public String toString(){
	return liste.toString();
    }
}
