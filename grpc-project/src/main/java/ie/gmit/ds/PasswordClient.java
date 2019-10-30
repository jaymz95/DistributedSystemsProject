package ie.gmit.ds;

import java.lang.System.Logger.Level;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class PasswordClient {
	
	private static final Logger logger =
            Logger.getLogger(PasswordClient.class.getName());
    private final ManagedChannel channel;
    private final PasswordServiceGrpc.PasswordServiceStub asyncPasswordService;
    private final PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService;

    public PasswordClient(String host, int port) {
        channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();
        syncPasswordService = PasswordServiceGrpc.newBlockingStub(channel);
        asyncPasswordService = PasswordServiceGrpc.newStub(channel);
    }
    
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    
    public void addNewUser(userIds newUser) {
        logger.info("Adding new inventory item " + newUser);
        hashedPassword result;
        try {
            result = syncPasswordService.hashPassword(newUser);
        } catch (StatusRuntimeException ex) {
            //logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
            return;
        }
        if (result.getAllFields() != null) {
            logger.info("Successfully added item " + newUser);
        } else {
            logger.warning("Failed to add item");
        }
    }
    
    /*private void getUsers() {
        StreamObserver<userIds> responseObserver = new StreamObserver<userIds>() {
            @Override
            public void onNext(Items items) {
                logger.info("Received items: " + items);
            }

            @Override
            public void onError(Throwable throwable) {
                Status status = Status.fromThrowable(throwable);

                logger.log(Level.WARNING, "RPC Error: {0}", status);
            }

            @Override
            public void onCompleted() {
                logger.info("Finished receiving items");
                // End program
                System.exit(0);
            }
        };

        try {
            logger.info("Requesting all items ");
            asyncInventoryService.getItems(Empty.newBuilder().build(), responseObserver);
            logger.info("Returned from requesting all items ");
        } catch (
                StatusRuntimeException ex) {
            logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
            return;
        }
    }
    */
    public static void main(String[] args) throws Exception {
    	PasswordClient client = new PasswordClient("localhost", 50551);
        userIds newUser = userIds.newBuilder()
                .setUserId("1234")
                .setPassword("New Item")
                .build();
        try {
            client.addNewUser(newUser);
            //client.getUsers();
        } finally {
            // Don't stop process, keep alive to receive async response
            Thread.currentThread().join();
        }
    	Thread.currentThread().join();
    }
    

}
