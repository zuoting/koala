package cn.lt.pianke.dao;

import cn.lt.pianke.model.AuthorFollow;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/5/7.
 */
public interface AuthorFollowDAO extends BaseDAO<AuthorFollow> {

    /**
     * 获取某位用户 关注作者的列表
     *
     */
    List<Map> getAuthorFollow(int user_id);


    /**
     * 某位用户 收到所有关注（粉丝）
     *
     */
    List<Map> getFans(int user_id);
}

