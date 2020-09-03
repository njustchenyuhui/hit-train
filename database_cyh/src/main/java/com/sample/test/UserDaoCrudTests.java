package com.sample.test;

import com.sample.dao.IUserDao;
import com.sample.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class UserDaoCrudTests {


    InputStream inputStream =null;
    SqlSessionFactoryBuilder builder = null;
    SqlSessionFactory factory = null;
    SqlSession sqlSession = null;
    IUserDao dao = null;

    @Before
    public void setUp() throws Exception {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(inputStream);
        sqlSession = factory.openSession();
        dao = sqlSession.getMapper(IUserDao.class);
    }

    @Test
    public void testFindAll() {
        List<User> users=dao.findAll();
        for(User user:users)
        {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByUserId() {
        User user = dao.findById(41);
        System.out.println(user);
        Assert.assertEquals("张三",user.getUsername());
    }

    @Test
    public void testUpdateUser()
    {
        //int
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
}
