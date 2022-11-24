package challnege.event.validador.cliente;

import java.util.ArrayList;
import java.util.List;

import challnege.event.Crosscuting.messages.Message;
import challnege.event.Domain.ClienteDTO;
import challnege.event.validador.Validator;

public class CrearClienteValidator implements Validator<ClienteDTO>{

	@Override
	public List<Message> validate(ClienteDTO dto) {
		List<Message> messages = new ArrayList<>(); 
		
		return messages;
	}
}
