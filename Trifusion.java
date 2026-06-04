public class Trifusion {
	public static void Afficher_tableau(int tab[]) {
		for(int i = 0; i < tab.length; ++i) {
			System.out.print(tab[i]);
			if (i < tab.length - 1) {
				System.out.print(" - ");
			}
		}
		System.out.println();
	}

	public static void Fusion(int tab[], int p, int q, int r) {
		int aux1 = q - p + 1;
		int aux2 = r - q;
		int i, j, k;
		int[] tab1 = new int[aux1 + 1];
		int[] tab2 = new int[aux2 + 1];
		for (i = 0; i < aux1; i++){
			tab1[i] = tab[p + i];
		}
		for (j = 0; j < aux2; j++){
			tab2[j] = tab[q + j + 1];
		}
		tab1[aux1] = Integer.MAX_VALUE;
		tab2[aux2] = Integer.MAX_VALUE;
		i = 0;
		j = 0;
		for (k = p; k <= r; k++){
			if (tab1[i] <= tab2[j]){
				tab[k] = tab1[i];
				i++;
			}else{
				tab[k] = tab2[j];
				j++;
			}
		}
	}

	public static void Tri_fusion(int tabl[], int p, int r) {
		int q;
		if (p < r){
			q = (p + r)/2;
			Tri_fusion(tabl, p, q);
			Tri_fusion(tabl, q + 1, r);
			Fusion(tabl, p, q, r);
		}
	}
	public static void main(String[] args) {
		int[] tableau = {322, 324, 0, 5, 343, 21, 34, 20, 546, 523, 43, 658, 832, 4, 234, 435, 5476, 769678, 423, 455, 234, 2};
		System.out.println("Tableau initial");
		Afficher_tableau(tableau);
		Tri_fusion(tableau, 0, (tableau.length - 1));
		System.out.println("Tableau final");
		Afficher_tableau(tableau);
	}
}
