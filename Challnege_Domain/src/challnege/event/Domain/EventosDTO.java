package challnege.event.Domain;

import java.sql.Date;
import java.sql.Time;

import static challnege.event.Crosscuting.helper.TimeHelper.getDefaultTimeIfNull;
import static challnege.event.Crosscuting.helper.DateHelper.getDefaultDate;
import static challnege.event.Crosscuting.helper.DateHelper.DEFAULT_DATE;
import static challnege.event.Crosscuting.helper.TimeHelper.TIME;
import static challnege.event.Crosscuting.helper.StringHelper.EMPTY;
import static challnege.event.Domain.Builder.ClienteDTOBuilder.getClienteDTOBuilder; 
import static challnege.event.Crosscuting.helper.ObjectHelper.getDefaultIfNull;
import static challnege.event.Crosscuting.helper.StringHelper.applyTrim;

public class EventosDTO {

	private Date fecha;
	private Time hora;
	private ClienteDTO cliente;
	private String salon;
	
	public EventosDTO() {
		setCliente(getClienteDTOBuilder().build());
		setFecha(DEFAULT_DATE);
		setHora(TIME);
		setSalon(EMPTY);
	}
	
	public EventosDTO(final Date fecha,final Time hora,final ClienteDTO cliente,final String salon) {
		setCliente(cliente);
		setFecha(fecha);
		setHora(hora);
		setSalon(salon);
	}
	
	public static final EventosDTO crear(final Date fecha,final Time hora,final ClienteDTO cliente,final String salon) {
		return new EventosDTO(fecha,hora,cliente,salon);
	}
	
	public Date getFecha() {
		return fecha;
	}
	public final void setFecha(final Date fecha) {
		this.fecha = getDefaultDate(fecha);
	}
	public Time getHora() {
		return hora;
	}
	public final void setHora(final Time hora) {
		this.hora = getDefaultTimeIfNull(hora);
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
