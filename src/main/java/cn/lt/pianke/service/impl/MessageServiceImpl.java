package cn.lt.pianke.service.impl;

import cn.lt.pianke.dao.*;
import cn.lt.pianke.service.MessageService;
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
public class MessageServiceImpl implements MessageService {
    @Autowired
    private LikeDAO likeDAO;
    @Autowired
    private CommentDAO commentDAO;
    @Autowired
    private TimelineCommentDAO timelineCommentDAO;
    @Autowired
    private LetterDAO letterDAO;
    @Autowired
    private AuthorFollowDAO authorFollowDAO;
    /**
     * 收到的评论
     *
     * @param user_id
     * @return
     */
    @Override
    public List<Map> getComments(int user_id) {
        return commentDAO.getComments(user_id);
    }

    /**
     * 获取某位用户收到的所有碎片评论
     *
     * @param user_id
     * @return
     */
    @Override
    public List<Map> getTimelineComments(int user_id) {
        return timelineCommentDAO.getTimelineComments(user_id);
    }

    /**
     * 收到的简讯
     *
     * @param user_id
     * @return
     */
    @Override
    public List<Map> getLetters(int user_id) {
        return letterDAO.getLetters(user_id);
    }

    /**
     * 收到的喜欢
     *
     * @param user_id
     * @return
     */
    @Override
    public List<Map> getLikeTo(int user_id) {
        return likeDAO.getLikeTo(user_id);
    }

    /**
     * 收到的关注（粉丝）
     *
     * @param user_id
     * @return
     */
    @Override
    public List<Map> getFans(int user_id) {
        return authorFollowDAO.getFans(user_id);
    }

}
