package Banco;

import java.util.Date;

public class Cuenta {
	public int NumCuenta;
	public int clave;
	public double Saldo;
	public Cliente cliente;
	public boolean TieneFiducia;
	public boolean TieneCDT;

	public double Deposito(double valor){ // es deposito en ahorros y retiro en corriente
		if (valor <= 0)
			Saldo= Saldo;
		else
			Saldo += valor;
		return Saldo;
	}
	public double Retiro(double valor){ //es retiro en ahorros y deposito en corriente
		if (valor <= 0)
			Saldo=Saldo;
		else 
			Saldo -= valor;
		return Saldo;
	}
	
	public long getNumCuenta() {
		return NumCuenta;
	}
	public void setNumCuenta(int numCuenta) {
		NumCuenta = numCuenta;
	}
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public double getSaldo() {
		return Saldo;
	}
	public void setSaldo(double saldo) {
		Saldo = saldo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public boolean isTieneFiducia() {
		return TieneFiducia;
	}
	public void setTieneFiducia(boolean tieneFiducia) {
		TieneFiducia = tieneFiducia;
	}
	public boolean isTieneCDT() {
		return TieneCDT;
	}
	public void setTieneCDT(boolean tieneCDT) {
		TieneCDT = tieneCDT;
	}
	public Cuenta(int numCuenta, int clave, double saldo, Cliente cliente, boolean tieneFiducia, boolean tieneCDT) {
		super();
		NumCuenta = numCuenta;
		this.clave = clave;
		Saldo = saldo;
		this.cliente = cliente;
		TieneFiducia = tieneFiducia;
		TieneCDT = tieneCDT;
	}
	
	
}
