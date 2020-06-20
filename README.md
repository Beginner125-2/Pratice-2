Test1 :  取出一个字符串中字母出现的次数。如：字符串：”abcdekka27qoq”，输出各个字符的次数

Test2 :  假如我们在开发一个系统时需要对员工进行建模，【员工】包含3个属性【经理】也是员工，除了含有员工的属性外，另为还有一个奖金属性 请使用继承的思想设计出员工类和经理类。要求类中提供必要的方法进行属性访问

Test3 :  定义一个的ArrayList中存放一个String类型的对象，一个Inegter类型对象

Test4 :  有五个学生，每个学生有3门课（语文、数学、英语）的成绩，写一个程序接收从键盘输入学生的信息， 输入格式为：name,30,30,30（姓名，三门课成绩）， 把输入的学生信息按总分从高到低的顺序写入到一个名称”stu.txt”文件中。 要求：stu.txt文件的格式要比较直观，打开这个文件，就可以很清楚的看到学生的信息。

Test5 :  定义一个文件输入流，调用read(byte[]b)方法将文件中的所有内容打印出来(byte数组的大小限制为5)

Test6 :  自定义字符输入流的包装类，通过这个包装类对底层字符输入流进行包装， 让程序通过这个包装类读取某个文本文件（例如，一个java源文件）时，能够在读取的每行前面都加上有行号和冒号

Test7 :  将一个字符串反转

Test8 :  定义一个交通灯枚举，包含红灯、绿灯、黄灯，需要有获得下一个灯的方法，例如：红灯获取下一个灯是绿灯，绿灯获取下一个灯是黄灯

Test9 :  编写一个类，增加一个实例方法用于打印一条字符串。并使用反射手段创建该类的对象，并调用该对象中的方法

Test10 :  把当前文件中的所有文本拷贝，存入一个txt文件，统计每个字符出现的次数并输出

Test11 :  编写程序，循环接收用户从键盘输入多个字符串，直到输入“end”时循环结束，并将所有已输入的字符串按字典顺序倒序打印

Test12 :  写一个Properties格式的配置文件，配置类的完整名称。写一个程序， 读取这个Properties配置文件，获得类的完整名称并加载这个类，用反射的方式运行run方法

Test13 :  单例模式获取设置配置信息

Test14 :  编写一个程序，获取10个1至20的随机数，要求随机数不能重复

Test15 :  声明一个共享数组，起两个线程，两个线程分别隔一段时间(可以写一个随机数)，给数组中添加数据，每一个线程为数组添加3个数据即可

Test16 :  代码实现c盘某个文件夹复制到D盘中，加上代码，加上注释，加上思路

Test17 :  写一个ArrayList类的代理，实现和ArrayList类中完全相同的功能，并可以计算每个方法运行的时间

Test18 :  编写一个程序，它先将键盘上输入的一个字符串转换成十进制整数，然后打印出这个十进制整数对应的二进制形式。 这个程序要考虑输入的字符串不能转换成一个十进制整数的情况，并对转换失败的原因要区分出是数字太大，还是其中包含有非数字字符的情况。

Test19 :  已知一个int数组，用冒泡排序法对数组中元素进行升序排列（简单题也不放过）

Test20 :  自定义枚举week表示星期几，要求每个枚举值都有tolocaleString方法。返回中文格式的星期几。

Test21 :  用TCP协议写一个客户端和一个服务端，实现上传文件

Test22 :  编写一个可以获取文件扩展名的函数，形参接收一个文件名字符串，返回一个扩展名字符串

Test23 :  用代码证明，在try中写了return，后面又写了finally，是先执行return还是先执行fianlly

Test24 :  编写函数，从一个字符串中按字节数截取一部分，但不能截取出半个中文（GB码表）

Test25 :  使用javaMail写一个程序，可以发送一封邮件给一个账号，要求可以自定义邮件内容

Test26 :  使用SAX解析一个XML文件，根据XML的文件创建对象

Test27 :  JAVA SAX解析器-解析XML文档

Test28 :  使用jdbc进行查询

Test29 :  写一个GUI程序，程序能够打开图片文件并显示。

Test30 :  写一个爬虫程序，爬取https://sports.163.com/nba/的新闻消息，并且放在文件里，每个文件大小为20条消息。

Test31 :  写一个使用log4j的示例程序

Test32 :  单独使用mybatis增删查改

Test33 :  用套接字获取http协议下发送的数据，并打印在控制台上。

Test34 :  使用redis进行缓冲，每二十秒进行一次与数据库的同步

Test35 :  根据数据库生成bean文件

Test36 : 

Test37 :  写一个类，使用状态模式，该类每次调用一个方法后会改变状态，之后该方法的调用效果会改变。

Test38 :  使用jdk建立观察者模式

Test39 :  写一个细胞自动机，使用MVC模式

Test40 :  写一个画CRC卡的框架，使用MVVC模式, 使用redis做数据持久化

Test41 :  使用系统的ping功能，使用多线程遍历指定范围的ip地址，将能够ping通的地址保存下来

Test42 :  使用线程池写一个生产者与消费者的问题

Test43 :  写一个可以用dos命令行批量重命名的工具

Test44 :  获取剪切板中的内容

Test45 :  爬取煎蛋网上的树洞信息并存在数据库中

Test46 :  使用java控制鼠标移动到谷歌浏览器bing的输入框中，输入查询的内容并回车，然后截图保存。

Test47 :  使用代码将本project下所有Test类的类名和Describe保存到README（便于github上查看）和Test47下的package-info（便于javadoc查看）中.*");.*");

Test48 :  使用Robot写一个完整的程序，该程序的作用是用命令行控制鼠标键盘

Test49 :  在五秒之后，使用编译器编译资源文件夹里面的Run.java并用类装载机装载，并运行其中的run()函数

Test50 :  Java中模拟购物网站的购物车

Test51 :  将字符串以倒Z字形输出

Test52 :  写一个有限状态机，该状态机能够接受像 a+b=c a-b<c a*b>c 这样的数学等式

Test53 :  写来自用，学英语的

Test54 :  写一个保存生词的程序，将复制的单词自动保存到txt文件当中。

Test55 :  写一个程序，可以根据一定格式的数据创建有限状态机，同时可以用图形界面画状态机生成格式数据。

Test56 :  随机组合日语平假名输出，学日语用

Test57 :  装载XML，根据该XML文件（该文件中包含数据库表的信息），创建建立mysql数据库表的语句

