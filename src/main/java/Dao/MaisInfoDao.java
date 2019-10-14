package Dao;

import java.util.List;

import javax.persistence.EntityManager;

import ConexaoBd.Conection;
import Proj.Po2.Entidades.MaisInfo;

import javafx.collections.ObservableList;

public class MaisInfoDao  implements InterfaceDAO<MaisInfo>  {

	private static ObservableList<MaisInfo> MaisInfos;
	
	@Override
	public MaisInfo get(String id) {
		return null;
	}

	@Override
	public List<MaisInfo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(MaisInfo MaisInfo) {
		EntityManager entityMng = Conection.getEntityManager();
		entityMng.getTransaction().begin();
		entityMng.persist(MaisInfo);
		entityMng.getTransaction().commit();
		entityMng.close();
		
	}

	@Override
	public void delete(MaisInfo obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MaisInfo obj) {
		// TODO Auto-generated method stub
		
	}

}
