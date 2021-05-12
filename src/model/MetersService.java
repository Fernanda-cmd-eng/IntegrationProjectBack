package model;

import java.util.List;

public class MetersService {

	private static MetersDao metersDao;

	public MetersService() {
		metersDao = new MetersDao();
	}

	public void persist(Meters entity) {
		metersDao.openCurrentSessionwithTransaction();
		metersDao.persist(entity);
		metersDao.closeCurrentSessionwithTransaction();
	}

	public void update(Meters entity) {
		metersDao.openCurrentSessionwithTransaction();
		metersDao.update(entity);
		metersDao.closeCurrentSessionwithTransaction();
	}

	public Meters findById(String id) {
		metersDao.openCurrentSession();
		Meters meters = metersDao.findById(id);
		metersDao.closeCurrentSession();
		return meters;
	}

	public void delete(String id) {
		metersDao.openCurrentSessionwithTransaction();
		Meters meters = metersDao.findById(id);
		metersDao.delete(meters);
		metersDao.closeCurrentSessionwithTransaction();
	}

	public List<Meters> findAll() {
		metersDao.openCurrentSession();
		List<Meters> meters = metersDao.findAll();
		metersDao.closeCurrentSession();
		return meters;
	}

	public List<String> getLines() {
		metersDao.openCurrentSession();
		List<String> lines = metersDao.getLines();
		metersDao.closeCurrentSession();
		return lines;
	}
	
	public List<Meters> getByLine(String line) {
		metersDao.openCurrentSession();
		List<Meters> meters = metersDao.getByLine(line);
		metersDao.closeCurrentSession();
		return meters;
	}

	public void deleteAll() {
		metersDao.openCurrentSessionwithTransaction();
		metersDao.deleteAll();
		metersDao.closeCurrentSessionwithTransaction();
	}

	public MetersDao metersDao() {
		return metersDao;
	}
}
