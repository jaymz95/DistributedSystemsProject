package ie.gmit.ds;

import java.util.ArrayList;
import java.util.Scanner;
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
    	
    	//hashPassword(userIds user,
    	//	io.grpc.stub.StreamObserver<ie.gmit.ds.hashedPassword> responseObserver);
    	
        logger.info("Adding new inventory item " + newUser);
        hashedPassword result;
        try {
            result = syncPasswordService.hashPassword(newUser);
            logger.info("HASH HASH HASH " + result);
            
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
    
    private void valid(userIds userPassword) {
    	
        hashedPassword result;
        checkPassword check = null;
        BoolValue ans;
        PasswordServiceImpl p = null;
        
        try {
            result = syncPasswordService.hashPassword(userPassword);
            logger.info("HASH HASH HASH " + result);
            
        } catch (StatusRuntimeException ex) {
            //logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
            return;
        }
        if (result.getAllFields() != null) {
            logger.info("Successfully added item " + userPassword);
        } else {
            logger.warning("Failed to add item");
        }
        check.newBuilder().setPassword(userPassword.getPassword())
        		.setHash(result.getHashedPassword())
        		.setSalt(result.getSalt());
        
        /*for (int i = -1 ; i < PasswordServiceImpl.usersHashList.size(); i++) {

        	boolean pass = false;
   		 	//pass = p.isExpectedPassword(u.getPassword().toCharArray(), PasswordServiceImpl.usersHashList.get(i).getSalt().getBytes(), PasswordServiceImpl.usersHashList.get(i).getHashedPassword().getBytes());
   		 	
        	check. = PasswordServiceImpl.usersHashList.get(i).getHashedPassword();
        	check = PasswordServiceImpl.usersHashList.get(i).getSalt();
        	
        	if (pass == true) {
   		 		i = PasswordServiceImpl.usersHashList.size() + 5;
   		        logger.info("LOOPY LOOPY LOOOO" + PasswordServiceImpl.usersHashList.get(i).getUserId());
   			 
   		 }
   	 }*/
        
        
        ans = syncPasswordService.validatePasswords(check);
        logger.info("please werq" + ans);
		
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
        userIds newUser;
    	Scanner myObj = new Scanner(System.in);
        
     
    	String quit = null;
    	
    	//while (quit != "q" || quit != "Q") {
    	for(int i = 0; i < 100 ; i++) {
    		System.out.println("Menu: ");
        	System.out.println("	1) Create Account: ");
        	System.out.println("	2) Sign in:");

        	int option = myObj.nextInt();
        	
        	if(option == 1) {
        		System.out.println("Enter User Id:");
            	int uId = myObj.nextInt();

            	System.out.println("Enter Password:");
            	String p = myObj.nextLine();;
            	p = myObj.nextLine();
            	
            	if (p != null) {
            		newUser = userIds.newBuilder()
                			.setUserId(uId)
                			.setPassword(p)
                            .build();
                	try {
                        client.addNewUser(newUser);
                        //client.getUsers();
                    } finally {
                        // Don't stop process, keep alive to receive async response
                        //Thread.currentThread().join();
                    }
            	}
            	
        	}
        	else if ( option == 2 ) {
        		System.out.println("Enter User Id:");
            	int uId = myObj.nextInt();

            	System.out.println("Enter Password:");
            	String p = myObj.nextLine();;
            	p = myObj.nextLine();
            	
            	if (p != null) {
            		newUser = userIds.newBuilder()
                			.setUserId(uId)
                			.setPassword(p)
                            .build();
                	try {
                        client.valid(newUser);
                        //client.getUsers();
                    } finally {
                        // Don't stop process, keep alive to receive async response
                        //Thread.currentThread().join();
                    }
            	}
        	}
        	else if ( quit == "q" ) {
        		//break;
        	}

    	}
    	
    	
    	
    	System.out.println();
    	
    	//Thread.currentThread().join();
    }
    

}
