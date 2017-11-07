package cn.lt.pianke.web;

import cn.lt.pianke.model.Topic;
import cn.lt.pianke.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/5/2.
 */
@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;


    /**
     * 获取阅读所有专题
     *
     * @return List<Topic>所有专题
     */
    @RequestMapping(value = "allReadTopics", method = RequestMethod.GET)
    public ResponseEntity<List<Map>> listAllReadTopics() {
        List<Map> allRadioTypes=topicService.getAllReadTopics();
        if (allRadioTypes.isEmpty()) {
            return new ResponseEntity< List<Map>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity< List<Map>>(allRadioTypes, HttpStatus.OK);
    }

    /**
     * 获取电台所有专题
     *
     * @return List<Topic>所有专题
     */
    @RequestMapping(value = "allRadioTopics", method = RequestMethod.GET)
    public ResponseEntity<List<Map>> listRadioArticles() {
        List<Map> allRadioTypes=topicService.getAllRadioTopics();
        if (allRadioTypes.isEmpty()) {
            return new ResponseEntity< List<Map>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity< List<Map>>(allRadioTypes, HttpStatus.OK);
    }

    /**
     * 获取后台所有专题界面
     * @return
     */
    @RequestMapping(value = "allTopics", method = RequestMethod.GET)
    public ResponseEntity< List<Topic>> listAllTopics() {
        List<Topic> topics = topicService.getAllTopics();
        if (topics.isEmpty()) {
            return new ResponseEntity<List<Topic>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Topic>>(topics, HttpStatus.OK);
    }


}