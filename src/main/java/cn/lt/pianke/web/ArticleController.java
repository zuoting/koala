package cn.lt.pianke.web;

import cn.lt.pianke.model.Comment;
import cn.lt.pianke.model.Like;
import cn.lt.pianke.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/9.
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 导航热门文章图片
     *
     * @return List<Article>导航热门3个电台图片
     */
    @RequestMapping(value = "articlePics", method = RequestMethod.GET)
    public ResponseEntity<List<Map>> listArticlePics() {
        List<Map> hotArticlePics=articleService.getHotArticlePics();
        if (hotArticlePics.isEmpty()) {
            return new ResponseEntity<List<Map>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Map>>(hotArticlePics, HttpStatus.OK);
    }

    /**
     * 导航热门电台图片
     *
     * @return List<Article>导航热门3个电台图片
     */
    @RequestMapping(value = "radioPicArticles", method = RequestMethod.GET)
    public ResponseEntity<List<Map>> listRadioPicArticles() {
        List<Map> hotRadioArticles=articleService.getHotRadioPics();
        if (hotRadioArticles.isEmpty()) {
            return new ResponseEntity<List<Map>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Map>>(hotRadioArticles, HttpStatus.OK);
    }
    /**
     * 获取热门文章的3个文章
     *
     * @return List<Article>热门的3个文章
     */
    @RequestMapping(value = "articles", method = RequestMethod.GET)
    public ResponseEntity<List<Map>> listArticles() {
        List<Map> hotArticles=articleService.getHotArticles();
        if (hotArticles.isEmpty()) {
            return new ResponseEntity< List<Map>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity< List<Map>>(hotArticles, HttpStatus.OK);
    }
    /**
     * 热门电台的3个文章
     *
     * @return List<Article>热门电台的3个文章
     */
    @RequestMapping(value = "radioArticles", method = RequestMethod.GET)
    public ResponseEntity<List<Map>> listRadioArticles() {
        List<Map> hotRadioArticles=articleService.getHotRadioArticles();
        if (hotRadioArticles.isEmpty()) {
            return new ResponseEntity< List<Map>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity< List<Map>>(hotRadioArticles, HttpStatus.OK);
    }

    /**
     * 获取所有文章
     *
     * @return List<Topic>所有文章
     */
    @RequestMapping(value = "allArticles", method = RequestMethod.GET)
    public ResponseEntity<List<Map>> listAllArticles() {
        List<Map> articles = articleService.getAllArticles();
        if (articles.isEmpty()) {
            return new ResponseEntity<List<Map>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Map>>(articles, HttpStatus.OK);
    }

    /**
     *根据文章id获取该文章所有详情数据
     *
     * @param article_id
     */
    @RequestMapping(value = "articles/{article_id}",method = RequestMethod.GET)
    public @ResponseBody
    Map getArticleInfo(@PathVariable("article_id")int article_id){
        Map articleInfo=articleService.getArticleInfo(article_id);
        return articleInfo;
    }
    /**
     *根据电台文章id获取该文章所有详情数据
     *
     * @param article_id
     */
    @RequestMapping(value = "radioArticles/{article_id}",method = RequestMethod.GET)
    public @ResponseBody
    Map getRadioArticleInfo(@PathVariable("article_id")int article_id){
        Map radioArticleInfo=articleService.getRadioArticleInfo(article_id);
        return radioArticleInfo;
    }

//    阅读界面
    /**
     * 阅读块轮播图
     *
     * @return
     */
    @RequestMapping(value = "readArticlePics", method = RequestMethod.GET)
    public ResponseEntity<List<Map>> listReadArticlePics() {
        List<Map> readArticles=articleService.getReadArticlePics();
        if (readArticles.isEmpty()) {
            return new ResponseEntity<List<Map>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Map>>(readArticles, HttpStatus.OK);
    }

    /**
     * 阅读界面所有文章
     *
     * @return
     */
    @RequestMapping(value = "readAllArticles", method = RequestMethod.GET)
    public ResponseEntity<List<Map>> listReadAllArticles() {
        List<Map> readAllArticles=articleService.getReadAllArticles();
        if (readAllArticles.isEmpty()) {
            return new ResponseEntity<List<Map>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Map>>(readAllArticles, HttpStatus.OK);
    }

    /**
     * 电台界面所有文章
     *
     * @return
     */
    @RequestMapping(value = "radioAllArticles", method = RequestMethod.GET)
    public ResponseEntity<List<Map>> listRadioAllArticles() {
        List<Map> radioAllArticles=articleService.getRadioAllArticles();
        if (radioAllArticles.isEmpty()) {
            return new ResponseEntity<List<Map>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Map>>(radioAllArticles, HttpStatus.OK);
    }

    /**
     * 喜欢（关注）一个文章
     * @param likeFroms
     */
    @RequestMapping(value = "likeFroms",method = RequestMethod.POST)
    public
    void followAuthor(@RequestBody Like likeFroms){
        articleService.followArticle(likeFroms);
    }

    /**
     * 评论一篇文章
     * @param comments
     */
    @RequestMapping(value = "comments",method = RequestMethod.POST)
    public
    void commentArticle(@RequestBody Comment comments){
        articleService.commentArticle(comments);
    }

//后台管理
    /**
     * 后台管理 根据id删除一个文章
     *
     * @param article_id
     * @return
     */
    @RequestMapping(value = "admin/deleteArticles/{article_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteArticle(@PathVariable int article_id) {
        Map articleMap =  articleService.getArticleInfo(article_id);
        if (articleMap == null) {
            System.out.println("not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        articleService.deleteArticleById(article_id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
