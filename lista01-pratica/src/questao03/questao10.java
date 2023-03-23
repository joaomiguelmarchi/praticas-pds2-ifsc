package questao03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class questao10 extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTable tabela;
    private static String tableName = "tabela1";
    private static String databaseName = "banco1";

    public questao10() {
        super("Tabela");

        tabela = new JTable();
        JScrollPane scrollPane = new JScrollPane(tabela);
        getContentPane().add(scrollPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        carregarDados();
    }

    private void carregarDados() {
        SwingUtilities.invokeLater(() -> {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ databaseName +"?serverTimezone=UTC", "root", "aluno");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM "+ tableName);

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("nome");
                model.addColumn("idade");
                model.addColumn("email");

                while (rs.next()) {
                    Object[] linha = new Object[3];
                    linha[0] = rs.getString("nome");
                    linha[1] = rs.getString("idade");
                    linha[2] = rs.getString("email");
                    model.addRow(linha);
                }

                tabela.setModel(model);

                rs.close();
                stmt.close();
                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        new questao10();
    }
}
