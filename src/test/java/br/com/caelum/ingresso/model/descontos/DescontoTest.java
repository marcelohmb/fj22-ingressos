package br.com.caelum.ingresso.model.descontos;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;

public class DescontoTest {
	private Sala sala;
	private Filme filme;
	private Sessao sessao;
	private Lugar lugar;
	
	@Before
	public void setup(){
		new Lugar("A",1);
		sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
		filme = new Filme("Rogue One", Duration.ofMinutes(120),"SCI-FI", new BigDecimal("12"));
		sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		
	}
	
	
	@Test
	public void naoDeveConcederDescontParaIngressoNormal(){
		
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.INTEIRO,lugar);
		
		BigDecimal precoEsperado = new BigDecimal("32.50");
		
		assertEquals(precoEsperado, ingresso.getPreco());
		
	} 
	
	@Test
	public void deveConcederDescontDe50PorcentoParaIngressoDeEstudante(){
		
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.ESTUDANTE, lugar);
		
		BigDecimal precoEsperado = new BigDecimal("16.25");
		
		assertEquals(precoEsperado, ingresso.getPreco());
		
	}
	
	
}
