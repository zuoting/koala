package cn.lt.pianke.web;

import cn.lt.pianke.model.TimelineComment;
import cn.lt.pianke.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/12.
 */
@RestController
public class TimelineController {
    @Autowired
    private TimelineService timelineService;

    /**
     * 查询所有碎片
     * @return
     */
    @RequestMapping(value = "allTimelines", method = RequestMethod.GET)
    public ResponseEntity<List<Map>> listAllTimelines() {
        List<Map> timelineAllArticles=timelineService.getTimelines();
        if (timelineAllArticles.isEmpty()) {
            return new ResponseEntity<List<Map>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Map>>(timelineAllArticles, HttpStatus.OK);
    }

    /**
     * 根据专题id获取该碎片所有详情数据
     * @param timeline_id
     * @return
     */
    @RequestMapping(value = "allTimelines/{timeline_id}",method = RequestMethod.GET)
    public @ResponseBody
    Map getTimelineArticleInfo(@PathVariable("timeline_id")int timeline_id){
        Map timelineArticleInfo=timelineService.getTimelineInfo(timeline_id);
        return timelineArticleInfo;
    }


    /**
     * 发表一个碎片的评论
     * @param timelineComments
     */
    @RequestMapping(value = "timelineComments",method = RequestMethod.POST)
    public
    void timelineCommentArticle(@RequestBody TimelineComment timelineComments){
        timelineService.timelineCommentArticle(timelineComments);
    }

}
