import com.sample.dao.IRoleDao;
import com.sample.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class RoleTest {
    InputStream in = null;
    SqlSessionFactoryBuilder builder = null;
    SqlSessionFactory factory = null;
    SqlSession session = null;
    IRoleDao roleDao = null;

    @Before
    public void setUp() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession(true);
        roleDao = session.getMapper(IRoleDao.class);
    }

    @Test
    public void testFindAll() {
        List<Role> roles = roleDao.findAll();

        assertEquals(3, roles.size());

        for (Role role : roles) {
            System.out.println("___每个角色的信息___");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }



    @After
    public void tearDown() throws Exception {
        session.close();
        in.close();
    }
}
