package cn.lt.pianke.dao;

import cn.lt.pianke.model.Timeline;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/8.
 */
public interface TimelineDAO extends BaseDAO<Timeline> {
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


}
