package innova4b.ejemplows4;

public class Coche {
	
	private String marca;
	private String modelo;
	private int anyoCompra;
	private String matricula;

	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnyoCompra() {
		return anyoCompra;
	}
	public void setAnyoCompra(int anyoCompra) {
		this.anyoCompra = anyoCompra;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String toString(){
		return "marca: "+marca+", modelo: "+modelo+" anyoCompra: "+anyoCompra+" matricula: "+matricula;
	}
	
}
