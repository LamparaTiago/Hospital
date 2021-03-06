package co.edu.eam.ingesoft.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.hospital.entidades.Examen;
import co.edu.eam.ingesoft.hospital.entidades.TipoCirugia;
import co.edu.eam.ingesoft.hospital.entidades.TipoExamen;
import co.edu.eam.ingesoft.pa.negocio.beans.ExamenEJB;

@FacesConverter(value="tipoExaConverter",forClass=TipoExamen.class)
@Named("tipoExaConverter")
public class TipoExamenConverter implements Converter {

	@EJB
	private ExamenEJB examenEJB;
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() == 0 || string.equals("Seleccione...")) {
			return null;
		}
		return examenEJB.buscarTipoExamen(Integer.parseInt(string));
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj instanceof TipoExamen) {
			TipoExamen tipoExa = (TipoExamen) obj;
			return tipoExa.getId()+"";
		}
		
		return null;
	}

}
