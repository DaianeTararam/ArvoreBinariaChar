/*@author: Daiane Tararam
O código está documentado de acordo com o que eu fiz

Criei uma Arvore Binária de busca para caracteres
Porém estou apenas adicionando e removendo nós (valores)
*/
package model.estrutura;

import model.estrutura.No;

public class ArvoreChar {
	private No raiz;
	
	// Aqui está o meu método construtor
	public ArvoreChar() {
		this.raiz = null;
	}
	
	//Este método insere um valor raiz e chama outro método para inserção de um novo nó
	public void inserir(char letra) {
		No atual = new No(letra);
		if (raiz == null) {
			this.raiz = atual;
		}else {
			// Chamei o método para inserir um novo nó e 
			// enviei parametros como a raiz que já tenho e meu no com valor atual
			inserirNo(raiz, atual);
		}
	}
	
	//Aqui está o meu método para inserir um novo nó
	public void inserirNo(No raiz, No atual) { 
		// Se a minha letra atual for > que a minha letra que está na raiz
		if (atual.getLetra() > raiz.getLetra()) {
			//Se não tiver valor a direita do meu nó -> null
			if(raiz.getDireita() == null) {
				//Vou escrever o valor do meu nó atual a direita da raiz -> 'letra'
				raiz.setDireita(atual);
			//caso contrário
			}else {
				//chamo recursivamente o meu método inserirNo e a minha "raiz" passa a ser o da direita
				inserirNo(raiz.getDireita(), atual);
			}
		//Repito todo o processo acima, porém com a esquerda	
		}else if (atual.getLetra() < raiz.getLetra()) {
			if(raiz.getEsquerda() == null) {
				raiz.setEsquerda(atual);
			}else {
				inserirNo(raiz.getEsquerda(), atual);
			}
		}
	}
	
	// Método remover
	public boolean remover(char letra) {
		//Caso a raiz seja vazia, não terá como remover um valor
		if(this.raiz == null) return false;
		// vai atualizar a raiz com o retorno do método recursivo removerNo()
		this.raiz = removerNo(this.raiz, letra);
		// A remoção foi bem sucedida
		return true;
	}
	
	// Método recursivo para removerNo
	public No removerNo(No atual, char letra) {
		if(atual == null) return null;
		//Se a minha letra na qual recebi for menor que o nó raiz
		if(letra < atual.getLetra()) {
			//O meu atual da <- esquerda receberá o valor da esquerda do atual
			atual.setEsquerda(removerNo(atual.getEsquerda(), letra));
		//Caso seja maior que o nó raiz
		}else if (letra > atual.getLetra()) {
			//O meu atual da -> direita receberá o valor da direita do atual 
			atual.setDireita(removerNo(atual.getDireita(), letra));
		}else {
			//Se a esquerda e direita do atual for vazia não retornará valor
			if (atual.getEsquerda() == null && atual.getDireita() == null) {
				return null;
			}
			if(atual.getEsquerda() == null) {
				//O nó só tem filho a direita
				return atual.getDireita();
			}
			if(atual.getDireita() == null) {
				//O nó só tem filho a esquerda
				return atual.getEsquerda();
			}
			//Crio um novo nó para encontrar o menor nó, com isso passo o da direita que é maior que as referencias da esquerda
			No sucessor = encontrarMenor(atual.getDireita());
			//O meu atual será o valor do sucessor
			atual.setLetra(sucessor.getLetra());
			// Aqui ocorre a remoção do no sucessor 
			atual.setDireita(removerNo(atual.getDireita(), sucessor.getLetra()));
		}
		//retornará o nó atualizado
		return atual;
	}
	
	//o método para encontrar o menor nó 
	public No encontrarMenor(No atual) {
		while(atual.getEsquerda() != null) {
			atual = atual.getEsquerda();
		}
		return atual;
	}
	
	// Este método irá imprimir a arvore em ordem 
	public void ordem(No no, StringBuilder builder){
		if (no == null) return;
		//é um método recursivo
		//Vou para toda a esquerda
		ordem(no.getEsquerda(), builder);
		// começo a adicionar os meus nós 
		builder.append(no.getLetra());
		builder.append(" ");
		//vou para toda a minha direita
		ordem(no.getDireita(), builder);
		//Paro a recursão quando o valor for null
	}
	
		
	@Override
	public String toString() {
		if (this.raiz == null) return "[]";  
        StringBuilder builder = new StringBuilder();
        ordem(this.raiz, builder);
        return builder.toString().trim();
	}
}
