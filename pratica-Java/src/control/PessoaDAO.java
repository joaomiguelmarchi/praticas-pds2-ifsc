package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Pessoa;

public class PessoaDAO {
	
	private Conexao con;
	
	public boolean Inserir(Pessoa pessoa) {
		
		con = Conexao.getInstacia();
		Connection c = Conexao.conectar();
		
		try {
			String query = "Insert INto pessoa(cpf, nome)values(?,?);";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, 123);
			stm.setString(2, "Elieie");
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return false;			
	}
	
	public boolean atualizar(Pessoa pessoa) {
		con = Conexao.getInstacia();
		Conexao.conectar();
		con.fecharConexao();
		return false;
	}
	
	public boolean deleter(Pessoa pessoa){
		con = Conexao.getInstacia();
		Conexao.conectar();
		con.fecharConexao();
		return false;
	}
	
	public ArrayList<Pessoa>listarPessoas(){
		
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		
		con = Conexao.getInstacia();
		Connection c = Conexao.conectar();
		
		try {
			Statement stm = c.createStatement();
			String query = "Select * from pessoa";
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				int cpf = rs.getInt("cpf");
				String nome = rs.getString("nome");
				Pessoa p= new Pessoa(nome, cpf);
				p.setCpf(cpf);
				p.setNome(nome);
				System.out.println(p);
				pessoas.add(p);
				
				return pessoas;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return null;
	}
		
	
	

}