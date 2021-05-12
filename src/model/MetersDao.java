package model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MetersDao implements MetersDaoInterface<Meters, String> {

	private Session currentSession;

	private Transaction currentTransaction;

	public MetersDao() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure("/resources/hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(Meters entity) {
		getCurrentSession().save(entity);
	}

	public void update(Meters entity) {
		getCurrentSession().update(entity);
	}

	public Meters findById(String id) {
		Meters meters = (Meters) getCurrentSession().get(Meters.class, id);
		return meters;
	}

	public void delete(Meters entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Meters> findAll() {
		List<Meters> meters = (List<Meters>) getCurrentSession().createQuery("from Meters").list();
		return meters;
	}

	@SuppressWarnings("unchecked")
	public List<String> getLines(){
		return (List<String>) getCurrentSession().createQuery("select line from Meters group by line").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Meters> getByLine(String line){
		return (List<Meters>) getCurrentSession().createQuery("from Meters where line = :param")
				.setParameter("param", line)
				.list();
	}

	public void deleteAll() {
		List<Meters> entityList = findAll();
		for (Meters entity : entityList) {
			delete(entity);
		}
	}
}
