package CbListas;

import java.util.List;

import javax.persistence.EntityManager;

import ConexaoBd.Conection;
import Dao.InterfaceDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AreaDao implements InterfaceDAO<Area>{
	
	private static ObservableList<Area> areas;
	
	@Override
	public Area get(String id) {
		if (areas != null)
			for (Area area : areas)
				if (area.getCod().contentEquals(id))
					return area;

		EntityManager entityMng = Conection.getEntityManager();
		Area area = entityMng.find(Area.class, id);
		entityMng.close();
		return area;
	}

	@Override
	public List<Area> getAll() {
		if (areas == null) {
			EntityManager entityMng = Conection.getEntityManager();
			areas = FXCollections.observableArrayList(
					entityMng.createQuery("select areas from Area as areas", Area.class).getResultList());
			entityMng.close();
		}
		return areas;
	}

	@Override
	public void add(Area area1) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		entityMng.persist(area1);
		entityMng.getTransaction().commit();
		entityMng.close();
		if (areas != null)
			areas.add(area1);
		
	}

	@Override
	public void delete(Area obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Area obj) {
		// TODO Auto-generated method stub
		
	}

}
