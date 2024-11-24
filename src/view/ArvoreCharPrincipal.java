//@author: Daiane Tararam
//O código está documentado de acordo com o que eu fiz
package view;
import controller.ArvoreCharController;

public class ArvoreCharPrincipal {

	public static void main(String[] args) {
		//fiz a instância da minha classe de controle
		ArvoreCharController controller = new ArvoreCharController();
		//adicionei um try{}catch(){ para caso dê erro
		try {
			String resultado = controller.teste();
			System.out.println("O resultado em ordem é: " + resultado);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
