package cn.lt.pianke.service;

import cn.lt.pianke.model.Topic;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/8.
 */
public interface TopicService {

    /**
     * 获取阅读所有专题
     *
     * @return List<Topic>所有专题
     */
    List<Map> getAllReadTopics();

    /**
     * 获取电台块专题
     *
     * @return List<Topic>所有专题
     */
    List<Map> getAllRadioTopics();

    /**
     * 获取后台所有专题界面
     *
     * @return List<Label>所有专题
     */
    List<Topic> getAllTopics();




}
