package com.hzq.demo.other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2026/4/2 23:52
 * @Version: 1.0
 */
public class HtmlTest {


    @Test
    public void testSpan() throws IOException {

/*        Connection connect = Jsoup.connect("https://yuluji.blogspot.com/2022/11/blog-post_39.html?m=1");
        Document document = connect.get();*/

        File input = new File("/Users/huangziqiang/Documents/code/github/demo-parent/original.html");
        Document document = Jsoup.parse(input, "UTF-8");


        Elements jammer = document.select("span.jammer");
        jammer.remove();

        System.out.println(document.body().html());
        Path path = Paths.get("/Users/huangziqiang/Documents/code/github/demo-parent", "aa.html");

        try {
            Files.write(path, document.body().html().getBytes(StandardCharsets.UTF_8));
            System.out.println("文件已写入：" + path.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("写入失败：" + e.getMessage());
        }
        System.out.println(document.body().html());


    }

}
