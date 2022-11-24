package challnege.event.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import challnege.event.Crosscuting.excepciones.DataChallengeExecpcion;
import challnege.event.Crosscuting.helper.ObjectHelper;
import challnege.event.Crosscuting.helper.StringHelper;
import challnege.event.Crosscuting.messages.Messages;
import challnege.event.Domain.ClienteDTO;
import challnege.event.Domain.EventoDTO;
import challnege.event.data.dao.EventosDAO;
import challnege.event.data.dao.relational.DAORelational;

public class EventosPosgreSqlDAO extends DAORelational implements EventosDAO{

	public EventosPosgreSqlDAO(Connection connection) {
		super(connection);
	}

	@Override
	public final void crear(final EventoDTO evento) {
		final var sql = "INSERT INTO public.evento(salon,dia,hora,"
				+ "cliente) VALUES(?,?,?,?)";
		
		try (final var preparedStatement = getConnection().prepareCall(sql)){
			preparedStatement.setString(1, evento.getSalon());
			preparedStatement.setString(2, evento.getFecha());
			preparedStatement.setString(3, evento.getHora());
			preparedStatement.setString(4, evento.getCliente().getCc());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public List<EventoDTO> buscar(EventoDTO evento) {
		var sqlBuilder = new StringBuilder();
		final var parameters = new ArrayList<Object>();
		
		creatSelectFrom(sqlBuilder);
		creatWhere(sqlBuilder, evento, parameters); 
		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}
	
	private final List<EventoDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder, final List<Object> parameters){
		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())){
			
			SetParameterValues(preparedStatement, parameters);
			
			return executeQuery(preparedStatement);
			
		} catch (final DataChallengeExecpcion exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataChallengeExecpcion.createTechnicalException(Messages.EventoPostgreSqlDAO.PROBLEMA_TECNICO_INESPERADO_CREANDO_PREPARED_STAMENT, exception);
		} catch (final Exception exception) {
			throw DataChallengeExecpcion.createTechnicalException(Messages.EventoPostgreSqlDAO.PROBLEMA_TECNICO_INESPERADO_CREANDO_PREPARED_STAMENT, exception);
		}
	}
	
	private final void creatSelectFrom(final StringBuilder sqlBuilder) {
		sqlBuilder.append("SELECT e.dia AS Fecha,");
		sqlBuilder.append(" e.hora AS Hora,");
		sqlBuilder.append(" e.cliente AS Cliente,");
		sqlBuilder.append(" e.salon AS Salon,");
		sqlBuilder.append(" c.cc AS Cedula,");
		sqlBuilder.append(" c.nombre AS Cliente");
		sqlBuilder.append(" FROM public.evento e");
		sqlBuilder.append(" INNER JOIN public.cliente c");
		sqlBuilder.append(" ON e.cliente = c.cc");
	}
	
	private final void creatWhere(final StringBuilder sqlBuilder, final EventoDTO evento, final List<Object> parameters) {
		if(!ObjectHelper.isNull(evento)) {
			StringHelper.applyTrim(evento.getSalon());
			sqlBuilder.append(" WHERE e.salon = ? ");
			parameters.add(evento.getSalon());
		}
	}
	
	private final List<EventoDTO> executeQuery(PreparedStatement preparedStatement) {
		
		try (final var resultset = preparedStatement.executeQuery()) {
			
			return fillResults(resultset);
			
		} catch (DataChallengeExecpcion exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataChallengeExecpcion.createTechnicalException(Messages.EventoPostgreSqlDAO.PROBLEMA_EJECUTANDO_QUERY, exception);
		} catch (final Exception exception) {
			throw DataChallengeExecpcion.createTechnicalException(Messages.EventoPostgreSqlDAO.PROBLEMA_TECNICO_INESPERADO_EJECUTANDO_QUERY, exception);
		}
	}
	
	private void SetParameterValues (PreparedStatement preparedStatement, final List<Object> parameters) {
		try {
			for(int index = 0; index < parameters.size(); index ++) {
				preparedStatement.setString(index + 1, parameters.get(index).toString());
			}
		} catch (SQLException exception) {
			throw DataChallengeExecpcion.createTechnicalException(Messages.EventoPostgreSqlDAO.PROBLEMA_TECNICO_ESTABLECIENDO_VARIABLES_QUERY, exception);
		} catch (final Exception exception) {
			throw DataChallengeExecpcion.createTechnicalException(Messages.EventoPostgreSqlDAO.PROBLEMA_TECNICO_INESPERADO_ESTABLECIENDO_VARIABLES_QUERY, exception);
		} 
	}

	private final List<EventoDTO> fillResults(final ResultSet resultSet){
			
			try {
				var results = new ArrayList<EventoDTO>();
				
				while(resultSet.next()) {
					results.add(fillEvento(resultSet));
				}
				return results;
			} catch (final DataChallengeExecpcion exception) {
				throw exception;
			} catch (final SQLException exception) {
				throw DataChallengeExecpcion.createTechnicalException(Messages.EventoPostgreSqlDAO.PROBLEMA_TECNICO_INESPERADO_LLENANDO_CLIENTE, exception);      
		}
	}

	private final EventoDTO fillEvento(final ResultSet resultSet) {
		try {
			
				return EventoDTO.crear(resultSet.getString("fecha"), resultSet.getString("hora"), 
						fillClienteDTO(resultSet),resultSet.getString("salon"));

		} catch (final SQLException exception) {
			throw DataChallengeExecpcion.createTechnicalException(Messages.EventoPostgreSqlDAO.PROBLEMA_TECNICO_LLENANDO_CLIENTE, exception);
		} catch (final Exception exception) {
			throw DataChallengeExecpcion.createTechnicalException(Messages.EventoPostgreSqlDAO.PROBLEMA_TECNICO_INESPERADO_LLENANDO_CLIENTE, exception);
		}
	}
	
	private final ClienteDTO fillClienteDTO(final ResultSet resultSet) {
		try {
			return ClienteDTO.crear(resultSet.getString("nombre"),
					resultSet.getString("cc"));
		} catch (final SQLException exception) {
			throw DataChallengeExecpcion.createTechnicalException(Messages.EventoPostgreSqlDAO.PROBLEMA_TECNICO_LLENANDO_CLIENTE, exception);			
		} catch (final Exception exception) {
			throw DataChallengeExecpcion.createTechnicalException(Messages.EventoPostgreSqlDAO.PROBLEMA_TECNICO_INESPERADO_LLENANDO_CLIENTE, exception);
		}
	}

	@Override
	public void modificar(EventoDTO evento) {
		final var sql = "UPDATE evento SET fecha = ? WHERE cliente = ?";
		
		try (final var preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setString(1, evento.getFecha());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public final void cancelar(final EventoDTO cliente) {
		final var sql = "DELETE FROM public.evento WHERE cliente = ?";
		final var getCliente = cliente.getCliente().getCc();
		
		try (final var preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setString(1, getCliente);
			preparedStatement.executeUpdate();
		} catch (final SQLException e) {
			e.getMessage();
		} catch (final Exception e) {
			e.getMessage();
		}
		
	}
}
