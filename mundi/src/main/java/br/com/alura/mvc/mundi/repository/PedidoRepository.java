package br.com.alura.mvc.mundi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.model.StatusPedido;

@Repository
@Transactional
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {


	
	public List<Pedido> findAll();
	
	@Cacheable("pedidos")
	public List<Pedido> findByStatus(StatusPedido statusPedido, Pageable pageRequest);
	
	@Query("select p from Pedido p join p.user u where u.username =:username")
	public List<Pedido> findAllByUser(@Param("username") String username);
	
	@Query("select p from Pedido p join p.user u where u.username =:username and p.status = :satusPedido")
	public List<Pedido> findByStatusEUsuario(@Param("satusPedido")StatusPedido statusPedido, @Param("username") String username);

}
