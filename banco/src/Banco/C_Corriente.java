package Banco;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class C_Corriente  extends Cuenta {
	public int CuotDebe;
	public double SaldoMax ; 
	public boolean sobregirada;
	double[] debeCouta;
	
	public void SobreGiro(){
		if(Saldo > SaldoMax)
			sobregirada =true;
		else
			sobregirada = false;
	}
	public double valorDebeCuenta(){
		int n=0;
		double pm=0;
		 while ( n < debeCouta.length){
			 pm= pm + debeCouta[n];
			 n++;
		 }
		 return pm;
	}
	public double valorCoutaCo(String nomClien, int cc, Date dateApagar) throws Exception{
		Calendar calendario = new GregorianCalendar();
		Date hoy= calendario.getTime();
		double valorApagar = valorDebeCuenta()/CuotDebe;
		double interes=0;
		if(dateApagar.before(hoy) || dateApagar.compareTo(hoy)==0)
			interes= valorApagar*0.1;
		else if(dateApagar.after(hoy))
			interes = valorApagar*0.15;
		return valorApagar+interes;
		
	}
	public int getCuotDebe() {
		return CuotDebe;
	}
	public void setCuotDebe(int cuotDebe) {
		CuotDebe = cuotDebe;
	}
	public double getSaldoMax() {
		return SaldoMax;
	}
	public void setSaldoMax(double saldoMax) {
		SaldoMax = 10000000;
	}
	public double[] getDebeCouta() {
		return debeCouta;
	}public void setDebeCouta(double[] debeCouta) {
		this.debeCouta = debeCouta;
	}
	public C_Corriente(int numCuenta, int clave, double saldo, Cliente cliente, boolean tieneFiducia, boolean tieneCDT,
			int cuotDebe, double saldoMax, boolean sobregirada) {
		super(numCuenta, clave, saldo, cliente, tieneFiducia, tieneCDT);
		CuotDebe = cuotDebe;
		SaldoMax = 10000000;
		this.sobregirada = false;
	}	

	
}
