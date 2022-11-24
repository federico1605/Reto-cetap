package challnege.event.Crosscuting.excepciones;

import challnege.event.Crosscuting.excepciones.enumeracion.LayerException;

import static challnege.event.Crosscuting.helper.StringHelper.EMPTY;

public class CrosscutingChallengeException extends ChallengeCustomException {

	private static final long serialVersionUID = 6462925700733081761L;
	
	private CrosscutingChallengeException(final Exception rootException, final String technicalMessage,
			final String userMessage) {
		super(rootException, technicalMessage, userMessage, LayerException.CROSSCUTTING);
	}
	
	public static final ChallengeCustomException create(final String userMessage, final String technicalMessage) {
		return new CrosscutingChallengeException(new Exception(), technicalMessage, userMessage);
	}

	public static final ChallengeCustomException create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new CrosscutingChallengeException(rootException, technicalMessage, userMessage);
	}

	public static final ChallengeCustomException createTechnicalException(final String technicalMessage) {
		return new CrosscutingChallengeException(new Exception(), technicalMessage,EMPTY);
	}
	
	public static final ChallengeCustomException createTechnicalException(final String technicalMessage, final Exception rootException) {
		return new CrosscutingChallengeException(rootException, technicalMessage,EMPTY);
	}
	
	public static final ChallengeCustomException createUserException(final String userMessage, final Exception rootException) {
		return new CrosscutingChallengeException(rootException, userMessage, userMessage);
	}
}
