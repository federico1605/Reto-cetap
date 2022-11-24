package challnege.event.data.dao;

import java.util.List;

import challnege.event.Domain.ClienteDTO;

public interface ClienteDAO {

	void crear(ClienteDTO cliente);

	List<ClienteDTO> buscarPorCC(String cc);
}
