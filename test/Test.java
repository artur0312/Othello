public class Test {
	
	public static void main (String[] args) {
		
		// tests des méthodes de la classe Tableau
		
			// Création d'un plateau avec les 4 pions du début.
			Plateau jeu = new Plateau ();
			 
			// test de l'affichage du tableau vierge
			System.out.println("test de l'affichage du tableau vierge");
			jeu.affichePlateau();
			System.out.println();
			
			// test de la méthode changeCase
			System.out.println("test de la méthode changeCase, touts les pions devraient etre des ronds");
			jeu.changeCase(4,4,-1);
			jeu.changeCase(5,5,-1);
			jeu.affichePlateau();
			System.out.println();
			
			// Réinitialisation du plateau
			jeu.changeCase(4,4,1);
			jeu.changeCase(5,5,1);
			
			// test de la méthode getCase
			System.out.println("test de la méthode getCase, on devrait avoir un 1 au dessus et un -1 en dessous : ");
			System.out.println(jeu.getCase(4,4));
			System.out.println(jeu.getCase(4,5));
			
			
			
		// tests de la classe Joueur
		
			// Création de deux joueurs
			System.out.println(" Création du Joueur j1 nommé Nicolas et jouant les croix et de Guy qui joue les ronds: ");
			Joueur j1 = new Joueur("Nicolas",1);
			Joueur j2 = new Joueur("Guy",-1);
			
			//test de la méthode getNom 
			System.out.println("test de la méthode getNom ");
			System.out.println("On devrait afficher 'Nicolas' : "+j1.getNom());
			System.out.println();
			
			//test de la méthode getId
			System.out.println("test de la méthode getId");
			System.out.println("On devrait afficher '1': "+j1.getId());
			System.out.println();
			
			//test de la méthode getPoints
			System.out.println("test de la méthode getPoints");
			System.out.println("On devrait afficher '2': "+j1.getPoints());
			System.out.println();
			
			
			
			//test de la méthode coup
			System.out.println("test de la méthode coup ");
			jeu.affichePlateau();
			j1.calculatePoints(jeu);
			j2.calculatePoints(jeu);
			System.out.println("Nicolas devrait avoir 2 points : "+j1.getPoints()+"  /   Et Guy devrait avoir 2 points : "+j2.getPoints());
			j1.coup(jeu, 4,6,j2);
			jeu.affichePlateau();
			j1.calculatePoints(jeu);
			j2.calculatePoints(jeu);
			System.out.println("Nicolas devrait avoir 4 points : "+j1.getPoints()+"  /   Et Guy devrait avoir 1 point : "+j2.getPoints());
			j2.coup(jeu, 3,6,j1);
			jeu.affichePlateau();
			j1.calculatePoints(jeu);
			j2.calculatePoints(jeu);
			System.out.println("Nicolas devrait avoir 3 points : "+j1.getPoints()+"  /   Et Guy devrait avoir 3 points : "+j2.getPoints());
			System.out.println();
			System.out.println();
			System.out.println();
		
	}
}

