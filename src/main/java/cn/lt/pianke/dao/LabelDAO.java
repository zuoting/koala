package cn.lt.pianke.dao;

import cn.lt.pianke.model.Label;

import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/8.
 */
public interface LabelDAO extends BaseDAO<Label>{
    /**
     * 根据专题id获取该专题所有文章
     * @param label_id
     * @return
     */
    Map getLabelInfo(int label_id);

}
