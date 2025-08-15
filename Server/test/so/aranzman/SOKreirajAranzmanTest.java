/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.aranzman;

/**
 *
 * @author Saki
 */
import domain.Aranzman;
import domain.PoreskaStopa;
import org.junit.*;

public class SOKreirajAranzmanTest {
    private SOKreirajAranzman so;
    private Aranzman aranzman;
    @Before
    public void setUp() {
        so = new SOKreirajAranzman();
        aranzman = new Aranzman();
    }
    @After
    public void tearDown() {
        so = null;
        aranzman = null;
    }
    @Test
    public void testValidAranzman() throws Exception {
        aranzman.setNaziv("Koalia");
        aranzman.setOpis("Crvene ruze sa dekoracijom");
        aranzman.setPoreskaStopa(new PoreskaStopa(1, 20.0));
        aranzman.setCenaBezPDV(1500.0);
        aranzman.setCenaSaPDV(1800.0);
        aranzman.setPopust(0.0);
        so.templateExecute(aranzman);
    }
    @Test(expected = Exception.class)
    public void testValidationNullObject() throws Exception {
         so.templateExecute(null);
    }
    @Test(expected = Exception.class)
    public void testValidationEmptyNaziv() throws Exception {
        aranzman.setNaziv(null);
        aranzman.setOpis("Dekoracija bez naziva");
        aranzman.setPoreskaStopa(new PoreskaStopa(1, 20.0));
        aranzman.setCenaBezPDV(1500.0);
        aranzman.setCenaSaPDV(1800.0);
        aranzman.setPopust(0.0);
        so.templateExecute(aranzman);
    }

}
