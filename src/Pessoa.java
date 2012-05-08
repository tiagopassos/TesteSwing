public class Pessoa {
	private String nome;
	private String estado;
	private String cidade;
	public Pessoa(String nome, String cidade, String estado){
		setNome(nome);
		setCidade(cidade);
		setEstado(estado);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}