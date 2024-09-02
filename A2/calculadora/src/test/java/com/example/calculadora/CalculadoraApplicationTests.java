package com.example.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CalculadoraApplicationTests {

    @Autowired
    private ApplicationContext context;

    // S1186
    @Test
    void contextLoads() {
        assertThat(context).isNotNull();
    }


    // S5786 
    @Test
    void testSomarNumeroNegativo() {
        Calculadora calc = new Calculadora(5);
        calc.somar(-3);
        assertEquals(2, calc.getMemoria());
    }

    // S5786
    @Test
    void testSubtrairNumeroPositivo() {
        Calculadora calc = new Calculadora(10);
        calc.subtrair(4);
        assertEquals(6, calc.getMemoria());
    }

    // S5786
    @Test
    void testMultiplicarNumeroPositivo() {
        Calculadora calc = new Calculadora(4);
        calc.multiplicar(3);
        assertEquals(12, calc.getMemoria());
    }

    // S5786
    @Test
     void testDividirPorZero() {
        Calculadora calc = new Calculadora(6);
        assertThrows(Exception.class, () -> calc.dividir(0));
    }

    // S5786
    @Test
     void testDividirPorValorPositivo() throws Exception {
        Calculadora calc = new Calculadora(20);
        calc.dividir(5);
        assertEquals(4, calc.getMemoria());
    }

    // S5786
    @Test
     void testExponenciacaoPor1() throws Exception {
        Calculadora calc = new Calculadora(3);
        calc.exponenciar(1);
        assertEquals(3, calc.getMemoria());
    }

    // S5786
    @Test
     void testExponenciacaoPor10() throws Exception {
        Calculadora calc = new Calculadora(3);
        calc.exponenciar(10);
        assertEquals(59049, calc.getMemoria());
    }

    // S5786
    @Test
     void testZerarMemoria() {
        Calculadora calc = new Calculadora(3);
        calc.zerarMemoria();
        assertEquals(0, calc.getMemoria());
    }
}
