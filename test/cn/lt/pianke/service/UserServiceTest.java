package cn.lt.pianke.service;

import cn.lt.pianke.model.Timeline;
import cn.lt.pianke.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;
    /**
     * 查询热门作者
     *
     * @return List<User>
     */
    @Test
    public void getHotAuthors() throws Exception {
        List<User> hotAuthors= userService.getHotAuthors();
        for(User user:hotAuthors){
            System.out.println(user);
        }
    }

    @Test
    public void getAuthors() throws Exception {
        List<User> users= userService.getAuthors();
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void findAuthorById() throws Exception {
        Map userView=userService.findAuthorById(2);
        System.out.println(userView);
    }

    @Test
    public void signUp() throws Exception {
        User user=new User("1","1","1","null","null",1 ,1 ,1) ;
        userService.signUp(user);
    }

    //登录
    @Test
    public void signIn() throws Exception {
        User user=new User("yiyi","111");
        Map map=userService.signIn(user);
        System.out.println(map);

    }

//    插入一个用户
    @Test
    public void insertUser() throws Exception{
        User user=new User("1","1","1","null","null",0 ,0 ,0) ;
        userService.insertUser(user);
    }

    @Test
    public void timelineUser() throws Exception{
        Timeline timelines=new Timeline(1,3,"","I like!",0,0);
        userService.timelineUser(timelines);
    }


}