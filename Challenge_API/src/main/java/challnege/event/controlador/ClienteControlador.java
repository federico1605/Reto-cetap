package challnege.event.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challnege.event.Crosscuting.excepciones.ChallengeCustomException;
import challnege.event.Crosscuting.messages.Message;
import challnege.event.Crosscuting.messages.Messages;
import challnege.event.Domain.ClienteDTO;
import challnege.event.response.Response;
import challnege.event.service.comando.CrearClienteComando;
import challnege.event.service.comando.implementacion.CrearClienteComandoImpl;
import challnege.event.validador.Validator;
import challnege.event.validador.cliente.CrearClienteValidator;

@RestController
@RequestMapping("/cetad/customer")
public class ClienteControlador {

	public CrearClienteComando crearCliente = new CrearClienteComandoImpl();
	
	@GetMapping("/find")
	public ClienteDTO cliente() {
		return new ClienteDTO();
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Response<ClienteDTO>> crear(@RequestBody ClienteDTO cliente){
		
		final Response<ClienteDTO> response = new Response<>();
		HttpStatus httpStatus = HttpStatus.OK;
		
		try {
			Validator<ClienteDTO> validator = new CrearClienteValidator();
			List<Message> messages = validator.validate(cliente); 
			
			if(messages.isEmpty()) {
				crearCliente.execute(cliente);
				final List<ClienteDTO> data = new ArrayList<>();
				data.add(cliente);
				response.setData(data);
				
				response.addSuccessMessages(Messages.ClienteController.CONTROLADOR_CREACION_DE_CLIENTE_EXISTOSA);
			} else {
				response.setMessages(messages);
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (final ChallengeCustomException e) {
			if(e.isTechnicalException()) {
				response.addErrorMessages(Messages.ClienteController.CONTROLADOR_PROBLEMA_TECNICO_TRATANDO_CREAR_CLIENTE);
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response.addErrorMessages(e.getMessage());
			}
			e.printStackTrace();
		} catch (final Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.addFatalMessages(Messages.ClienteController.CONTROLADOR_PROBLEMA_TECNICO_TRATANDO_CREAR_CLIENTE);
			
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(response, httpStatus);
	}
}
