/**
 * Test removing elements from the sorted list.
 */
public void test_07_suplisT() {
    ListeTriee lT = new ListeTriee(new ListeProf());

    // Add elements to the list
    String[] mots = {"a", "b", "c", "d", "e"};
    for (int i = 0; i < mots.length; i++) {
        lT.adjlisT(mots[i]);
    }

    // Remove elements from the list
    String[] removeElements = {"b", "d"};
    String[] reponse = {"a", "c", "e"};
    for (int i = 0; i < removeElements.length; i++) {
        lT.suplisT(removeElements[i]);
    }

    // Verification
    verifie(lT, reponse);
}

/**
 * Test removing elements from the sorted list when the list is empty.
 */
public void test_08_suplisT_EmptyList() {
    ListeTriee lT = new ListeTriee(new ListeProf());

    // Remove elements from the empty list
    String[] removeElements = {"a", "b", "c"};
    String[] reponse = {};
    for (int i = 0; i < removeElements.length; i++) {
        lT.suplisT(removeElements[i]);
    }

    // Verification
    verifie(lT, reponse);
}

/**
 * Test removing elements from the sorted list when the element to remove is not present in the list.
 */
public void test_09_suplisT_ElementNotPresent() {
    ListeTriee lT = new ListeTriee(new ListeProf());

    // Add elements to the list
    String[] mots = {"a", "b", "c"};
    for (int i = 0; i < mots.length; i++) {
        lT.adjlisT(mots[i]);
    }

    // Remove elements not present in the list
    String[] removeElements = {"d", "e"};
    String[] reponse = {"a", "b", "c"};
    for (int i = 0; i < removeElements.length; i++) {
        lT.suplisT(removeElements[i]);
    }

    // Verification
    verifie(lT, reponse);
}