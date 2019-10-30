package ie.gmit.ds;


import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;

import ie.gmit.ds.PasswordServiceGrpc.PasswordServiceImplBase;
import io.grpc.stub.StreamObserver;

public class PasswordServiceImpl extends PasswordServiceImplBase {
	
	private ArrayList<userIds> usersList;
    private static final Logger logger =
            Logger.getLogger(PasswordServiceImpl.class.getName());

    public PasswordServiceImpl() {
        usersList = new ArrayList<>();
        //createDummyItems();
    }

    @Override
    public void hashPassword(userIds user,
    		io.grpc.stub.StreamObserver<ie.gmit.ds.hashedPassword> responseObserver) {
    	
    
        usersList.add(user);
        logger.info("Added new user: " + user);
        
        usersList.add(userIds.newBuilder()
                .setUserId("001")
                .setPassword("Acoolitem")
                .build());
        
        Passwords p = null;
    	byte[] salt  = p.getNextSalt();
    	
    	byte[] hashh = p.hash(user.getPassword().toCharArray(), salt);

        logger.info("Salt: " + salt);
        logger.info("Hash: " + hashh);
        
        hashedPassword.Builder users = hashedPassword.newBuilder();
        //users.addItems(u);
        users.setUserId("001")
        		.setHashedPassword(hashh.toString())
        		.setSalt(salt.toString());

        responseObserver.onNext(users.build());
        responseObserver.onCompleted();
       
    }
    
    @Override
    public void validatePasswords(ie.gmit.ds.checkPassword request,
    		io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
    	String userId, password, hash, salt;
    	Passwords p = null;
    	boolean pass;
    	userIds u;
    	
    	userId = request.getUserId();
    	password = request.getPassword();
    	hash = request.getHash();
    	salt = request.getSalt();
    	
    	 u = usersList.get(0);
    	
    	pass = p.isExpectedPassword(u.getPassword().toCharArray(), salt.getBytes(), hash.getBytes());
    	
        logger.info("Password match?????: " + pass);
        
        if ( pass == true ) {
            responseObserver.onNext(BoolValue.newBuilder().setValue(true).build());
        } 
        else if ( pass == false ) {
            responseObserver.onNext(BoolValue.newBuilder().setValue(false).build());
        }
        responseObserver.onCompleted();
       
    }
    
    /*public void hashPassword(ie.gmit.ds.userId request,
            io.grpc.stub.StreamObserver<ie.gmit.ds.hashedPassword> responseObserver) {
          asyncUnimplementedUnaryCall(getHashPasswordMethod(), responseObserver);
        }*/

    /*@Override
    public void getItems(Empty request,
                         StreamObserver<userId> responseObserver) {
        userId.Builder u = Items.newBuilder();
        for (userId u1 : usersList) {
            userId.addItems(u1);
        }
        responseObserver.onNext(u.build());
        responseObserver.onCompleted();
    }*/

}
