####  关于Form，你要了解的内容
首先，明确下<form>标签的属性。最重要的有三个属性：method、enctype、action。

关于method，通常取值为GET、POST。默认GET
关于action，为表单提交到的服务器地址
关于enctype，通常取值为：application/x-www-form-urlencoded、multipart/form-data、text/plain。默认application/x-www-form-urlencoded
#### application/x-www-form-urlencoded
当我们的表单中只包含文本数据，并且采用默认形式的enctype的时候，采用GET、POST的差别仅在于请求内容的存放位置。而请求内容均为根据form中所有表单控件的name值与value构成的key1=value1&key2=value2这样的形式。

当采用GET提交的方式。GET请求会附加在URL中。POST请求则附加在请求体中。

如果是中文内容的请求，还需注意编码问题。在Tomcat7中URL会默认编码为ISO8859-1，而在Tomcat8中则默认为UTF-8，这也是曾经踩过的一个坑。

前台Html代码：

<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
    </head>
    <body>
        <%-- 如果不写enctype，则默认enctype=application/x-www-form-urlencoded --%>
        <form method="post" action="/form/submit1">
            <input name="username1" value="" type="text">
            <input name="username2" value="" type="text">
            <input type="submit" value="submit">
        </form>
    </body>
</html>
后台接收代码：

@RequestMapping(value = "/submit1", method = RequestMethod.POST)
@ResponseBody
public String submit1_Get(User user) {
    System.out.println(user.getUsername1());
    System.out.println(user.getUsername2());
    return "ok";
}
关于后台的接收，我们可以采用@RequstParam接收，或者直接用Java Pojo接收，更复杂的接收情况，可以参考这篇博文： [Spring MVC] - SpringMVC的各种参数绑定方式

#### multipart/form-data
当我们需要上传文件的时候，必须使用这个属性。

POST http://www.example.com HTTP/1.1
Content-Type:multipart/form-data; boundary=----WebKitFormBoundaryrGKCBY7qhFd3TrwA
 
------WebKitFormBoundaryrGKCBY7qhFd3TrwA
Content-Disposition: form-data; name="text"
 
title
------WebKitFormBoundaryrGKCBY7qhFd3TrwA
Content-Disposition: form-data; name="file"; filename="chrome.png"
Content-Type: image/png
 
PNG ... content of chrome.png ...
------WebKitFormBoundaryrGKCBY7qhFd3TrwA--
上述代码为一个请求的例子。首先生成了一个 boundary 用于分割不同的字段，为了避免与正文内容重复，boundary 很长很复杂。然后 Content-Type 里指明了数据是以 mutipart/form-data 来编码，本次请求的 boundary 是什么内容。消息主体里按照字段个数又分为多个结构类似的部分，每部分都是以 –boundary 开始，紧接着内容描述信息，然后是回车，最后是字段具体内容（文本或二进制）。如果传输的是文件，还要包含文件名和文件类型信息。消息主体最后以 –boundary– 标示结束。关于 mutipart/form-data 的详细定义，请前往 rfc1867 查看。

由于涉及到文件上传操作，所以我们采用POST提交的方式。 前台代码：

<html lang="zh-CN">
<head>
    <meta charset="utf-8">
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="/form/submit2">
	    <input name="username1" value="" type="text">
	    <input name="username2" value="" type="text">
	    <input type="file" name="image">
	    <input type="submit" value="submit">
	</form>
</body>
</html>
后台代码：

@RequestMapping(value = "/submit2", method = RequestMethod.POST)
@ResponseBody
public String submit2(User user, @RequestParam("image") MultipartFile file) {
	System.out.println(user.getUsername1());
    System.out.println(user.getUsername2());
    System.out.println(file.getSize());
    return "ok";
}
当我们使用SpringMVC提供的MultipartFile时，需要在配置文件中对文件上传的要求进行配置

<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="maxUploadSize" value="104857600"/>
        <property name="maxInMemorySize" value="4096"/>
</bean>
或者我们可以使用最原始的方法，获取HttpServletRequest进行操作，将request转为MultipartHttpServletRequest：

MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
multipartRequest.getParameter("image");
更复杂的情况是：关于前台上传的数据不是简单的表单控件的value值，可能需要拼接、转换操作，这时我们可以使用HTML5中的FormData解决，具体用法，大家可自行Google解决

#### application/json
由于ajax 的大行其道，越来越多的请求带有该形式，表示向服务器发送一个Json，例如：

POST http://www.example.com HTTP/1.1
Content-Type: application/json;charset=utf-8
 
{"title":"test","sub":[1,2,3]
前台代码：

<html lang="zh-CN">
<head>
    <meta charset="utf-8">
</head>
<body>
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script>
    data = {};
    data["username1"] = "haha";
    data["username2"] = "hahafdf";
    $.ajax({
        "url": "/form/submit3",
        "type": "POST",
        "data": JSON.stringify(data),
        "dataType":"json",
        "contentType":"application/json;charset=UTF-8",
        "success": function () {
            alert("success");
        },
        "error": function () {
            alert("error");
        }
    });
</script>
</body>
</html>
需要注意的地方是，需要写上contentType，以及Json对象必须转为字符串格式 后台代码：

@RequestMapping(value = "/submit3", method = RequestMethod.POST)
@ResponseBody
public String submit3(@RequestBody User user) {
    System.out.println(user.getUsername1());
    System.out.println(user.getUsername2());
    return "{}";
}
SpringMVC中接收一个Json采用RequestBody，不能是RequestParam这一点非常重要，也就是说这两个注解不能同时存在。