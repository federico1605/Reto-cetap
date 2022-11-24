package challnege.event.service.comando;

import java.util.List;

import challnege.event.Domain.ClienteDTO;

public interface EncontrarEventoPorId {

	public List<ClienteDTO> getByCC(String cc);
}
