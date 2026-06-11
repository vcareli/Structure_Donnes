public class Triselection {
	public static void Afficher_tableau(int tab[]) {
		for(int i = 0; i < tab.length; ++i) {
			System.out.print(tab[i]);
			if (i < tab.length - 1) {
				System.out.print(" - ");
			}
		}
		System.out.println();
	}

	public static void Permut(int tab[], int x, int y) {
		int aux = tab[x];
		tab[x] = tab[y];
		tab[y] = aux;
   }
	public static void main(String[] args) {
		int tableau[] = {21, 64, 33, 16, 17, 99, 14, 12, 18, 55};
		System.out.println("Tableau initial:");
		Afficher_tableau(tableau);
		System.out.println();
		for(int i = 0; i < tableau.length; ++i) {
			int mini = i;
			for(int j = i + 1; j < tableau.length; ++j) {
				if (tableau[j] < tableau[mini]) {
					mini = j;
				}
			}
			if (mini > i) {
				System.out.println("troca " + tableau[mini] + " por " + tableau[i]);
				Permut(tableau, i, mini);
			}
		}
		System.out.println();
		System.out.println("Tableau final:");
		Afficher_tableau(tableau);
	}
}
