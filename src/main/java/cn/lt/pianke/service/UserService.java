package cn.lt.pianke.service;

import cn.lt.pianke.model.AuthorFollow;
import cn.lt.pianke.model.Letter;
import cn.lt.pianke.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/8.
 */
public interface UserService {
    /**
     * 查询热门作者
     *
     * @return List<User>
     */
    List<User> getHotAuthors();

    /**
     * 查询所有作者
     *
     * @return List<User>
     */
    List<User> getAuthors();

    /**
     * 获取作者详情
     *
     * @param user_id
     */
    Map findAuthorById(int user_id);

    /**
     * 个人中心
     * @param user_id
     * @return
     */
    List<Map> getAuthorFollow(int user_id);//我关注的人

    List<Map> getLikeFrom(int user_id);//我喜欢的文章


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
     * 修改个人信息
     * @param user
     * @return
     */
    User update(User user);  //后台管理  根据id更改一个实体

    /**
     * 根据用户名查找用户
     * @param account
     * @return
     */
    User findUserByAccount(String account);

    /**
     * 关注一个作者
     * @param authorFollow
     */
    void followAuthor(AuthorFollow authorFollow);

    /**
     * 取消关注作者
     * @param authorFollow
     */
    void cancelFollowAuthor(AuthorFollow authorFollow);

    /**
     * 发表一个简信
     * @param letters
     */
    void letterUser(Letter letters);

    /**
     * 后台管理 插入一个用户
     * @param user
     * @return
     */
    void insertUser(User user);  //插入一个实体

    /**
     * 后台管理 根据id删除一个实体
     * @param user_id
     * @return
     */
    void deleteUserById(int user_id);       //根据id删除一个实体

}
