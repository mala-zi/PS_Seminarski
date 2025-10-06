/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.kupac;

/**
 *
 * @author Saki
 */
import org.junit.*;
import domain.Kupac;
import domain.Mesto;
import domain.TipKupca;

public class SOKreirajKupcaTest {
    private SOKreirajKupca so;
    @Before
    public void setUp() {
        so = new SOKreirajKupca();
    }
    @After
    public void tearDown() {
        so = null;
    }
    @Test
    public void testExecuteOperation_ValidKupac() throws Exception {
        Kupac k = new Kupac();
        k.setEmail("aleksandratodorovic9999@gmail.com");
        k.setNaziv("Flores");
        k.setPib(48512351);
        k.setTelefon("+3816463576");
        k.setIme("Aleksandra");
        k.setPrezime("Todorović");
        k.setTip(TipKupca.PRAVNO_LICE);
        Mesto m = new Mesto();
        m.setId(2);
        k.setMesto(m);

        so.templateExecute(k);
    }
    @Test(expected = Exception.class)
    public void testExecuteOperation_InvalidKupac() throws Exception {
        Kupac k = null;
         so.templateExecute(k);
    }
}
