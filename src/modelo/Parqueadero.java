package modelo;

import java.util.Random;

public class Parqueadero {

	public final static double TARIFA_HORA_MOTO = 1000;
	public final static double TARIFA_HORA_CARRO = 3500;

	public final static String MOTO = "Moto";
	public final static String CARRO = "Carro";

	private String tipoVehiculo;

	private int horaInicio;
	private int minutoInicio;
	private int horaFinal;
	private int minutoFinal;

	public Parqueadero() {
	}

	public void marcarHoraInicio(String tipoV) {
		tipoVehiculo = tipoV;
		// To modify: Random rnd = new Random();
		horaInicio = (int) ((new Random().nextDouble()) * 5 + 7);
		minutoInicio = (int) ((new Random().nextDouble()) * 59 + 0);
	}

	public String darHoraInicio() {
		return horaInicio + ":" + minutoInicio;
	}

	public void marcarHoraFinal() {
		// To modify:
		horaInicio = (int) ((new Random().nextDouble()) * 10 + 12);
		minutoInicio = (int) ((new Random().nextDouble()) * 59 + 0);
	}

	public String darHoraFinal() {
		return horaInicio + ":" + minutoInicio;
	}

	public double calcularValorAPagar() {
		double tarifa;
		if (tipoVehiculo.equals(MOTO)) {
			tarifa = TARIFA_HORA_MOTO;
		} else {
			tarifa = TARIFA_HORA_CARRO;
		}

		double valorAPagar = (horaFinal - horaInicio) * tarifa;
		if (minutoFinal > minutoInicio) {
			valorAPagar += tarifa;
		}
		return valorAPagar;
	}
}
