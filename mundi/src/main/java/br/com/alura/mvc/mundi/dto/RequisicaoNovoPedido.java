package br.com.alura.mvc.mundi.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.mundi.model.Pedido;

public class RequisicaoNovoPedido {
	
	@NotBlank 
	private String nomeProduto;
	@NotBlank
	private String urlProduto;
	@NotBlank
	private String urlImagem;
	@NotBlank
	private String descricao;

	public Pedido toPedido() {
		Pedido pedido = new Pedido();

		pedido.setNome(this.nomeProduto);
		pedido.setUrlDoProduto(urlProduto);
		pedido.setUrlIMGProduto(urlImagem);
		pedido.setDescricaoDoProduto(descricao);

		return pedido;

	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
