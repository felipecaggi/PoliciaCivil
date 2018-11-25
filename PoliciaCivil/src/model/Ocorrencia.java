package model;

import java.util.Collection;
import java.util.Date;

public class Ocorrencia {

	private Date data;

	private int horario;

	private int infracao;

	private int segredoJustica;

	private int status;

	private Usuario usuario;

	private Delegado delegado;

	private Delegacia delegacia;

	private Endereco endereco;

	private Collection<Evidencia> evidencia;

	private Policial policial;

	private Collection<Policial> equipePolicial;

	private Collection<Cidadao> autor;

	private Collection<Cidadao> vitima;

	private Collection<Cidadao> testemunha;

	private Collection<Cidadao> comunicante;

	public void setData(int data) {

	}

	public int getData() {
		return 0;
	}

	public void setHorario(int horario) {

	}

	public int getHorario() {
		return 0;
	}

	public void setInfracao(int infracao) {

	}

	public int getInfracao() {
		return 0;
	}

	public void setSegredoJustica(int segredoJustica) {

	}

	public int getSegredoJustica() {
		return 0;
	}

	public void setStatus(int status) {

	}

	public int getStatus() {
		return 0;
	}

	public void setDelegado(Delegado delegado) {

	}

	public void setEquipe(int equipe) {

	}

	public void setTestemunha(int idCidadao) {

	}

	public void setAutor(int idCidadao) {

	}

	public void setComunicante(int idCidadao) {

	}

	public void setVitima(int idCidadao) {

	}

	public void setEvidencia(Evidencia evidencia) {

	}

}
