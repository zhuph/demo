import com.example.demo.utils.Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        return Util.getSql()
                .SELECT("P.ID", "A.USERNAME", "A.PASSWORD", "P.FULL_NAME", "D.DEPARTMENT_NAME", "C.COMPANY_NAME")
                .FROM("PERSON P", "ACCOUNT A")
                .INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID", "COMPANY C on D.COMPANY_ID = C.ID")
                .WHERE("P.ID = A.ID", "P.FULL_NAME like #{name}")
                .ORDER_BY("P.ID", "P.FULL_NAME")
                .toString();
    }

    @Test
    public void testStartUp() {

    }
}