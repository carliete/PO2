package Proj.Po2.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MaisInfo {
	@Id
	private String PalaChave;
	private String Nome;
	private String Area;
	private String Priv;
	private String Idioma;
	private String Tipo;

	public MaisInfo(String palaChave, String nome, String area, String priv, String idioma, String tipo) {
		super();
		PalaChave = palaChave;
		Nome = nome;
		Area = area;
		Priv = priv;
		Idioma = idioma;
		Tipo = tipo;
	}

	public MaisInfo() {
		super();
	}

	public String getPalaChave() {
		return PalaChave;
	}

	public void setPalaChave(String palaChave) {
		PalaChave = palaChave;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getPriv() {
		return Priv;
	}

	public void setPriv(String priv) {
		Priv = priv;
	}

	public String getIdioma() {
		return Idioma;
	}

	public void setIdioma(String idioma) {
		Idioma = idioma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PalaChave == null) ? 0 : PalaChave.hashCode());
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
		MaisInfo other = (MaisInfo) obj;
		if (PalaChave == null) {
			if (other.PalaChave != null)
				return false;
		} else if (!PalaChave.equals(other.PalaChave))
			return false;
		return true;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}
}
