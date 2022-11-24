package challnege.event.Crosscuting.excepciones;

import challnege.event.Crosscuting.excepciones.enumeracion.LayerException;

import static challnege.event.Crosscuting.helper.ObjectHelper.getDefaultIfNull;
import static challnege.event.Crosscuting.helper.StringHelper.applyTrim;
import static challnege.event.Crosscuting.helper.StringHelper.isEmpty;

public class ChallengeCustomException extends RuntimeException{

	private static final long serialVersionUID = -1248346293196099172L;
	private String userMessage;
	private LayerException layer;
	
	protected ChallengeCustomException(final Exception rootException, final String technicalMessage, final String userMessage, final LayerException layer) {
		super(applyTrim(technicalMessage),getDefaultIfNull(rootException, new Exception()));
		setUserMessage(userMessage);
		setLayer(layer);
	}

	public final String getUserMessage() {
		return userMessage;
	}

	private final void setUserMessage(final String userMessage) {
		this.userMessage = applyTrim(userMessage);
	}

	public final LayerException getLayer() {
		return layer;
	}

	private final void setLayer(final LayerException layer) {
		this.layer = getDefaultIfNull(layer, LayerException.APLICATION);
	}
	
	public final boolean isTechnicalException() {
		return isEmpty(getUserMessage());
	}
}
