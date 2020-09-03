import com.sample.dao.IAccountDao;
import com.sample.domain.AccountUser;
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
public class AccountTest {
    InputStream in = null;
    SqlSessionFactoryBuilder builder = null;
    SqlSessionFactory factory = null;
    SqlSession session = null;
    IAccountDao accountDao = null;

    @Before
    public void setUp() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession(true);
        accountDao = session.getMapper(IAccountDao.class);
    }

    @Test
    public void testFindAll() {
        List<AccountUser> accountUsers = accountDao.findAll();
        for (AccountUser au : accountUsers) {
            System.out.println(au);
        }

        assertEquals(3, accountUsers.size());
    }

    @After
    public void tearDown() throws Exception {
        session.close();
        in.close();
    }
}
