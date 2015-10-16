package br.com.implementation;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class GenealogyApp {

	public static void main(String[] args) {
		GeneralTree arvore = readTree("ArvoreTeste_UTF8.txt");

		// conjunto inicial de casos de teste
		// complete-o para os métodos não implementados

/*		System.out.println("\n2. Ascendentes de Júlia S01 A02");
		List<String> asc = arvore.ascendentes("Júlia S01 A02");
		for (String s : asc) {
			System.out.print(s + "  ");
		}
		System.out.println("\n---");
*/
		System.out.println("\n3. Número de descendentes de Mauro Paulo S01: "
				+ arvore.contarDescendentes("Mauro Paulo S01"));
		System.out.println("\n---");

		System.out.println("\n4. Listar Filhos de Mauro Paulo S01: "
				+ arvore.listarFilhos("Mauro Paulo S01"));
		System.out.println("\n---");

		 System.out.println("\n5. Netos de Edmundo Antônio S01"); List<String>
		  netos = arvore.netos("Edmundo Antônio S01"); 
		 for (String s : netos) {
			 System.out.print(s + "  "); 
		 } 
		 System.out.println("\n---");
		 
		 System.out.println("\n6. Listar Tios de Mauro Paulo S01: " +  arvore.tios("Mauro Paulo S01"));
		 System.out.println("\n---");
		   
		 System.out.println("\n7. Primos de Júlia S01 A02");
		 arvore.primos("Júlia S01 A02");
		 
		 /* 
		 System.out.println("\nMostrar..."); arvore.mostrar("AA");
		  arvore.mostrar("Henrique João S01");
		 */

	}

	private static GeneralTree readTree(String arq) {

		GeneralTree arv = null;
		try {

			BufferedReader buff = new BufferedReader(new InputStreamReader(
					new FileInputStream(arq), "UTF-8"));

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
