package com.cxy.es;

import com.rometools.rome.feed.module.Module;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @program: elasticSearch
 * @description: rss订阅测试
 * @author: cuixy
 * @create: 2020-08-19 14:44
 **/
public class FeedConsumer {

    private final static String RSS_URL = "https://bk.cuixiaoyan.xyz/atom.xml";

    /**
     * 链接地址
     *
     * @throws MalformedURLException
     */
    @Test
    public void test() throws MalformedURLException {
        //URL feedUrl = new URL(String.format(RSS_URL, symbol));
        //null 代表header
        URL feedUrl = new URL(String.format(RSS_URL, null));
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = null;
        try {
            feed = input.build(new XmlReader(feedUrl));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (feed == null) {
            //log.warn("syndFeed is null, symbol:{}", symbol);
            return;
        }
        List<SyndEntry> list = feed.getEntries();
        for (SyndEntry entry : list) {
            System.out.println(entry.getTitle() + "-" + entry.getUpdatedDate() + "-" + entry.getLink());
        }

    }

    /**
     * 获取博客
     */
    @Test
    public void getBlog() {
        try {
            String url = "https://bk.cuixiaoyan.xyz/atom.xml";
            try (XmlReader reader = new XmlReader(new URL(url))) {
                SyndFeed feed = new SyndFeedInput().build(reader);
                //博客名称
                //System.out.println(feed.getTitle());
                for (int i = 0; i < feed.getEntries().size(); i++) {
                    SyndEntry syndEntry = feed.getEntries().get(i);
                    //作者
                    System.out.println(syndEntry.getAuthor());
                    //链接
                    System.out.println(syndEntry.getLink());
                    //标题
                    System.out.println(syndEntry.getTitle());
                    //发布时间
                    System.out.println(syndEntry.getPublishedDate());
                    //内容
                    System.out.println(syndEntry.getContents().get(0).getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

