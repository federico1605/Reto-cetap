package challnege.event.Crosscuting.messages;

public class Messages {
	
	private Messages() {
		super();
	}

	public static class SqlConnectionHelper {
			
			private SqlConnectionHelper() {
				super();
			}
			
			public static final String TECHNICAL_CONNECTION_IS_NULL="Connection is null";
			public static final String TECHNICAL_CONNECTION_IS_CLOSED="Connection is closed";
			public static final String TECHNICAL_CONNECTION_ALREDY_IS_CLOSED = "Connection alredy is closed";
			public static final String TECHNICAL_PROBLEM_CLOSING_CONNECTION = "There was a problem try close the connection. Please verify the technicals details";
			public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_INIT_TRANSACTION = "Connection is closed to start a new transaction";
			public static final String TECHNICAL_PROBLEM_TRY_INIT_TRANSACTION = "There was a problem trying to start the transaction. Please verify the technical details";	
			public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_COMMIT_TRANSACTION = "Connection is closed to commit the current transaction";
			public static final String TECHNICAL_PROBLEM_TRY_COMMIT_TRANSACTION = "There was a problem trying to commit the current trasaction. Please verify te technical details";
			public static final String TECHNICAL_CONNECTION_IS_CLOSED_FOR_ROLLBACK_TRANSACTION = "Connection is closed to rollback the current transaction";
			public static final String TECHNICAL_PROBLEM_TRY_ROLLBACK_TRANSACTION = "There was a problem trying to rollback the current trasaction. Please verify te technical details";
	
		}
	
	public static class PostgreSqlDAOFactory{
			
		private PostgreSqlDAOFactory() {
			super();
		}
		
		public static final String TECHNICAL_CONNECTION_NOT_POSSIBLE = "The connection is not possible";
		public static final String TECHNICAL_OPEN_CONNECTION_UNEXPECTED_ERROR = "The was an unexpected error trying openning connection in PostgreSqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_INIT_TRANSACTION = "There was a problem trying to init transaction with the current connection in PostgreSqlDAOFactory";
		public static final String TECHNICAL_INIT_TRANSACTION_UNEXPECTED_ERROR = "There was an unexpected error trying init transaction in PostgreSqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_CONFIRM_TRANSACTION = "There was a problem trying to confirm transaction with the current connection in PostgreSqlDAOFactory";
		public static final String TECHNICAL_CONFIRM_TRANSACTION_UNEXPECTED_ERROR = "There was an unexpected error trying confirm transaction in PostgreSqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_CANCEL_TRANSACTION = "There was a problem trying to cancel transaction with the current connection in PostgreSqlDAOFactory";
		public static final String TECHNICAL_CANCEL_TRANSACTION_UNEXPECTED_ERROR = "There was an unexpected error trying cancel transaction in PostgreSqlDAOFactory";
		public static final String TECHNICAL_PROBLEM_CLOSE_CONNECTION = "There was a problem trying to close connection in PostgreSqlDAOFactory";
		public static final String TECHNICAL_CLOSE_CONNECTION_UNEXPECTED_ERROR = "There was an unexpected error trying close connection in PostgreSqlDAOFactory";
	}
	
	public static  class ClientePostgreSqlDAO {
		
		private ClientePostgreSqlDAO() {
			super();
		}
		
		public static final String PROBLEMA_TECNICO_INESPERADO_CREANDO_CLIENTE =  "Hubo un problema inesperado intentando crear un cliente en ClientePostgreSqlDAO";
		public static final String PROBLEMA_TECNICO_CREANDO_CLIENTE =  "Hubo un problema intentando crear un cliente en ClientePostgreSqlDAO con id=";
		public static final String PROBLEMA_TECNICO_CREANDO_PREPARED_STAMENT =  "Hubo un problema intentando crear el preparet stament en ClientePostgreSqlDAO";
		public static final String PROBLEMA_TECNICO_INESPERADO_CREANDO_PREPARED_STAMENT =  "Hubo un problema inesperado intentando crear el preparet stament en ClientePostgreSqlDAO";
		public static final String PROBLEMA_EJECUTANDO_QUERY =  "Hubo un problema intentando ejecutar el query en ClientePostgreSqlDAO";
		public static final String PROBLEMA_TECNICO_INESPERADO_EJECUTANDO_QUERY =  "Hubo un problema intentando ejecutar el query en ClientePostgreSqlDAO";
		public static final String PROBLEMA_TECNICO_ESTABLECIENDO_VARIABLES_QUERY =  "Hubo un problema intentando establecer las variables del query en ClientePostgreSqlDAO";
		public static final String PROBLEMA_TECNICO_INESPERADO_ESTABLECIENDO_VARIABLES_QUERY =  "Hubo un problema intentando establecer las variables del query en ClientePostgreSqlDAO";
		public static final String PROBLEMA_TECNICO_INESPERADO_LLENANDO_CLIENTE =  "Hubo un problema intentando llenar los datos de cliente en ClientePostgreSqlDAO";
		public static final String PROBLEMA_TECNICO_LLENANDO_CLIENTE =  "Hubo un problema intentando llenar los datos de cliente en ClientePostgreSqlDAO";
	}
	
	public static class EventoPostgreSqlDAO{
		private EventoPostgreSqlDAO() {
			super();
		}
		
		public static final String PROBLEMA_TECNICO_INESPERADO_CREANDO_EVENTO =  "Hubo un problema inesperado intentando crear un evento en EventoPostgreSqlDAO";
		public static final String PROBLEMA_TECNICO_CREANDO_EVENTO =  "Hubo un problema intentando crear un evento en EventoPostgreSqlDAO con id=";
		public static final String PROBLEMA_TECNICO_CREANDO_PREPARED_STAMENT =  "Hubo un problema intentando crear el preparet stament en EventoPostgreSqlDAO";
		public static final String PROBLEMA_TECNICO_INESPERADO_CREANDO_PREPARED_STAMENT =  "Hubo un problema inesperado intentando crear el preparet stament en EventoPostgreSqlDAO";
		public static final String PROBLEMA_EJECUTANDO_QUERY =  "Hubo un problema intentando ejecutar el query en EventoPostgreSqlDAO";
		public static final String PROBLEMA_TECNICO_INESPERADO_EJECUTANDO_QUERY =  "Hubo un problema intentando ejecutar el query en EventoPostgreSqlDAO";
		public static final String PROBLEMA_TECNICO_ESTABLECIENDO_VARIABLES_QUERY =  "Hubo un problema intentando establecer las variables del query en EventoPostgreSqlDAO";
		public static final String PROBLEMA_TECNICO_INESPERADO_ESTABLECIENDO_VARIABLES_QUERY =  "Hubo un problema intentando establecer las variables del query en EventoPostgreSqlDAO";
		public static final String PROBLEMA_TECNICO_INESPERADO_LLENANDO_CLIENTE =  "Hubo un problema intentando llenar los datos de evento en EventoPostgreSqlDAO";
		public static final String PROBLEMA_TECNICO_LLENANDO_CLIENTE =  "Hubo un problema intentando llenar los datos de evento en EventoPostgreSqlDAO";
	}

	public static class DAOFactory {
		
		private DAOFactory() {
			super();
		}
		
		public static final String TECHNICAL_MY_SQL_NOT_IMPLEMENTED="DAOFactory for MYSQL is'nt implemented yet";
		public static final String TECHNICAL_ORACLE_NOT_IMPLEMENTED="DAOFactory for ORACLE is'nt implemented yet";
		public static final String TECHINICAL_SQL_SERVER_NOT_IMPLEMENTED="DAOFactory for SQLSERVER is'nt implemented yet";
		public static final String TECHNICAL_UNEXPECTED_DAOFACTORY= "Unexpected DAOFactory is'nt implemented";
	}
	
	public static class ClienteController{
		private ClienteController() {
			super();
		}
		
		public static final String CONTROLADOR_PROBLEMA_TECNICO_TRATANDO_CREAR_CLIENTE = "Hubo un problema creando el cliente. Por favor intente de nuevo";
		public static final String CONTROLADOR_CREACION_DE_CLIENTE_EXISTOSA = "Cliente fue creado con exito";
		public static final String CONTROLADOR_EXITO_ENCONTRANDO_CLIENTE_POR_CEDULA = "Cliente fue encontrado";
		public static final String CONTROLADOR_ERROR_TRATTANDO_ENCONTRAR_CLIENTE_POR_CEDULA = "Cliente no fue encontrado, por favor dijite de nuevo la cedula";
	}
}	