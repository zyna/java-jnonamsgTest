import nanomsg.pubsub.PubSocket;

/**
 * 发布个人模拟账号相关信息
 * Created by BIan on 17/1/10.
 */
public class PublisherAcctB {

    public void publisherMsg(String msg){
        PubSocket pubSocket = new PubSocket();
        pubSocket.bind("ipc:///tmp/sock");
        pubSocket.send("test nonamsg");
        pubSocket.close();
    }

    public static void main(String[] args) {

    PubSocket pubSocket = new PubSocket(1);
    pubSocket.bind("tcp://127.0.0.1:7996");

while (true){
    byte[] bytes = new byte[]{'1'};
    int retunnum = pubSocket.send("testB");
    System.out.println(retunnum);
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

    }

}
