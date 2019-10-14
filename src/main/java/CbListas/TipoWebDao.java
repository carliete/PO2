package CbListas;

import java.util.List;

import javax.persistence.EntityManager;

import ConexaoBd.Conection;
import Dao.InterfaceDAO;
import Proj.Po2.Entidades.Perfil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TipoWebDao implements InterfaceDAO<TipoWeb>{

	private static ObservableList<TipoWeb> tipos;
	
	@Override
	public TipoWeb get(String id) {
		if (tipos != null)
			for (TipoWeb tipo : tipos)
				if (tipo.getCod().contentEquals(id))
					return tipo;

		EntityManager entityMng = Conection.getEntityManager();
		TipoWeb tipo = entityMng.find(TipoWeb.class, id);
		entityMng.close();
		return tipo;
	}

	@Override
	public void add(TipoWeb tipo) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		entityMng.persist(tipo);
		entityMng.getTransaction().commit();
		entityMng.close();
		if (tipos != null)
			tipos.add(tipo);
		
	}

	@Override
	public void delete(TipoWeb obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TipoWeb obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<TipoWeb> getAll() {
		if (tipos == null) {
			EntityManager entityMng = Conection.getEntityManager();
			tipos = FXCollections.observableArrayList(
					entityMng.createQuery("select TipoWeb from TipoWeb as TipoWeb", TipoWeb.class).getResultList());
			entityMng.close();
		}
		return tipos;
	}
	
	

}
