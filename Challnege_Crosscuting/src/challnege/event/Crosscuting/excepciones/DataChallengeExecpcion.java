package challnege.event.Crosscuting.excepciones;

import challnege.event.Crosscuting.excepciones.enumeracion.LayerException;

import static challnege.event.Crosscuting.helper.StringHelper.EMPTY;

public class DataChallengeExecpcion extends ChallengeCustomException{

	private static final long serialVersionUID = -2149558877979447021L;
	
	private DataChallengeExecpcion(final Exception rootException, final String technicalMessage,
			final String userMessage) {
		super(rootException, technicalMessage, userMessage, LayerException.DATA);
	}
	
	public static final ChallengeCustomException create(final String userMessage, final String technicalMessage) {
		return new DataChallengeExecpcion(new Exception(), technicalMessage, userMessage);
	}

	public static final ChallengeCustomException create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DataChallengeExecpcion(rootException, technicalMessage, userMessage);
	}

	public static final ChallengeCustomException createTechnicalException(final String technicalMessage) {
		return new DataChallengeExecpcion(new Exception(), technicalMessage,EMPTY);
	}
	
	public static final ChallengeCustomException createTechnicalException(final String technicalMessage, final Exception rootException) {
		return new DataChallengeExecpcion(rootException, technicalMessage,EMPTY);
	}
	
	public static final ChallengeCustomException createUserException(final String userMessage, final Exception rootException) {
		return new DataChallengeExecpcion(rootException, userMessage, userMessage);
	}
}
