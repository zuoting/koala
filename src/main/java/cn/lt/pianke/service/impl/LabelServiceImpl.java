package cn.lt.pianke.service.impl;

import cn.lt.pianke.dao.LabelDAO;
import cn.lt.pianke.model.Label;
import cn.lt.pianke.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/12.
 */
@Service
@Transactional
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelDAO labelDAO;
    /**
     * 获取所有专题
     *
     * @return List<Label>所有专题
     */
    @Override
    public List<Label> getAllLabels() {
        return labelDAO.selectAll();
    }

    /**
     * 根据id查询单个标签
     *
     * @param label_id
     * @return
     */
    @Override
    public Label findLabelById(int label_id) {
        Example example=new Example(Label.class);
        example.createCriteria()
                .andEqualTo("label_id",label_id);
        return labelDAO.selectByExample(example).get(0);
    }

    /**
     * 根据专题id获取该专题所有文章
     *
     * @param label_id
     * @return
     */
    @Override
    public Map getLabelInfo(int label_id) {
        return labelDAO.getLabelInfo(label_id);
    }

//后台管理
    /**
     * 后台管理 根据id删除一个标签
     *
     * @param label_id
     * @return
     */
    @Override
    public void deleteLabelById(int label_id) {
        Example example =new Example(Label.class);
        example.createCriteria()
                .andEqualTo("label_id",label_id);
        labelDAO.deleteByExample(example);
    }

}
