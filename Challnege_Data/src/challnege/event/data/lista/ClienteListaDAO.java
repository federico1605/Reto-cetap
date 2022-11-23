package challnege.event.data.lista;

import java.util.ArrayList;
import java.util.List;

import challnege.event.Domain.ClienteDTO;
import challnege.event.data.ClienteDAO;

public class ClienteListaDAO implements ClienteDAO{
	ArrayList<ClienteDTO> clientes;
	
	@Override
	public void crear(ClienteDTO cliente) {
		clientes = new ArrayList<>();
		clientes.add(cliente);
	}

	@Override
	public List<ClienteDTO> buscar(ClienteDTO cliente) {
		return clientes;
	}
}
