public class Plateau {

	// Atributs

	private int[][] tab;

	// constructeur
	public Plateau() {
		tab = new int[10][10];
		tab[4][4] = 1;
		tab[4][5] = -1;
		tab[5][4] = -1;
		tab[5][5] = 1;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 0 || i == 9 || j == 0 || j == 9) {
					tab[i][j] = 2;
				}
			}
		}
	}

	// getteur/ setteur

	public void changeCase(int ligne, int colonne, int a) {
		tab[ligne][colonne] = a;
	}

	public int getCase(int ligne, int colonne) {
		return tab[ligne][colonne];
	}



	public void affichePlateau() {
		System.out.println("     1  2  3  4  5  6  7  8 ");
		for (int i = 0; i < this.tab.length; i++) {
			for (int j = 0; j < this.tab.length; j++) {
				if (getCase(i, j) == 1) {
					System.out.print(" X ");
				}
				if (getCase(i, j) == -1) {
					System.out.print(" O ");
				}
				if (getCase(i, j) == 0) {
					System.out.print(" . ");
				}
				if (i == 0 && j == 0 || i == 0 && j == 9 || i == 9 && j == 0 || i == 9 && j == 9) {
					System.out.print("   ");
				} else if (i == 0 || i == this.tab.length - 1) {
					System.out.print("  _");
				} else if (j == 0 && i > 0) {
					System.out.print(i + " | ");
				} else if (j == this.tab.length - 1) {
					System.out.print(" | ");
				}

			}
			System.out.println();
			System.out.println();
		}
	}

	// cette methode détermine si ce coup est légal ( true( ou pas (false)
	// a est égal a 1 ou -1,si la case est pleine, et 0 si elle est vide
	public boolean coupLegal(int x, int y, int a) {

		if (tab[x - 1][y - 1] == 0 && tab[x][y - 1] == 0 && tab[x + 1][y - 1] == 0 && tab[x + 1][y] == 0
				&& tab[x + 1][y + 1] == 0 && tab[x][y + 1] == 0 && tab[x - 1][y + 1] == 0 && tab[x - 1][y] == 0) {
			return false;
		} else if (tab[x][y] != 0) {
			return false;
		}

		// 4 directions horizontales & verticales
		int i = 0;
		int j = 0;
		boolean valable = false;
		// droite
		i = x;
		j = y + 1;
		if (!valable) {
			while (tab[i][j] == -a) {
				j++;
			}
			if (tab[i][j] == a && j != y + 1) {
				valable = true;

			}
		}

		// gauche
		if (!valable) {
			i = x;
			j = y - 1;
			while (tab[i][j] == -a) {
				j--;
			}
			if (tab[i][j] == a && j != y - 1) {
				valable = true;

			}

		}

		// bas
		if (!valable) {
			i = x + 1;
			j = y;
			while (tab[i][j] == -a) {
				i++;
			}
			if (tab[i][j] == a && i != x + 1) {
				valable = true;

			}
		}

		// haut
		if (!valable) {
			i = x - 1;
			j = y;

			while (tab[i][j] == -a) {
				i--;
			}
			if (tab[i][j] == a && i != x - 1) {
				valable = true;

			}
		}
		// 4 directions diagonales

		// bas / droite
		if (!valable) {
			i = x + 1;
			j = y + 1;
			while (tab[i][j] == -a) {
				j++;
				i++;
			}
			if (tab[i][j] == a && i != x + 1) {
				valable = true;

			}
		}

		// haut / droite
		if (!valable) {
			i = x - 1;
			j = y + 1;
			while (tab[i][j] == -a) {
				j++;
				i--;
			}
			if (tab[i][j] == a && i != x - 1) {
				valable = true;

			}
		}

		// haut / gauche
		if (!valable) {
			i = x - 1;
			j = y - 1;

			while (tab[i][j] == -a) {
				j--;
				i--;
			}
			if (tab[i][j] == a && i != x - 1) {
				valable = true;

			}
		}

		// bas / gauche
		if (!valable) {
			i = x + 1;
			j = y - 1;
			while (tab[i][j] == -a) {
				j--;
				i++;
			}
			if (tab[i][j] == a && i != x + 1) {
				valable = true;

			}
		}

		return valable;

	}


}
