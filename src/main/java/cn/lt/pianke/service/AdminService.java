package cn.lt.pianke.service;

import cn.lt.pianke.model.Admin;

/**
 * Created by 刘婷 on 2017/6/19.
 *
 */
public interface AdminService {
    /**
     * 管理员登录
     * @param account
     * @param password
     * @return
     */
    Admin adminLogin(String account, String password);

}
