package login_cyh.demo.dao;

import login_cyh.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
@Repository
@Mapper
public interface LoginMapper {
    @Select("SELECT * FROM USER WHERE username = #{userName} AND pwd=#{pwd}")
    List<User> LoginDao(@Param("userName")String userName, @Param("pwd")String pwd);
}
