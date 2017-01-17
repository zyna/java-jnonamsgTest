import nanomsg.pipeline.PullSocket;
import nanomsg.pipeline.PushSocket;

import java.nio.channels.Pipe;

public class PipelineClient {

    public static void main(String[] args) {

        PullSocket pullSocket = new PullSocket(1);
        pullSocket.connect("tcp://127.0.0.1:7897");
        pullSocket.setRecvTimeout(10000);
        while (true) {
            try {
                System.out.println(pullSocket.recvString());
            } catch (Exception e) {
                if ("Operation timed out".equalsIgnoreCase(e.getMessage())) {
                    pullSocket.setRecvTimeout(10000);
                }
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
}
