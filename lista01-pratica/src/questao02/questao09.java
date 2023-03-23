package questao02;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class questao09 extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;
    
    private JTextField campoNome;
    private JLabel labelNome;
    private JButton botaoInserir;
    private static String databaseName = "banco1";
    private JLabel labelIdade_1;
    private JTextField campoIdade;
    private JTextField campoEmail;
    
    public questao09() {
        super("Exemplo JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(392, 150);
        
        JPanel painel = new JPanel();
        
        labelNome = new JLabel("Nome:");
        labelNome.setBounds(63, 9, 43, 14);
        campoNome = new JTextField(20);
        campoNome.setBounds(111, 6, 166, 20);
        botaoInserir = new JButton("Inserir");
        botaoInserir.setBounds(287, 77, 79, 23);
        botaoInserir.addActionListener(this);
        painel.setLayout(null);
        
        labelIdade_1 = new JLabel("Idade:");
        labelIdade_1.setBounds(63, 34, 55, 14);
        painel.add(labelIdade_1);
        
        painel.add(labelNome);
        painel.add(campoNome);
        painel.add(botaoInserir);
        
        getContentPane().add(painel);
        
        campoIdade = new JTextField(20);
        campoIdade.setBounds(111, 31, 166, 20);
        painel.add(campoIdade);
        
        campoEmail = new JTextField(20);
        campoEmail.setBounds(111, 59, 166, 20);
        painel.add(campoEmail);
        
        JLabel labelEmail_1_1 = new JLabel("E-mail:");
        labelEmail_1_1.setBounds(63, 62, 55, 14);
        painel.add(labelEmail_1_1);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new questao09();
            }
        });
    }
    
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() == botaoInserir) {
            String nome = campoNome.getText();
            String idade = campoIdade.getText();
            String email = campoEmail.getText();

            
            try {	
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/"+ databaseName +"?serverTimezone=UTC","root","aluno");
                String sql = "INSERT INTO tabela1 (nome, idade, email) VALUES (?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, nome);
                ps.setString(2, idade);
                ps.setString(3, email);
                final int i = ps.executeUpdate();
                
                if(i == 1) {
                JOptionPane.showMessageDialog(null, "Cadastrado");
                conn.close();	
                dispose();
                }else {
                	JOptionPane.showMessageDialog(null, "Valor invalido, redigite");
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Valor invalido, redigite");
            }
        }
    }
}


/*

DROP database banco1;
CREATE DATABASE banco1;
USE banco1;
CREATE TABLE tabela1(
nome VARCHAR(50),
idade INT,
email VARCHAR(100)
);

*/
