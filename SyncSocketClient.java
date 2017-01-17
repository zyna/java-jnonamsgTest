import nanomsg.async.AsyncSocket;
import nanomsg.async.IAsyncCallback;
import nanomsg.pipeline.PullSocket;

/**
 * Created by BIan on 17/1/11.
 */
public class SyncSocketClient {

    public static void main(String[] args) {
        final PullSocket pullSocket = new PullSocket();
        final AsyncSocket asyncSocket = new AsyncSocket(pullSocket);
        pullSocket.connect("tcp://127.0.0.1:7897");
        while (true) {
            asyncSocket.recvString(new IAsyncCallback<String>() {
                @Override
                public void success(String result) {
                    System.out.println(result);
                }

                @Override
                public void fail(Throwable t) {
                    System.out.println(t.getMessage());
                }
            });
        }
    }
}
