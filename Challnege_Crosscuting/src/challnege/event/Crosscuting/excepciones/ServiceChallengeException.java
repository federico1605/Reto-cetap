package challnege.event.Crosscuting.excepciones;

import static challnege.event.Crosscuting.helper.StringHelper.EMPTY;

import challnege.event.Crosscuting.excepciones.enumeracion.LayerException;


public class ServiceChallengeException extends ChallengeCustomException{

	private static final long serialVersionUID = -2530186233965561937L;

	private ServiceChallengeException(Exception rootException, String technicalMessage, String userMessage) {
		super(rootException, technicalMessage, userMessage, LayerException.SERVICE);
	}

	public static final ChallengeCustomException create(final String userMessage, final String technicalMessage) {
		return new ServiceChallengeException(new Exception(), technicalMessage, userMessage);
	}

	public static final ChallengeCustomException create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new ServiceChallengeException(rootException, technicalMessage, userMessage);
	}

	public static final ChallengeCustomException createTechnicalException(final String technicalMessage) {
		return new ServiceChallengeException(new Exception(), technicalMessage, EMPTY);
	}

	public static final ChallengeCustomException createTechnicalException(final String technicalMessage,
			final Exception rootException) {
		return new ServiceChallengeException(rootException, technicalMessage, EMPTY);
	}

	public static final ChallengeCustomException createBussinesException(final String bussinesMessage,
			final Exception rootException) {
		return new ServiceChallengeException(rootException, EMPTY, bussinesMessage);
	}

	public static final ChallengeCustomException createUserException(final String userMessage) {
		return new ServiceChallengeException(new Exception(), EMPTY, userMessage);
	}

	public static final ChallengeCustomException wrapException(final String message, final ChallengeCustomException exception) {
		if(exception.isTechnicalException()) {
			return ServiceChallengeException.createBussinesException(message, exception);
		}
		return exception;
	}
}
