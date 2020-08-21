package controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.PessoaDAO;
import model.Pessoa;

@ManagedBean
public class PessoaMB {
	private Pessoa pessoa;
	private PessoaDAO pessoaDAO;
	private List<Pessoa> Lista;
	
	public void PessoaDAO() {
		pessoaDAO = new PessoaDAO();
		pessoa = new Pessoa();
		
		Lista = pessoaDAO.listarTodos();
	}
	
	public Pessoa getPessoa() {
		return this.pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getList(){
		return this.Lista;
	}
	
	public void salvar() {
		pessoaDAO.salvar(pessoa);
		
		FacesMessage message = new FacesMessage("O Registro foi salvo com êxito !");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("O",message);
        
		//addMessage("O Registro foi salvo com êxito !");
		Lista = pessoaDAO.listarTodos();
	}
	
	
	
}
