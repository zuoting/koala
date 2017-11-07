package cn.lt.pianke.service;

import cn.lt.pianke.model.Comment;
import cn.lt.pianke.model.Like;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/8.
 */
public interface ArticleService {
    /**
     * 获取导航热门文章图片
     * @return
     */
    List<Map>  getHotArticlePics();
    /**
     * 获取导航热门电台图片
     * @return
     */
    List<Map> getHotRadioPics();

    /**
     * 获取热门文章
     * @return
     */
    List<Map> getHotArticles();

    /**
     * 获取热门文章
     * @return
     */
    List<Map> getHotRadioArticles();

    /**
     * 获取所有文章  主界面
     *
     * @return List<Topic>所有文章
     */
    List<Map> getAllArticles();

    /**
     * 根据文章id获取该文章所有详情数据
     * @param article_id
     * @return
     */
    Map getArticleInfo(int article_id);

    /**
     * 根据电台文章id获取该文章所有详情数据
     * @param article_id
     * @return
     */
    Map getRadioArticleInfo(int article_id);

//    阅读界面
    /**
     *阅读块轮播图
     * @return
     */
    List<Map>  getReadArticlePics();

    /**
     * 阅读界面所有文章
     * @return
     */
    List<Map> getReadAllArticles();

    /**
     * 电台界面所有文章
     * @return
     */
    List<Map> getRadioAllArticles();

    /**
     * 喜欢（关注）一个文章
     * @param likeFroms
     */
    void followArticle(Like likeFroms);

    /**
     * 发表一个文章的评论
     * @param comments
     */
    void commentArticle(Comment comments);

    /**
     * 后台管理 根据id删除一个文章
     * @param article_id
     * @return
     */
    void deleteArticleById(int article_id);       //根据id删除一个实体

}
