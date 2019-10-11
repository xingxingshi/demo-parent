package com.hzq.demo.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.PluginAggregator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用java代码生成，可以使用重写的生成注解的类
 * @author YTGHTGHS
 * @date 2017年11月30日
 * @description
 */
public class MyBatisGeneratorMain {
	public static void main(String[] args) {
		java.net.URL url = MyBatisGeneratorMain.class.getProtectionDomain().getCodeSource().getLocation();
		String filePath = null;
		try {
			filePath = java.net.URLDecoder.decode(url.getPath(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (filePath.endsWith(".jar")){
		    filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		}
		File file = new File(filePath);
		filePath = file.getAbsolutePath();
		String fileName = filePath+"/generator-config.xml";
		File configFile = new File(fileName);
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		try{
			PluginAggregator pluginAggregator=new PluginAggregator();
			pluginAggregator.addPlugin(new MyPlugin());
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			System.out.println("==============generator start==========");
			myBatisGenerator.generate(null);
			System.out.println("==============generator complete=======================");
		}catch (Exception e) {
			System.out.println("==============generator error=======================");
			e.printStackTrace();
		}
		
	}
}
