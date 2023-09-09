package br.com.agenda.aplicacao;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		ContatoDAO contatoDao = new ContatoDAO();
		
		Contato contato = new Contato();
		
		contato.setNome("Ana Maria");
		contato.setIdade(55);
		contato.setDataCadastro(new Date());
		
		contatoDao.save(contato);

	}

}
