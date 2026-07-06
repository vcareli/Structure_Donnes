//Implementando tabela Hash
public class MesaHash {
	public No[] gaveta;

	public MesaHash() {
		this.gaveta = new No[10];
	}

	static class No {
		String chave;
		int valor;

		public No(String chave, int valor) {
        	this.chave = chave;
        	this.valor = valor;
		}
	}
	public int hash(String v) {
		return Math.abs(v.hashCode()) % 10;
	}

	public void inserir(String chave, int valor) {
		int indice = hash(chave);
		gaveta[indice] = new No(chave, valor);
	}

	public int consultar(String valor) {
		int i = hash(valor);
		return gaveta[i].valor;
	}

	public void remove(String valor) {
		gaveta[hash(valor)] = null;
	}

	public static void main(String[] args) {
		MesaHash tabela = new MesaHash();
		System.out.println("Inserir e consultar");
		tabela.inserir("Vinny", 7970);
		tabela.inserir("Deby", 1599);

		System.out.println("Telefone " + tabela.consultar("Deby"));
	}
}
