package challnege.event.Domain.Builder;

import challnege.event.Domain.ClienteDTO;
import static challnege.event.Domain.ClienteDTO.crear;

public class ClienteDTOBuilder {

	private String nombre;
	private String cc;
	
	private ClienteDTOBuilder() {
		super();
	}

	public static final ClienteDTOBuilder getClienteDTOBuilder() {
		return new ClienteDTOBuilder();
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}
	
	public final ClienteDTO build() {
		return crear(nombre,cc);
	}
}
