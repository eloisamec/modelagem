package controllers;


//classe que controla os eventos
public class EventoControl {

	// private double tempoAtual; // em segundos
	// private List<Evento> listaEventos;
	// private double tempoTotalSimulacao; // tempo total de duracao da
	// simulacao
	// // em segundos
	// private Long eventId; // id do mais novo evento
	//
	// private double probEntreChegadaC1; // parametro para a funcao exponencial
	// de
	// // chegade da celula 2
	// private double probEntreChegadaC2; // parametro para a funcao exponencial
	// de
	// // chegade da celula 2
	//
	// // as probabilidas CXFA vão ser de CXCY atá 1.0
	// private double probC1C1;
	// private double probC1C2;
	// private double probC2C2;
	// private double probC2C1;
	//
	// private double tempoChegada;
	//
	// private TipoDuracao tipoDuracao; // tipo da funcao randomica para gerar o
	// // tempo da duracao de uma chamada
	//
	// private Celula celula1;
	// private Celula celula2;
	//
	// public EventoControl(Celula celula1, Celula celula2) {
	// this.listaEventos = new ArrayList<Evento>();
	// this.tempoAtual = 0.0;
	// this.eventId = -1L;
	// }
	//
	// public void setAllParameters() {
	// // this.celula1 = new Celula(getName(), getLinhas());
	// }
	//
	// public void fillListaEventos() {
	// double tmpChegada = 0.0;
	// while (this.tempoAtual < this.tempoTotalSimulacao) {
	// List<Evento> tmp = this.createEvento();
	// this.listaEventos.addAll(tmp);
	//
	// }
	//
	// // bubblesort
	// int length = this.listaEventos.size();
	// boolean swapped = false;
	// do {
	//
	// swapped = false;
	// for (int i = 1; i < length - 1; i++) {
	// if (this.listaEventos.get(i - 1).getTempo() >
	// this.listaEventos.get(i).getTempo()) {
	// Evento tmp = this.listaEventos.get(i - 1);
	// this.listaEventos.set(i - 1, this.listaEventos.get(i));
	// this.listaEventos.set(i, tmp);
	// swapped = true;
	// }
	// }
	// } while (swapped == false);
	//
	// }
	//
	// public void run() {
	// do {
	//
	// } while (this.tempoAtual < this.tempoTotalSimulacao);
	//
	// }
	//
	// private List<Evento> createEvento() {
	// double duracao = this.getRandomTempoDuracao();
	//
	// // TipoChamada tpChamada = this.getNewTipoChamada();
	// TipoChamada tpChamada = null;
	//
	// // Chamada chamada = new Chamada(duracao, tpChamada);
	// this.eventId++;
	// List<Evento> eventos = new ArrayList<Evento>();
	//
	// if (tpChamada == models.enums.TipoChamada.C1C1 || tpChamada ==
	// models.enums.TipoChamada.C2C2) {
	//
	// // eventos.add(new Evento(1, this.tempoChegada + duracao,
	// // this.eventId, chamada));
	// }
	// // if(tpChamada == models.enums.TipoChamada.C1C2 || tpChamada ==
	// // models.enums.TipoChamada.C1C2){
	// // eventos.add(new Evento(0, this.tempoChegada, this.eventId, chamada));
	// // eventos.add(new Evento(2, this.tempoChegada + duracao/2,
	// // this.eventId, chamada));
	// // eventos.add(new Evento(1, this.tempoChegada + duracao, this.eventId,
	// // chamada));
	// // }
	// // if(tpChamada == models.enums.TipoChamada.C1FA || tpChamada ==
	// // models.enums.TipoChamada.C1FA){
	// // eventos.add(new Evento(0, this.tempoChegada, this.eventId, chamada));
	// // eventos.add(new Evento(2, this.tempoChegada + duracao/2,
	// // this.eventId, chamada));
	// // }
	//
	// this.tempoAtual = this.tempoAtual + this.tempoChegada;
	// return eventos;
	// }
	//
	// private double getRandomTempoDuracao() {
	// if (this.tipoDuracao == TipoDuracao.CONSTANTE) {
	// return MathsUtils.Uniforme(10, 20);
	// }
	// if (this.tipoDuracao == TipoDuracao.UNIFORME) {
	// return MathsUtils.Uniforme(10, 10);
	// }
	// if (this.tipoDuracao == TipoDuracao.EXPONENCIAL) {
	// // return MathsUtils.Expo(0.6);
	// }
	// if (this.tipoDuracao == TipoDuracao.NORMAL) {
	// return MathsUtils.Normal(10, 3);
	// }
	// if (this.tipoDuracao == TipoDuracao.TRIANGULAR) {
	// return MathsUtils.Triangular(10, 20, 30);
	// }
	// return (Double) null;
	// }
	//
	// // private TipoChamada getNewTipoChamada(){
	// // if(MathsUtils.Rand() < 0.5){
	// // double tmp = MathsUtils.Rand();
	// // if(tmp < this.probC1C1){
	// // this.tempoChegada = MathsUtils.Expo(this.probEntreChegadaC1);
	// // return TipoChamada.C1C1;
	// // }
	// //
	// // else{
	// // if(tmp < this.probC1C2){
	// // this.tempoChegada = MathsUtils.Expo(this.probEntreChegadaC1);
	// // return TipoChamada.C1C2;
	// // }
	// //
	// // else{
	// // this.tempoChegada = MathsUtils.Expo(this.probEntreChegadaC1);
	// // return TipoChamada.C1FA;
	// // }
	// //
	// // }
	// // }
	// // else {
	// // double tmp = MathsUtils.Rand();
	// // if(tmp < this.probC2C2){
	// // this.tempoChegada = MathsUtils.Expo(this.probEntreChegadaC2);
	// // return TipoChamada.C2C2;
	// // }
	// //
	// // else{
	// // if(tmp < this.probC2C1){
	// // this.tempoChegada = MathsUtils.Expo(this.probEntreChegadaC2);
	// // return TipoChamada.C2C1;
	// // }
	// //
	// // else{
	// // this.tempoChegada = MathsUtils.Expo(this.probEntreChegadaC2);
	// // return TipoChamada.C2FA;
	// // }
	// //
	// // }
	// // }
	// // }
	//
	// public double getTempoAtual() {
	// return tempoAtual;
	// }
	//
	// public void setTempoAtual(double tempoAtual) {
	// this.tempoAtual = tempoAtual;
	// }
	//
	// public List<Evento> getListaEventos() {
	// return listaEventos;
	// }
	//
	// public void setListaEventos(List<Evento> listaEventos) {
	// this.listaEventos = listaEventos;
	// }
	//
	// public Long getEventId() {
	// return eventId;
	// }
	//
	// public void setEventId(Long eventId) {
	// this.eventId = eventId;
	// }
	//
	// public Celula getCelula1() {
	// return celula1;
	// }
	//
	// public void setCelula1(Celula celula1) {
	// this.celula1 = celula1;
	// }
	//
	// public Celula getCelula2() {
	// return celula2;
	// }
	//
	// public void setCelula2(Celula celula2) {
	// this.celula2 = celula2;
	// }
	//
}
