package Banco;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Gerente extends Persona {

	Banco banco;
	Cliente[] clientes;
	Banquero[] empleados;
	
	public Gerente(String nombre, int registro, int edad) {
		super(nombre, registro, edad);
		// TODO Auto-generated constructor stub
	}
	//intereses
	
	public Banquero Empleado(String NomBanq, int ccBanq, int edadBanq) throws Exception{
		int i=0;
		if(NomBanq==null || NomBanq == "")
			throw new IOException("no se ha puesto un nombre");
		if(empleados ==null)
			throw new Exception("no hay empleado que buscar");
		while (i<empleados.length && NomBanq.compareToIgnoreCase(empleados[i].getNombre())!=0 ){
				i++;}
		if(empleados.length<=i){
			empleados = Arrays.copyOf(empleados , empleados.length+1);
	        Banquero b= new Banquero(NomBanq, ccBanq, edadBanq);
	        b= empleados[empleados.length-1];
	        return b;
		}else
			throw new Exception("ya existe empleado con ese nombre");
		
	}
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
	public boolean PediPrestamo(String client,int cc, double valor) throws Exception{
		if(client==null || client == "")
			throw new IOException("no se ha puesto nombre del solicitante");
		if(clientes ==null)
			throw new Exception("no hay clientes que buscar");
		int i=0;
		while(i< clientes.length && client.compareToIgnoreCase(clientes[i].getNombre())!=0){
			i++;
		}
		if(clientes.length<=i){
			clientes = Arrays.copyOf(clientes , clientes.length+1);
		    Cliente c= new Cliente(client, cc, getEdad(), false, true, true, true, true);
		    c= clientes[clientes.length-1];
		    if(c.isCertIngresos()==false || c.isDecDeRenta()==false || c.isPredial()==false || c.isReferncias()==false)
		    	return false;
		}else{
			if(clientes[i].isCertIngresos()==false || clientes[i].isDecDeRenta()==false || clientes[i].isPredial()==false || clientes[i].isReferncias()==false)
				return false;
		}
		if( valor >15000000)
			return false;
		else if(valor <=0)
			throw new Exception("valor a prestar no valido");
		
		return true;
	}
	public double Prestamo(String cli,int cc, double valor) throws Exception{
		if(PediPrestamo(cli, cc, valor)==true)
			return valor;
		else
			throw new Exception("su prestamo ha sido negado");
	}

	public double valorCoutaPrest(String nomClien, int cc,double valorPres, int meses, Date dateApagar) throws Exception{
		Calendar calendario = new GregorianCalendar();
		Date hoy= calendario.getTime();
		double valorApagar = (Prestamo(nomClien, cc, valorPres))/meses;
		double interes=0;
		if(dateApagar.before(hoy) || dateApagar.compareTo(hoy)==0)
			interes= valorApagar*0.1;
		else if(dateApagar.after(hoy))
			interes = valorApagar*0.15;
		return valorApagar+interes;
		
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

	public Banquero[] getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Banquero[] empleados) {
		this.empleados = empleados;
	}
	
}
