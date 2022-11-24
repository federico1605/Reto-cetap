package challnege.event.service.comando.implementacion;

import challnege.event.Crosscuting.excepciones.ChallengeCustomException;
import challnege.event.Domain.EventoDTO;
import challnege.event.data.daoFactory.DAOFactory;
import challnege.event.data.daoFactory.enumaracion.DAOFactoryType;
import challnege.event.service.comando.CrearEventoComando;
import challnege.event.service.usecase.evento.CrearEnvetoUseCase;
import challnege.event.service.usecase.evento.implementacion.CrearEventoUseCaseImpl;

public class CrearEventoComandoImpl implements CrearEventoComando{

	@Override
	public void execute(EventoDTO evento) {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
		CrearEnvetoUseCase usecase = new CrearEventoUseCaseImpl(factory);
		try {
			factory.initTransaction();
			
			usecase.crear(evento);
			
			factory.confirmTransaction();
		} catch (ChallengeCustomException e) {
			factory.cancelTransaction();
			throw e;
		} catch (Exception e) {
			factory.cancelTransaction();
			e.getMessage();
		} finally {
			factory.closeConnection();
		}
	}

}
