package challnege.event.Crosscuting.excepciones;

import challnege.event.Crosscuting.excepciones.enumeracion.LayerException;

import static challnege.event.Crosscuting.helper.StringHelper.EMPTY;

public class UseCaseCustomException extends ChallengeCustomException{

	private static final long serialVersionUID = -3170033697115883411L;

	private UseCaseCustomException(final Exception rootException, final String technicalMessage,
			final String userMessage) {
		super(rootException, technicalMessage, userMessage, LayerException.USECASE);
	}

	public static final ChallengeCustomException create(final String userMessage, final String technicalMessage) {
		return new UseCaseCustomException(new Exception(), technicalMessage, userMessage);
	}

	public static final ChallengeCustomException create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new UseCaseCustomException(rootException, technicalMessage, userMessage);
	}

	public static final ChallengeCustomException createTechnicalException(final String technicalMessage) {
		return new UseCaseCustomException(new Exception(), technicalMessage,EMPTY);
	}
	
	public static final ChallengeCustomException createTechnicalException(final String technicalMessage, final Exception rootException) {
		return new UseCaseCustomException(rootException, technicalMessage,EMPTY);
	}
	
	public static final ChallengeCustomException createUserException(final String userMessage, final Exception rootException) {
		return new UseCaseCustomException(rootException, userMessage, userMessage);
	}
	
	public static final ChallengeCustomException createUserException(final String userMessage) {
		return new UseCaseCustomException(new Exception(), userMessage, EMPTY);
	}
}
