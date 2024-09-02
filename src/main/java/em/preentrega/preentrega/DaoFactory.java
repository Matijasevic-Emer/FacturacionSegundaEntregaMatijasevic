package em.preentrega.preentrega;


import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoFactory {
    private final SessionFactory sessionFactory;

    @Autowired
    public DaoFactory(EntityManagerFactory factory) {
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    public void create(Object obj)  {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
    }

    public void update(Object obj) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(obj);
        session.getTransaction().commit();
    }
    public Cliente getCliente(Cliente cliente) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Cliente clienteGuardado = session.get(Cliente.class,cliente.getId());
        session.getTransaction().commit();
        return clienteGuardado;
    }
}
