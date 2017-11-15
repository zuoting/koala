package cn.lt.pianke.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 刘婷 on 2017/6/8.
 */
@Table(name="t_label")
public class Label {
    private Integer label_id;
    private Integer admin_id;
    private String label_name;
    private String logo;
    private Integer timeline_count;

    public Label() {
    }

    public Label(Integer label_id, Integer admin_id, String label_name, String logo, Integer timeline_count) {
        this.label_id = label_id;
        this.admin_id = admin_id;
        this.label_name = label_name;
        this.logo = logo;
        this.timeline_count = timeline_count;
    }

    //主键映射
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "label_id",length = 11,unique = true,nullable = false)
    public Integer getLabel_id() {
        return label_id;
    }

    public void setLabel_id(Integer label_id) {
        this.label_id = label_id;
    }
    @Column(name = "admin_id",length = 11,nullable = false)
    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }
    @Column(name = "label_name",length = 20,nullable = false)
    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }
    @Column(name = "logo",length = 50,nullable = false)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    @Column(name = "timeline_count",length = 11,nullable = false)
    public Integer getTimeline_count() {
        return timeline_count;
    }

    public void setTimeline_count(Integer timeline_count) {
        this.timeline_count = timeline_count;
    }

}
