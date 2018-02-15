package Banco;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.tools.JavaFileManager;
import javax.xml.ws.handler.MessageContext;

public class Cliente extends Persona {
	
	
	public boolean TieneCuenA;
	public boolean Referncias;
	public boolean DecDeRenta;
	public boolean CertIngresos;
	public boolean Predial;
	public Cuenta cuenta;
//	public C_Ahorros ahorros;
//	public C_Corriente corriente;
	
	public Cliente(String nombre, int registro, int edad, boolean tieneCuenA , boolean referncias, boolean decDeRenta,
			boolean certIngresos, boolean predial) {
		super(nombre, registro, edad);
		TieneCuenA = true;
		Referncias = false;
		DecDeRenta = false;
		CertIngresos = false;
		Predial = false;
	}
	public Cliente(String nombre, int registro, int edad) {
		super(nombre, registro, edad);
		TieneCuenA=false;
		
		// TODO Auto-generated constructor stub
	} 
	public double Transferencia(Cuenta Atransf, double valor) throws  NumCuenException, ValorException{
//   la cuente tiene que ser de ahorros para hacer la transferencia
		if(Atransf.getNumCuenta() <= 000000000 || Atransf.getNumCuenta() >= 999999999)  
			throw new NumCuenException("no exite numero de la cuenta");
		if(valor<0 || valor >500000)
			throw new ValorException("valor a transferir no permitido");
		if(cuenta.getSaldo() > valor){
			cuenta.Retiro(valor);
			Atransf.Deposito(valor);
		}else
			throw new ValorException("no tienes saldo suficiente");
		
		return cuenta.Saldo;
	}
	public double MirarSaldo(){
		return cuenta.getSaldo();
	}
	public double valorCoutaPrest( double valorPres, int meses, Date dateApagar) throws Exception{
		Calendar calendario = new GregorianCalendar();
		Date hoy= calendario.getTime();
		double valorApagar = (valorPres)/meses;
		return valorApagar;
		
	}
/*	
 * mirar como poder hacer esto
 * public double pagarCoutaPres(Gerente gerente, Date dateApagar) throws Exception{
		
		return gerente.valorCoutaPrest(getNombre(), getRegistro(), getEdad(), meses, dateApagar);
	}
	public double pagarCoutaCO(){
		double a=0;
		return a;
	}
*/	
	/*
	 
	public String MayorEd(){
		String MayorEdad = null;
		if (getEdad()>=18 && getEdad() <= 70){
			setReferncias(true);
			setDecDeRenta(true);
			setCertIngresos(true);
			setPredial(true);
			MayorEdad="puedes sacar una cuenta de corriente, presentnado referencias, la declaracion de renta, un certificado de ingresos y el predial o puedes abrir una cuenta de ahorros";
			}
		else if(getEdad()< 18 && getEdad()>=13 ){
			setReferncias(false);
			setDecDeRenta(false);
			setCertIngresos(false);
			setPredial(false);
			MayorEdad="como eres menor de edad si quieres abrir una cuenta de ahorros puedes hacerlo con un mayor presente,pero no puedes sacar una cuenta de corriente";	
			}
		else if(getEdad() <13 && getEdad()>=0){
				setReferncias(false);
				setDecDeRenta(false);
				setCertIngresos(false);
				setPredial(false);
				MayorEdad="no eres lo suficientemente mayor como para sacar una cuenta en este banco";
				}
		else
			MayorEdad="error";
		return MayorEdad;}
		*/
	
	public boolean isReferncias() {
		return Referncias;
	}
	public void setReferncias(boolean referncias) {
		Referncias = referncias;
	}
	public boolean isDecDeRenta() {
		return DecDeRenta;
	}
	public void setDecDeRenta(boolean decDeRenta) {
		DecDeRenta = decDeRenta;
	}
	public boolean isCertIngresos() {
		return CertIngresos;
	}
	public void setCertIngresos(boolean certIngresos) {
		CertIngresos = certIngresos;
	}
	public boolean isPredial() {
		return Predial;
	}
	public void setPredial(boolean predial) {
		Predial = predial;
	}
	public boolean isTieneCuenA() {
		return TieneCuenA;
	}
	public void setTieneCuenA(boolean tieneCuenA) {
		TieneCuenA = tieneCuenA;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
/*	public C_Ahorros getAhorros() {
		return ahorros;
	}
	public void setAhorros(C_Ahorros ahorros) {
		this.ahorros = ahorros;
	}
	public C_Corriente getCorriente() {
		return corriente;
	}
	public void setCorriente(C_Corriente corriente) {
		this.corriente = corriente;
	}	
*/	 

}
