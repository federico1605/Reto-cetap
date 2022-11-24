package challnege.event.validador.evento;

import java.util.ArrayList;
import java.util.List;

import challnege.event.Crosscuting.messages.Message;
import challnege.event.Domain.EventoDTO;
import challnege.event.validador.Validator;

public class CrearEventoValidator implements Validator<EventoDTO>{

	@Override
	public List<Message> validate(EventoDTO dto) {
		List<Message> messages = new ArrayList<>(); 
		
		return messages;
	}
}
