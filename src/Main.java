import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) {
		String nomJoueur1, nomJoueur2;
		Scanner sc1 = new Scanner(System.in);
		if (args.length == 0) {
			sc1 = new Scanner(System.in);
		} else if (args.length == 1) {
			File input = new File(args[0]);
			try {
				sc1 = new Scanner(input);
			} catch (FileNotFoundException e) {
				System.out.println("Erreur: Fichier non trouvee");
			}
		} else {
			System.out.println("Nombre d'arguments non reconnu.");
			return;
		}
		// Demande le nom des joueurs
		System.out.print("Joueur 1(noir): ");
		nomJoueur1 = sc1.nextLine();
		System.out.print("Joueur 2(blanc): ");
		nomJoueur2 = sc1.nextLine();

		// Cree les deux joueurs
		Joueur joueur1 = new Joueur(nomJoueur1, 1);
		Joueur joueur2 = new Joueur(nomJoueur2, -1);

		// Creer le tableau
		Plateau jeu = new Plateau();

		// Affiche le tableau du début du jeu
		System.out.println("C'est partie pour l'othello !!! C'est a " + joueur1.getNom() + " de commencer.");
		jeu.affichePlateau();
		int tour = 1;
		while (joueur1.existeCoup(jeu) || joueur2.existeCoup(jeu)) {
			// Controle qui est le prochaine a jouer
			// true:joueur1 false:joueur2
			int ligne, colonne;
			if (tour > 0 && joueur1.existeCoup(jeu)) {
				System.out.println("Tapez la ligne de votre coup");
				ligne = sc1.nextInt();
				System.out.println("Tapez la colonne de votre coup");
				colonne = sc1.nextInt();
				if (!jeu.coupLegal(ligne, colonne, joueur1.getId())) {
					System.out.println("Mouvement non valide. Vous devez réessayer:");
				} else {
					tour = -tour;
					joueur1.coup(jeu, ligne, colonne, joueur2);
					jeu.affichePlateau();
					System.out.println("bravo !! C'est au tour du joueur 2 de jouer. ");
				}

			} else {
				System.out.println("Tapez la ligne de votre coup");
				ligne = sc1.nextInt();
				System.out.println("Tapez la colonne de votre coup");
				colonne = sc1.nextInt();
				if (!jeu.coupLegal(ligne, colonne, joueur2.getId())) {
					System.out.println("Mouvement non valide. Vous devez réessayer:");
				} else {
					tour = -tour;
					joueur2.coup(jeu, ligne, colonne, joueur1);
					jeu.affichePlateau();
					System.out.println("bravo !! C'est au tour du joueur 1 de jouer. ");
				}
			}
			joueur1.calculatePoints(jeu);
			joueur2.calculatePoints(jeu);
		}
		System.out.println(" La partie est finie et voici les scores : ");
		System.out.println(joueur1.getNom() + " a " + joueur1.getPoints() + " points");
		System.out.println(joueur2.getNom() + " a " + joueur2.getPoints() + " points");
		if (joueur1.getPoints() > joueur2.getPoints()) {
			System.out.println("Bravo a toi " + joueur1.getNom() + ", tu as gagné !!!");
		} else if (joueur1.getPoints() < joueur2.getPoints()) {
			System.out.println("Bravo a toi " + joueur2.getNom() + ", tu as gagné !!!");
		} else {
			System.out.println("Bravo a tous les deux, c'est une égalité parfaite !!");
		}
	}
}
