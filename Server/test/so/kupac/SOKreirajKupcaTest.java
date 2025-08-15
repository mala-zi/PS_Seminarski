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
        k.setEmail("prvi@gmail.com");
        k.setNaziv("Flores");
        k.setPib(48512358);
        k.setTelefon("+3816463526");
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
