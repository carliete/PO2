package CbListas;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Privacidade {
	
	@Id
	private String Cod;
	private String PrivNome;
	public String getCod() {
		return Cod;
	}
	public void setCod(String cod) {
		Cod = cod;
	}
	public String getPrivNome() {
		return PrivNome;
	}
	public void setPrivNome(String privNome) {
		PrivNome = privNome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cod == null) ? 0 : Cod.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Privacidade other = (Privacidade) obj;
		if (Cod == null) {
			if (other.Cod != null)
				return false;
		} else if (!Cod.equals(other.Cod))
			return false;
		return true;
	}
	public Privacidade(String cod, String privNome) {
		super();
		Cod = cod;
		PrivNome = privNome;
	}
	public Privacidade() {
		super();
	}
	@Override
	public String toString() {
		return (getCod() + "  " + getPrivNome());
	}


}
