package cn.lt.pianke.service.impl;

import cn.lt.pianke.dao.ArticleDAO;
import cn.lt.pianke.dao.CommentDAO;
import cn.lt.pianke.dao.LikeDAO;
import cn.lt.pianke.model.Article;
import cn.lt.pianke.model.Comment;
import cn.lt.pianke.model.Like;
import cn.lt.pianke.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/8.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleDAO articleDAO;
    @Autowired
    private LikeDAO likeDAO;
    @Autowired
    private CommentDAO commentDAO;
    /**
     * 获取导航热门文章图片
     *
     * @return
     */
    @Override
    public List<Map> getHotArticlePics() {
        List<Map> hotArticlePics=articleDAO.getHotArticlePics();
        return hotArticlePics;
    }

    /**
     * 获取导航热门电台图片
     *
     * @return
     */
    @Override
    public List<Map> getHotRadioPics() {
        List<Map> hotRadioPics=articleDAO.getHotRadioPics();
        return hotRadioPics;
    }

    /**
     * 获取热门文章
     *
     * @return
     */
    @Override
    public List<Map> getHotArticles() {
        List<Map> hotArticles=articleDAO.getHotArticles();
        return hotArticles;
    }

    /**
     * 获取热门电台文章
     *
     * @return
     */
    @Override
    public List<Map> getHotRadioArticles() {
        List<Map> hotRadioArticles=articleDAO.getHotRadioArticles();
        return hotRadioArticles;
    }

    /**
     * 获取所有文章
     *
     * @return List<Topic>所有专题
     */
    @Override
    public List<Map> getAllArticles() {
        List<Map> allArticles=articleDAO.getAllArticles();
        return allArticles;
    }

    /**
     * 根据专题id获取该文章所有详情数据
     *
     * @param article_id
     * @return
     */
    @Override
    public Map getArticleInfo(int article_id) {
        return articleDAO.getArticleInfo(article_id);
    }

    /**
     * 根据电台文章id获取该文章所有详情数据
     *
     * @param article_id
     * @return
     */
    @Override
    public Map getRadioArticleInfo(int article_id) {
        return articleDAO.getRadioArticleInfo(article_id);
    }

//    阅读界面
    /**
     * 阅读块轮播图
     *
     * @return
     */
    @Override
    public List<Map> getReadArticlePics() {
        List<Map> readArticles=articleDAO.getReadArticlePics();
        return readArticles;
    }

    /**
     * 阅读界面所有文章
     *
     * @return
     */
    @Override
    public List<Map> getReadAllArticles() {
        List<Map> readAllArticles=articleDAO.getReadAllArticles();
        return readAllArticles;
    }

    /**
     * 电台界面所有文章
     *
     * @return
     */
    @Override
    public List<Map> getRadioAllArticles() {
        List<Map> radioAllArticles=articleDAO.getRadioAllArticles();
        return radioAllArticles;
    }

    /**
     * 喜欢（关注）一个文章
     *
     * @param likeFroms
     */
    @Override
    public void followArticle(Like likeFroms) {
        likeDAO.insert(likeFroms);//向喜欢文章关注表插入一条记录
        //更新喜欢文章数量
        Example example=new Example(Article.class);
        example.createCriteria()
                .andEqualTo("article_id",likeFroms.getArticle_id());
        Article article=articleDAO.selectByExample(example).get(0);
        article.setLike_count(article.getLike_count()+1); //关注数+1
        articleDAO.updateByExample(article,example);
    }

    /**
     * 发表一个文章的评论
     *
     * @param comments
     */
    @Override
    public void commentArticle(Comment comments) {
        commentDAO.insert(comments);//插入一条评论
        //更新文章评论
        Example example = new Example(Article.class);
        example.createCriteria()
                .andEqualTo("article_id",comments.getArticle_id());
        Article article = articleDAO.selectByExample(example).get(0);
        article.setComment_count(article.getComment_count()+1);
        articleDAO.updateByExample(article,example);
    }

//后台管理
    /**
     * 后台管理 根据id删除一个文章
     *
     * @param article_id
     * @return
     */
    @Override
    public void deleteArticleById(int article_id) {
        Example example =new Example(Article.class);
        example.createCriteria()
                .andEqualTo("article_id",article_id);
        articleDAO.deleteByExample(example);
    }

}
