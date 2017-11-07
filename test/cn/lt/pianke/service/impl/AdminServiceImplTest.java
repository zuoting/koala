package cn.lt.pianke.service.impl;

import cn.lt.pianke.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 刘婷 on 2017/6/19.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;
    @Test
    public void adminLogin() throws Exception {
        System.out.println(adminService.adminLogin("admin","admin"));
    }

}