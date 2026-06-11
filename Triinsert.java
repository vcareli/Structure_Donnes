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
		int tableau[] = {21, 64, 33, 16, 17, 99, 14, 12, 18, 55};
		System.out.println("Tableau initial:");
		Afficher_tableau(tableau);
		System.out.println();
		for(int j = 1; j < tableau.length; ++j) {
			int cle = tableau[j];
			int i;
			for(i = j - 1; i >= 0 && tableau[i] > cle; --i) {
				System.out.println("troca " + tableau[i + 1] + " por " + tableau[i]);
				tableau[i + 1] = tableau[i];
			}
			tableau[i + 1] = cle;
		}
		System.out.println();
		System.out.println("Tableau final:");
		Afficher_tableau(tableau);
	}
}
