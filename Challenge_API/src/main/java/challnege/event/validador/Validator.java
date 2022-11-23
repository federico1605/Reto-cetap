package challnege.event.validador;

import java.util.List;

import challnege.event.Crosscuting.helper.Message;

public interface Validator<T> {

	List<Message> validate(T dto);
}
