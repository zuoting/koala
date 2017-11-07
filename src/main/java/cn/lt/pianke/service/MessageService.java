package cn.lt.pianke.service;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/8.
 */
public interface MessageService {
    /**
     * 收到的评论
     * @param user_id
     * @return
     */
    List<Map> getComments(int user_id);//收到的评论

    /**
     * 获取某位用户收到的所有碎片评论
     * @param user_id
     * @return
     */
    List<Map> getTimelineComments(int user_id);//收到的碎片评论

    /**
     * 收到的简讯
     * @param user_id
     * @return
     */
    List<Map> getLetters(int user_id);//收到的简讯

    /**
     * 收到的喜欢
     * @param user_id
     * @return
     */
    List<Map> getLikeTo(int user_id); //收到的喜欢

    /**
     * 收到的关注（粉丝）
     * @param user_id
     * @return
     */
    List<Map> getFans(int user_id);//收到的关注（粉丝）
}
