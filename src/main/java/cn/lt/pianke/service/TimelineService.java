package cn.lt.pianke.service;

import cn.lt.pianke.model.TimelineComment;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/9.
 */
public interface TimelineService {

    /**
     * 查询所有碎片
     *
     * @return List<User>
     */
    List<Map> getTimelines();

    /**
     * 根据专题id获取该碎片所有详情数据
     * @param timeline_id
     * @return
     */
    Map getTimelineInfo(int timeline_id);

    /**
     * 发表一个碎片的评论
     * @param timelineComments
     */
    void timelineCommentArticle(TimelineComment timelineComments);

}
