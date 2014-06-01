package structure;

import java.util.ArrayList;
import java.util.List;

import utils.Maths;
import enumeration.TipoChamada;
import enumeration.TipoRandom;

//classe que controla os eventos
public class EventoControl {

	private double tempoAtual;
	private List<Evento> listaEventos;
	private double tempoTotalSimulacao;
	
	private Long eventId; // id do mais novo evento

	private double probChegadaC1;
	
	private double probC1C1;
	private double probC1C2;
	private double probC2C2;
	private double probC2C1;
	
	
	
	private TipoRandom tipoDuracao;
	private TipoRandom tipoChegada;
	private TipoRandom probTipoChamada;
	private TipoRandom probTipoC1;
	private TipoRandom probTipoC2;

	private Celula celula1;
	private Celula celula2;
	

	public EventoControl(Celula celula1, Celula celula2) {
		this.celula1 = celula1;
		this.celula2 = celula2;
		this.listaEventos = new ArrayList<Evento>();
		this.tempoAtual = 0.0;
		this.eventId = -1L;
	}
	
	
	public void setAllParameters(){
		
	}
	
	
	
	public void fillListaEventos() {
		double tmpChegada = 0.0;
		while(this.tempoAtual < this.tempoTotalSimulacao)	{
			tmpChegada = this.getRandomTempoChegada();
			List<Evento> tmp = this.createEvento(tmpChegada);
			this.listaEventos.addAll(tmp);
			this.tempoAtual = this.tempoAtual + tmpChegada;
			
		}
	
		//bubblesort
		int length = this.listaEventos.size();
		boolean swapped = false;
		do{
			
		swapped = false;
			for(int i = 1; i < length - 1; i++){
				if(this.listaEventos.get(i-1).getTempo() > this.listaEventos.get(i).getTempo()){
					Evento tmp = this.listaEventos.get(i-1);
					this.listaEventos.set(i-1, this.listaEventos.get(i));
					this.listaEventos.set(i, tmp);
					swapped = true;
				}	
			}
		}while(swapped == false);
		
		
	}

	public void run() {

	}

	private List<Evento> createEvento(double tpChegada) {
		double duracao = this.getRandomTempoDuracao();
	
		
		TipoChamada tpChamada = this.getNewTipoChamada();
		

		Chamada chamada = new Chamada(duracao, tpChamada);
		this.eventId++;
		List<Evento> eventos = new ArrayList<Evento>();
		eventos.add(new Evento(0, tpChegada, this.eventId, chamada));
		if(tpChamada == enumeration.TipoChamada.C1C1 || tpChamada == enumeration.TipoChamada.C2C2){
			eventos.add(new Evento(0, tpChegada + duracao, this.eventId, chamada));
		}
		if(tpChamada == enumeration.TipoChamada.C1C2 || tpChamada == enumeration.TipoChamada.C1C2){
			eventos.add(new Evento(2, tpChegada + duracao/2, this.eventId, chamada));
			eventos.add(new Evento(1, tpChegada + duracao, this.eventId, chamada));
		}
		if(tpChamada == enumeration.TipoChamada.C1FA || tpChamada == enumeration.TipoChamada.C1FA){
			eventos.add(new Evento(2, tpChegada + duracao/2, this.eventId, chamada));
		}
		
		
		return eventos;
	}

	private double getRandomTempoDuracao() {
		if (this.tipoDuracao == enumeration.TipoRandom.CONSTANTE ) {
			return Maths.Uniforme(10, 20);
		}
		if(this.tipoDuracao == enumeration.TipoRandom.UNIFORME){
			return Maths.Uniforme(10, 10);
		}
		if (this.tipoDuracao == enumeration.TipoRandom.EXPONENCIAL) {
			return Maths.Expo(0.6);
		}
		if (this.tipoDuracao == enumeration.TipoRandom.NORMAL) {
			return Maths.Normal(10, 3);
		}
		if (this.tipoDuracao == enumeration.TipoRandom.TRIANGULAR) {
			return Maths.Triangular(10, 20, 30);
		}
		return (Double) null;
	}
	
	private double getRandomTempoChegada() {
		if (this.tipoChegada == enumeration.TipoRandom.CONSTANTE ) {
			return Maths.Uniforme(10, 20);
		}
		if(this.tipoChegada == enumeration.TipoRandom.UNIFORME){
			return Maths.Uniforme(10, 10);
		}
		if (this.tipoChegada == enumeration.TipoRandom.EXPONENCIAL) {
			return Maths.Expo(0.6);
		}
		if (this.tipoChegada == enumeration.TipoRandom.NORMAL) {
			return Maths.Normal(10, 3);
		}
		if (this.tipoChegada == enumeration.TipoRandom.TRIANGULAR) {
			return Maths.Triangular(10, 20, 30);
		}
		return (Double) null;
	}
	
	
	private double generateProbChamada(){
		if (this.probTipoChamada == enumeration.TipoRandom.CONSTANTE ) {
			return Maths.Uniforme(10, 20);
		}
		if(this.probTipoChamada == enumeration.TipoRandom.UNIFORME){
			return Maths.Uniforme(10, 10);
		}
		if (this.probTipoChamada == enumeration.TipoRandom.EXPONENCIAL) {
			return Maths.Expo(0.6);
		}
		if (this.probTipoChamada == enumeration.TipoRandom.NORMAL) {
			return Maths.Normal(10, 3);
		}
		if (this.probTipoChamada == enumeration.TipoRandom.TRIANGULAR) {
			return Maths.Triangular(10, 20, 30);
		}
		return (Double) null;
	}
	
	
	private double getRandomTipoC1() {
		if (this.probTipoC1 == enumeration.TipoRandom.CONSTANTE ) {
			return Maths.Uniforme(10, 20);
		}
		if(this.probTipoC1 == enumeration.TipoRandom.UNIFORME){
			return Maths.Uniforme(10, 10);
		}
		if (this.probTipoC1 == enumeration.TipoRandom.EXPONENCIAL) {
			return Maths.Expo(0.6);
		}
		if (this.probTipoC1 == enumeration.TipoRandom.NORMAL) {
			return Maths.Normal(10, 3);
		}
		if (this.probTipoC1 == enumeration.TipoRandom.TRIANGULAR) {
			return Maths.Triangular(10, 20, 30);
		}
		return (Double) null;
	}
	
	private double getRandomTipoC2() {
		if (this.probTipoC2 == enumeration.TipoRandom.CONSTANTE ) {
			return Maths.Uniforme(10, 20);
		}
		if(this.probTipoC2 == enumeration.TipoRandom.UNIFORME){
			return Maths.Uniforme(10, 10);
		}
		if (this.probTipoC2 == enumeration.TipoRandom.EXPONENCIAL) {
			return Maths.Expo(0.6);
		}
		if (this.probTipoC2 == enumeration.TipoRandom.NORMAL) {
			return Maths.Normal(10, 3);
		}
		if (this.probTipoC2 == enumeration.TipoRandom.TRIANGULAR) {
			return Maths.Triangular(10, 20, 30);
		}
		return (Double) null;
	}
	
	private TipoChamada getNewTipoChamada(){
		if(this.generateProbChamada() < this.probChegadaC1){
			double tmp = this.getRandomTipoC1(); 
			if(tmp < this.probC1C1)
					return TipoChamada.C1C1;
			else{
				if(tmp < this.probC1C2)
					return TipoChamada.C1C2;
				else
					return TipoChamada.C1FA;
			}
		}
		else {
			double tmp = this.getRandomTipoC2(); 
			if(tmp < this.probC2C2)
					return TipoChamada.C2C2;
			else{
				if(tmp < this.probC2C1)
					return TipoChamada.C2C1;
				else
					return TipoChamada.C2FA;
			}
		}
	}

	public double getTempoAtual() {
		return tempoAtual;
	}

	public void setTempoAtual(double tempoAtual) {
		this.tempoAtual = tempoAtual;
	}

	public List<Evento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	
	public Celula getCelula1() {
		return celula1;
	}

	public void setCelula1(Celula celula1) {
		this.celula1 = celula1;
	}

	public Celula getCelula2() {
		return celula2;
	}

	public void setCelula2(Celula celula2) {
		this.celula2 = celula2;
	}


	public TipoRandom getTipoChegada() {
		return tipoChegada;
	}


	public void setTipoChegada(TipoRandom tipoChegada) {
		this.tipoChegada = tipoChegada;
	}

}
