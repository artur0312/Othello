public class Joueur {
	private String nom;
	private int points = 2;
	private int id;

	public Joueur(String nom, int id) {
		this.nom = nom;
		this.id = id;
	}

	// Retourne le nom du joueur
	public String getNom() {
		return nom;
	}

	// Retourne le nombre actuel de points du joueur
	public int getPoints() {
		return points;
	}

	public int getId() {
		return id;
	}

	public void addPoints(int val) {
		points += val;
	}

	// Represent un coup

	public void coup(Plateau tab, int ligne, int colonne, Joueur adversaire) {

		int x = 0;
		int y = 0;
		this.points++;
		int compte = 0;
		// bas
		y = ligne + 1;
		while (tab.getCase(y, colonne) == adversaire.getId()) {
			y++;
		}
		if (tab.getCase(y, colonne) == this.id) {
			while (y > ligne) {
				y--;
				tab.changeCase(y, colonne, this.id);
				compte++;
			}
		}

		// haut
		y = ligne - 1;
		while (tab.getCase(y, colonne) == adversaire.getId()) {
			y--;
		}
		if (tab.getCase(y, colonne) == this.id) {
			for (int j = ligne; j > y; j--) {
				tab.changeCase(j, colonne, this.id);
				compte++;
			}
		}

		// gauche
		x = colonne - 1;
		while (tab.getCase(ligne, x) == adversaire.getId()) {
			x--;
		}
		if (tab.getCase(ligne, x) == this.id) {
			for (int j = colonne; j > x; j--) {
				tab.changeCase(ligne, j, this.id);
				compte++;
			}
		}

		// droite
		x = colonne + 1;

		while (tab.getCase(ligne, x) == adversaire.getId()) {
			x++;
		}
		if (tab.getCase(ligne, x) == this.id) {
			for (int j = colonne; j < x; j++) {
				tab.changeCase(ligne, j, this.id);
				compte++;
			}
		}

		// diagonale haut/droite
		x = colonne + 1;
		y = ligne - 1;
		while (tab.getCase(y, x) == adversaire.getId()) {
			x++;
			y--;
		}
		if (tab.getCase(y, x) == this.id) {
			while (x != colonne) {
				y++;
				x--;
				tab.changeCase(y, x, this.id);
				compte++;
			}
		}

		// diagonale haut / gauche
		x = colonne - 1;
		y = ligne - 1;
		while (tab.getCase(y, x) == adversaire.getId()) {
			x--;
			y--;
		}
		if (tab.getCase(y, x) == this.id) {
			while (x != colonne) {
				y++;
				x++;
				tab.changeCase(y, x, this.id);
				compte++;
			}
		}

		// diagonale bas / droite
		x = colonne + 1;
		y = ligne + 1;
		while (tab.getCase(y, x) == adversaire.getId()) {
			x++;
			y++;
		}
		if (tab.getCase(y, x) == this.id) {
			while (x != colonne) {
				y--;
				x--;
				tab.changeCase(y, x, this.id);
				compte++;
			}
		}

		// diagonale bas / gauche
		x = colonne - 1;
		y = ligne + 1;
		while (tab.getCase(y, x) == adversaire.getId()) {
			x--;
			y++;
		}
		if (tab.getCase(y, x) == this.id) {
			while (x != colonne) {
				y--;
				x++;
				tab.changeCase(y, x, this.id);
				compte++;
			}
		}

		this.points += compte;
		adversaire.addPoints(-compte);
		System.out.println(compte);

	}

	public boolean existeCoup(Plateau jeu) {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				if (jeu.coupLegal(i, j, this.id)) {
					return true;
				}
			}
		}
		return false;
	}

	public void calculatePoints(Plateau jeu) {
		this.points = 0;
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				if (jeu.getCase(i, j) == this.id) {
					this.points++;
				}
			}
		}
	}
}
