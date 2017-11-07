package cn.lt.pianke.dao;

import cn.lt.pianke.model.Letter;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/5/7.
 */
public interface LetterDAO extends BaseDAO<Letter>{
    /**
     * 根据用户Id查找用户收到的简信
     * @param user_id
     * @return
     */
    List<Map> getLetters(int user_id);

}
