package challnege.event.Domain;

import static challnege.event.Crosscuting.helper.StringHelper.applyTrim;
import static challnege.event.Crosscuting.helper.StringHelper.EMPTY;;

public class ClienteDTO {

	private String nombre;
	private String cc;
	
	public ClienteDTO() {
		setNombre(EMPTY);
		setCc(EMPTY);
	}
	
	public ClienteDTO(final String nombre,final  String cc) {
		setNombre(nombre);
		setCc(cc);
	}
	
	public static final ClienteDTO crear(final String nombre, final String cc) {
		return new ClienteDTO(nombre,cc);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public final void setNombre(final String nombre) {
		this.nombre = applyTrim(nombre);
	}
	
	public String getCc() {
		return cc;
	}
	
	public final void setCc(final String cc) {
		this.cc = applyTrim(cc);
	}
}
