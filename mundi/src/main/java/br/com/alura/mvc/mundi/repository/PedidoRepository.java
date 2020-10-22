package br.com.alura.mvc.mundi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.model.StatusPedido;

@Repository
@Transactional
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {



	public List<Pedido> findAll();

	public List<Pedido> findByStatus(StatusPedido statusPedido);

}