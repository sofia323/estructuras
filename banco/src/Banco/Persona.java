package Banco;


public class Persona {

	public String Nombre;
	public int Registro; // si es cedula o tarjeta de identidad o nit empresa
	public int Edad;

	public Persona(String nombre, int registro, int edad) {
		super();
		Nombre = nombre;
		Registro = registro;
		Edad = edad;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getRegistro() {
		return Registro;
	}
	public void setRegistro(int registro) {
		Registro = registro;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
} 