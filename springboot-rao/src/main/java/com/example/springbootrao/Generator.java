package com.example.springbootrao;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Generator {

    public static void main(String[] args) {
        // 包名
        String packageName = "com.example.springbootrao";

        boolean serviceNameStartWithI = false;//auth -> UserService, 设置成true: auth -> IUserService
        String[] tableNames="sys_log_content,sys_log,user_info".split(",");


        //把需要自动生成的表 放在这里!!
        generateByTables(serviceNameStartWithI, packageName, "guoyou", "mytest", "sys_log");
   //     generateByTables(serviceNameStartWithI, packageName, "guoyou", "mytest", "user_info");
        System.out.println("completed...");
    }

    /**
     * @param serviceNameStartWithI
     * @param packageName           包名
     * @param author                作者
     * @param database              数据库名
     * @param tableNames            表名
     */
    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String author, String database, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://localhost:3306/" + database + "?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false&serverTimezone=UTC";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("guoyou")
                .setDriverName("com.mysql.cj.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(true)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
        //   .setSuperMapperClass("cn.saytime.mapper.BaseMapper")
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setAuthor(author)
                .setOutputDir("d:\\codeGen")
                .setFileOverride(true)
                .setEnableCache(false);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("model")
                                .setMapper("mapper")
                                .setService("service")
                                .setServiceImpl("service.impl")
                                .setXml("mappers")
                ).execute();
    }


}