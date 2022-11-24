package challnege.event.service.usecase.cliente.implementacion;

import challnege.event.Domain.ClienteDTO;
import challnege.event.data.daoFactory.DAOFactory;
import challnege.event.service.usecase.cliente.CrearClienteUsecCase;

public class CrearClienteUseCaseImpl implements CrearClienteUsecCase{

	private final DAOFactory factory;
	
	public CrearClienteUseCaseImpl(DAOFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public void crear(ClienteDTO cliente) {
	
		factory.getClienteDAO().crear(cliente);

	}
}
