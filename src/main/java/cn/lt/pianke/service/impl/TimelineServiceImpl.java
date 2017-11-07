package cn.lt.pianke.service.impl;

import cn.lt.pianke.dao.TimelineCommentDAO;
import cn.lt.pianke.dao.TimelineDAO;
import cn.lt.pianke.model.Timeline;
import cn.lt.pianke.model.TimelineComment;
import cn.lt.pianke.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/9.
 */
@Service
@Transactional
public class TimelineServiceImpl implements TimelineService {
    @Autowired
    private TimelineDAO timelineDAO;
    @Autowired
    private TimelineCommentDAO timelineCommentDAO;

    /**
     * 查询所有碎片
     *
     * @return List<User>
     */
    @Override
    public List<Map> getTimelines() {
        List<Map> timelineAllArticles=timelineDAO.getTimelines();
        return timelineAllArticles;
    }

    /**
     * 根据专题id获取该碎片所有详情数据
     *
     * @param timeline_id
     * @return
     */
    @Override
    public Map getTimelineInfo(int timeline_id) {
        return timelineDAO.getTimelineInfo(timeline_id);
    }

    /**
     * 发表一个碎片的评论
     *
     * @param timelineComments
     */
    @Override
    public void timelineCommentArticle(TimelineComment timelineComments) {
        timelineCommentDAO.insert(timelineComments);//插入一条评论
        //更新碎片评论
        Example example = new Example(Timeline.class);
        example.createCriteria()
                .andEqualTo("timeline_id",timelineComments.getTimeline_id());
        Timeline timeline = timelineDAO.selectByExample(example).get(0);
        timeline.setComment_count(timeline.getComment_count()+1);
        timelineDAO.updateByExample(timeline,example);
    }

}
