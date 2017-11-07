package cn.lt.pianke.dao;

import cn.lt.pianke.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/8.
 */
public interface UserDAO extends BaseDAO<User> {
    /**
     * 获取热门作者
     * @return
     */
    List<User> getHotAuthors();

    /**
     * 获取作者详情
     * @param user_id
     * @return
     */
    Map findAuthorById(int user_id);

    /**
     * 登录
     * @param user
     * @return
     */
    Map signIn(User user);

    /**
     * 注册
     * @param user
     * @return
     */
    boolean signUp(User user);

    /**
     * 根据用户名查找用户
     * @param account
     * @return
     */
    User findUserByAccount(String account);

}
