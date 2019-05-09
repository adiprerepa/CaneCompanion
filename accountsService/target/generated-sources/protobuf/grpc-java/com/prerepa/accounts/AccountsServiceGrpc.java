package com.prerepa.accounts;

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
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: AccountProto.proto")
public final class AccountsServiceGrpc {

  private AccountsServiceGrpc() {}

  public static final String SERVICE_NAME = "accounts.AccountsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.prerepa.accounts.UserCredentials,
      com.prerepa.accounts.UserInfo> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login",
      requestType = com.prerepa.accounts.UserCredentials.class,
      responseType = com.prerepa.accounts.UserInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.prerepa.accounts.UserCredentials,
      com.prerepa.accounts.UserInfo> getLoginMethod() {
    io.grpc.MethodDescriptor<com.prerepa.accounts.UserCredentials, com.prerepa.accounts.UserInfo> getLoginMethod;
    if ((getLoginMethod = AccountsServiceGrpc.getLoginMethod) == null) {
      synchronized (AccountsServiceGrpc.class) {
        if ((getLoginMethod = AccountsServiceGrpc.getLoginMethod) == null) {
          AccountsServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<com.prerepa.accounts.UserCredentials, com.prerepa.accounts.UserInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "accounts.AccountsService", "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.prerepa.accounts.UserCredentials.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.prerepa.accounts.UserInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new AccountsServiceMethodDescriptorSupplier("Login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.prerepa.accounts.UserRegisterInfo,
      com.prerepa.accounts.RegisterSuccessful> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Register",
      requestType = com.prerepa.accounts.UserRegisterInfo.class,
      responseType = com.prerepa.accounts.RegisterSuccessful.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.prerepa.accounts.UserRegisterInfo,
      com.prerepa.accounts.RegisterSuccessful> getRegisterMethod() {
    io.grpc.MethodDescriptor<com.prerepa.accounts.UserRegisterInfo, com.prerepa.accounts.RegisterSuccessful> getRegisterMethod;
    if ((getRegisterMethod = AccountsServiceGrpc.getRegisterMethod) == null) {
      synchronized (AccountsServiceGrpc.class) {
        if ((getRegisterMethod = AccountsServiceGrpc.getRegisterMethod) == null) {
          AccountsServiceGrpc.getRegisterMethod = getRegisterMethod = 
              io.grpc.MethodDescriptor.<com.prerepa.accounts.UserRegisterInfo, com.prerepa.accounts.RegisterSuccessful>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "accounts.AccountsService", "Register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.prerepa.accounts.UserRegisterInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.prerepa.accounts.RegisterSuccessful.getDefaultInstance()))
                  .setSchemaDescriptor(new AccountsServiceMethodDescriptorSupplier("Register"))
                  .build();
          }
        }
     }
     return getRegisterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccountsServiceStub newStub(io.grpc.Channel channel) {
    return new AccountsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AccountsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccountsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AccountsServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AccountsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(com.prerepa.accounts.UserCredentials request,
        io.grpc.stub.StreamObserver<com.prerepa.accounts.UserInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void register(com.prerepa.accounts.UserRegisterInfo request,
        io.grpc.stub.StreamObserver<com.prerepa.accounts.RegisterSuccessful> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.prerepa.accounts.UserCredentials,
                com.prerepa.accounts.UserInfo>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getRegisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.prerepa.accounts.UserRegisterInfo,
                com.prerepa.accounts.RegisterSuccessful>(
                  this, METHODID_REGISTER)))
          .build();
    }
  }

  /**
   */
  public static final class AccountsServiceStub extends io.grpc.stub.AbstractStub<AccountsServiceStub> {
    private AccountsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountsServiceStub(channel, callOptions);
    }

    /**
     */
    public void login(com.prerepa.accounts.UserCredentials request,
        io.grpc.stub.StreamObserver<com.prerepa.accounts.UserInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void register(com.prerepa.accounts.UserRegisterInfo request,
        io.grpc.stub.StreamObserver<com.prerepa.accounts.RegisterSuccessful> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AccountsServiceBlockingStub extends io.grpc.stub.AbstractStub<AccountsServiceBlockingStub> {
    private AccountsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.prerepa.accounts.UserInfo login(com.prerepa.accounts.UserCredentials request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.prerepa.accounts.RegisterSuccessful register(com.prerepa.accounts.UserRegisterInfo request) {
      return blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AccountsServiceFutureStub extends io.grpc.stub.AbstractStub<AccountsServiceFutureStub> {
    private AccountsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.prerepa.accounts.UserInfo> login(
        com.prerepa.accounts.UserCredentials request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.prerepa.accounts.RegisterSuccessful> register(
        com.prerepa.accounts.UserRegisterInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_REGISTER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AccountsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AccountsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((com.prerepa.accounts.UserCredentials) request,
              (io.grpc.stub.StreamObserver<com.prerepa.accounts.UserInfo>) responseObserver);
          break;
        case METHODID_REGISTER:
          serviceImpl.register((com.prerepa.accounts.UserRegisterInfo) request,
              (io.grpc.stub.StreamObserver<com.prerepa.accounts.RegisterSuccessful>) responseObserver);
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

  private static abstract class AccountsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.prerepa.accounts.AccountsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountsService");
    }
  }

  private static final class AccountsServiceFileDescriptorSupplier
      extends AccountsServiceBaseDescriptorSupplier {
    AccountsServiceFileDescriptorSupplier() {}
  }

  private static final class AccountsServiceMethodDescriptorSupplier
      extends AccountsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AccountsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AccountsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccountsServiceFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getRegisterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
