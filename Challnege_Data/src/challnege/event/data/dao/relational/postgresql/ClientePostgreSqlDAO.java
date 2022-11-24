package challnege.event.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import challnege.event.Crosscuting.excepciones.DataChallengeExecpcion;
import challnege.event.Crosscuting.messages.Messages;
import challnege.event.Domain.ClienteDTO;
import challnege.event.Domain.EventoDTO;
import challnege.event.data.dao.ClienteDAO;
import challnege.event.data.dao.relational.DAORelational;

public class ClientePostgreSqlDAO extends DAORelational implements ClienteDAO{

	public ClientePostgreSqlDAO(Connection connection) {
		super(connection);
	}
	
	@Override
	public final void crear(final ClienteDTO cliente) {
		final var sql = "INSERT INTO public.cliente(cc,nombre)"
				+ "VALUES(?,?)";
		
		try (final var preparedStatement = getConnection().prepareCall(sql)) {
			preparedStatement.setString(1, cliente.getCc());
			preparedStatement.setString(2, cliente.getNombre());
			
			preparedStatement.executeUpdate();
		} catch (final SQLException e) {
			final String message = Messages.ClientePostgreSqlDAO.PROBLEMA_TECNICO_CREANDO_CLIENTE.
					concat(cliente.getNombre());
			throw DataChallengeExecpcion.createTechnicalException(message, e);
		} catch (final Exception e) {
			throw DataChallengeExecpcion.createTechnicalException(Messages.ClientePostgreSqlDAO.PROBLEMA_TECNICO_INESPERADO_CREANDO_CLIENTE, e);
		}
	}
	
private final List<ClienteDTO> fillResults(final ResultSet resultSet){
		
		try {
			var results = new ArrayList<ClienteDTO>();
			
			while(resultSet.next()) {
				results.add(fillCliente(resultSet));
			}
			return results;
		} catch (final DataChallengeExecpcion exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataChallengeExecpcion.createTechnicalException(Messages.ClientePostgreSqlDAO.PROBLEMA_EJECUTANDO_QUERY, exception);      
	}
}

private final ClienteDTO fillCliente(final ResultSet resultSet) {
	try {
		return ClienteDTO.crear(resultSet.getString("nombre"), resultSet.getString("cc"));
	} catch (final SQLException e) {
		throw DataChallengeExecpcion.createTechnicalException(Messages.ClientePostgreSqlDAO.PROBLEMA_TECNICO_LLENANDO_CLIENTE, e);
	} catch (final Exception e) {
		throw DataChallengeExecpcion.createTechnicalException(Messages.ClientePostgreSqlDAO.PROBLEMA_TECNICO_INESPERADO_LLENANDO_CLIENTE, e);
	}
}
	
private final List<ClienteDTO> executeQuery(PreparedStatement preparedStatement) {
		
		try (final var resultset = preparedStatement.executeQuery()) {
			
			return fillResults(resultset);
			
		} catch (DataChallengeExecpcion exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataChallengeExecpcion.createTechnicalException(Messages.ClientePostgreSqlDAO.PROBLEMA_EJECUTANDO_QUERY, exception);
		} catch (final Exception exception) {
			throw DataChallengeExecpcion.createTechnicalException(Messages.ClientePostgreSqlDAO.PROBLEMA_TECNICO_INESPERADO_CREANDO_PREPARED_STAMENT, exception);		
		}
	}
	
	@Override
	public List<ClienteDTO> buscarPorCC(String cc) {
		String query = "SELECT * FROM public.evento WHERE cliente = ?";
		try (final var preparedStatement = getConnection().prepareStatement(query)) {

			preparedStatement.setString(1, cc);

			return executeQuery(preparedStatement);

		} catch (final DataChallengeExecpcion exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataChallengeExecpcion.createTechnicalException(
					Messages.EventoPostgreSqlDAO.PROBLEMA_TECNICO_CREANDO_PREPARED_STAMENT
					.concat("\nMore info: ").concat(exception.getMessage()), exception);
		} catch (final Exception exception) {
			throw DataChallengeExecpcion.createTechnicalException(
					Messages.EventoPostgreSqlDAO.PROBLEMA_TECNICO_INESPERADO_CREANDO_PREPARED_STAMENT
					.concat("\nMore info: ").concat(exception.getMessage()), exception);
		}
	}

}
