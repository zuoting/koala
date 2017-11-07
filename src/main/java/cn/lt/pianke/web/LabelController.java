package cn.lt.pianke.web;

import cn.lt.pianke.model.Label;
import cn.lt.pianke.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 刘婷 on 2017/6/12.
 */
@RestController
public class LabelController {
    @Autowired
    private LabelService labelService;

    /**
     * 获取碎片所有专题
     *
     * @return List<Label>所有专题
     */
    @RequestMapping(value = "allLabels", method = RequestMethod.GET)
    public ResponseEntity< List<Label>> listAllTopics() {
        List<Label> labels = labelService.getAllLabels();
        if (labels.isEmpty()) {
            return new ResponseEntity<List<Label>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Label>>(labels, HttpStatus.OK);
    }

    /**
     * 根据id查询单个标签
     *
     * @param label_id
     * @return
     */
    @RequestMapping(value = "labels/{label_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Label> findLabel(@PathVariable("label_id") int label_id) {
        Label label = labelService.findLabelById(label_id);
        if (label == null) {
            System.out.println(" not found");
            return new ResponseEntity<Label>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Label>(label, HttpStatus.OK);
    }

    /**
     * 后台管理 根据id删除一个标签
     *
     * @param label_id
     * @return
     */
    @RequestMapping(value = "admin/deleteLabels/{label_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBook(@PathVariable("topic_id") int label_id) {
        Label label =  labelService.findLabelById(label_id);
        if (label == null) {
            System.out.println("not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        labelService.deleteLabelById(label_id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
