public class Triinsert {
	public static void Afficher_tableau(int tab[]) {
		for(int i = 0; i < tab.length; ++i) {
			System.out.print(tab[i]);
			if (i < tab.length - 1) {
				System.out.print(" - ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int tableau[] = {322, 324, 0, 5, 343, 21, 34, 20, 546, 523, 43, 658, 832, 4, 234, 435, 5476, 769678, 423, 455, 234, 2};
		System.out.println("Tableau initial:");
		Afficher_tableau(tableau);
		for(int j = 1; j < tableau.length; ++j) {
			int cle = tableau[j];
			int i;
			for(i = j - 1; i >= 0 && tableau[i] > cle; --i) {
				tableau[i + 1] = tableau[i];
			}
			tableau[i + 1] = cle;
		}
		System.out.println("Tableau final:");
		Afficher_tableau(tableau);
	}
}
