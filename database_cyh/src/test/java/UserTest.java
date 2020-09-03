import com.sample.dao.IUserDao;
import com.sample.domain.QueryVo;
import com.sample.domain.QueryVolds;
import com.sample.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class UserTest {
    InputStream in = null;
    SqlSessionFactoryBuilder builder = null;
    SqlSessionFactory factory = null;
    SqlSession session = null;
    IUserDao userDao = null;

    @Before
    public void setUp() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession(true);
        userDao = session.getMapper(IUserDao.class);
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(41);
        System.out.println(user);
        assertEquals("张三", user.getUsername());
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("华泰");
        user.setAddress("南京市建邺区");
        user.setSex("男");
        user.setBirthday(new Date());

        int affectedRows = userDao.saveUser(user);
        assertEquals(1, affectedRows);

        User savedUser = userDao.findById(user.getId());
        assertEquals("华泰", user.getUsername());
    }

    @Test
    public void testUpdateUser() {
        int id = 46;
        User user = userDao.findById(id);

        user.setAddress("北京市顺义区");
        int res = userDao.updateUser(user);

        User savedUser = userDao.findById(id);
        assertEquals("北京市顺义区", savedUser.getAddress());
    }

    @Test
    public void testDeleteUser() {
        int res = userDao.deleteUser(46);
        assertEquals(1, res);
    }

    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName("%王%");

        assertEquals(2, users.size());
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testCount() {
        int res = userDao.count();
        assertEquals(18, res);
    }

    @Test
    public void testQueryByVo() {
        QueryVo vo = new QueryVo();
        vo.setUsername("%王%");
        vo.setAddress("%南京%");

        List<User> users = userDao.findByVo(vo);
        assertEquals(1, users.size());
    }

    @Test
    public void testFindInIds() {
        QueryVolds volds = new QueryVolds();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(45);
        ids.add(46);
        volds.setIds(ids);

        List<User> users = userDao.findInIds(volds);

        assertEquals(4, users.size());
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();

        assertEquals(20, users.size());

        for (User user : users) {
            System.out.println("___每个角色的信息___");
            System.out.println(user);
        }
    }

    @After
    public void tearDown() throws Exception {
        session.close();
        in.close();
    }
}
