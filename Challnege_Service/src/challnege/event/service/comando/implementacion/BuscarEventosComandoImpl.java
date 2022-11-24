package challnege.event.service.comando.implementacion;

import java.util.List;

import challnege.event.Crosscuting.excepciones.ChallengeCustomException;
import challnege.event.Domain.EventoDTO;
import challnege.event.data.daoFactory.DAOFactory;
import challnege.event.data.daoFactory.enumaracion.DAOFactoryType;
import challnege.event.service.comando.BuscarEventosComando;

public class BuscarEventosComandoImpl implements BuscarEventosComando{

	private DAOFactory factory;
	
	@Override
	public List<EventoDTO> buscar() {
		try {	
			factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
			return factory.getEventosDAO().buscar(null);
		} catch (ChallengeCustomException e) {
			factory.cancelTransaction();
			throw e;
		} catch(Exception e){
			factory.cancelTransaction();
			throw e;
		}finally {
			factory.closeConnection();
		}
	}

}
