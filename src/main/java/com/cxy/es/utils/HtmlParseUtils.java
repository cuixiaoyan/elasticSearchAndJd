package com.cxy.es.utils;

import com.cxy.es.entity.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: elasticSearch
 * @description: 爬取京东商品信息。
 * @author: cuixy
 * @create: 2020-07-18 11:08
 **/
public class HtmlParseUtils {

    public static void main(String[] args) throws IOException {
        parseJD("java").forEach(System.out::println);
    }

    public static List<Content> parseJD(String keyWord) throws IOException {
        //获取请求  https://search.jd.com/Search?keyword=java
        String url = "https://search.jd.com/Search?keyword=" + keyWord;
        //根据url解析网页  Jsoup返回的document对象就是javascript中的页面对象，所有在javascript中能够使用的方法在这里都能使用
        Document document = Jsoup.parse(new URL(url), 30000);   //第二个参数为最大连接时间，超时即报错
        //通过document对象获取页面上的一部分元素
        Element element = document.getElementById("J_goodsList");  //element是获取的商品列表的主要信息
        //获取到所有的li元素，商品信息部分是用ul来装载的，所以要先获取到所有的li元素
        Elements elements = element.getElementsByTag("li");
        //通过li标签我们可以获取到每一个li标签中的商品信息，在此我们主要获取三个部分：图片地址，标题，价格
        ArrayList<Content> contentList = new ArrayList<>();
        for (Element el : elements) {  //每一个el都是一个li
            //获取图片地址，在此获取的并不是img的src属性，而是source-data-lazy-img属性
            //原因是因为京东为了追求网页渲染的速度，会在图片渲染之前先渲染一个默认的页面，而真实的图片路径会放在source-data-lazy-img中进行懒加载
            String img = el.getElementsByTag("img").eq(0).attr("src");
            String title = el.getElementsByClass("p-name").eq(0).text();
            String price = el.getElementsByClass("p-price").eq(0).text();
            Content content = new Content(img, title, price);
            contentList.add(content);
        }
        return contentList;
    }


}