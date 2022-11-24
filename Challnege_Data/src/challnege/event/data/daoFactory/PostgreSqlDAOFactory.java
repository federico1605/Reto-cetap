package challnege.event.data.daoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import challnege.event.Crosscuting.excepciones.CrosscutingChallengeException;
import challnege.event.Crosscuting.excepciones.DataChallengeExecpcion;
import challnege.event.Crosscuting.helper.SQLConnectionHelper;
import challnege.event.Crosscuting.messages.Messages;
import challnege.event.data.dao.ClienteDAO;
import challnege.event.data.dao.EventosDAO;
import challnege.event.data.dao.relational.postgresql.ClientePostgreSqlDAO;
import challnege.event.data.dao.relational.postgresql.EventosPosgreSqlDAO;


public class PostgreSqlDAOFactory extends DAOFactory{

	private Connection connection;

	public PostgreSqlDAOFactory() {
		openConnection();
	}
	
	@Override
	protected void openConnection() {
		final String url = "jdbc:postgresql://ec2-35-170-21-76.compute-1.amazonaws.com/df7f8n649fij8i";
		final String user = "jqfqqgioigerua";
		final String pass = "95c86ffbf0eee37a4676aed43dd2f6a420fb1a7d8dd332d70e4aa28b3e5b8f41";
		try {
			connection = DriverManager.getConnection(url,user,pass);
		} catch (SQLException exception) {
			throw DataChallengeExecpcion.createTechnicalException(
					Messages.PostgreSqlDAOFactory.TECHNICAL_CONNECTION_NOT_POSSIBLE, exception);
		} catch (Exception exception) {
			throw DataChallengeExecpcion.createTechnicalException(
					Messages.PostgreSqlDAOFactory.TECHNICAL_OPEN_CONNECTION_UNEXPECTED_ERROR, exception);
		}
	}

	@Override
	public void initTransaction() {
		try {
			SQLConnectionHelper.initTransaction(connection);
		} catch (CrosscutingChallengeException exception) {
			throw DataChallengeExecpcion.createTechnicalException(
					Messages.PostgreSqlDAOFactory.TECHNICAL_PROBLEM_INIT_TRANSACTION, exception);
		} catch (Exception exception) {
			throw DataChallengeExecpcion.createTechnicalException(
					Messages.PostgreSqlDAOFactory.TECHNICAL_INIT_TRANSACTION_UNEXPECTED_ERROR, exception);
		}
	}

	@Override
	public void confirmTransaction() {
		try {
			SQLConnectionHelper.commitTransaction(connection);
		} catch (CrosscutingChallengeException exception) {
			throw DataChallengeExecpcion.createTechnicalException(
					Messages.PostgreSqlDAOFactory.TECHNICAL_PROBLEM_CONFIRM_TRANSACTION, exception);
		} catch (Exception exception) {
			throw DataChallengeExecpcion.createTechnicalException(
					Messages.PostgreSqlDAOFactory.TECHNICAL_CONFIRM_TRANSACTION_UNEXPECTED_ERROR, exception);
		}
	}

	@Override
	public void cancelTransaction() {
		try {
			SQLConnectionHelper.rollbackTransaction(connection);
		} catch (CrosscutingChallengeException exception) {
			throw DataChallengeExecpcion.createTechnicalException(
					Messages.PostgreSqlDAOFactory.TECHNICAL_PROBLEM_CANCEL_TRANSACTION, exception);
		} catch (Exception exception) {
			throw DataChallengeExecpcion.createTechnicalException(
					Messages.PostgreSqlDAOFactory.TECHNICAL_CANCEL_TRANSACTION_UNEXPECTED_ERROR, exception);
		}
	}

	@Override
	public void closeConnection() {
		try {
			SQLConnectionHelper.closeConnection(connection);

		} catch (CrosscutingChallengeException exception) {
			throw DataChallengeExecpcion.createTechnicalException(
					Messages.PostgreSqlDAOFactory.TECHNICAL_PROBLEM_CLOSE_CONNECTION, exception);
		} catch (Exception exception) {
			throw DataChallengeExecpcion.createTechnicalException(
					Messages.PostgreSqlDAOFactory.TECHNICAL_CLOSE_CONNECTION_UNEXPECTED_ERROR, exception);
		}
	}

	@Override
	public ClienteDAO getClienteDAO() {
		return new ClientePostgreSqlDAO(connection);
	}

	@Override
	public EventosDAO getEventosDAO() {
		return new EventosPosgreSqlDAO(connection);
	}
}
