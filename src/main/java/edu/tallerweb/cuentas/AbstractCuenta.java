package edu.tallerweb.cuentas;

/**
 * Modela el concepto de Cuenta. Esta clase abstracta sirve
 * como base para una posible jerarquía (si fuese necesaria)
 *
 * Es probable que la tarea se facilite otorgando una imple-
 * mentación a los métodos proporcionados.
 */
public abstract class AbstractCuenta {

	protected double monto;
	
	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	protected void _depositar(double montoADepositar) {
		
		this.monto += montoADepositar;
	}
	
	protected void _extraer(double montoAExtraer) {
		
		if (this.monto - montoAExtraer < 0) {
			throw new CuentaBancariaException("No hay suficiente monto para realizar la extraccion");
		}
		this.monto -= montoAExtraer;
	}
	/**
	 * Agrega a la cuenta el monto determinado
	 * @param monto a depositar
	 */
	public abstract void depositar(final Double monto);

	/**
	 * Retira de la cuenta el monto determinado
	 * @param monto a extraer
	 */
	public abstract void extraer(final Double monto);

}
