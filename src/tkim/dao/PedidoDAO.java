package tkim.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tkim.hibernate.util.HibernateUtil;
import tkim.modelo.Pedido;
import tkim.modelo.Pedido;

public class PedidoDAO implements IPedidoDAO{

	Transaction transaction = null;
	Session session = null;
	@Override
	public Boolean existePedido(Integer codigo) {
		session = HibernateUtil.getSessionFactory().openSession();
		Boolean existePedido = false;
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Pedido> cr = cb.createQuery(Pedido.class);
		Root<Pedido> root = cr.from(Pedido.class);
		cr.select(root);
		cr.select(root).where(cb.equal(root.get("numero_pedido"), codigo));
		Query query = session.createQuery(cr);
		
		if (!query.getResultList().isEmpty()) {
			existePedido = true;
		}
		
		//Cerramos la sesion
		session.close();
		return existePedido;
	}

	@Override
	public String save(Pedido pedido) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		try {
			session.save(pedido);
			//Hacemos commit de la transaccion en BBDD para que se guarden 
			transaction.commit();
			//Cerramos la sesion
			session.close();
			return "Pedido guardado con exito";
		} catch (RuntimeException re) {
			//Hacemos rollback de los datos introducidos por si hay algun fallo en la insercion del articulo
			transaction.rollback();
			return "La insercion del pedido ha fallado" + re;
		}
	}

	@Override
	public String eliminarPedido(int numPedido) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		try {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaDelete<Pedido> delete = cb.createCriteriaDelete(Pedido.class);
			Root<Pedido> pedido = delete.from(Pedido.class);
			delete.where(cb.equal(pedido.get("numero_pedido"), numPedido));
			int resultado = session.createQuery(delete).executeUpdate();
			if (resultado == 1) {
				transaction.commit();
				session.close();
				return "El pedido ha sido borrado correctamente";
			} else {
				transaction.commit();
				session.close();
				return "El numero de pedido introducido no existe";
			}
			
			
		} catch (RuntimeException re) {
			// Hacemos rollback de los datos introducidos por si hay algun fallo en la
			// insercion del articulo
			transaction.rollback();
			return "El borrado del pedido ha fallado" + re;
		}	
	}

	@Override
	public List<Pedido> pedidosEnviados(String nif) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> pedidosPendientes(String nif) {
		// TODO Auto-generated method stub
		return null;
	}

}
