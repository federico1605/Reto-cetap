package challnege.event.data;

import java.util.List;

import challnege.event.Domain.ClienteDTO;

public interface ClienteDAO {

	void crear(ClienteDTO cliente);
	
	List<ClienteDTO> buscar(ClienteDTO cliente);
}
