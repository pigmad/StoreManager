package entity;

import junit.framework.TestCase; 
import org.junit.Test;

/**
 *
 * @author laste
 */
public class DirectorTest extends TestCase { 
    private Director stubDirector; 
    
    @Override
    protected void setUp() throws Exception {
        stubDirector = new Director();
    } 
    
    @Test
    public void testSetAndGetIdDirector() {
        int testId = 1;
        assertEquals(0, 0, 0);    
        stubDirector.setIdDirector(testId);
        assertEquals(testId, stubDirector.getIdDirector());
    }
    
    @Test
    public void testSetAndGetFirstName() {
        String testFirstName = "NameTest";
        assertNull(stubDirector.getFirstName());
        stubDirector.setFirstName(testFirstName);
        assertEquals(testFirstName, stubDirector.getFirstName());
    } 
    
    @Test
    public void testSetAndGetLastName() {
        String testLastName = "NameTest";
        assertNull(stubDirector.getLastName());
        stubDirector.setLastName(testLastName);
        assertEquals(testLastName, stubDirector.getLastName());
    } 
    
    @Test 
    public void testSetAndGetMail() {
        String testMail = "test@magasin.fr";
        assertNull(stubDirector.getMail());
        stubDirector.setMail(testMail);
        assertEquals(testMail, stubDirector.getMail());
    }

    @Test
    public void testSetAndGetPassword() {
        String testPassword = "testpassword";
        assertNull(stubDirector.getPassword());
        stubDirector.setPassword(testPassword);
        assertEquals(testPassword, stubDirector.getPassword());
    }
    
    @Test
    public void testConstructor(){
        int testId = 1;
        boolean testIsAdmin = true;
        String testFirstName = "testFirstName";
        String testLastName = "testLastName";
        String testMail = "test@magasin.fr";
        String testPassword = "testpassword";
        stubDirector = new Director(testId, testFirstName, testLastName, testMail, testPassword);
        assertEquals(testId, stubDirector.getIdDirector());
        assertEquals(testFirstName, stubDirector.getFirstName());
        assertEquals(testLastName, stubDirector.getLastName());
        assertEquals(testMail, stubDirector.getMail());
        assertEquals(testPassword, stubDirector.getPassword());
    }
}
