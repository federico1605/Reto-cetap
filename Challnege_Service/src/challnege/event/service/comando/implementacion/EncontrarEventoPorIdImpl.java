package challnege.event.service.comando.implementacion;

import java.util.List;

import challnege.event.Crosscuting.excepciones.ChallengeCustomException;
import challnege.event.Crosscuting.excepciones.DataChallengeExecpcion;
import challnege.event.Domain.ClienteDTO;
import challnege.event.Domain.EventoDTO;
import challnege.event.data.daoFactory.DAOFactory;
import challnege.event.data.daoFactory.enumaracion.DAOFactoryType;
import challnege.event.service.comando.EncontrarEventoPorId;

public class EncontrarEventoPorIdImpl implements EncontrarEventoPorId{

	DAOFactory factory;
	
	@Override
	public List<ClienteDTO> getByCC(String cc) {
		try {
			factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
			return factory.getEventosDAO().buscarPorId(cc);
			
		} catch (ChallengeCustomException e) {
			factory.cancelTransaction();
			throw e;
		}
		catch (Exception e) {
			factory.cancelTransaction();
			throw DataChallengeExecpcion.createTechnicalException(e.getMessage());
		}finally {
			factory.closeConnection();
		}
	}

}
