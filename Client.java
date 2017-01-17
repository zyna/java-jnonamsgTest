import nanomsg.reqrep.ReqSocket;

/**
 * Created by BIan on 17/1/10.
 */
public class Client {
    public static void main(String[] args) {
        final ReqSocket s = new ReqSocket();
        s.connect("tcp://127.0.0.1:7897");
    }
}
