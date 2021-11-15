package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test
    public void saldoSentteinäEnnenMuutosta(){
        assertEquals(1000,kortti.saldo());
    }
    @Test
    public void saldoAlussaOikein(){
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void lataaminenKasvattaaSaldoa(){
        kortti.lataaRahaa(500);
        assertEquals("saldo: 15.0", kortti.toString());
    }
    @Test
    public void saldoVaheneeJosOnRahaaTarpeeksi(){
        kortti.otaRahaa(500);
        assertEquals("saldo: 5.0", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuJosEiTarpeeksiRahaa(){
        kortti.otaRahaa(1100);
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void metodiPalauttaaTrueJosRahatRiittävät(){
        assertTrue(kortti.otaRahaa(500));
    }
    
    @Test
    public void metodiPalauttaaFalseJosRahatEivätRiitä(){
        assertFalse(kortti.otaRahaa(1100));
    }
}
