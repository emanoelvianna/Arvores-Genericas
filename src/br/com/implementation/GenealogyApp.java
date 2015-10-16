package br.com.implementation;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class GenealogyApp {
	public static void main(String[] args) {
		GeneralTree arvore = readTree("ArvoreTeste_UTF8.txt");

		// conjunto inicial de casos de teste
		// complete-o para os m�todos n�o implementados

		System.out.println("\n2. Ascendentes de J�lia S01 A02");
		List<String> asc = arvore.ascendentes("J�lia S01 A02");
		for (String s : asc) {
			System.out.print(s + "  ");
		}
		System.out.println("\n---");

		System.out.println(
				"\n3. N�mero de descendentes de Mauro Paulo S01: " + arvore.contarDescendentes("Mauro Paulo S01"));
		System.out.println("\n---");

		System.out.println("\n4. Listar Filhos de ??? :    ????");
		System.out.println("\n---");

		System.out.println("\n5. Netos de Edmundo Ant�nio S01");
		List<String> netos = arvore.netos("Edmundo Ant�nio S01");
		for (String s : netos) {
			System.out.print(s + "  ");
		}
		System.out.println("\n---");

		System.out.println("\n6. Listar Tios de ??? :    ????");
		System.out.println("\n---");

		System.out.println("\n7. Primos de J�lia S01 A02");
		List<String> primos = arvore.primos("J�lia S01 A02");
		for (String s : primos) {
			System.out.print(s + "  ");
		}
		System.out.println("\n---");

		System.out.println("\nMostrar...");
		arvore.mostrar("AA");
		arvore.mostrar("Henrique Jo�o S01");

	}

	private static GeneralTree readTree(String arq) {

		GeneralTree arv = null;
		try {
			BufferedReader buff = new BufferedReader(new FileReader(arq));
			String line = null;
			try {
				line = buff.readLine();
				line = line.trim();
				arv = new GeneralTree(line);
				line = buff.readLine();

				while (line != null) {
					line = line.trim();
					String[] pessoas = line.split(" \\| ");
					for (int i = 1; i < pessoas.length; i++) {
						arv.inserir(pessoas[i], pessoas[0]);
					}
					line = buff.readLine();

				}
			} finally {
				buff.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arv;
	}
}
