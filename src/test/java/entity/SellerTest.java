package entity;

import junit.framework.TestCase; 
import org.junit.Test;

/**
 *
 * @author laste
 */
public class SellerTest extends TestCase { 
    private Seller stubSeller; 
    
    @Override
    protected void setUp() throws Exception {
        stubSeller = new Seller();
    } 
    
    @Test
    public void testSetAndGetIdSeller() {
        int testId = 1;
        assertEquals(0, 0, 0);    
        stubSeller.setIdSeller(testId);
        assertEquals(testId, stubSeller.getIdSeller());
    }
    
    @Test
    public void testIsAndSetIsAdmin() {
        boolean testIsAdmin = true;
        assertEquals(false, stubSeller.isIsAdmin());
        stubSeller.setIsAdmin(testIsAdmin);
        assertEquals(testIsAdmin, stubSeller.isIsAdmin());
    }
    
    @Test
    public void testSetAndGetFirstName() {
        String testFirstName = "NameTest";
        assertNull(stubSeller.getFirstName());
        stubSeller.setFirstName(testFirstName);
        assertEquals(testFirstName, stubSeller.getFirstName());
    } 
    
    @Test
    public void testSetAndGetLastName() {
        String testLastName = "NameTest";
        assertNull(stubSeller.getLastName());
        stubSeller.setLastName(testLastName);
        assertEquals(testLastName, stubSeller.getLastName());
    } 
    
    @Test 
    public void testSetAndGetMail() {
        String testMail = "test@magasin.fr";
        assertNull(stubSeller.getMail());
        stubSeller.setMail(testMail);
        assertEquals(testMail, stubSeller.getMail());
    }

    @Test
    public void testSetAndGetPassword() {
        String testPassword = "testpassword";
        assertNull(stubSeller.getPassword());
        stubSeller.setPassword(testPassword);
        assertEquals(testPassword, stubSeller.getPassword());
    }
    
    @Test
    public void testConstructor(){
        int testId = 3;
        boolean testIsAdmin = true;
        String testFirstName = "testFirstName";
        String testLastName = "testLastName";
        String testMail = "test@magasin.fr";
        String testPassword = "testpassword";
        stubSeller = new Seller(testId, testIsAdmin, testFirstName, testLastName, testMail, testPassword);
        assertEquals(testId, stubSeller.getIdSeller());
        assertEquals(testIsAdmin, stubSeller.isIsAdmin());
        assertEquals(testFirstName, stubSeller.getFirstName());
        assertEquals(testLastName, stubSeller.getLastName());
        assertEquals(testMail, stubSeller.getMail());
        assertEquals(testPassword, stubSeller.getPassword());
    }
}
