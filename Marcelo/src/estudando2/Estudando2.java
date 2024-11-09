
package estudando2;


import java.util.List;
import java.util.Scanner;


public class Estudando2 {


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ContatoDao contatoDao = new ContatoDao();
        System.out.println("Deseja executar essa aplicacao no Console ou em interface grafica Swing?");
        System.out.println("[1] Console | [2] Swing");
        int esc = scanner.nextInt();
        switch(esc){
            case 1:
                System.out.println("<Console> selecionado.");
                Console.menuPrincipal();
                break;
            case 2:
                System.out.println("<Swing> selecionado.");
                Swing app = new Swing();
                app.setVisible(true);
                break;
            default:
                System.out.println("Opcao invalida.");
                break;
        }
        /*System.out.println("\n\n-=Contatos atuais=-");
        List<Contato> contatos = contatoDao.listar();
        if(contatos != null){
            for (Contato contato : contatos){
                System.out.println("ID: " + contato.getId());
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Telefone: " + contato.getTelefone());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("-----------");
                
            } 
        } else {
                    System.out.println("Erro ao listar contatos");
                    }*/
        
    }
    
}
