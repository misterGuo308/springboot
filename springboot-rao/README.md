大家好截至2019年7月11号该项目框架1.0版本终于搭建完成。该项目使用与中小型前后台分离的项目。
项目中对于单表的操作Generator会帮你生成，并且不会生成多余的代码，项目结构与代码清晰。
符合快速、简洁、便利的开发习惯，在开发过程中你会感觉很爽。
                                                         ------在此感谢磊哥提供的宝贵意见
近期有时间我还会继续更新新的技术。
##### 项目规范
1、我是用idea搭建的springboot新项目，建议大家将编译器换成idea，在idea中安装阿里的代码检验工具。
2、该项目建议的环境为 jdk1.8 maven 3.6 mysql 8 redis 3.0 版本。
3、项目中用到的数据库文件为mytest.sql 没有学习过mybatis plus的建议先去官网学习一下用法。
4、该项目的mapper持久层连接是用全注解的形式，记得在接口类上加上@mapper注解在方法中加上@select @insert @update @delete 具体用法与mybatis用法一样。
5、该项目的model为对应数据库表的实体类，@data注解代替了get set 等方法具体详细信息请查看lombok的具体用法。
6、在新增数据库表时可以用Generator的工具生成基本的模板代码。
7、下面分别说一下该项目的结构： 
springboot-rao 
            -|sec
                -|main   
                    -|java
                          -|com.example.springbootra
                                                    -|common(公共的一些工具与项目中的配置信息)
                                                            -|annotation(自定义注解类暂时用于aop日志记录功能 :注记录日志需要用户登录)
                                                            -|constant(公共用到的常量,一个是regEx的常量一个是系统定义的通用常量)
                                                            -|jop(异步定时任务,可以支持多个任务非阻塞的情况下运行)
                                                            -|model(封装数据的实体)
                                                            -|ret(处理条用者返回的封装json实体)
                                                            -|utils(加密工具类与传入参数验证工具类)
                                                    -configuration
                                                            _|aop(aop日志处理类)
                                                            _|cors(解决跨域问题)
                                                            _|exception(全局异常拦截类与系统系自定义异常类)
                                                            _|interceptor(系统拦截器拦截请求并判断用户是否登录)
                                                            _|listener(session的监听器如果需求问用到可以将其删除)
                                                    -|controller(前端控制器)
                                                    -|mapper(mapper里边可以写对数据库crud的注解同事也支持多表的操作)
                                                    -|service(服务类)
                                                            _|impl(服务类实现)
                    -|resources 
                        -|application.properties (公共文件配置)
                        _|application-dev.properties(开发配置)
                        _|application-pord.properties(正式环境配置)
                        _|application-test.properties(测试配置)
            _|project-resources(项目所用的的文件)
            _|pom.xml(maven配置文件 该项目支持热部署 支持多环境maven打包)
            -|README.md(项目说明文件)
            
暂时1.0版本就这么多基础的功能。以后有时间会持续更新。
大家有什么疑问或者意见欢迎给我邮箱留言。
guoyou5378@139.com  --------希望大家多多交流共同进步。加油你是最胖的  哈哈