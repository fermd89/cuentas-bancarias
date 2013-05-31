package edu.tallerweb.cuentas;

import org.junit.Assert;
import org.junit.Test;

public class CuentaTests {

	@Test
	public void queVerifiqueLaConsigna() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(4000.0);

		Assert.assertEquals(
				"al depositar $ 4000.0 en una cuenta vacía, tiene $ 4000.0",
				4000.0, cuenta.getSaldo(), 0.0);

		cuenta.extraer(500.0);
	
		Assert.assertEquals(
				"al extraer $ 500.0 de una cuenta con $ 4000.0 se obtienen $ 3500.0",
				3500.0, cuenta.getSaldo(), 0.0);
	}

	@Test(expected=CuentaBancariaException.class)
	public void queVerifiqueLaConsignaException() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(3500.0);

		cuenta.extraer(4000.0);
	}
	
	@Test
	public void cajaDeAhorros() {
		
		CajaAhorros cuenta = new CajaAhorros();
		cuenta.depositar(5000.0);

		cuenta.extraer(500.0);
		cuenta.extraer(500.0);
		cuenta.extraer(500.0);
		cuenta.extraer(500.0);
		cuenta.extraer(500.0);
		
		Assert.assertEquals(
				"al extraer $ 2500.0 en Caja de Ahorro, tiene $ 2500.0",
				2500.0, cuenta.getSaldo(), 0.0);
		
		cuenta.extraer(500.0);
		
		Assert.assertEquals(
				"al extraer por 6ta vez se cobra 6$ de comision",
				1994.0, cuenta.getSaldo(), 0.0);
	}
	
	@Test(expected=CuentaBancariaException.class)	
	public void cajaDeAhorroError() {

		CajaAhorros cuenta = new CajaAhorros();
		cuenta.depositar(3500.0);

		cuenta.extraer(4000.0);
	}
	
	@Test(expected=CuentaBancariaException.class)	
	public void cuentaCorrienteError() {

		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		cuenta.depositar(3500.0);

		cuenta.extraer(4000.0);
	}
	
	@Test	
	public void cajaAhorrosOk() {

		CajaAhorros cuenta = new CajaAhorros();
		cuenta.depositar(100.0);

		cuenta.extraer(100.0);
		
		Assert.assertEquals(
				"extraccion ok",
				0.0, cuenta.getSaldo(), 0.0);
	}
	
	@Test	
	public void cuentaCorrienteOk() {

		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		cuenta.depositar(100.0);

		cuenta.extraer(100.0);
		
		Assert.assertEquals(
				"extraccion ok",
				0.0, cuenta.getSaldo(), 0.0);
	}
	
	@Test
	public void cuentaCorriente() {
		
		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		cuenta.depositar(100.0);

		cuenta.extraer(150.0);		
		
		Assert.assertEquals(
				"al extraer un monto mayor al que se deposito se descuenta dinero del monto descubierto",
				47.5, cuenta.getDescubierto(), 0.0);
		
		Assert.assertEquals(
				"el monto de la cuenta queda en 0",
				0.0, cuenta.getSaldo(), 0.0);
	}

}
