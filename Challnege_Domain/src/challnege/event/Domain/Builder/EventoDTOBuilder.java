package challnege.event.Domain.Builder;

import challnege.event.Domain.ClienteDTO;
import challnege.event.Domain.EventoDTO;

import static challnege.event.Domain.EventoDTO.crear;

public class EventoDTOBuilder {

	private String fecha;
	private String hora;
	private ClienteDTO cliente;
	private String salon;
	
	private EventoDTOBuilder() {
		super();
	}
	
	public static final EventoDTOBuilder getEventosDTOBuilder() {
		return new EventoDTOBuilder();
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public void setSalon(String salon) {
		this.salon = salon;
	}
	
	public final EventoDTO build() {
		return crear(fecha,hora,cliente,salon);
	}
}
