配置文件说明

1、使用约定的方式，以便简单的进行调用
    约定如下：
    文件名：电视名+型号+.appconfig如:haier01.appconfig

2、base.appconfig为默认配置，在app系统时加载。

3、配置文件支持组合：
    modules：添加文件名，使用逗号隔开
    比如:在haier01.appconfig中，可以使用haier01.appconfig,haier02.appconfig中的所有事件配置,如：modules:haier01,haier02
    如果组合中的event name如果重复，被组合的event可以被覆盖

{
   version:"版本号",
   modules:"组合的事件",
   events:[
         {
            name:"事件名字",
            describe:"时间描述",
            enable:"是否可用",
            handlers:[处理器
            "",
            ""
            ]
         }
   ]
}