package challnege.event.service.comando.implementacion;

import challnege.event.Crosscuting.excepciones.ChallengeCustomException;
import challnege.event.Domain.ClienteDTO;
import challnege.event.data.daoFactory.DAOFactory;
import challnege.event.data.daoFactory.enumaracion.DAOFactoryType;
import challnege.event.service.comando.CrearClienteComando;
import challnege.event.service.usecase.cliente.CrearClienteUsecCase;
import challnege.event.service.usecase.cliente.implementacion.CrearClienteUseCaseImpl;

public class CrearClienteComandoImpl implements CrearClienteComando{
	
	@Override
	public void execute(ClienteDTO cliente) {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.POSTGRESQL);
		CrearClienteUsecCase usecase = new CrearClienteUseCaseImpl(factory);
		try {
			factory.initTransaction();
			
			usecase.crear(cliente);
			
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
