package CbListas;

import java.util.List;

import javax.persistence.EntityManager;

import ConexaoBd.Conection;
import Dao.InterfaceDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PrivacDao implements InterfaceDAO<Privacidade> {

	
	
	private static ObservableList<Privacidade> privs;
	@Override
	public Privacidade get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Privacidade> getAll() {
			if (privs == null) {
				EntityManager entityMng = Conection.getEntityManager();
				privs = FXCollections.observableArrayList(
						entityMng.createQuery("select privs from Privacidade as privs", Privacidade.class).getResultList());
				entityMng.close();
			}
			return privs;
	}

	@Override
	public void add(Privacidade priv) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		entityMng.persist(priv);
		entityMng.getTransaction().commit();
		entityMng.close();
		if (privs != null)
			privs.add(priv);
		
		
	}

	@Override
	public void delete(Privacidade obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Privacidade obj) {
		// TODO Auto-generated method stub
		
	}

}
