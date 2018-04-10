ai.qa.autotest.ui.custom.annotation包：包含一些自定义注解。

ai.qa.autotest.ui.dataentity包：包含一些输入的数据结构等信息。

ai.qa.autotest.ui.framework.constants包：常量类包，包含一些公共的常量和配置文件相关的key值。

ai.qa.autotest.ui.framework.utility包：工具类包，包含一些公共的与测试业务无关的逻辑，如：解析配置文件的方法，执行EXE文件的命令，执行shell脚本等操作。

ai.qa.autotest.ui.framework.utility.base包：接口类包，定义测试用例的基类、浏览器的接口类 。

ai.qa.autotest.ui.framework.webdriverfactory包：存放浏览器的配置和创建。

ai.qa.autotest.ui.pageobject包：测试过程中，为了方便维护测试对象和相应的测试动作，以每一个页面为一个java文件进行维护，每个页面需要测试的标签对象和对此页面标签的操作都在此Java文件中维护，测试其他页面需要重新创建被测页面的java文件。

ai.qa.autotest.ui.testbase包：包含测试用例运行前的公共初始化逻辑和测试用例结束后的一些公共逻辑，如：初始化浏览器类型，配置浏览器配置，生成驱动测试对象等。

ai.qa.autotest.ui.testcases包：测试用例包，包含具体的测试用例操作逻辑，再次保重编写具体 测试用例代码。

browserDriver：存放浏览器的驱动程序和一些可执行的文件。

config：存放测试全局配置文件，包括框架的配置和测试的配置。

config-log4j：存放log4j日志文件的配置。

config-testng：存放testNG组织运行测试用例的配置文件，主要是运行哪些用例，运行的方式，用例间的依赖关系，组合测试场景等。

Test-output：默认testNG的输出文件夹，内有testng的原生测试报告。

pom.xml文件：maven配置文件。




