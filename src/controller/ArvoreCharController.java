//@author: Daiane Tararam
//O código está documentado de acordo com o que eu fiz
package controller;
import model.estrutura.ArvoreChar;

public class ArvoreCharController {
	//Construtor 
	public ArvoreCharController(){
		super();
	}
	//Método para testar o código
	public String teste() {
		ArvoreChar tree = new ArvoreChar();
		tree.inserir('l');
		tree.inserir('c');
		tree.inserir('k');
		tree.inserir('o');
		tree.inserir('a');
		tree.inserir('z');
				
		//tree.remover('z');
		return tree.toString();
		
	}
}
