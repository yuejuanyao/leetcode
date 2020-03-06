package practice1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Isomorphic_strings_205Test {
    /**
     * 这个类有一个构造函数，存储测试数据。
     * 这个类有一个静态方法生成并返回测试数据，并注明@Parameters注解。
     * 这个类有一个测试，它需要注解@Test到方法。
     */
    private String s;
    private String t;
    private boolean result;
    Isomorphic_strings_205 test;

    public Isomorphic_strings_205Test(String s, String t, boolean result){
        this.s = s;
        this.t = t;
        this.result = result;
    }
    @Parameterized.Parameters
    public static Collection<?> init(){
        return Arrays.asList(new Object[][]{{"add","egg",true},{"add","edf",false},{"","",true}});
    }

    @Before
    public void setup(){
        test = new Isomorphic_strings_205();
    }

    @Test
    public void isIsomorphic() {
        assertEquals(result,test.isIsomorphic(s,t));
    }

}