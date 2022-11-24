package challnege.event.service.usecase.evento.implementacion;

import challnege.event.Domain.EventoDTO;
import challnege.event.data.daoFactory.DAOFactory;
import challnege.event.service.usecase.evento.CrearEnvetoUseCase;

public class CrearEventoUseCaseImpl implements CrearEnvetoUseCase{

	private final DAOFactory factory;
	
	public CrearEventoUseCaseImpl(DAOFactory factory) {
		super();
		this.factory = factory;
	}
	
	@Override
	public void crear(EventoDTO evento) {
		factory.getEventosDAO().crear(evento);
		
	}

}
