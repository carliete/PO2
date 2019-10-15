package CbListas;

import java.util.List;

import javax.persistence.EntityManager;

import ConexaoBd.Conection;
import Dao.InterfaceDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class IdiomaDao implements InterfaceDAO<Idioma> {

	
	private static ObservableList<Idioma> idiomas;
	
	
	@Override
	public Idioma get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Idioma> getAll() {
			if (idiomas == null) {
				EntityManager entityMng = Conection.getEntityManager();
				idiomas = FXCollections.observableArrayList(
						entityMng.createQuery("select idiomas from Idioma as idiomas", Idioma.class).getResultList());
				entityMng.close();
			}
			return idiomas;
	}

	@Override
	public void add(Idioma idioma) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		entityMng.persist(idioma);
		entityMng.getTransaction().commit();
		entityMng.close();
		if (idiomas != null)
			idiomas.add(idioma);
		
	}

	@Override
	public void delete(Idioma obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Idioma obj) {
		// TODO Auto-generated method stub
		
	}

}
