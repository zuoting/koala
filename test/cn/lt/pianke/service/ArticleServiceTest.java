package cn.lt.pianke.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/6/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    /**
     * 获取导航热门电台图片
     * @return
     */
    @Test
    public void getHotArticlePics() throws Exception {
        List<Map> hotArticlePics=articleService.getHotRadioPics();
        for (Map articleView:hotArticlePics
                ) {
            System.out.println(articleView);
        }
    }

    /**
     * 获取导航热门电台图片
     * @return
     */
    @Test
    public void getHotRadioPics() throws Exception {
        List<Map> hotRadioPics=articleService.getHotRadioPics();
        for (Map articleView:hotRadioPics
                ) {
            System.out.println(articleView);
        }
    }

    /**
     * 获取热门文章
     * @return
     */
    @Test
    public void getHotArticles() throws Exception {
        List<Map> hotArticles=articleService.getHotArticles();
        for (Map articleView:hotArticles
                ) {
            System.out.println(articleView);
        }
    }

    /**
     * 获取热门电台文章
     * @return
     */
    @Test
    public void getHotRadioArticles() throws Exception {
        List<Map> hotRadioArticles=articleService.getHotRadioArticles();
        for (Map articleView:hotRadioArticles
                ) {
            System.out.println(articleView);
        }
    }

    /**
     * 获取所有文章  主界面
     * @throws Exception
     */
    @Test
    public void getAllArticles() throws Exception {
        List<Map> allArticles=articleService.getAllArticles();
        for (Map articleView:allArticles
                ) {
            System.out.println(articleView);
        }
    }

    /**
     * 根据文章id获取该文章所有详情数据
     * @throws Exception
     */
    @Test
    public void getArticleInfo() throws Exception {
        Map articleView=articleService.getArticleInfo(2);
        System.out.println(articleView);
    }

    /**
     * 根据电台文章id获取该文章所有详情数据
     * @throws Exception
     */
    @Test
    public void getRadioArticleInfo() throws Exception {
        Map articleView=articleService.getRadioArticleInfo(2);
        System.out.println(articleView);
    }

    /**
     * 电台界面所有文章
     * @throws Exception
     */
    @Test
    public void getRadioAllArticles() throws Exception {
        List<Map> radioAllArticles=articleService.getRadioAllArticles();
        for (Map articleView:radioAllArticles
                ) {
            System.out.println(articleView);
        }
    }

}