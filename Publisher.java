import nanomsg.pubsub.PubSocket;

/**
 * Created by BIan on 17/1/10.
 */
public class Publisher {

    public static void main(String[] args) {
        PubSocket sock = new PubSocket();
        sock.bind("ipc:///Users/BIan/sock");

        for(int i=0; i<5; i++) {
            sock.send("test msg");
        }

        sock.close();
    }
}
