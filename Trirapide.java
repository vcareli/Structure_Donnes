public class Trirapide {
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

	public static int Partition(int[] tab, int p, int r) {
		int x = tab[r];
		int i = p - 1;
		for (int j = p; j < r; j++){
			if (tab[j] <= x){
				i++;
				System.out.println("troca " + tab[i] + " por " + tab[j]);
				Permut(tab, i, j);
			}
		}
		Permut(tab, i + 1, r);
		return i + 1;
	}

	public static void Tri_rapide(int[] tab, int p, int r) {
		int q;
		if (p < r){
			q = Partition(tab, p, r);
			Tri_rapide(tab, p, q - 1);
			Tri_rapide(tab, q + 1, r);
		}
	}

	public static void main(String[] args) {
		int tableau[] = {21, 64, 33, 16, 17, 99, 14, 12, 18, 55};
		System.out.println("Tableau initial:");
		Afficher_tableau(tableau);
		System.out.println();
		Tri_rapide(tableau, 0, tableau.length - 1);
		System.out.println();
		System.out.println("Tableau final:");
		Afficher_tableau(tableau);
	}
}
