import com.example.demo.utils.Assert;
import com.example.demo.utils.MapUtil;
import com.example.demo.utils.SqlUtil;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 朱鹏辉
 * @date 2019/11/8 16:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.example.demo.DemoApplication.class)
public class DemoApplication {

    @Before
    public void before() {
        System.out.println("start=============");
    }

    public String selectPersonSql() {
        return SqlUtil.getSql()
                .SELECT("P.ID", "A.USERNAME", "A.PASSWORD", "P.FULL_NAME", "D.DEPARTMENT_NAME", "C.COMPANY_NAME")
                .FROM("PERSON P", "ACCOUNT A")
                .INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID", "COMPANY C on D.COMPANY_ID = C.ID")
                .WHERE("P.ID = A.ID", "P.FULL_NAME like #{name}")
                .ORDER_BY("P.ID", "P.FULL_NAME")
                .toString();
    }

    @Test
    public void testStartUp() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put(1, null);
//        Assert.cannotEmpty(map,"map not null");
//        Assert.mustContain(map, 0, "map must contain key");
//        Object value = MapUtil.getValue(map, 1);
//        Object value1 = MapUtil.getSafeValueToStringNull(map, 1);
//        A a = new A();
//        a.setValue(value1);
//        System.out.println(a.getValue().toString());
//        a.setValue(value);
//        System.out.println(a.getValue().toString());
        ArrayList<Integer> listNull = null;
        ArrayList<Integer> list = new ArrayList<>();

//        Assert.cannotEmpty(listNull, "listNull");
        list.add(111);
        Assert.cannotEmpty(list, "list");
    }

    @Data
    class A {
        Object value;
    }
}