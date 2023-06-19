package Interface;

import java.util.List;

import Modelo.Cliente;

public interface DAOCliente {
	
	/**
	 * Gets the list of all Cliente records.   
	 * @return ArrayList of Cliente.
	 * @see Cliente class
	 */
	public List<Cliente> selectClientes();
	
	/**
	 * Create a table Cliente.
	 */
	public void createCliente();
	
	
	/**
	 * Insert a new record Cliente in the table.
	 * @param id the Cliente identifier. 
	 * @param name the Cliente name.
	 * @param mail the Cliente email.
	 * @see Cliente class
	 */
	public void insertCliente(int id, String name, String mail);
	

	/**
	 * Gets a client by ID
	 * @param id   the client identification number. 
	 * @return Cliente
	 * @see Cliente class
	 */
	public Cliente getCliente(int id);
	

	/**
	 * Gets a list of clients with a specified name.
	 * @param name   the String name. 
	 * @return ArrayList of Cliente.
	 * @see Cliente class
	 */
	public List<Cliente> getClienteByName(String name);

	
	/**
	 * Gets a list of clients with a specified email.
	 * @param mail   the String email. 
	 * @return ArrayList of Cliente.
	 * @see Cliente class cliente
	 */
	public List<Cliente> getClienteByMail(String mail);

	
	/**
	 * Gets a list of clients with a returns a list of customers sorted by billing in descending order.   
	 * @return ArrayList of Cliente.
	 * @see Cliente class
	 */
	public List<Cliente> getRankingFacturacion();


}




