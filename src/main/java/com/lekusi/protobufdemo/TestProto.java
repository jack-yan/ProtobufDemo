package com.lekusi.protobufdemo;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Protobuf 测试类
 * 使用步骤：
 * 1、下载protoc-3.3.0-win32
 * 2、编写*.proto文件
 * 3、使用bin下的protoc.exe生成所需语言的实体类
 *    cmd：protoc --java_out=[文件路径] [文件名]
 * 4、将生成的实体类拷贝至项目中
 * 5、添加protobuf-java-***.jar依赖包
 * 6、使用如下代码进行读写测试
 * <p>
 * Created by Jack.Yan on 2017/8/8.
 */
public class TestProto {
    public static void main(String[] args) {
//        writeFile("F:/", "Company.dat", createComay());//将对象数据写入文件
        System.out.println(readFile("F:/","Company.dat"));//从文件读数据至对象
    }

    /**
     * 将对象数据写入文件
     * @param filePath 文件路径
     * @param fileName 文件名
     * @param bean 实体类
     */
    private static void writeFile(String filePath,String fileName,GeneratedMessageV3 bean){
        File file=new File(filePath,fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bean.writeTo(fos);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e1){
            e1.getMessage();
        }
    }

    /**
     * 从文件读数据至对象
     * @param filePath 文件路径
     * @param fileName 文件名
     * @return 实体类
     */
    private static CompanyProto.Compay readFile(String filePath, String fileName){
        File file=new File(filePath,fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            return CompanyProto.Compay.parseFrom(fis);
           /* int size=fis.available();
            byte[] buffer=new byte[size];
            fis.read(buffer);
            return readBytes(buffer);*/
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e1){
            e1.getMessage();
        }
        return null;
    }

    /**
     * 从byte数组读数据至对象
     * @param data byte数组
     * @return 实体类
     */
    private static CompanyProto.Compay readBytes(byte[] data){
        try {
            return CompanyProto.Compay.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 创建实例化对象
     * @return 实体类
     */
    private static CompanyProto.Compay createComay(){
        return CompanyProto.Compay.newBuilder()
                .setId(1)
                .setName("Global Company")
                .setAddress("any where")
                .addContact("66666660")
                .addContact("66666661")
                .setWebsite("www.google.com")
                .setType(CompanyProto.Compay.TYPE.PRIVATE)
                .addStaffs(CompanyProto.Staff.newBuilder().setId(10001).setUserName("Peter Jeff").setSex(CompanyProto.Staff.SEX.MALE).setAge(28).setDepartment("Dev").setJob("Java").addPhoneNums("05812345678").build())
                .addStaffs(CompanyProto.Staff.newBuilder().setId(10001).setUserName("Jack Allen").setSex(CompanyProto.Staff.SEX.FEMALE).setAge(32).setDepartment("HR").setJob("manager").addPhoneNums("05899999999").addPhoneNums("05899999900").build())
                .build();
    }

}
