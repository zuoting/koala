package cn.lt.pianke.service;

import cn.lt.pianke.model.TimelineComment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TimelineServiceTest {
    @Autowired
    private TimelineService timelineService;
    @Test
    public void getTimelines() throws Exception {

    }

    @Test
    public void getTimelineInfo() throws Exception {
        Map timelineArticleView=timelineService.getTimelineInfo(33);
        System.out.println(timelineArticleView);
    }

    @Test
    public void timelineCommentArticle() throws Exception {
        TimelineComment timelineComment=new TimelineComment(34,4,"好美的插入", null);
        timelineService.timelineCommentArticle(timelineComment);
    }

}
