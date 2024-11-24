//@author: Daiane Tararam
//O código está documentado de acordo com o que eu fiz
package model.estrutura;

public class No {
	// Atribuição de caracteres 
	private char letra;
	private No esquerda;
	private No direita;
	
	//Criei uma classe construtora
	public No(char letra) {
		this.letra = letra;
		this.esquerda = null;
		this.direita = null;
	}
	
	// Adicionei os métodos getters e setters
	//Getters -> É para leitura de dados
	//Setters -> É para escrever dados
	
	public char getLetra() {
		return letra;
	}
	
	public void setLetra(char letra) {
		this.letra = letra;
	}
	// Pense na esquerda como o menor valor
	public No getEsquerda() {
		return esquerda;
	}
	
	public void setEsquerda( No esquerda) {
		this.esquerda = esquerda;
	}
	// Pense na direita como o maior valor
	public No getDireita() {
		return direita;
	}
	
	public void setDireita(No direita) {
		this.direita = direita;
	}
	//Foi sobrescrito o valor de letra para retorna imprimir o dado de letra e não o seu 
	//endereço de memória
	@Override
	public String toString() {
		//String.valueOf() -> converte o valor de letra para uma String
		return String.valueOf(letra);
	}

		
}
