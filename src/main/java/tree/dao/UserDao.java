package tree.dao;

import tree.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao{
    @Select("select*from tb_user")
    @Results(id = "userMap",value={
            @Result(property = "uid",column = "id",id=true),
            @Result(property="password",column="pwd"),
            @Result(property = "username",column = "name")
    })
    public List<User>getAll();

    @Select("select*from tb_user where id=#{id}")
    @ResultMap("userMap")
    public User getOne(int id);

    @Insert("insert into tb_user(name,pwd) values(#{username},#{password})")
    public int insertOne(User user);
}
