package br.com.caelum.ingresso.model;

import java.time.LocalTime;

public class Sessao {

	private Integer id;
	
	private LocalTime horario;
	
	private Filme filme;
	
	private Sala sala;

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Integer getId() {
		return id;
	}
	
	public Sessao(LocalTime horario, Filme filme, Sala sala){
		this.filme = filme;
		this.horario = horario;
		this.sala = sala;
	}
	
	public LocalTime getHorarioTermino(){
		return this.horario.plusMinutes(this.filme.getDuracao().toMinutes());
	}
}
