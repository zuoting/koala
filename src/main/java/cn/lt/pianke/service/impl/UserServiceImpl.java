package cn.lt.pianke.service.impl;

import cn.lt.pianke.dao.*;
import cn.lt.pianke.model.*;
import cn.lt.pianke.service.UserService;
import cn.lt.pianke.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/8.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private AuthorFollowDAO authorFollowDAO;
    @Autowired
    private LikeDAO likeDAO;
    @Autowired
    private LetterDAO letterDAO;
    @Autowired
    private TimelineDAO timelineDAO;
    @Autowired
    private LabelDAO labelDAO;
    /**
     * 查询热门作者
     *
     * @return List<User>
     */
    @Override
    public List<User> getHotAuthors() {
        List<User> hotAuthors=userDAO.getHotAuthors();
        return hotAuthors;
    }

    /**
     * 查询所有作者
     *
     * @return List<User>
     */
    @Override
    public List<User> getAuthors() {
        return userDAO.selectAll();
    }

    /**
     * 获取作者详情
     *
     * @param user_id
     */
    @Override
    public Map findAuthorById(int user_id) {
        return userDAO.findAuthorById(user_id);
    }
    /**
     * 个人中心
     *
     * @param user_id
     * @return
     */
    //我关注的人
    @Override
    public List<Map> getAuthorFollow(int user_id) {
        return authorFollowDAO.getAuthorFollow(user_id);
    }
    //我喜欢的文章
    @Override
    public List<Map> getLikeFrom(int user_id) {
        return likeDAO.getLikeFrom(user_id);
    }


    /**
     * 登录
     *
     * @param user
     * @return
     */
    @Override
    public Map signIn(User user) {
        User user1 = null;
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("account",user.getAccount());
        List<User> list = userDAO.selectByExample(example);
        if( list.size() != 0 ){
            user1 = list.get(0);
        }
        Token token = null;
        if(user.getPassword().equals(user1.getPassword())){
            token = new Token();//生成令牌
            token.setUser_id(user1.getUser_id());
            token.setToken(TokenUtil.getToken());
        }

        Map map = new HashMap();
        map.put("user",user1);//存储用户信息
        map.put("token",token);//存储令牌信息

        return map;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public boolean signUp(User user) {
        int n=userDAO.insert(user);
        return n != 0 ? true : false;
    }

    /**
     * 修改个人信息
     *
     * @param user
     * @return
     */
    @Override
    public User update(User user) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("account" ,user.getAccount());
        User userInfo = userDAO.selectByExample(example).get(0);
        userInfo.setAccount(user.getAccount());
        userInfo.setPassword(user.getPassword());
        userInfo.setNickname(user.getNickname());
        userInfo.setDescription(user.getDescription());
        userInfo.setHead(user.getHead());
        userDAO.updateByExample(userInfo,example);
        return userInfo;
    }

    /**
     * 根据用户名查找用户
     *
     * @param account
     * @return
     */
    @Override
    public User findUserByAccount(String account) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("account",account);
        List<User> users = userDAO.selectByExample(example);
        if(users.size() == 0 ){
            return null;
        }
        return users.get(0);
    }

    /**
     * 关注一个作者
     *
     * @param authorFollow
     */
    @Override
    public void followAuthor(AuthorFollow authorFollow) {
        authorFollowDAO.insert(authorFollow);//向作者关注表插入一条记录
        //更新作者的粉丝数
        Example example=new Example(User.class);
        example.createCriteria()
                .andEqualTo("user_id",authorFollow.getId_to());
        User user=userDAO.selectByExample(example).get(0);
        user.setFans_count(user.getFans_count()+1); //粉丝数+1
        user.setFollow_count(user.getFollow_count()+1); //关注数+1
        userDAO.updateByExample(user,example);
    }

    /**
     * 取消关注作者
     *
     * @param authorFollow
     */
    @Override
    public void cancelFollowAuthor(AuthorFollow authorFollow) {
        Example example =new Example(AuthorFollow.class);
        example.createCriteria()
                .andEqualTo("user_id",authorFollow.getId_to());
        User user=userDAO.selectByExample(example).get(0);
        user.setFans_count(user.getFans_count()-1); //粉丝数-1
        user.setFollow_count(user.getFollow_count()-1); //关注数-1
        userDAO.deleteByExample(example);
    }

    /**
     * 用户发表一个简信
     *
     * @param letters
     */
    @Override
    public void letterUser(Letter letters) {
        letterDAO.insert(letters);//插入一条评论
        //更新用户收到的简信
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("user_id",letters.getTo_id());
        User user=userDAO.selectByExample(example).get(0);
        user.setLetter_count(user.getLetter_count()+1);
        userDAO.updateByExample(user,example);
    }

    /**
     * 后台管理 插入一个用户
     *
     * @param user
     * @return
     */
    @Override
    public void insertUser(User user) {
        userDAO.insert(user);//向作者表插入一条记录
    }

    /**
     * 后台管理 根据id删除一个实体
     *
     * @param user_id
     * @return
     */
    @Override
    public void deleteUserById(int user_id) {
        Example example =new Example(User.class);
        example.createCriteria()
                .andEqualTo("user_id",user_id);
        userDAO.deleteByExample(example);
    }

    /**
     * 发表一个碎片
     *
     * @param timelines
     */
    @Override
    public void timelineUser(Timeline timelines) {
        timelineDAO.insert(timelines);//插入一条碎片
        //更新用户发表一个碎片数
        Example example = new Example(Label.class);
        example.createCriteria()
                .andEqualTo("label_id",timelines.getLabel_id());
        Label label=labelDAO.selectByExample(example).get(0);
        label.setTimeline_count(label.getTimeline_count()+1);
        labelDAO.updateByExample(label,example);
    }

}