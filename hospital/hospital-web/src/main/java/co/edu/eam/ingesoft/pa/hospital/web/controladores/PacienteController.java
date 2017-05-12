package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.hospital.entidades.Afiliacion;
import co.edu.eam.ingesoft.hospital.entidades.Paciente;
import co.edu.eam.ingesoft.hospital.entidades.Usuario;
import co.edu.eam.ingesoft.hospital.enumeraciones.EstratoEnumeracion;
import co.edu.eam.ingesoft.hospital.enumeraciones.TipoUsuarioEnum;
import co.edu.eam.ingesoft.pa.negocio.beans.PacienteEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Named("pacienteControlador")
@ViewScoped
public class PacienteController implements Serializable{
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(min=4,max=15,message="longitud entre 4 y 15")
	private String cedula;
	
	@Pattern(regexp="[A-Za-z ]*",message="solo Letras")
	@Length(min=3,max=50,message="longitud entre 3 y 50")
	private String nombre;
	
	@Pattern(regexp="[A-Za-z ]*",message="solo Letras")
	@Length(min=3,max=50,message="longitud entre 3 y 50")
	private String apellido;
	
	@Email
	private String correo;
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(max=20,message="maximo 20 digitos")
	private String telefono;
	
	private int edad;
	
	@Length(max=20,message="maximo 20 digitos")
	private String nickname;
	
	private String contrasenia;
	
	
	private EstratoEnumeracion estrato;
	
	public EstratoEnumeracion[] getTipos(){
		return EstratoEnumeracion.values();
	}
	
	private Integer afiliacionCodigo;
	
	@Pattern(regexp="[A-Za-z ]*",message="Este campo solo acepta letras")
	@Length(min=4,max=10,message="longitud entre 4 y 50")
	private String trabajo;
	
	private Afiliacion a;
	private List<Afiliacion> listaafiliaciones;
	private List<Paciente> listapaciente;


	
	@EJB
	private PacienteEJB paciEJB;
	
	@PostConstruct
	public void inicializador(){
		listaafiliaciones = paciEJB.listarAfiliacion();
		listapaciente = paciEJB.listarPaciente();
	}
	
	
	
	public String getCedula() {
		return cedula;
	}



	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getContrasenia() {
		return contrasenia;
	}



	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}



	public EstratoEnumeracion getEstrato() {
		return estrato;
	}



	public void setEstrato(EstratoEnumeracion estrato) {
		this.estrato = estrato;
	}





	public Integer getAfiliacionCodigo() {
		return afiliacionCodigo;
	}



	public void setAfiliacionCodigo(Integer afiliacionCodigo) {
		this.afiliacionCodigo = afiliacionCodigo;
	}



	public String getTrabajo() {
		return trabajo;
	}



	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}



	public Afiliacion getA() {
		return a;
	}



	public void setA(Afiliacion a) {
		this.a = a;
	}



	public List<Afiliacion> getListaafiliaciones() {
		return listaafiliaciones;
	}



	public void setListaafiliaciones(List<Afiliacion> listaafiliaciones) {
		this.listaafiliaciones = listaafiliaciones;
	}



	public List<Paciente> getListapaciente() {
		return listapaciente;
	}



	public void setListapaciente(List<Paciente> listapaciente) {
		this.listapaciente = listapaciente;
	}



	public PacienteEJB getPaciEJB() {
		return paciEJB;
	}



	public void setPaciEJB(PacienteEJB paciEJB) {
		this.paciEJB = paciEJB;
	}



	public void crearPaciente(){
	try{
		Afiliacion a = paciEJB.buscarAfiliacion(afiliacionCodigo);
		Paciente pa = new Paciente (cedula, nickname, contrasenia, nombre, apellido, edad, 
				correo, TipoUsuarioEnum.Paciente, telefono,estrato, a, trabajo);
		
		paciEJB.crearPaciente(pa);
		limpiar();
		Messages.addFlashGlobalInfo("PACIENTE INGRESADO AL SISTEMA CORRECTAMENTE");
			
	} catch (ExcepcionNegocio e) {
	       Messages.addGlobalError(e.getMessage());
		   }
	}
	/**
	 * 
	 */
	public void limpiar(){
		
		nombre ="";
		apellido  ="";
		cedula ="";
		nickname ="";
		correo="";
		contrasenia = "";
		edad = 0;
		telefono = "";
	    trabajo = "";
	    
		
	}
	
public void buscarPaciente(){
		
		Paciente pa = paciEJB.buscarPaciente(cedula);
		if(pa!=null){
			cedula = pa.getCedula();
			estrato = pa.getEstrato();
			trabajo= pa.getTrabajo();
			afiliacionCodigo =Integer.parseInt (pa.getAfiliacionCodigo().getNombre() );
			Messages.addFlashGlobalInfo("Paciente encontrado");

		} else {
			Messages.addFlashGlobalWarn("El paciente no se encuentra");
		}
	}

public void borrarPaciente(Paciente pa) {

	paciEJB.eliminarPaciente(pa);
	Messages.addFlashGlobalInfo("El paciente ha sido eliminado");
	listapaciente = paciEJB.listarPaciente();
}

public void editarPaciente() {
	Paciente pa = paciEJB.buscarPaciente(cedula);
	if (pa != null) {
		pa.setEstrato(estrato);
		pa.setTrabajo(trabajo);
		pa.getAfiliacionCodigo().getNombre();
		listapaciente = paciEJB.listarPaciente();
		
		Messages.addFlashGlobalInfo("El paciente a sido editado ");
	} else {
		Messages.addFlashGlobalWarn("El paciente no existe");
	}
}


}
	
	
	
	
	
	
	
	
	


