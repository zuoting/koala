package cn.lt.pianke.dao;

import cn.lt.pianke.model.Article;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/8.
 */
public interface ArticleDAO extends BaseDAO<Article>{

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
     * 获取热门电台文章
     * @return
     */
    List<Map> getHotRadioArticles();

    /**
     * 获取所有文章  主界面
     *
     * @return 所有文章
     */
    List<Map> getAllArticles();

    /**
     * 根据阅读文章id获取该文章所有详情数据
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

}
