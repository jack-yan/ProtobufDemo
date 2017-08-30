# ProtobufDemo
protobuf java demo

步骤：
1、下载protoc-3.3.0-win32

2、编写*.proto文件

3、使用bin下的protoc.exe生成所需语言的实体类
cmd：protoc --java_out=[文件路径] [文件名]

4、将生成的实体类拷贝至项目中

5、添加protobuf-java-***.jar依赖包

6、使用如下代码进行读写测试

 more installation instructions: https://github.com/google/protobuf
