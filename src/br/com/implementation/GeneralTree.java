package br.com.implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class GeneralTree {
	private Node raiz;

	private static class Node {
		String Elem;
		Node Pai;
		List<Node> Filhos;

		public Node(String valor) {
			Elem = valor;
			Pai = null;
			Filhos = new ArrayList<>();
		}
	}

	public GeneralTree(String elem) {
		raiz = new Node(elem);
	}

	public void inserir(String elem, String paiStr) {
		Node pai = pesquisa(paiStr, raiz);
		if (pai != null) {
			Node novo = new Node(elem);
			novo.Pai = pai;
			pai.Filhos.add(novo);
		}
	}

	private Node pesquisa(String e, Node r) {
		if (r.Elem.equals(e))
			return r;
		for (Node f : r.Filhos) {
			Node aux = pesquisa(e, f);
			if (aux != null)
				return aux;
		}
		return null;
	}

	public void preordem() {
		preordem(raiz);
	}

	private void preordem(Node r) {
		System.out.print(r.Elem + " - ");
		for (Node f : r.Filhos) {
			preordem(f);
		}
	}

	public void largura() {
		Queue<Node> q = new LinkedList<>();

		q.add(raiz);
		while (!q.isEmpty()) {
			Node aux = q.remove();
			System.out.print(aux.Elem + " - ");
			for (Node f : aux.Filhos) {
				q.add(f);
			}
		}
	}

	public void mostrar(String string) {
		// TODO Auto-generated method stub
		
	}

	public List<String> primos(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> netos(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> ascendentes(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public String contarDescendentes(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
