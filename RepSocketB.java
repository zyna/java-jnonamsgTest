import nanomsg.reqrep.RepSocket;

/**
 * Created by BIan on 17/1/11.
 */
public class RepSocketB {

    public static void main(String[] args) {
        RepSocket repSocket = new RepSocket(1);
        repSocket.bind("tcp://127.0.0.1:7898");
        repSocket.setSendTimeout(10000);
        repSocket.setRecvTimeout(10000);
        while (true){
            System.out.println(repSocket.recvString());
            repSocket.send("this is repB send!");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
