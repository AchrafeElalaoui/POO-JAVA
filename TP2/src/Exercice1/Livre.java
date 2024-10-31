package Exercice1;

public class Livre {
        private int ISBN ;
        private Auteur auteur;
        private String titre;
        public Livre(int ISBN, Auteur auteur, String titre) {
            this.ISBN = ISBN;
            this.auteur = auteur;
            this.titre = titre;
        }
        public void affiche() {
            System.out.println("ISBN: " + ISBN);
            System.out.println("titre: " + titre);
            System.out.println();
            auteur.affiche();
            System.out.println();
        }
}
