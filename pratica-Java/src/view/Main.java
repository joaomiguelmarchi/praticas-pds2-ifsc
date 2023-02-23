package view;

import control.PessoaDAO;
import model.Pessoa;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pessoa pessoa = new Pessoa("JOAOZIN", 2);
		PessoaDAO pessoaDao = null;
		pessoaDao.Inserir(pessoa);
		
	}

}