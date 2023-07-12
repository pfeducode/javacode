package helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TestMassage {
    @Test
    public void testSendMessage() throws IOException, TimeoutException{
       //创建工厂对象
        ConnectionFactory connectionFactory=new ConnectionFactory();
        //设置连接过期时间
        connectionFactory.setConnectionTimeout(99999999);
        //设置连接
        connectionFactory.setHost("192.168.32.128");
        //设置端口
        connectionFactory.setPort(5672);
        //设置虚拟主机
        connectionFactory.setVirtualHost("/ems");
        //设置用户名和密码
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");

        //获取连接对象
        Connection connection=connectionFactory.newConnection();

        //获取连接中通道
        Channel channel=connection.createChannel();
        channel.queueDeclare("hello",false,false,false,null);

        //发布消息
        channel.basicPublish("","hello",null,"hello rabbitmq".getBytes());


    }
}
