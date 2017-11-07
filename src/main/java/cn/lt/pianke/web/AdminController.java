package cn.lt.pianke.web;

import cn.lt.pianke.model.Admin;
import cn.lt.pianke.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/19.
 *
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    @RequestMapping(value = "adminLogin",method = RequestMethod.POST)
    public Map<String,Object> login (@RequestBody Admin admin){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg" ,adminService.adminLogin(admin.getUsername(),admin.getPassword()));
//        map.put("admin",admin);
        return map;
    }



}
