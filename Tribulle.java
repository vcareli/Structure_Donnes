public class Tribulle {
	public static void Afficher_tableau(int tab[]){
		for(int i = 0; i < tab.length; ++i) {
			System.out.print(tab[i]);
			if (i < tab.length - 1) {
				System.out.print(" - ");
			}
		}
		System.out.println();
	}

	public static void Permut(int tab[], int x, int y){
		int aux = tab[x];
		tab[x] = tab[y];
		tab[y] = aux;
	}
	public static void main(String[] args) {
		int tableau[] = {322, 324, 0, 5, 343, 21, 34, 20, 546, 523, 43, 658, 832, 4, 234, 435, 5476, 769678, 423, 455, 234, 2};
		System.out.println("Tableau initial:");
		Afficher_tableau(tableau);
		for(int i = 0; i < tableau.length; ++i) {
			for(int j = tableau.length - 1; j >= i + 1; --j) {
				if (tableau[j] < tableau[j - 1]) {
					Permut(tableau, j, j - 1);
				}
			}
		}
		System.out.println("Tableau final:");
		Afficher_tableau(tableau);
	}
}
