import nanomsg.pubsub.SubSocket;

/**
 * Created by BIan on 17/1/10.
 */
public class Subscriber {

    public static void main(String[] args) {
        SubSocket sock = new SubSocket();
        sock.connect("ipc:///Users/BIan/sock");
        sock.subscribe("test");

        for(int i=0; i<5; i++) {
            System.out.println(sock.recvString());
        }

        sock.close();
    }
}
