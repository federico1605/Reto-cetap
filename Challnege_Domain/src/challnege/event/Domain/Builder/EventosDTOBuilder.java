package challnege.event.Domain.Builder;

import java.sql.Date;
import java.sql.Time;

import challnege.event.Domain.ClienteDTO;
import challnege.event.Domain.EventosDTO;

import static challnege.event.Domain.EventosDTO.crear;

public class EventosDTOBuilder {

	private Date fecha;
	private Time hora;
	private ClienteDTO cliente;
	private String salon;
	
	private EventosDTOBuilder() {
		super();
	}
	
	public static final EventosDTOBuilder getEventosDTOBuilder() {
		return new EventosDTOBuilder();
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public void setSalon(String salon) {
		this.salon = salon;
	}
	
	public final EventosDTO build() {
		return crear(fecha,hora,cliente,salon);
	}
}
