package cn.lt.pianke.util;

import java.util.UUID;

/**
 * Created by 刘婷 on 2017/5/9.
 */
public class TokenUtil {
    public static String getToken(){
        return UUID.randomUUID().toString();
    }
}
