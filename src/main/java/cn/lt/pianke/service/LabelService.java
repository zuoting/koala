package cn.lt.pianke.service;

import cn.lt.pianke.model.Label;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/12.
 */
public interface LabelService {
    /**
     * 获取碎片所有专题
     *
     * @return List<Label>所有专题
     */
    List<Label> getAllLabels();

    /**
     * 根据id查询单个实体
     * @param label_id
     * @return
     */
    Label findLabelById(int label_id);


// 后台管理
    /**
     * 根据专题id获取该专题所有文章
     * @param label_id
     * @return
     */
    Map getLabelInfo(int label_id);

    /**
     * 后台管理 根据id删除一个标签
     * @param label_id
     * @return
     */
    void deleteLabelById(int label_id);       //根据id删除一个实体




}
