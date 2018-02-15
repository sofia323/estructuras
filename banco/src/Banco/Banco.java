package Banco;

import java.io.IOException;
import java.util.Arrays;

public class Banco {

	public String Direccion;
	public String nombre;
	int telefono;
	public int sucursales;
    Banquero[] empleados;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSucursales() {
		return sucursales;
	}
	public void setSucursales(int sucursales) {
		this.sucursales = sucursales;
	}
	public Banquero[] getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Banquero[] empleados) {
		this.empleados = empleados;
	}
	public void CrearPWeb(Banco banco){
		PagWeb pw= new PagWeb(banco);
	}	
	public Banquero buscarEmpleado(String NomBanq, int ccBanq, int edadBanq) throws Exception{
		int i=0;
		if(NomBanq==null || NomBanq == "")
			throw new IOException("no se ha puesto un nombre");
		if(empleados ==null)
			throw new Exception("no hay empleado que buscar");
		while (i<empleados.length && NomBanq.compareToIgnoreCase(empleados[i].getNombre())!=0 ){
				i++;}
		if(empleados.length<=i){
			throw new Exception("no hay empleado con ese nombre");
		}else
			return empleados[i];

	}
	public static void main(String[] args) {
		
/*
 * el gerente es creado por el banco que tambien puede crear banqueros, a los banqueros tambien los puede crear el gerente
 * el banco tambien crea la pagina web donde se pueden hacer transacciones y consultar el saldo
 * el banquero puede hacer transacciones, consultar saldo, buscar y crear clientes(con cuentas), y crea los cdt y las fiducias de las cuentas
 * la cuenta tiene el metodo de retirar y consignar dinero
 * 		
 */
		Banco aaaaaaaaa = new Banco();
		Gerente ger = new Gerente("admi", 32525, 35);
		Banquero banq0 =new Banquero("banq0", 12332, 27);
/*		Banquero[] banqueros =new Banquero[1] ;
		banq0= banqueros[0];
		ger.getEmpleados();
		ger.setEmpleados(banqueros);
		
		try {
			ger.Empleado("banq1",12345, 32);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
*/
		try {
			ger.Prestamo("pepe", 123456,500000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
