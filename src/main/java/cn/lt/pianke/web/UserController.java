package cn.lt.pianke.web;

import cn.lt.pianke.model.AuthorFollow;
import cn.lt.pianke.model.Letter;
import cn.lt.pianke.model.Timeline;
import cn.lt.pianke.model.User;
import cn.lt.pianke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by 刘婷 on 2017/6/9.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 获取热门作者
     *
     * @return List<User>热门的4个作者
     */
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAuthors() {
        List<User> users = userService.getHotAuthors();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    /**
     * 获取所有作者
     *
     * @return List<User>所有作者
     */
    @RequestMapping(value = "allUsers", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllAuthors() {
        List<User> users = userService.getAuthors();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    /**
     *获取作者详情
     *
     * @param user_id
     */
    @RequestMapping(value = "users/{user_id}",method = RequestMethod.GET)
    public @ResponseBody
    Map findAuthorById(@PathVariable("user_id")int user_id){
        Map articleInfo=userService.findAuthorById(user_id);
        return articleInfo;
    }
    /**
     * 个人中心
     * @param user_id
     * @return
     */
    @RequestMapping(value = "personal/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Map getAuthorInfo(@PathVariable("user_id") int user_id) {
        Map map =new HashMap();
        List authorFollow=userService.getAuthorFollow(user_id);
        map.put("authorFollow",authorFollow);
        List likeFroms=userService.getLikeFrom(user_id);
        map.put("likeFroms",likeFroms);

        return map;
    }


    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public

    Map signIn(@RequestBody User user) {
        return userService.signIn(user);//登录成功得到用户基本信息和token令牌
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "signUp",method = RequestMethod.POST)
    public ResponseEntity<User> signUp(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder){
        userService.signUp(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/user/{id}").buildAndExpand(user.getUser_id()).toUri());
        return new ResponseEntity<User>(headers,HttpStatus.CREATED);
    }

    /**
     * 更改用户信息
     * @param
     * @return
     */
    @RequestMapping(value = "updateUsers",method = RequestMethod.POST)
    public
    @ResponseBody
    User update(HttpServletRequest request,
                @RequestParam(value = "file",required=false) MultipartFile file) throws IOException {
        String account = request.getParameter("account");
        System.out.println(account);
        User user = userService.findUserByAccount(account);//找出原有用户信息
        if (file != null) {
            String originalFilename = file.getOriginalFilename(); //原图片名 1.jpg
            String newFileName = UUID.randomUUID()
                    + originalFilename.substring(originalFilename.lastIndexOf("."));//新图片名 ******.jpg
            String filePath = request.getSession().getServletContext().getRealPath("/") + newFileName; //服务器端路径+新图片名
            file.transferTo(new File(filePath)); //将客户端文件上传到服务器
            user.setHead(newFileName); //重新设置用户头像
            System.out.println(newFileName);
        }
        System.out.println(user);
        String nickname = request.getParameter("nickname");
        user.setNickname(nickname);
        String description=request.getParameter("description");
        user.setDescription(description);
        String password = request.getParameter("password");
        user.setPassword(password);
        user.setAccount(account);
        userService.update(user);
        return user;
    }

    /**
     * 关注一个作者
     * @param authorFollow
     */

    @RequestMapping(value = "authorFollow",method = RequestMethod.POST)
    public
    void followAuthor(@RequestBody AuthorFollow authorFollow){
        userService.followAuthor(authorFollow);
    }

    /**
     * 取消关注一个用户
     * @param authorFollow
     */
    @RequestMapping(value = "cancelFollowUser",method = RequestMethod.POST)
    public void cancelFollowAuthor(@RequestBody AuthorFollow authorFollow){
        userService.cancelFollowAuthor(authorFollow);
    }

    /**
     * 用户发表一个简信
     *
     * @param letters
     */
    @RequestMapping(value = "letters",method = RequestMethod.POST)
    public
    void letterUser(@RequestBody Letter letters){
        userService.letterUser(letters);
    }


//后台管理
    /**
     * 后台管理 插入一个用户
     * @param request
     * @param file
     * @throws IOException
     */
    @RequestMapping(value = "admin/insertUsers",method = RequestMethod.POST)
    public @ResponseBody
    void insertUser(HttpServletRequest request,
                @RequestParam(value = "file",required=false) MultipartFile file) throws IOException {
        User user=new User();
        //设置用户名
        String account = request.getParameter("account");
        user.setAccount(account);//找出原有用户信息
        //设置密码
        String password=request.getParameter("password");
        user.setPassword(password);
        // 设置昵称
        String nickname=request.getParameter("nickname");
        user.setNickname(nickname);
        // 设置简介
        String description=request.getParameter("description");
        user.setDescription(description);

        //传送图片
        if (file != null) {
            String originalFilename = file.getOriginalFilename(); //原图片名 1.jpg
            String newFileName = UUID.randomUUID()
                    + originalFilename.substring(originalFilename.lastIndexOf("."));//新图片名 ******.jpg
            String filePath = request.getSession().getServletContext().getRealPath("/") + newFileName; //服务器端路径+新图片名
            file.transferTo(new File(filePath)); //将客户端文件上传到服务器
            user.setHead(newFileName); //重新设置用户头像
            System.out.println(newFileName);
        }
        userService.insertUser(user);
    }

    /**
     * 后台管理 根据id删除一个实体
     *
     * @param user_id
     * @return
     */
    @RequestMapping(value = "admin/deleteUsers/{user_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable int user_id) {
        Map userMap =  userService.findAuthorById(user_id);
        if (userMap == null) {
            System.out.println("not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(user_id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /**
     * 用户发表了一个碎片
     * @param request
     * @param file
     * @throws IOException
     */
    @RequestMapping(value = "timelineUser",method = RequestMethod.POST)
    public @ResponseBody
    void timelineUser(HttpServletRequest request,Timeline timeline,
                    @RequestParam(value = "file",required=false) MultipartFile file) throws IOException {
        Timeline timelines=new Timeline();
        //设置碎片的所属话题id
        Integer label_id=timeline.getLabel_id();
        timelines.setLabel_id(label_id);

        //设置碎片的作者id
        Integer user_id=timeline.getUser_id();
        timelines.setUser_id(user_id);

        //设置写作时间
        Date date=new Date();
        Timestamp time=new Timestamp(date.getTime());
        timelines.setWrite_time(time);

        // 设置内容
        String content=timeline.getContent();
        timelines.setContent(content);

        //传送图片
        if (file != null) {
            String originalFilename = file.getOriginalFilename(); //原图片名 1.jpg
            String newFileName = UUID.randomUUID()
                    + originalFilename.substring(originalFilename.lastIndexOf("."));//新图片名 ******.jpg
            String filePath = request.getSession().getServletContext().getRealPath("/") + newFileName; //服务器端路径+新图片名
            file.transferTo(new File(filePath)); //将客户端文件上传到服务器
            timelines.setPic_url(newFileName); //重新设置碎片图片
            System.out.println(newFileName);
        }
        userService.timelineUser(timelines);
    }


}
