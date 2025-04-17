import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/17       create this file
 * </pre>
 */
public class MyTest {

    @Test
    public void test01() {

        long period = 100L;

        int attempt = 3;

        double pow = Math.pow(1.5, attempt);
        System.out.println("pow:" + pow);

        long result = (long)(period * pow);
        System.out.println(result);


    }

    @Test
    public void test02() {
        Map<String, Integer> map = new HashMap<>();

        map.put("a", 3);

        map.merge("a", 1, Integer::sum);
        System.out.println(map.get("a"));



    }


}
