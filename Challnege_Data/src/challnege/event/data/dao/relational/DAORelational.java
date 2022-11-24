package challnege.event.data.dao.relational;

import java.sql.Connection;

import challnege.event.Crosscuting.excepciones.DataChallengeExecpcion;
import challnege.event.Crosscuting.helper.SQLConnectionHelper;
import challnege.event.Crosscuting.messages.Messages;

public class DAORelational {

private Connection connection;
	
	protected DAORelational(final Connection connection) {
		
		if(!SQLConnectionHelper.connectionIsOpen(connection)) {
			throw DataChallengeExecpcion
			.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED);
		}
		
		this.connection = connection;
	}

	protected final Connection getConnection() {
		return connection;
	}
}
