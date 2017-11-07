package cn.lt.pianke.dao;

import cn.lt.pianke.model.TimelineComment;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/10.
 */
public interface TimelineCommentDAO extends BaseDAO<TimelineComment> {
    /**
     * 获取某位用户收到的所有碎片评论
     * @param user_id
     * @return
     */
    List<Map> getTimelineComments(int user_id);
}
