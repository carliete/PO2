package CbListas;

import java.util.List;

import javax.persistence.EntityManager;

import ConexaoBd.Conection;
import Dao.InterfaceDAO;
import Proj.Po2.Entidades.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TipoWebDao implements InterfaceDAO<TipoWeb> {

	
	
	
	private static ObservableList<TipoWeb> tiposW;
	@Override
	public TipoWeb get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoWeb> getAll() {
			if (tiposW == null) {
				EntityManager entityMng = Conection.getEntityManager();
				tiposW = FXCollections.observableArrayList(
						entityMng.createQuery("select tiposW from TipoWeb as tiposW", TipoWeb.class).getResultList());
				entityMng.close();
			}
			return tiposW;
	}

	@Override
	public void add(TipoWeb tipoweb) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		entityMng.persist(tipoweb);
		entityMng.getTransaction().commit();
		entityMng.close();
		if (tiposW != null)
			tiposW.add(tipoweb);
		
	}

	@Override
	public void delete(TipoWeb obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TipoWeb obj) {
		// TODO Auto-generated method stub
		
	}

}
