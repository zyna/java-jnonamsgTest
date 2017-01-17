import nanomsg.reqrep.RepSocket;

/**
 * Created by BIan on 17/1/10.
 */
public class Server {
    public static void main(String[] args) {
        final RepSocket s = new RepSocket();
        s.bind("tcp:///Users/BIan/sock");
    }
}
