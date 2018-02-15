package Banco;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.plaf.DimensionUIResource;

public class Banquero extends Persona{

	Banco banco;
	public Banquero(String nombre, int registro, int edad) {
		super(nombre, registro, edad);
		// TODO Auto-generated constructor stub
	}
	public String Banco;
    private  Cliente[] clientes;
//    private Cuenta C;
//	private C_Ahorros CA;
//	private C_Corriente CC;

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

	public void ClienteNuevo(String nameUs, int cc, int edad, boolean ahorros) throws Exception{
		if(nameUs==null || nameUs == "")
			throw new IOException("no se ha puesto un nombre");
		if(cc<=00000000)
			throw new Exception("cedula no valida");
		if(clientes==null)
			throw new Exception("no hay clientes para buscar"); 
		int i=0;
		while(i< clientes.length && nameUs.compareToIgnoreCase(clientes[i].getNombre())!=0){
			i++;
		}
		if(clientes.length<=i){
			clientes = Arrays.copyOf(clientes , clientes.length+1);
			Cliente c= new Cliente(nameUs, cc, edad);
			c= clientes[clientes.length-1];
			if (ahorros==true){ 
				Cuenta a= new C_Ahorros( 12345+i, 1234, 100000, c, false, false);
				a.setCliente(c);
				}
			else {
				Cuenta b= new C_Corriente(12345+i+i, 45+i+i, 0, c, false, false, 0, 10000000, false);
			    c.setCertIngresos(true);
			    c.setDecDeRenta(true);
			    c.setPredial(true);
			    c.setReferncias(true);
			    b.setCliente(c);
			    }
			}
		else {
			if (ahorros==true){ 
				if(clientes[i].isTieneCuenA()==true)
					throw new Exception("usted ya tiene una cuenta de ahorros");
				else{
					Cuenta b2= new C_Corriente(123456+i+i, 45+i+i, 0, clientes[i], false, false, 0, 10000000, false);
					b2.setCliente(clientes[i]);
				}					
			}else {
				if(clientes[i].isTieneCuenA()==false)
					throw new Exception("usted ya tiene una cuenta de corriente");
				else{
					Cuenta a2 = new C_Ahorros(123456+i, 1234, 100000, clientes[i], false, false);
					a2.setCliente(clientes[i]);
			        }
				}
			}
	}
	
		public double CDT(String nomClie,double Dinero, double interes, Date date) throws Exception{
			Calendar calendario = new GregorianCalendar();
			Date hoy= calendario.getTime();
			int i=0;
			if(nomClie==null || nomClie == "")
				throw new IOException("no se ha puesto un nombre");
			while (i<clientes.length && nomClie.compareToIgnoreCase(clientes[i].getNombre())!=0 ){
					i++;
				}
			if(Dinero<=0 )
				throw new Exception("no se ha depositado dinero");
			if(interes<=0)
				throw new Exception("no gano ningun interes");
			if(date.before(hoy))
				throw new Exception("la fecha dada ya ha pasado");
		    if(date == null)
				throw new IOException("no se ha ingresado fecha");
		    if(clientes[i].getCuenta().isTieneCDT()==true)
		    	throw new Exception("ya tiene en su cuenta un CDT");
		    else{
			if(date.after(hoy)){
					while(hoy.compareTo(date) != 0){
						if(clientes.length<=i)
								throw new Exception("no existe cliente con ese nombre");
						else
							Dinero += interes; 
			       }
			}}
				return Dinero;
		}
		
		public void fiducia(String nomClien, double Dinero, double interes) throws Exception{
			Calendar calendario = new GregorianCalendar();
			Date hoy= calendario.getTime();
			BuscarCliente(nomClien);
			if(Dinero<=0 )
				throw new Exception("no se ha depositado dinero");
			if(interes<=0)
				throw new Exception("no gano ningun interes");
			if(BuscarCliente(nomClien).getCuenta().isTieneFiducia() == true)
				throw new Exception("ya se tiene una fiducia en esta cuenta");
			else{
			     while(hoy.getTime()!=0 ){
						Dinero += interes;}		
			}
		}
}
