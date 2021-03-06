package domain;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
	private String nome;
	private Empresa empresa;
	private int id;
	private int numOc=0;
	private List<Ocorrencia> ocorrencias=new ArrayList<Ocorrencia>();

	public Funcionario(String nome, Empresa empresa) {
		if(nome.isEmpty()) {
			throw new Error("empty name");
		}
		
		
		this.nome=nome;
		this.empresa=empresa;
		this.id=empresa.getIdFunc();
		this.empresa.insereFuncionario(this);
		
	}


	public void mudaEmpresa(Empresa empresa) {
		this.empresa.removeFuncionario(this);
		empresa.insereFuncionario(this);
		this.empresa=empresa;
		this.id=empresa.getIdFunc();
	}

	public void mudaId(int idFunc) {
		this.id=idFunc;
		
	}

	public void removeOcorrencia(Ocorrencia oc) {
		this.ocorrencias.remove(oc);
	}

	public void adicionaOcorrencia(Ocorrencia oc) {
		this.ocorrencias.add(oc);
	}

	public int getOc() {
		return this.ocorrencias.size();
	}
	public String getNome() {
		return this.nome;
	}

	public void terminaOcorrencia(Ocorrencia oc) {
		if(this.ocorrencias.contains(oc)) {
			oc.finaliza();
			this.removeOcorrencia(oc);
		}
	}


	public int getId() {
		return this.id;
	}


	public Empresa getEmpresa() {
		return this.empresa;
	}


}
