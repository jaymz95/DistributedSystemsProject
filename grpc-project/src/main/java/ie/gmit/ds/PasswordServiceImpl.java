package ie.gmit.ds;


import java.util.ArrayList;
import java.util.logging.Logger;

import com.google.protobuf.BoolValue;

import ie.gmit.ds.PasswordServiceGrpc.PasswordServiceImplBase;

public class PasswordServiceImpl extends PasswordServiceImplBase {
	
	private ArrayList<userIds> usersList;
	private ArrayList<hashedPassword.Builder> usersHashList;
    private static final Logger logger =
            Logger.getLogger(PasswordServiceImpl.class.getName());

    public PasswordServiceImpl() {
        usersList = new ArrayList<>();
        usersHashList = new ArrayList<>();
        //createDummyItems();
    }

    @Override
    public void hashPassword(userIds user,
    		io.grpc.stub.StreamObserver<ie.gmit.ds.hashedPassword> responseObserver) {
    
        usersList.add(user);
        logger.info("Added new user(PasswordServiceImpl: " + user);
        
        /*usersList.add(userIds.newBuilder()
                .setUserId(001)
                .setPassword("Acoolitem")
                .build());*/
        
        Passwords p = null;
    	byte[] salt  = p.getNextSalt();
    	
    	byte[] hashh = p.hash(user.getPassword().toCharArray(), salt);

        logger.info("Salt: " + salt);
        logger.info("Hash: " + hashh);
        
        hashedPassword.Builder users = hashedPassword.newBuilder()
        		.setUserId(user.getUserId())
        		.setHashedPassword(hashh.toString())
        		.setSalt(salt.toString());
        
        usersHashList.add(users);

        responseObserver.onNext(users.build());
        responseObserver.onCompleted();
       
    }
    
    
    @Override
    public void validatePasswords(ie.gmit.ds.checkPassword request,
    		io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
    	String hash, salt;
    	//String password;
    	//int userId;
    	Passwords p = null;
    	boolean pass;
    	userIds u;
    	
    	//userId = request.getUserId();
    	//password = request.getPassword();
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
