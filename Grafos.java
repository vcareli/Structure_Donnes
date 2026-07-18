//Grafos
import java.util.*;

public class Grafos {
	public static void main(String[] args){
		Grafo modeloGrafo = new Grafo();
		Vertice v1 = new Vertice("A");
		Vertice v2 = new Vertice("B");
		Vertice v3 = new Vertice("C");
		modeloGrafo.adicionarVertice(v1);
		modeloGrafo.adicionarVertice(v2);
		modeloGrafo.adicionarVertice(v3);
		modeloGrafo.conectar(v1, v2);
		modeloGrafo.conectar(v1, v3);
		modeloGrafo.exibirGrafo();
		//modeloGrafo.bfs(v1);
		System.out.println();
		if (modeloGrafo.vizinhosYesNo(v1, v2)) System.out.println("A e B sao amigos");
		else System.out.println("A e B nao sao amigos");
		if (modeloGrafo.vizinhosYesNo(v1, v3)) System.out.println("A e C sao amigos");
		else System.out.println("A e C nao sao amigos");
		if (modeloGrafo.vizinhosYesNo(v2, v3)) System.out.println("B e C sao amigos");
		else System.out.println("B e C nao sao amigos");
		System.out.println();
		modeloGrafo.bfs(v2);
		System.out.println("Distancia de B ate A: " + v1.distancia);
		System.out.println("Predecessor de A: " + (v1.pred != null ? v1.pred.nome : "Nenhum"));
		System.out.println();
		modeloGrafo.bfs(v3);
		System.out.println("Distancia de C ate A: " + v1.distancia);
		System.out.println("Predecessor de B: " + (v3.pred != null ? v3.pred.nome : "Nenhum"));
	}
}
	
class Grafo{
	ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	HashMap<Vertice, ArrayList<Vertice>> vizinhos = new HashMap<Vertice, ArrayList<Vertice>>();
	
//Busca em Largura no grafo
	public void bfs(Vertice start){
		Queue<Vertice> fila = new LinkedList<Vertice>();
		fila.add(start);
		start.cor = 'C';
		start.distancia = 0;
		while (!fila.isEmpty()){
			Vertice u = fila.poll();
			for (Vertice v : vizinhos.get(u)) {
				if (v.cor == 'B'){
					v.cor = 'C';
					v.distancia = 1 + u.distancia;
					fila.add(v);
					v.pred = u;
				}
			}
			u.cor = 'P';
		}
	}

//Adiciona um ponto no grafo
	public void adicionarVertice(Vertice vert){
		vertices.add(vert);
		vizinhos.put(vert, new ArrayList<Vertice>());
	}

//Conecta dois pontos no grafo apos a adiçao dos mesmos
	public void conectar(Vertice vertA, Vertice vertB){
		ArrayList<Vertice> vizinhancaA = null;
		ArrayList<Vertice> vizinhancaB = null;
		if ((vizinhancaA = vizinhos.get(vertA)) != null && (vizinhancaB = vizinhos.get(vertB)) != null){
			vizinhancaA.add(vertB);
			vizinhancaB.add(vertA);
		}
	}

//Exibe o grafo com suas conexoes
	public void exibirGrafo() {
		ArrayList<Vertice> vizinhoA = null;
		for (Vertice v : vertices) {
			vizinhoA = vizinhos.get(v);
			System.out.println(v.nome + "--> " + vizinhoA);
		}
	}

//Veririfca se dois pontos sao vizinhos
	public boolean vizinhosYesNo(Vertice vertA, Vertice vertB){
		if (vizinhos.containsKey(vertA) && vizinhos.containsKey(vertB)) {
			ArrayList<Vertice> vizinhoA = vizinhos.get(vertA);
			ArrayList<Vertice> vizinhoB = vizinhos.get(vertB);
			if (vizinhoA.contains(vertB) || vizinhoB.contains(vertA)) return true;
			return false;
		}
		return false;
	}
}

class Vertice {
	String nome;
	char cor;
	int distancia;
	Vertice pred;
	
//Construtor de um vertice com nome, cor, distancia
	Vertice(String nome) {
		this.nome = nome;
		this.cor = 'B';
		this.distancia = Integer.MAX_VALUE;
		this. pred = null;
	}
	
//Sobreescrever o metodo toString() para aparecer o nome do vertice
	@Override
	public String toString(){
		return nome.toString();
	}
}
