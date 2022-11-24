package challnege.event.data.daoFactory;

import challnege.event.Crosscuting.excepciones.DataChallengeExecpcion;
import challnege.event.Crosscuting.messages.Messages;
import challnege.event.data.dao.ClienteDAO;
import challnege.event.data.dao.EventosDAO;
import challnege.event.data.daoFactory.enumaracion.DAOFactoryType;

public abstract class DAOFactory {
	
	public static final DAOFactory getDAOFactory(final DAOFactoryType factory) {
		
		DAOFactory daoFactory;
	
		switch (factory) {
		case POSTGRESQL: {
			try {
				daoFactory = new PostgreSqlDAOFactory();
			} catch (Exception exception) {
				throw DataChallengeExecpcion.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_NULL, exception);
			}
			break;
			}
			case SQL_SERVER: {
				throw DataChallengeExecpcion
						.createTechnicalException(Messages.DAOFactory.TECHNICAL_MY_SQL_NOT_IMPLEMENTED);
			}
			case ORACLE: {
				throw DataChallengeExecpcion
						.createTechnicalException(Messages.DAOFactory.TECHNICAL_ORACLE_NOT_IMPLEMENTED);
			}
			default:
				throw DataChallengeExecpcion.createTechnicalException(Messages.DAOFactory.TECHNICAL_UNEXPECTED_DAOFACTORY);
			
		}
		return daoFactory;
	}
	
	protected abstract void openConnection();

	public abstract void initTransaction();

	public abstract void confirmTransaction();

	public abstract void cancelTransaction();

	public abstract void closeConnection();
	
	public abstract ClienteDAO getClienteDAO();
	
	public abstract EventosDAO getEventosDAO();
}
