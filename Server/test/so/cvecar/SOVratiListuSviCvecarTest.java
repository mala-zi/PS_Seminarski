/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.cvecar;

/**
 *
 * @author Saki
 */

import domain.Cvecar;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class SOVratiListuSviCvecarTest {
    private SOVratiListuSviCvecar so;
    @Before
    public void setUp() {
        so = new SOVratiListuSviCvecar();
    }
    @After
    public void tearDown() {
        so = null;
    }
    @Test
    public void testVratiSveCvecare() throws Exception {
        Cvecar parametar = new Cvecar(); 
        so.templateExecute(parametar);
        ArrayList<Cvecar> lista = so.getList();
        assertNotNull("Lista cvećara ne sme biti null", lista);
        for (Cvecar c : lista) {
            assertNotNull("Cvećar ne sme imati null ime", c.getIme());
            assertNotNull("Cvećar ne sme imati null prezime", c.getPrezime());
        }
    }
    @Test(expected = Exception.class)
    public void testValidationGreska() throws Exception {
        so.templateExecute(null);
    }
}
