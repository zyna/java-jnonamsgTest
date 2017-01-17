import nanomsg.reqrep.ReqSocket;

/**
 * Created by BIan on 17/1/11.
 */
public class ReqSocketA {
    public static void main(String[] args) {
        ReqSocket reqSocket = new ReqSocket(1);
        reqSocket.connect("tcp://127.0.0.1:7898");
        reqSocket.setSendTimeout(10000);
        reqSocket.setRecvTimeout(10000);
        while (true){

            reqSocket.send("this is ReqA send!");
            System.out.println(reqSocket.recvString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
