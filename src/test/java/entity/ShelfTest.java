package entity;

import junit.framework.TestCase; 
import org.junit.Test;

/**
 *
 * @author laste
 */
public class ShelfTest extends TestCase { 
    private Shelf stubShelf; 
    
    @Override
    protected void setUp() throws Exception {
        stubShelf = new Shelf();
    } 
    
    @Test
    public void testSetAndGetIdShelf() {
        int testId = 1;
        assertEquals(0, 0, 0);    
        stubShelf.setIdShelf(testId);
        assertEquals(testId, stubShelf.getIdShelf());
    }
    
    @Test
    public void testSetAndGetName() {
        String testName = "testName";
        assertNull(stubShelf.getName());
        stubShelf.setName(testName);
        assertEquals(testName, stubShelf.getName());
    } 
    
    
    @Test
    public void testConstructor(){
        int testId = 5;
        String testName = "testName";
        stubShelf = new Shelf(testId, testName);
        assertEquals(testId, stubShelf.getIdShelf());
        assertEquals(testName, stubShelf.getName());
    }
}
