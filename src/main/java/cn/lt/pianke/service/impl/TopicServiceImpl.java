package cn.lt.pianke.service.impl;

import cn.lt.pianke.dao.TopicDAO;
import cn.lt.pianke.model.Topic;
import cn.lt.pianke.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/8.
 */
@Service
@Transactional
public class TopicServiceImpl implements TopicService{
    @Autowired
    private TopicDAO topicDAO;
    /**
     * 获取阅读所有专题
     *
     * @return List<Topic>所有专题
     */
    @Override
    public List<Map> getAllReadTopics() {
        List<Map> allReadTopics=topicDAO.getAllReadTopics();
        return allReadTopics;
    }

    /**
     * 获取电台块专题
     *
     * @return List<Topic>所有专题
     */
    @Override
    public List<Map> getAllRadioTopics() {
        List<Map> allRadioTopics=topicDAO.getAllRadioTopics();
        return allRadioTopics;
    }

    /**
     * 获取后台所有专题界面
     *
     * @return List<Label>所有专题
     */
    @Override
    public List<Topic> getAllTopics() {
        return topicDAO.selectAll();
    }

}
