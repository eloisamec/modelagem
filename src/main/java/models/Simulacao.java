package models;

import java.io.Serializable;
import java.util.ArrayList;

import utils.Estatistica;

public class Simulacao implements Serializable {

	private static final long serialVersionUID = -7554792485811666284L;

	private String nome;
	private int idSimulacao;
	private ArrayList<String> log;
	private Estatistica estatistica;

	public Simulacao(String nome, int idSimulacao) {
		this.nome = nome;
		this.idSimulacao = idSimulacao;
		log = new ArrayList<String>();
		estatistica = new Estatistica();
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "; ID: " + idSimulacao + ";";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdSimulacao() {
		return idSimulacao;
	}

	public void setIdSimulacao(int idSimulacao) {
		this.idSimulacao = idSimulacao;
	}

	public ArrayList<String> getLog() {
		return log;
	}

	public void setLog(ArrayList<String> log) {
		this.log = log;
	}

	public Estatistica getEstatistica() {
		return estatistica;
	}

	public void setEstatistica(Estatistica estatistica) {
		this.estatistica = estatistica;
	}
}
