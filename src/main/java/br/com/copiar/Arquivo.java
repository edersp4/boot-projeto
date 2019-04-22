package br.com.copiar;

public class Arquivo {

	private String caminhoDoProjeto;
	private String nomeDiretorioRemoto;
	private String nomeDoDiretorioDestino;
	private String pastaZip;

	public String getNomeDiretorioRemoto() {
		return nomeDiretorioRemoto;
	}

	public void setNomeDiretorioRemoto(String nomeDiretorioRemoto) {
		this.nomeDiretorioRemoto = nomeDiretorioRemoto;
	}

	public String getNomeDoDiretorioDestino() {
		return nomeDoDiretorioDestino;
	}

	public void setNomeDoDiretorioDestino(String nomeDoDiretorioDestino) {
		this.nomeDoDiretorioDestino = nomeDoDiretorioDestino;
	}

	public String getCaminhoDoProjeto() {
		return caminhoDoProjeto;
	}

	public void setCaminhoDoProjeto(String caminhoDoProjeto) {
		this.caminhoDoProjeto = caminhoDoProjeto;
	}

	public String getPastaZip() {
		return pastaZip;
	}

	public void setPastaZip(String pastaZip) {
		this.pastaZip = pastaZip;
	}

}
