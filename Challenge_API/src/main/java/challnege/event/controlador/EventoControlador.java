package challnege.event.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challnege.event.Crosscuting.excepciones.ChallengeCustomException;
import challnege.event.Crosscuting.excepciones.DataChallengeExecpcion;
import challnege.event.Crosscuting.messages.Message;
import challnege.event.Crosscuting.messages.Messages;
import challnege.event.Domain.ClienteDTO;
import challnege.event.Domain.EventoDTO;
import challnege.event.response.Response;
import challnege.event.service.comando.CrearEventoComando;
import challnege.event.service.comando.implementacion.CrearEventoComandoImpl;
import challnege.event.validador.Validator;
import challnege.event.validador.evento.CrearEventoValidator;
import challnege.event.service.comando.BuscarEventosComando;
import challnege.event.service.comando.implementacion.BuscarEventosComandoImpl;
import challnege.event.service.comando.EncontrarEventoPorId;
import challnege.event.service.comando.implementacion.EncontrarEventoPorIdImpl;

@RestController
@RequestMapping("/cetad/evento")
public class EventoControlador {

	public CrearEventoComando crearevento = new CrearEventoComandoImpl();
	
	@PostMapping("/crearEvento")
	public ResponseEntity<Response<EventoDTO>> crear(@RequestBody EventoDTO evento){
		
		final Response<EventoDTO> response = new Response<>();
		HttpStatus httpStatus = HttpStatus.OK;
		
		try {
			Validator<EventoDTO> validator = new CrearEventoValidator();
			List<Message> messages = validator.validate(evento);
			
			if(messages.isEmpty()) {
				crearevento.execute(evento);
				final List<EventoDTO> data = new ArrayList<>();
				data.add(evento);
				response.setData(data); 
				
				response.addSuccessMessages(Messages.ClienteController.CONTROLADOR_CREACION_DE_CLIENTE_EXISTOSA);
			} else {
				response.setMessages(messages);
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<>(response, httpStatus);
	}
	
	@GetMapping("/find")
	public ResponseEntity<Response<EventoDTO>> buscar() {
		final Response<EventoDTO> response = new Response<>();
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		try {
			BuscarEventosComando command = new BuscarEventosComandoImpl();
			List<EventoDTO> list = command.buscar();
			response.setData(list);
			httpStatus = HttpStatus.OK;
			response.addSuccessMessages("Success");
			
		}catch(ChallengeCustomException carpoolingException) {
			response.addErrorMessages(carpoolingException.getMessage());
		}
		catch (Exception e) {
			response.addErrorMessages("There was an unexpected error trying to get request information\nMore info: ".concat(e.getMessage()));
		}
		return new ResponseEntity<Response<EventoDTO>>(response, httpStatus);
	}
	
	@GetMapping("/byid/{id}")
	ResponseEntity<Response<ClienteDTO>> getCustomerById(@PathVariable(required = true) String cc) {
		Response<ClienteDTO> response = new Response<>();
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		try {
			EncontrarEventoPorId command = new EncontrarEventoPorIdImpl();
			List<ClienteDTO> dto = command.getByCC(cc);
			if(dto.isEmpty()) {
				throw DataChallengeExecpcion.createTechnicalException(Messages.ClienteController.CONTROLADOR_CREACION_DE_CLIENTE_EXISTOSA);
			}else {
				response.setData(dto);
				httpStatus = HttpStatus.OK;
				response.addSuccessMessages(Messages.ClienteController.CONTROLADOR_CREACION_DE_CLIENTE_EXISTOSA);				
			}
		} catch(ChallengeCustomException e) {
			response.addErrorMessages(e.getMessage());
		}
		catch (Exception e) {
			response.addErrorMessages(e.getMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}
}
