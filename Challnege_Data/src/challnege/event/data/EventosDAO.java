package challnege.event.data;

import java.util.List;

import challnege.event.Domain.EventoDTO;

public interface EventosDAO {

	void crear(EventoDTO evento);
	
	List<EventoDTO> buscar(EventoDTO evento);
	
	void modificar (EventoDTO evento);
	
	void cancelar (String salon);
}
