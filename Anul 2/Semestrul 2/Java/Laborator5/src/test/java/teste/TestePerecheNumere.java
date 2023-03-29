package teste;

import org.example.ex2.PerecheNumere;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestePerecheNumere {

    @Test
    public void test1_fib(){
        PerecheNumere p = new PerecheNumere(0,1);
        assertTrue(p.areFib());
    }
    @Test
    public void test1_common(){
        PerecheNumere p = new PerecheNumere(3,9);
        assertEquals(9,p.leastCommon());
    }
    @Test
    public void test1_nrcifre(){
        PerecheNumere p = new PerecheNumere(124,14);
        assertFalse(p.nrcifre());
    }
    @Test
    public void test1_nrpare(){
        PerecheNumere p = new PerecheNumere(2468,1111);
        assertTrue(!p.nrpare());
    }
}
