
package estudando2;

import java.util.List;
import java.util.Scanner;

public class Console {

    static ContatoDao dao = new ContatoDao();

    public static void menuPrincipal() {
        Scanner esc = new Scanner(System.in);
        int user;

        System.out.println("-= Contatos =-\n");
        System.out.println("[1] Novo contato\n[2] Apagar contato\n[3] Atualizar contato\n[4] Listar contatos\n[5] Sair\n");
        System.out.println("Digite sua opcao: ");
        user = esc.nextInt();
        while (user != 5) {
            System.out.println("-= Contatos =-\n");
            System.out.println("[1] Novo contato\n[2] Apagar contato\n[3] Atualizar contato\n[4] Listar contatos\n[5] Sair\n");
            System.out.println("Digite sua opcao: ");
            user = esc.nextInt();
            switch (user) {
                case 1:
                    System.out.println("\n-= Novo Contato =-\n");
                    dao.inserir(receberContato());
                    System.out.println("Contato adicionado!");
                    ok();
                    break;

                case 2:
                    System.out.println("\n-= Apagar contato =-\n");
                    dao.deletar(receberContato());
                    System.out.println("Contato apagado!");
                    ok();
                    break;

                case 3:
                    System.out.println("\n-= Atualizar contato =-\n");
                    dao.atualizar(receberContato());
                    System.out.println("Contato atualizado!");
                    ok();
                    break;

                case 4:
                    System.out.println("\n Listar contatos =-\n");
                    listarContatos();
                    ok();

                    break;

                case 5:
                    System.out.println("\n\nFinalizando programa..");
                    ok();
                    break;

            }
            
        }

    }

    public static Contato receberContato() {
        String nome, email, telefone;
        Scanner texto = new Scanner(System.in);
        System.out.println("Nome: ");
        nome = texto.nextLine();
        System.out.println("Email: ");
        email = texto.nextLine();
        System.out.println("Telefone: ");
        telefone = texto.nextLine();
        Contato contato = new Contato(nome, email, telefone);
        return contato;

    }

    public static void listarContatos() {
        System.out.println("\n\n-=Contatos atuais=-");
        List<Contato> contatos = dao.listar();
        if (contatos != null) {
            for (Contato contato : contatos) {
                System.out.println("ID: " + contato.getId());
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Telefone: " + contato.getTelefone());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("-----------");

            }
        } else {
            System.out.println("Erro ao listar contatos");
        }
    }

    public static void ok() {
        Scanner esc = new Scanner(System.in);
        System.out.println("Digite enter para continuar");
        esc.next();
    }

}
