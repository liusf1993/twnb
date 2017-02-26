#mybatis 动态判断

mybatis动态sql
参数 type ：1或-1
动态sql <if test="type.equals('1')"> 发现判断为false；
改成 <if test="type==1"> 后结果为true

但如果 type 的值为good或ok时
动态sql<if test="type.equals('good')"> 判断正常
用<if test="type=='good'">判断也是正常的

再次试验 
发现动态sql<if test="type.equals('a')">也是有问题

跟踪代码发现

'a' '1' 单引号内只有一个字符串，默认是当char处理的，
而多个字符如'abc'是当字符串处理的，类型不一致，从而导致
判断失败。

解决方案：

1、外部用单引号，内部用双引号 
test='type.equals("1")'

2、改用等于号
        
test=‘type==‘1‘’

改为等于号是最为保险的

另equals方法最好确定的字符串放前面
如"1".equals("type") 以确保不会出现空指针异常，
用 test='type!=null and type.equals("1")'
则比较麻烦