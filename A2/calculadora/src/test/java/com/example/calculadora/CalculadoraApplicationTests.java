package com.example.calculadora;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalculadoraApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testSomarNumeroNegativo() {
        Calculadora calc = new Calculadora(5);
        calc.somar(-3);
        assertEquals(2, calc.getMemoria());
    }

    @Test
    public void testSubtrairNumeroPositivo() {
        Calculadora calc = new Calculadora(10);
        calc.subtrair(4);
        assertEquals(6, calc.getMemoria());
    }

    @Test
    public void testMultiplicarNumeroPositivo() {
        Calculadora calc = new Calculadora(4);
        calc.multiplicar(3);
        assertEquals(12, calc.getMemoria());
    }

    @Test
    public void testDividirPorZero() {
        Calculadora calc = new Calculadora(6);
        assertThrows(Exception.class, () -> calc.dividir(0));
    }

    @Test
    public void testDividirPorValorPositivo() throws Exception {
        Calculadora calc = new Calculadora(20);
        calc.dividir(5);
        assertEquals(4, calc.getMemoria());
    }

    @Test
    public void testExponenciacaoPor1() throws Exception {
        Calculadora calc = new Calculadora(3);
        calc.exponenciar(1);
        assertEquals(3, calc.getMemoria());
    }

    @Test
    public void testExponenciacaoPor10() throws Exception {
        Calculadora calc = new Calculadora(3);
        calc.exponenciar(10);
        assertEquals(59049, calc.getMemoria());
    }

    @Test
    public void testZerarMemoria() {
        Calculadora calc = new Calculadora(3);
        calc.zerarMemoria();
        assertEquals(0, calc.getMemoria());
    }
}
