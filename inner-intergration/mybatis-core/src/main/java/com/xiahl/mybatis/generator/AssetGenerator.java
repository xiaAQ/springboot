package com.xiahl.mybatis.generator;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetGenerator {

    private static String[] databasesName = {
//            "YCA_TRADEMARK_PATENT_RIGHT",
//            "YCA_TRADEMARK_PATENT_RIGHT_OBLIGOR",
//            "YCA_CONSTRUCT_QUALIFICATION",
//            "YCA_CONSTRUCT_QUALIFICATION_CERTIFICATE",
            "xiaoming"
    };

    private static final boolean override = true;
    private static final String packageName = ".asset.company";
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/springboot?serverTimezone=Asia/Shanghai&useUnicode=true&useSSL=false&allowMultiQueries=true&autoReconnect=true";
        String username = "root";
        String password = "root";

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
        String projectPath = "D:/java_monitor";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("DoyuTu");
        gc.setOpen(true);
        gc.setFileOverride(override)
                .setSwagger2(true)
                .setDateType(DateType.ONLY_DATE)
                .setIdType(IdType.AUTO)
                .setKotlin(false)
                .setBaseColumnList(true)
                .setBaseResultMap(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
        pc.setParent("");
        String parentPackage = "com.yc.common.";
        pc.setEntity(parentPackage + "entity.po" + packageName);
        pc.setService(parentPackage + "dao" + packageName);
        pc.setServiceImpl(parentPackage + "dao" + packageName + ".impl");
        pc.setMapper(parentPackage + "mapper" + packageName);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
                Map<String, Object> map = new HashMap<>();
//                map.put("idType", "AUTO");
//                this.setMap(map);
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" /*+ pc.getModuleName()*/
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
//        focList.add(new FileOutConfig("/templates/entity.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return projectPath + "/src/main/java/com/yc/entity/po/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
//            }
//        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setController(null);
        templateConfig.setXml(null);
        templateConfig.setEntity("/templates/entity.java");
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperServiceClass(ISuperService.class.getName());
//        strategy.setSuperServiceImplClass(SuperServiceImpl.class.getName());
//        strategy.setSuperMapperClass(SuperMapper.class.getName());
        strategy.setLogicDeleteFieldName("is_deleted");
//        strategy.setTableFillList(Lists.newArrayList(
//                new TableFill("GMT_CREATE", FieldFill.INSERT),
//                new TableFill("GMT_MODIFIED", FieldFill.INSERT_UPDATE),
//                new TableFill("GMT_UPDATE", FieldFill.INSERT_UPDATE),
//                new TableFill("gmt_create", FieldFill.INSERT),
//                new TableFill("gmt_modified", FieldFill.INSERT_UPDATE),
//                new TableFill("gmt_update", FieldFill.INSERT_UPDATE),
//                new TableFill("create_time", FieldFill.INSERT),
//                new TableFill("update_time", FieldFill.INSERT_UPDATE)
//        ));
        strategy.setEntityLombokModel(true);
        strategy.setEntityBuilderModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(databasesName);
//        strategy.setSuperEntityColumns("id");
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setEntityBuilderModel(true);
        strategy.setEntityLombokModel(true);
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
