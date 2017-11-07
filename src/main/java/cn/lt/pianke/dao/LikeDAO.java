package cn.lt.pianke.dao;

import cn.lt.pianke.model.Like;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/5/7.
 */
public interface LikeDAO extends BaseDAO<Like> {

    /**
     * 我喜欢的文章
     *
     */
    List<Map> getLikeFrom(int user_id);

    /**
     *
     * 喜欢我写的文章
     */
    List<Map> getLikeTo(int user_id);


}
