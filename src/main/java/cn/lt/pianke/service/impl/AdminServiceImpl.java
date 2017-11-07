package cn.lt.pianke.service.impl;

import cn.lt.pianke.dao.AdminDAO;
import cn.lt.pianke.model.Admin;
import cn.lt.pianke.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 刘婷 on 2017/6/19.
 *
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDAO adminDAO;

    /**
     * 管理员登录
     * @param account
     * @param password
     * @return
     */
    @Override
    public Admin adminLogin(String account, String password) {
        Admin admin=new Admin();
        admin.setUsername(account);
        admin.setPassword(password);
        List<Admin> adminList =adminDAO.select(admin);
        if(adminList.size() == 0 ){
            return  null;
        }else{
            return adminList.get(0);
        }

    }

}
