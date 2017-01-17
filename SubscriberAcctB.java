import nanomsg.pubsub.SubSocket;

/**
 * Created by BIan on 17/1/10.
 */
public class SubscriberAcctB {

    public static void main(String[] args) {
      SubSocket subSocket = new SubSocket(1);
      subSocket.setRecvTimeout(10000);
      byte[] bytes = new byte[]{'1'};
      subSocket.subscribe("test1");
      subSocket.connect("tcp://127.0.0.1:7896");
      while (true){
          String byteBuffer = subSocket.recvString();
          System.out.println(byteBuffer);
          //subSocket.getSndFd();
          subSocket.getRcvFd();
          System.out.println("============="+subSocket.getRcvFd());
      }
    }
}
