
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @Test
    public void aloitusRahaOikea(){
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void aloitusLounaatMäärä(){
        assertEquals(0, kassa.maukkaitaLounaitaMyyty()+kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void käteisMaksuEiRiittäväEdullinen(){
        kassa.syoEdullisesti(100);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void käteisMaksuEiRiittäväMaukas(){
        kassa.syoMaukkaasti(100);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void käteisMaksuOikeaPalautusJaKasvuEdullinen(){
        kassa.syoEdullisesti(300);
        assertEquals(100000+240,kassa.kassassaRahaa());
    }
    
    @Test
    public void käteisMaksuOikeaPalautusJaKasvuMaukas(){
        kassa.syoMaukkaasti(500);
        assertEquals(100000+400, kassa.kassassaRahaa());
    }
    
    @Test
    public void käteisMaksuLounaidenMääräKasvaaEdullinen(){
        kassa.syoEdullisesti(300);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void käteisMaksuLounaidenMääräKasvaaMaukas(){
        kassa.syoMaukkaasti(500);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiOstoEdullinenToimii(){
        assertTrue(kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void korttiOstoEdullinenMyytyMääräNousee(){
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiOstoMaukasToimii(){
        assertTrue(kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void korttiOstoMaukkasMyytyMääräNousee(){
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiEiTarpeeksiRahaaEdullinen(){
        kortti = new Maksukortti(100);
        assertFalse(kassa.syoEdullisesti(kortti));
    }
    @Test
    public void korttiEitarpeeksiRahaaMaukas(){
        kortti = new Maksukortti(100);
        assertFalse(kassa.syoMaukkaasti(kortti));
    }
    @Test
    public void korttiEdullinenMääräEiNouseIlmanRahaa(){
        kortti = new Maksukortti(100);
        kassa.syoEdullisesti(kortti);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void korttiMaukasMääräEiNouseIlmanRahaa(){
        kortti = new Maksukortti(100);
        kassa.syoMaukkaasti(kortti);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void kassaEiMuutuEdullinenKortti(){
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void kassaEiMuutuMaukasKortti(){
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void kassaNouseeKortilleLadattaessa(){
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(100000+1000, kassa.kassassaRahaa());
    }
    @Test
    public void korttiEiLataaNegatiivista(){
        kassa.lataaRahaaKortille(kortti, -1000);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
}
