package Banco;

import java.io.IOException;

public class PagWeb {

	Banco banco;
    Cliente[] clientes;

	public Cliente BuscarCliente(String nomClien) throws Exception{
		int i=0;
		if(nomClien==null || nomClien == "")
			throw new IOException("no se ha puesto un nombre");
		if(clientes ==null)
			throw new Exception("no hay clientes que buscar");
		while (i<clientes.length && nomClien.compareToIgnoreCase(clientes[i].getNombre())!=0 ){
				i++;}
		if(clientes.length<=i)
				throw new Exception("no existe cliente con ese nombre");
		else
			return clientes[i];
	}
	public double Transferencia(String nomCliente, Cuenta Atransf, double valor) throws  Exception{
		return BuscarCliente(nomCliente).Transferencia(Atransf, valor);
	}
	
	public double MirarSaldo(String nomCliente)throws Exception{
			return BuscarCliente(nomCliente).MirarSaldo();
	}
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	public Cliente[] getClientes() {
		return clientes;
	}
	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}
	public PagWeb(Banco banco) {
		super();
		this.banco = banco;
	}

}
