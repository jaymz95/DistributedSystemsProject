package ie.gmit.ds;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: password.proto")
public final class PasswordServiceGrpc {

  private PasswordServiceGrpc() {}

  public static final String SERVICE_NAME = "ie.gmit.ds.PasswordService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ie.gmit.ds.userIds,
      ie.gmit.ds.hashedPassword> getHashPasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "hashPassword",
      requestType = ie.gmit.ds.userIds.class,
      responseType = ie.gmit.ds.hashedPassword.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.ds.userIds,
      ie.gmit.ds.hashedPassword> getHashPasswordMethod() {
    io.grpc.MethodDescriptor<ie.gmit.ds.userIds, ie.gmit.ds.hashedPassword> getHashPasswordMethod;
    if ((getHashPasswordMethod = PasswordServiceGrpc.getHashPasswordMethod) == null) {
      synchronized (PasswordServiceGrpc.class) {
        if ((getHashPasswordMethod = PasswordServiceGrpc.getHashPasswordMethod) == null) {
          PasswordServiceGrpc.getHashPasswordMethod = getHashPasswordMethod =
              io.grpc.MethodDescriptor.<ie.gmit.ds.userIds, ie.gmit.ds.hashedPassword>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "hashPassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.userIds.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.hashedPassword.getDefaultInstance()))
              .setSchemaDescriptor(new PasswordServiceMethodDescriptorSupplier("hashPassword"))
              .build();
        }
      }
    }
    return getHashPasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ie.gmit.ds.checkPassword,
      com.google.protobuf.BoolValue> getValidatePasswordsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "validatePasswords",
      requestType = ie.gmit.ds.checkPassword.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.ds.checkPassword,
      com.google.protobuf.BoolValue> getValidatePasswordsMethod() {
    io.grpc.MethodDescriptor<ie.gmit.ds.checkPassword, com.google.protobuf.BoolValue> getValidatePasswordsMethod;
    if ((getValidatePasswordsMethod = PasswordServiceGrpc.getValidatePasswordsMethod) == null) {
      synchronized (PasswordServiceGrpc.class) {
        if ((getValidatePasswordsMethod = PasswordServiceGrpc.getValidatePasswordsMethod) == null) {
          PasswordServiceGrpc.getValidatePasswordsMethod = getValidatePasswordsMethod =
              io.grpc.MethodDescriptor.<ie.gmit.ds.checkPassword, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "validatePasswords"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.checkPassword.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new PasswordServiceMethodDescriptorSupplier("validatePasswords"))
              .build();
        }
      }
    }
    return getValidatePasswordsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PasswordServiceStub newStub(io.grpc.Channel channel) {
    return new PasswordServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PasswordServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PasswordServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PasswordServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PasswordServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PasswordServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void hashPassword(ie.gmit.ds.userIds request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.hashedPassword> responseObserver) {
      asyncUnimplementedUnaryCall(getHashPasswordMethod(), responseObserver);
    }

    /**
     */
    public void validatePasswords(ie.gmit.ds.checkPassword request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(getValidatePasswordsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHashPasswordMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.ds.userIds,
                ie.gmit.ds.hashedPassword>(
                  this, METHODID_HASH_PASSWORD)))
          .addMethod(
            getValidatePasswordsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.ds.checkPassword,
                com.google.protobuf.BoolValue>(
                  this, METHODID_VALIDATE_PASSWORDS)))
          .build();
    }
  }

  /**
   */
  public static final class PasswordServiceStub extends io.grpc.stub.AbstractStub<PasswordServiceStub> {
    private PasswordServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PasswordServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasswordServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PasswordServiceStub(channel, callOptions);
    }

    /**
     */
    public void hashPassword(ie.gmit.ds.userIds request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.hashedPassword> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHashPasswordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validatePasswords(ie.gmit.ds.checkPassword request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getValidatePasswordsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PasswordServiceBlockingStub extends io.grpc.stub.AbstractStub<PasswordServiceBlockingStub> {
    private PasswordServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PasswordServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasswordServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PasswordServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ie.gmit.ds.hashedPassword hashPassword(ie.gmit.ds.userIds request) {
      return blockingUnaryCall(
          getChannel(), getHashPasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue validatePasswords(ie.gmit.ds.checkPassword request) {
      return blockingUnaryCall(
          getChannel(), getValidatePasswordsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PasswordServiceFutureStub extends io.grpc.stub.AbstractStub<PasswordServiceFutureStub> {
    private PasswordServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PasswordServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasswordServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PasswordServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ie.gmit.ds.hashedPassword> hashPassword(
        ie.gmit.ds.userIds request) {
      return futureUnaryCall(
          getChannel().newCall(getHashPasswordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> validatePasswords(
        ie.gmit.ds.checkPassword request) {
      return futureUnaryCall(
          getChannel().newCall(getValidatePasswordsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HASH_PASSWORD = 0;
  private static final int METHODID_VALIDATE_PASSWORDS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PasswordServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PasswordServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HASH_PASSWORD:
          serviceImpl.hashPassword((ie.gmit.ds.userIds) request,
              (io.grpc.stub.StreamObserver<ie.gmit.ds.hashedPassword>) responseObserver);
          break;
        case METHODID_VALIDATE_PASSWORDS:
          serviceImpl.validatePasswords((ie.gmit.ds.checkPassword) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PasswordServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PasswordServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ie.gmit.ds.Password.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PasswordService");
    }
  }

  private static final class PasswordServiceFileDescriptorSupplier
      extends PasswordServiceBaseDescriptorSupplier {
    PasswordServiceFileDescriptorSupplier() {}
  }

  private static final class PasswordServiceMethodDescriptorSupplier
      extends PasswordServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PasswordServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PasswordServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PasswordServiceFileDescriptorSupplier())
              .addMethod(getHashPasswordMethod())
              .addMethod(getValidatePasswordsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
