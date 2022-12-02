package tkim.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tkim.hibernate.util.HibernateUtil;
import tkim.modelo.Cliente;

public class ClienteDAO implements IClienteDAO {

	Transaction transaction = null;
	Session session = null;
	
	@Override
	public Boolean existeCliente(String nif) {
		session = HibernateUtil.getSessionFactory().openSession();
		Boolean existeCliente = false;
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Cliente> cr = cb.createQuery(Cliente.class);
		Root<Cliente> root = cr.from(Cliente.class);
		cr.select(root);
		cr.select(root).where(cb.equal(root.get("nif"), nif));
		Query query = session.createQuery(cr);
		
		if (!query.getResultList().isEmpty()) {
			existeCliente = true;
		}
		
		//Cerramos la sesion
		session.close();
		return existeCliente;
	}

	@Override
	public List<Cliente> mostrarCliente() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		try {
			//Creamos la query de select all indicandole con el .class la clase que queremos
	        CriteriaQuery<Cliente> criteriaQuery = session.getCriteriaBuilder().createQuery(Cliente.class);
	        criteriaQuery.from(Cliente.class);
	        //Aqui los datos que nos ha devuelto lo metemos en una lista tipo arraylist
	        List<Cliente> clientes = session.createQuery(criteriaQuery).getResultList();
	        //Cerramos la sesion
	        session.close();
	        //Y la devolvemos	
			return clientes;
		} catch (RuntimeException re) {
			System.out.println("fallo al mostrar los clientes."+re);
			return null;
		}
	}

	
	@Override
	public String save(Cliente cliente) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		try {
			session.save(cliente);
			//Hacemos commit de la transaccion en BBDD para que se guarden 
			transaction.commit();
			//Cerramos la sesion
			session.close();
			return "Cliente guardado con exito";
		} catch (RuntimeException re) {
			//Hacemos rollback de los datos introducidos por si hay algun fallo en la insercion del articulo
			transaction.rollback();
			return "La insercion del cliente ha fallado" + re;
		}
	}

}
