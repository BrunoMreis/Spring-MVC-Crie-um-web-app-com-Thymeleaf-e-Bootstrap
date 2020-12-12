package br.com.alura.mvc.mundi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nome;
	private BigDecimal valor;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDeEntrega;
	private String urlDoProduto;
	private String descricaoDoProduto;
	private String urlIMGProduto;

	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	public Pedido() {
		this.setStatus(StatusPedido.AGUARDANDO);
	}

	public String getUrlIMGProduto() {
		return urlIMGProduto;
	}

	public void setUrlIMGProduto(String urlIMGProduto) {
		this.urlIMGProduto = urlIMGProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataDeEntrega() {
		return dataDeEntrega;
	}

	public void setDataDeEntrega(LocalDate dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}

	public String getUrlDoProduto() {
		return urlDoProduto;
	}

	public void setUrlDoProduto(String urlDoProduto) {
		this.urlDoProduto = urlDoProduto;
	}

	public String getDescricaoDoProduto() {
		return descricaoDoProduto;
	}

	public void setDescricaoDoProduto(String descricaoDoProduto) {
		this.descricaoDoProduto = descricaoDoProduto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", nome=" + nome + ", valor=" + valor + ", dataDeEntrega=" + dataDeEntrega
				+ ", urlDoProduto=" + urlDoProduto + ", descricaoDoProduto=" + descricaoDoProduto + ", urlIMGProduto="
				+ urlIMGProduto + ", status=" + status + "]";
	}

}
