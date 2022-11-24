package challnege.event.Domain;

import static challnege.event.Crosscuting.helper.StringHelper.EMPTY;
import static challnege.event.Domain.Builder.ClienteDTOBuilder.getClienteDTOBuilder; 
import static challnege.event.Crosscuting.helper.ObjectHelper.getDefaultIfNull;
import static challnege.event.Crosscuting.helper.StringHelper.applyTrim;

public class EventoDTO {

	private String fecha;
	private String hora;
	private ClienteDTO cliente;
	private String salon;
	
	public EventoDTO() {
		setCliente(getClienteDTOBuilder().build());
		setFecha(EMPTY);
		setHora(EMPTY);
		setSalon(EMPTY);
	}
	
	public EventoDTO(final String fecha,final String hora,final ClienteDTO cliente,final String salon) {
		setCliente(cliente);
		setFecha(fecha);
		setHora(hora);
		setSalon(salon);
	}
	
	public static final EventoDTO crear(final String fecha,final String hora,final ClienteDTO cliente,final String salon) {
		return new EventoDTO(fecha,hora,cliente,salon);
	}
	
	public String getFecha() {
		return fecha;
	}
	public final void setFecha(final String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public final void setHora(final String hora) {
		this.hora = hora;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = getDefaultIfNull(cliente, getClienteDTOBuilder().build());
	}
	public String getSalon() {
		return salon;
	}
	public void setSalon(String salon) {
		this.salon = applyTrim(salon);
	}	
}
