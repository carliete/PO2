package CbListas;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Idioma {

	@Id
	private String cod;
	private String IdioNome;

	public String getIdioNome() {
		return IdioNome;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public void setIdioNome(String idioNome) {
		IdioNome = idioNome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
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
		Idioma other = (Idioma) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

	public Idioma(String cod, String idioNome) {
		super();
		this.cod = cod;
		IdioNome = idioNome;
	}

	public Idioma() {
		super();
	}

	@Override
	public String toString() {
		return (getCod() + "    " + getIdioNome());
	}
	
	

}
