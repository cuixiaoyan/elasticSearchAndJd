# elasticSearch7.6.2

## ElasticSearch概述

Elaticsearch，简称为es， es是一个开源的高扩展的分布式全文检索引擎，它可以近乎实时的存储、检 索数据;本身扩展性很好，可以扩展到上百台服务器，处理PB级别(大数据时代)的数据。es也使用 Java开发并使用Lucene作为其核心来实现所有索引和搜索的功能，但是它的目的是通过简单的RESTful API来隐藏Lucene的复杂性，从而让全文搜索变得简单。

据国际权威的数据库产品评测机构DB Engines的统计，在2016年1月，ElasticSearch已超过Solr等，成 为排名第一的搜索引擎类应用。

## 历史小故事

多年前，一个叫做Shay Banon的刚结婚不久的失业开发者，由于妻子要去伦敦学习厨师，他便跟着也去 了。在他找工作的过程中，为了给妻子构建一个食谱的搜索引擎，他开始构建一个早期版本的Lucene。

直接基于Lucene工作会比较困难，所以Shay开始抽象Lucene代码以便Java程序员可以在应用中添加搜 索功能。他发布了他的第一个开源项目，叫做“Compass”。

后来Shay找到一份工作，这份工作处在高性能和内存数据网格的分布式环境中，因此高性能的、实时 的、分布式的搜索引擎也是理所当然需要的。然后他决定重写Compass库使其成为一个独立的服务叫做 Elasticsearch。

第一个公开版本出现在2010年2月，在那之后Elasticsearch已经成为Github上最受欢迎的项目之一，代 码贡献者超过300人。一家主营Elasticsearch的公司就此成立，他们一边提供商业支持一边开发新功 能，不过Elasticsearch将永远开源且对所有人可用。

Shay的妻子依旧等待着她的食谱搜索......

现在我们就知道了 elasticsearch 重要性!

## Elasticsearch简介

Elasticsearch是一个实时分布式搜索和分析引擎。它让你以前所未有的速度处理大数据成为可能。 它用于**全文搜索**、**结构化搜索**、**分析**以及将这三者混合使用:

维基百科使用Elasticsearch提供全文搜索并高亮关键字，以及输入实时搜索(search-asyou-type)和搜索 纠错(did-you-mean)等搜索建议功能。

英国卫报使用Elasticsearch结合用户日志和社交网络数据提供给他们的编辑以实时的反馈，以便及时了 解公众对新发表的文章的回应。

StackOverflow结合全文搜索与地理位置查询，以及more-like-this功能来找到相关的问题和答案。 Github使用Elasticsearch检索1300亿行的代码。

但是Elasticsearch不仅用于大型企业，它还让像DataDog以及Klout这样的创业公司将最初的想法变成可 扩展的解决方案。

Elasticsearch可以在你的笔记本上运行，也可以在数以百计的服务器上处理PB级别的数据 。

Elasticsearch是一个基于Apache Lucene(TM)的开源搜索引擎。无论在开源还是专有领域，Lucene可以 被认为是迄今为止最先进、性能最好的、功能最全的搜索引擎库。

但是，Lucene只是一个库。想要使用它，你必须使用Java来作为开发语言并将其直接集成到你的应用 中，更糟糕的是，Lucene非常复杂，你需要深入了解检索的相关知识来理解它是如何工作的。

Elasticsearch也使用Java开发并使用Lucene作为其核心来实现所有索引和搜索的功能，但是它的目的是 通过简单的RESTful API来隐藏Lucene的复杂性，从而让全文搜索变得简单。

## Solr简介

Solr 是Apache下的一个顶级开源项目，采用Java开发，它是基于Lucene的全文搜索服务器。Solr提供了

比Lucene更为丰富的查询语言，同时实现了可配置、可扩展，并对索引、搜索性能进行了优化

Solr可以独立运行，运行在Jetty、Tomcat等这些Servlet容器中，Solr 索引的实现方法很简单，用 POST 方法向 Solr 服务器发送一个描述 Field 及其内容的 XML 文档，Solr根据xml文档添加、删除、更新索引 。Solr 搜索只需要发送 HTTP GET 请求，然后对 Solr 返回Xml、json等格式的查询结果进行解析，组织 页面布局。Solr不提供构建UI的功能，Solr提供了一个管理界面，通过管理界面可以查询Solr的配置和运 行情况。

solr是基于lucene开发企业级搜索服务器，实际上就是封装了lucene。

Solr是一个独立的企业级搜索应用服务器，它对外提供类似于Web-service的API接口。用户可以通过 http请求，向搜索引擎服务器提交一定格式的文件，生成索引;也可以通过提出查找请求，并得到返回 结果。

## Lucene简介

Lucene是apache软件基金会4 jakarta项目组的一个子项目，是一个开放源代码的全文检索引擎工具 包，但它不是一个完整的全文检索引擎，而是一个全文检索引擎的架构，提供了完整的查询引擎和索引 引擎，部分文本分析引擎(英文与德文两种西方语言)。Lucene的目的是为软件开发人员提供一个简单 易用的工具包，以方便的在目标系统中实现全文检索的功能，或者是以此为基础建立起完整的全文检索 引擎。Lucene是一套用于全文检索和搜寻的开源程式库，由Apache软件基金会支持和提供。Lucene提 供了一个简单却强大的应用程式接口，能够做全文索引和搜寻。在Java开发环境里Lucene是一个成熟的 免费开源工具。就其本身而言，Lucene是当前以及最近几年最受欢迎的免费Java信息检索程序库。人们 经常提到信息检索程序库，虽然与搜索引擎有关，但不应该将信息检索程序库与搜索引擎相混淆。

Lucene是一个全文检索引擎的架构。那什么是全文搜索引擎?

全文搜索引擎是名副其实的搜索引擎，国外具代表性的有Google、Fast/AllTheWeb、AltaVista、 Inktomi、Teoma、WiseNut等，国内著名的有百度(Baidu)。它们都是通过从互联网上提取的各个网 站的信息(以网页文字为主)而建立的数据库中，检索与用户查询条件匹配的相关记录，然后按一定的 排列顺序将结果返回给用户，因此他们是真正的搜索引擎。

从搜索结果来源的角度，全文搜索引擎又可细分为两种，一种是拥有自己的检索程序(Indexer)，俗称 “蜘蛛”(Spider)程序或“机器人”(Robot)程序，并自建网页数据库，搜索结果直接从自身的数据库中 调用，如上面提到的7家引擎;另一种则是租用其他引擎的数据库，并按自定的格式排列搜索结果，如 Lycos引擎。

## Elasticsearch和Solr比较

1、es基本是开箱即用(解压就可以用 ! )，非常简单。Solr安装略微复杂一丢丢!

2、Solr 利用 Zookeeper 进行分布式管理，而 Elasticsearch 自身带有分布式协调管理功能。

3、Solr 支持更多格式的数据，比如JSON、XML、CSV，而 Elasticsearch 仅支持json文件格式。

4、Solr 官方提供的功能更多，而 Elasticsearch 本身更注重于核心功能，高级功能多有第三方插件提 供，例如图形化界面需要kibana友好支撑~!

5、Solr 查询快，但更新索引时慢(即插入删除慢)，用于电商等查询多的应用; ES建立索引快(即查询慢)，即实时性查询快，用于facebook新浪等搜索。

Solr 是传统搜索应用的有力解决方案，但 Elasticsearch 更适用于新兴的实时搜索应用。 6、Solr比较成熟，有一个更大，更成熟的用户、开发和贡献者社区，而 Elasticsearch相对开发维护者

较少，更新太快，学习使用成本较高。(趋势!)

> 了解 ELK

ELK是Elasticsearch、Logstash、Kibana三大开源框架首字母大写简称。市面上也被成为Elastic Stack。其中Elasticsearch是一个基于Lucene、分布式、通过Restful方式进行交互的近实时搜索平台框 架。像类似百度、谷歌这种大数据全文搜索引擎的场景都可以使用Elasticsearch作为底层支持框架，可 见Elasticsearch提供的搜索能力确实强大,市面上很多时候我们简称Elasticsearch为es。Logstash是ELK 的中央数据流引擎，用于从不同目标(文件/数据存储/MQ)收集的不同格式数据，经过过滤后支持输出 到不同目的地(文件/MQ/redis/elasticsearch/kafka等)。Kibana可以将elasticsearch的数据通过友好 的页面展示出来，提供实时分析的功能。

市面上很多开发只要提到ELK能够一致说出它是一个日志分析架构技术栈总称，但实际上ELK不仅仅适用 于日志分析，它还可以支持其它任何数据分析和收集的场景，日志分析和收集只是更具有代表性。并非 唯一性。

![image-20200712093026256](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712093026256.png)

## 软件安装参考

[docker安装](https://gitee.com/cuixiaoyan/docker/blob/master/%E8%BD%AF%E4%BB%B6%E5%AE%89%E8%A3%85.md)

# 核心概念

1. 索引

2. 字段类型(mapping)

3. 文档(documents)

   >概述

集群，节点，索引，类型，文档，分片，映射是什么?

elasticsearch是面向文档，关系行数据库和elasticsearch客观的对比！一切都是json！

| Relational DB    | Elasticsearch |
| ---------------- | ------------- |
| 数据库(database) | 索引(indices) |
| 表(tables)       | types         |
| 行(rows)         | documents     |
| 字段(columns)    | fields        |

elasticsearch(集群)中可以包含多个索引(数据库)，每个索引中可以包含多个类型(表)，每个类型下又包 含多 个文档(行)，每个文档中又包含多个字段(列)。

**物理设计:**

elasticsearch 在后台把每个**索引划分成多个分片**，每分分片可以在集群中的不同服务器间迁移 一个人就是一个集群!默认的集群名称就是 elaticsearh

**逻辑设计:**

一个索引类型中，包含多个文档，比如说文档1，文档2。 当我们索引一篇文档时，可以通过这样的一各 顺序找到 它: 索引 ▷ 类型 ▷ 文档ID ，通过这个组合我们就能索引到某个具体的文档。 注意:ID不必是整 数，实际上它是个字 符串。

> 文档

就是我们的一条条数据

```bash
user
1   zhangsan    18
2   cuixiaoyan   3
```

之前说elasticsearch是面向文档的，那么就意味着索引和搜索数据的最小单位是文档，elasticsearch 中，文档有几个 重要属性 :

- 自我包含，一篇文档同时包含字段和对应的值，也就是同时包含 key:value! 
- 可以是层次型的，一个文档中包含自文档，复杂的逻辑实体就是这么来的! {就是一个json对象! fastjson进行自动转换!} 
- 灵活的结构，文档不依赖预先定义的模式，我们知道关系型数据库中，要提前定义字段才能使用， 在elasticsearch中，对于字段是非常灵活的，有时候，我们可以忽略该字段，或者动态的添加一个 新的字段。

尽管我们可以随意的新增或者忽略某个字段，但是，每个字段的类型非常重要，比如一个年龄字段类 型，可以是字符 串也可以是整形。因为elasticsearch会保存字段和类型之间的映射及其他的设置。这种 映射具体到每个映射的每种类型，这也是为什么在elasticsearch中，类型有时候也称为映射类型。

> 类型

![image-20200710174050208](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200710174050208.png)

类型是文档的逻辑容器，就像关系型数据库一样，表格是行的容器。 类型中对于字段的定义称为映射， 比如 name 映 射为字符串类型。 我们说文档是无模式的，它们不需要拥有映射中所定义的所有字段， 比如新增一个字段，那么elasticsearch是怎么做的呢?elasticsearch会自动的将新字段加入映射，但是这 个字段的不确定它是什么类型，elasticsearch就开始猜，如果这个值是18，那么elasticsearch会认为它 是整形。 但是elasticsearch也可能猜不对， 所以最安全的方式就是提前定义好所需要的映射，这点跟关 系型数据库殊途同归了，先定义好字段，然后再使用，别 整什么幺蛾子。

> 索引

就是数据库!

索引是映射类型的容器，elasticsearch中的索引是一个非常大的文档集合。索引存储了映射类型的字段 和其他设置。 然后它们被存储到了各个分片上了。 我们来研究下分片是如何工作的。

**物理设计 :节点和分片 如何工作**

![image-20200712093334287](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712093334287.png)

一个集群至少有一个节点，而一个节点就是一个elasricsearch进程，节点可以有多个索引默认的，如果 你创建索引，那么索引将会有个5个分片 ( primary shard ,又称主分片 ) 构成的，每一个主分片会有一个 副本 ( replica shard ,又称复制分片 )

![image-20200712093355792](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712093355792.png)

上图是一个有3个节点的集群，可以看到主分片和对应的复制分片都不会在同一个节点内，这样有利于某 个节点挂掉 了，数据也不至于丢失。 实际上，一个分片是一个Lucene索引，一个包含倒排索引的文件 目录，倒排索引的结构使 得elasticsearch在不扫描全部文档的情况下，就能告诉你哪些文档包含特定的 关键字。 不过，等等，倒排索引是什 么鬼?

> 倒排索引

elasticsearch使用的是一种称为倒排索引的结构，采用Lucene倒排索作为底层。这种结构适用于快速的 全文搜索， 一个索引由文档中所有不重复的列表构成，对于每一个词，都有一个包含它的文档列表。 例 如，现在有两个文档， 每个文档包含如下内容:

Study every day, good good up to forever # 文档1包含的内容

To forever, study every day, good good up # 文档2包含的内容

为了创建倒排索引，我们首先要将每个文档拆分成独立的词(或称为词条或者tokens)，然后创建一个包 含所有不重 复的词条的排序列表，然后列出每个词条出现在哪个文档 :

![image-20200712094112638](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712094112638.png)

现在，我们试图搜索 to forever，只需要查看包含每个词条的文档 score

![image-20200712094132561](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712094132561.png)

两个文档都匹配，但是第一个文档比第二个匹配程度更高。如果没有别的条件，现在，这两个包含关键 字的文档都将返回。

再来看一个示例，比如我们通过博客标签来搜索博客文章。那么倒排索引列表就是这样的一个结构 :

## 重中之重

![image-20200712094212233](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712094212233.png)

如果要搜索含有 python 标签的文章，那相对于查找所有原始数据而言，查找倒排索引后的数据将会快 的多。只需要 查看标签这一栏，然后获取相关的文章ID即可。完全过滤掉无关的所有数据，提高效率!

elasticsearch的索引和Lucene的索引对比

在elasticsearch中， 索引 (库)这个词被频繁使用，这就是术语的使用。 在elasticsearch中，索引被 分为多个分片，每份 分片是一个Lucene的索引。所以一个elasticsearch索引是由多个Lucene索引组成 的。别问为什么，谁让elasticsearch使用Lucene作为底层呢! 如无特指，说起索引都是指elasticsearch 的索引。

接下来的一切操作都在kibana中Dev Tools下的Console里完成。基础操作!

## Rest风格说明

一种软件架构风格，而不是标准，只是提供了一组设计原则和约束条件。它主要用于客户端和服务器交

互类的软件。基于这个风格设计的软件可以更简洁，更有层次，更易于实现缓存等机制。 基本Rest命令说明:

![image-20200712094410922](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712094410922.png)

# 关于索引的基本操作

**所有执行操作，都需要光标选中，然后运行**

### 创建一个索引!

```shell
# 格式如下
PUT /索引名/～类型名～/文档id
{请求体}
# 实际效果
PUT /user/type/1
{
  "name": "cuixiaoyan",
  "age": 18
}
```

![image-20200712094923824](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712094923824.png)

完成了自动增加了索引!数据也成功的添加了，大家在初期可以把它当做数据库学习的原因!

![image-20200712101412030](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712101412030.png)

3、那么 name 这个字段用不用指定类型呢。毕竟我们关系型数据库 是需要指定类型的啊 !

字符串类型
 text 、 keyword
 数值类型
 long, integer, short, byte, double, float, half_float, scaled_float 

日期类型
 date

**method url****地址 描述**

te布尔值类型 boolean 二进制类型 binary 等等......

### 指定字段的类型

```bash
PUT /test2
{
  "mappings": {
    "properties": {
      "name": {
        "type": "text"
      },
      "age": {
        "type": "text"
      },
      "birthday": {
        "type": "date"
      }
    }
  }
}
```

![image-20200712101810904](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712101810904.png)

获得这个规则! 可以通过 GET 请求获取具体的信息!

![image-20200712101915341](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712101915341.png)

### 查看默认的信息

```bash
PUT /test3/_doc/1
{
  "name": "cuixiaoyan",
  "age": 18,
  "birth": "2020-07-01"
}


GET /test3
```

![image-20200712102158249](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712102158249.png)

如果自己的文档字段没有指定，那么es 就会给我们默认配置字段类型!

扩展: 通过命令 elasticsearch 索引情况! 通过get _cat/ 可以获得es的当前的很多信息!

![image-20200712102356473](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712102356473.png)

# 关于文档的基本操作(重点)

## 增删改

#### 添加数据

```bash
PUT /userlist/user/1
{
  "name": "小崔",
  "age": 18,
  "desc": "爱写代码的程序员",
  "tags": [
    "健身",
    "做法",
    "直男"
  ]
}
```

![image-20200712105400015](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712105400015.png)

![image-20200712105429329](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712105429329.png)



> 修改 提交还是使用PUT 即可! 然后覆盖!最新办法!

#### 修改数据

```bash
PUT /test3/_doc/1
{
  "name":"崔笑颜",
  "age":18,
  "birth":"2020-01-01"
}
```

![image-20200712104226642](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712104226642.png)

现在的方法!

```bash
POST /test3/_doc/1/_update
{
  "doc": {
    "name": "我是cxy"
  }
}
```

![image-20200712104517225](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712104517225.png)

3、修改数据，推荐第二种方式。

![image-20200712105911947](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712105911947.png)

> 删除索引

#### 删除索引

通过DELETE 命令实现删除、 根据你的请求来判断是删除索引还是删除文档记录!

使用RESTFUL 风格是我们ES推荐大家使用的!

![image-20200712104926883](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712104926883.png)



## 简单搜索!

可以根据默认的映射规则，产生基本的查询!

```bash
GET /userlist/user/_search?q=name:老崔
```

![image-20200712110808969](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712110808969.png)

## 复杂搜索！

复杂操作搜索 select ( 排序，分页，高亮，模糊查询，精准查询!)

```bash
GET userlist/user/_search
{
  "query": {
    "match": {
      "name": "崔"
    }
  }
}
```

![image-20200712111319872](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712111319872.png)

**_source** 输出结果，等同于mysql : select name, age from user;

![image-20200712111540099](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712111540099.png)

> 排序

![image-20200712112035362](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712112035362.png)

> 分页查询

![image-20200712112345264](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200712112345264.png)

我们可以通过设置"from"和"size"参数来设置分页查询的相关信息。

### 布尔值查询

通过布尔值查询的方式我们可以实现类似于数据库的多条件查询：

![image-20200715161943487](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200715161943487.png)

例如通过这个must指令就可以实现多条件查询，在上图中，只有同时满足name中包含老崔，并且年龄为88的数据才会被查询出。简单的来说满足这两个条件就会返回true的布尔值然后被查询出来，所以被叫做布尔值查询，相当于sql语句中的where and条件语句。

![image-20200715162308324](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200715162308324.png)

而should命令则表示后方的两个条件只需要满足其中之一即可，就类似于sql语句中的where or条件语句。

![image-20200715162411744](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200715162411744.png)

同理，must_not表示查询出不满足条件的数据，例如上图查询出年龄不为18的信息，相当于sql中的not条件语句。

### 过滤查询操作

在满足多种条件查询的同时，es也支持我们对查询的数据进行进一步的筛选过滤。

![image-20200715162949063](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200715162949063.png)

通过上图的配置可以实现按照年龄大小进行进一步过滤的操作，gte是大于等于操作，lte是小于等于操作，gt只表示大于操作，lt只表示小于操作。

同时，也可以同时设置大于和小于来进行值的区间搜索操作，相当于sql中的between and条件。

![image-20200715163034131](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200715163034131.png)

### 匹配多个条件查询

匹配多个条件查询就有点类似于sql中的in关键字。

![image-20200715163439604](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200715163439604.png)

如图所示，tags是兴趣标签，在数据中是以数组的形式存在的，也就是说有多个值，通过这种方式就可以进行多个值的随意匹配。

### 精确匹配term

**term精确匹配和match的不同：**

term会将条件依据倒排索引进行精确匹配，而match则会将查询条件进行分词然后再匹配。简单的来说，match会产生类似与模糊查询的效果，而term不会，条件匹配不上即使数据包含查询条件也不会被查询出来。

**关于text和keyword类型：**

text类型和keyword的不同之处在于，text会被分词器进行分词，而keyword不会被分词器分词。

![image-20200715164003928](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200715164003928.png)

### 高亮查询

ElasticSearch同时也支持高亮查询，他会将查询结果中的查询条件关键字进行自动的高亮显示。

```bash

 
GET /userlist/user/_search
{
  "query": {
    "match": {
      "name": "老崔"
    }
  },
  "highlight": {
    "pre_tags": "<p class ='key' style = 'color=red'>",
    "post_tags": "</p>",
    "fields": {
      "name": {}
    }
  }
}
```

![image-20200715170827489](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200715170827489.png)

# SpringBoot集成ElasticSearch

此次SpringBoot集成ElasticSearch采用SpringBoot脚手架来进行学习。使用gradle来构建，顺便学习grade。

1. ElasticSearch版本要与你安装的版本一致。
2. 测试类的话，需要加上@SpringBootTest注解。

## 创建项目

### 方式一

![image-20200716135005558](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200716135005558.png)

![image-20200716135139461](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200716135139461.png)

### 方式二

创建一个新的maven项目，或者gradle项目。

![image-20200716135354952](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200716135354952.png)

> 引入jackson和lombok

```java
plugins {
    id 'java'
    id 'org.springframework.boot' version '2.3.1.RELEASE'
    id 'io.spring.dependency-management' version '1.0.9.RELEASE'
}

group 'com.cxy'
version '1.0-SNAPSHOT'

sourceCompatibility = 1.8

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-elasticsearch'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    //lombok
    implementation 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    //jackson
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.11.1'

    testImplementation('org.springframework.boot:spring-boot-starter-test') {
        exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
    }
}
```



#### 配置文件

```java
package com.cxy.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: elasticSearch
 * @description: 配置类
 * @author: cuixy
 * @create: 2020-07-15 17:50
 **/
@Configuration
public class ElasticSearchClientConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        //ES集群的相关信息，如果有多个就配置多个
                        new HttpHost("192.168.106.129", 9200, "http")
                )
        );
        return client;
    }


}
```

## 索引测试类

```java
package com.cxy.es;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @program: elasticSearch
 * @description: 索引测试类
 * @author: cuixy
 * @create: 2020-07-15 17:59
 **/
@SpringBootTest
public class esIndexTest {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    //测试索引的创建
    @Test
    public void createIndex() throws IOException {
        //创建索引请求
        CreateIndexRequest java_index = new CreateIndexRequest("cxy1_index");
        //客户端执行请求创建索引
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(java_index, RequestOptions.DEFAULT);
    }

    //判断索引是否存在
    @Test
    void existIndex() throws IOException {
        GetIndexRequest cxy1_index = new GetIndexRequest("cxy1_index");
        System.out.println(restHighLevelClient.indices().exists(cxy1_index, RequestOptions.DEFAULT));
    }

    //删除索引
    @Test
    void deleteIndex() throws IOException {
        DeleteIndexRequest java_index = new DeleteIndexRequest("cxy1_index");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(java_index, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }


}
```

## 文档测试类

```java
package com.cxy.es;

import com.cxy.es.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.directory.SearchResult;
import java.io.IOException;

/**
 * @program: elasticSearch
 * @description: es文档测试类
 * @author: cuixy
 * @create: 2020-07-16 14:27
 **/
@SpringBootTest
public class esDocumentTest {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    /**
     * 创建文档对象，使用jackson转换
     *
     * @throws IOException
     */
    @Test
    public void addDocument() throws IOException {
        //创建对象
        User user = new User();
        user.setName("崔笑颜1");
        user.setAge(18);
        //创建请求
        IndexRequest user_index = new IndexRequest("user_index");
        //文档编号
        user_index.id("2");
        //将对象转换成json放入请求中
        ObjectMapper objectMapper = new ObjectMapper();
        user_index.source(objectMapper.writeValueAsString(user), XContentType.JSON);
        //客户端发送请求，接收响应结果
        IndexResponse index = restHighLevelClient.index(user_index, RequestOptions.DEFAULT);
        //打印响应结果
        System.out.println(index.toString());  //查看返回的具体json信息
        System.out.println(index.status());  //查看操作的状态

    }

    /**
     * 判断文档是否存在
     */
    @Test
    public void existDocument() throws IOException {
        //获取索引中的id值是否存在
        GetRequest user_index = new GetRequest("user_index", "1");
        System.out.println(restHighLevelClient.exists(user_index, RequestOptions.DEFAULT));
    }

    /**
     * 获取文档内容
     *
     * @throws IOException
     */
    @Test
    public void getDocument() throws IOException {
        GetRequest user_iddex = new GetRequest("user_index", "1");
        GetResponse documentFields = restHighLevelClient.get(user_iddex, RequestOptions.DEFAULT);
        System.out.println(documentFields.getSource());
        System.out.println(documentFields);
    }

    /**
     * 修改文档。
     *
     * @throws IOException
     */
    @Test
    public void updateDocument() throws IOException {
        UpdateRequest user_index = new UpdateRequest("user_index", "2");
        User user = new User();
        user.setName("cuixiaoyan");
        user.setAge(18);
        ObjectMapper objectMapper = new ObjectMapper();
        user_index.doc(objectMapper.writeValueAsString(user), XContentType.JSON);
        UpdateResponse update = restHighLevelClient.update(user_index, RequestOptions.DEFAULT);
        System.out.println(update.status());
    }

    /**
     * 删除文档
     *
     * @throws IOException
     */
    @Test
    public void deleteDocument() throws IOException {
        DeleteRequest user_index = new DeleteRequest("user_index", "2");
        System.out.println(restHighLevelClient.delete(user_index, RequestOptions.DEFAULT).status());
    }

    /**
     * 查询文档信息
     * Hits对象中包含的是所有的查询结果信息，我们可以通过遍历想要的参数获得具体的信息。
     * 对于复杂查询的各种操作都可以在searchSourceBuilder对象的方法中找到对应的方法：
     *
     * @throws IOException
     */
    @Test
    public void search() throws IOException {
        SearchRequest user_index = new SearchRequest("user_index");
        //构造搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //使用工具类构造搜索信息
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "崔笑颜");
        searchSourceBuilder.query(matchQueryBuilder);
        //高亮
        searchSourceBuilder.highlighter();
        //分页
//        searchSourceBuilder.from();
        user_index.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(user_index, RequestOptions.DEFAULT);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(search.getHits()));
    }
  /**
     * 批量新增，批量删除也同理。
     *
     * @throws IOException
     */
    @Test
    public void bulkDocument() throws IOException {
        //创建批量操作对象
        BulkRequest bulkRequest = new BulkRequest();
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName("崔笑颜" + i);
            user.setAge(i);
            userList.add(user);
        }
        for (int j = 0; j < userList.size(); j++) {
            ObjectMapper objectMapper = new ObjectMapper();
            bulkRequest.add(new IndexRequest("user_index").id("" + j + 1).source(objectMapper.writeValueAsString(userList.get(j))
                    , XContentType.JSON));
        }

        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.hasFailures());


    }


}
```

![image-20200716151025878](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200716151025878.png)

新增成功

![image-20200716151043734](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200716151043734.png)

修改成功

![image-20200717222540822](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200717222540822.png)

查询成功

![image-20200717224623444](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200717224623444.png)

批量新增成功

![image-20200717230344783](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200717230344783.png)

# 模拟京东项目

