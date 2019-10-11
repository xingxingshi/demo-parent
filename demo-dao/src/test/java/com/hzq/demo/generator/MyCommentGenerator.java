package com.hzq.demo.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

public class MyCommentGenerator extends DefaultCommentGenerator {

	@Override
	public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		//引入lombok框架 自动产生get/set和构造方法
		topLevelClass.addJavaDocLine("import lombok.Data;");
		topLevelClass.addJavaDocLine("");
		topLevelClass.addJavaDocLine("/**");

		String remarks = introspectedTable.getRemarks();
		introspectedTable.getRemarks();
		System.out.println(remarks);
		if (StringUtility.stringHasValue(remarks)) {
			String[] remarkLines = remarks.split(System.getProperty("line.separator"));
			for (String remarkLine : remarkLines) {
				topLevelClass.addJavaDocLine(" * " + remarkLine);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(introspectedTable.getFullyQualifiedTable());
		topLevelClass.addJavaDocLine(" * " + sb.toString());
		topLevelClass.addJavaDocLine(" */");
		topLevelClass.addJavaDocLine("@Data");
	}

	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		field.addJavaDocLine("/**");

		String remarks = introspectedColumn.getRemarks();
		if (StringUtility.stringHasValue(remarks)) {
			String[] remarkLines = remarks.split(System.getProperty("line.separator"));
			for (String remarkLine : remarkLines) {
				field.addJavaDocLine(" * " + remarkLine);
			}
		}
		field.addJavaDocLine(" */");
	}

	@Override
	public void addGetterComment(Method method,
						  IntrospectedTable introspectedTable,
						  IntrospectedColumn introspectedColumn){
		return;
	}

	@Override
	public void addSetterComment(Method method,
						  IntrospectedTable introspectedTable,
						  IntrospectedColumn introspectedColumn){
		return;
	}



}
