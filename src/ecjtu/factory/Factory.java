package ecjtu.factory;
import ecjtu.dao.IGetName;

import java.io.IOException;
import java.util.Properties;

/**
 * 工具类使用单例
 * 通过工厂设计模式生成接口实现类的对象
 *
 */
public class Factory {
    private static Factory instance=new Factory();
    static Properties pro=new Properties();
    static{
        try {
            //相对路径Factory.class.getResourceAsStream（）获取的classpath==工程的bin
            //使用绝对路径在文件/conf.properties
            //使用类的加载器Factory.class.getClassLoader().getResourceAsStream("conf.properties")
            pro.load(Factory.class.getClassLoader().getResourceAsStream("conf.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private Factory()
    {

    }
    public static Factory getInstance(){
        return  instance;
    }

    //生成接口的对象
    public IGetName getName(){
        IGetName instance=null;
        //获取配置的信息
        String value=pro.getProperty("cls");
        try {
            Class cls=Class.forName(value);
            instance=(IGetName)cls.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return  instance;
    }


}
