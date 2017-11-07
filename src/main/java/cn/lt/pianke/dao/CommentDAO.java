package cn.lt.pianke.dao;

import cn.lt.pianke.model.Comment;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/5/7.
 */
public interface CommentDAO extends BaseDAO<Comment>  {
    /**
     * 获取某位用户收到的所有评论
     * @param user_id
     * @return
     */
    List<Map> getComments(int user_id);

}
