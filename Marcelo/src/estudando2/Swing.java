package estudando2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Swing extends JFrame {
    private JTextField nomeField;
    private JTextField emailField;
    private JTextField numeroField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton listButton;
    private JTable contatoTable;
    private DefaultTableModel tableModel;
    
    // Instância do DAO
    private ContatoDao contatoDao = new ContatoDao();

    public Swing() {
        // Configura o layout
        setTitle("Gerenciador de Contatos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Campos e botões
        
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(280, 20, 100, 25);
        add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(350, 20, 150, 25);
        add(idField);

        
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 20, 100, 25);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(120, 20, 150, 25);
        add(nomeField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 60, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(120, 60, 150, 25);
        add(emailField);

        JLabel numeroLabel = new JLabel("Número:");
        numeroLabel.setBounds(10, 100, 100, 25);
        add(numeroLabel);

        numeroField = new JTextField();
        numeroField.setBounds(120, 100, 150, 25);
        add(numeroField);

        addButton = new JButton("Adicionar");
        addButton.setBounds(10, 140, 100, 25);
        add(addButton);

        updateButton = new JButton("Atualizar");
        updateButton.setBounds(120, 140, 100, 25);
        add(updateButton);

        deleteButton = new JButton("Deletar");
        deleteButton.setBounds(230, 140, 100, 25);
        add(deleteButton);

        listButton = new JButton("Listar");
        listButton.setBounds(340, 140, 100, 25);
        add(listButton);

        // Configura a tabela
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "Email", "Número"}, 0);
        contatoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(contatoTable);
        scrollPane.setBounds(10, 180, 560, 180);
        add(scrollPane);


        // Adiciona listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                String numero = numeroField.getText();
                Contato contato = new Contato(nome, email, numero);
                contatoDao.inserir(contato);
                JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!");
            }
        });

        updateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Obter dados dos campos de texto
                int id = Integer.parseInt(idField.getText()); // Obtenha o ID do campo de texto
                String nome = nomeField.getText();
                String email = emailField.getText();
                String numero = numeroField.getText();

                // Criar o objeto Contato com os novos dados
                Contato contato = new Contato(id, nome, email, numero);

                // Chamar o método de atualização
                contatoDao.atualizar(contato);

                // Mostrar confirmação
                JOptionPane.showMessageDialog(null, "Contato atualizado com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID inválido. Por favor, insira um número válido.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar contato: " + ex.getMessage());
            }
        }
    });



        deleteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Obter o ID do campo de texto
                int id = Integer.parseInt(idField.getText());

                // Criar o objeto Contato com o ID
                Contato contato = new Contato(id, null, null, null);

                // Chamar o método de deleção
                contatoDao.deletar(contato);

                // Mostrar confirmação
                JOptionPane.showMessageDialog(null, "Contato deletado com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID inválido. Por favor, insira um número válido.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao deletar contato: " + ex.getMessage());
            }
        }
    });

        listButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Contato> contatos = contatoDao.listar(); // Método de listar contatos
            tableModel.setRowCount(0); // Limpa a tabela
            for (Contato contato : contatos) {
                tableModel.addRow(new Object[]{contato.getId(), contato.getNome(), contato.getEmail(), contato.getTelefone()});
            }
        }
    });

    }

    
}
