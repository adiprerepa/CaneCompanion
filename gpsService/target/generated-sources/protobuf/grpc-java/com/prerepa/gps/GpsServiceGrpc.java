package com.prerepa.gps;

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
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: gps.proto")
public final class GpsServiceGrpc {

  private GpsServiceGrpc() {}

  public static final String SERVICE_NAME = "gps.GpsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.prerepa.gps.CaneCoordinates,
      com.prerepa.gps.InsertStatus> getCaneInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CaneInsert",
      requestType = com.prerepa.gps.CaneCoordinates.class,
      responseType = com.prerepa.gps.InsertStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.prerepa.gps.CaneCoordinates,
      com.prerepa.gps.InsertStatus> getCaneInsertMethod() {
    io.grpc.MethodDescriptor<com.prerepa.gps.CaneCoordinates, com.prerepa.gps.InsertStatus> getCaneInsertMethod;
    if ((getCaneInsertMethod = GpsServiceGrpc.getCaneInsertMethod) == null) {
      synchronized (GpsServiceGrpc.class) {
        if ((getCaneInsertMethod = GpsServiceGrpc.getCaneInsertMethod) == null) {
          GpsServiceGrpc.getCaneInsertMethod = getCaneInsertMethod = 
              io.grpc.MethodDescriptor.<com.prerepa.gps.CaneCoordinates, com.prerepa.gps.InsertStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "gps.GpsService", "CaneInsert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.prerepa.gps.CaneCoordinates.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.prerepa.gps.InsertStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new GpsServiceMethodDescriptorSupplier("CaneInsert"))
                  .build();
          }
        }
     }
     return getCaneInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.prerepa.gps.CoordinatesID,
      com.prerepa.gps.Coordinates> getAppRetrieveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AppRetrieve",
      requestType = com.prerepa.gps.CoordinatesID.class,
      responseType = com.prerepa.gps.Coordinates.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.prerepa.gps.CoordinatesID,
      com.prerepa.gps.Coordinates> getAppRetrieveMethod() {
    io.grpc.MethodDescriptor<com.prerepa.gps.CoordinatesID, com.prerepa.gps.Coordinates> getAppRetrieveMethod;
    if ((getAppRetrieveMethod = GpsServiceGrpc.getAppRetrieveMethod) == null) {
      synchronized (GpsServiceGrpc.class) {
        if ((getAppRetrieveMethod = GpsServiceGrpc.getAppRetrieveMethod) == null) {
          GpsServiceGrpc.getAppRetrieveMethod = getAppRetrieveMethod = 
              io.grpc.MethodDescriptor.<com.prerepa.gps.CoordinatesID, com.prerepa.gps.Coordinates>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "gps.GpsService", "AppRetrieve"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.prerepa.gps.CoordinatesID.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.prerepa.gps.Coordinates.getDefaultInstance()))
                  .setSchemaDescriptor(new GpsServiceMethodDescriptorSupplier("AppRetrieve"))
                  .build();
          }
        }
     }
     return getAppRetrieveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GpsServiceStub newStub(io.grpc.Channel channel) {
    return new GpsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GpsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GpsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GpsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GpsServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class GpsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Retrieves coordinates, inserts, sends back a status.
     * </pre>
     */
    public void caneInsert(com.prerepa.gps.CaneCoordinates request,
        io.grpc.stub.StreamObserver<com.prerepa.gps.InsertStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getCaneInsertMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves user and id from database (recieved from app) and sends coordinates.
     * </pre>
     */
    public void appRetrieve(com.prerepa.gps.CoordinatesID request,
        io.grpc.stub.StreamObserver<com.prerepa.gps.Coordinates> responseObserver) {
      asyncUnimplementedUnaryCall(getAppRetrieveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCaneInsertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.prerepa.gps.CaneCoordinates,
                com.prerepa.gps.InsertStatus>(
                  this, METHODID_CANE_INSERT)))
          .addMethod(
            getAppRetrieveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.prerepa.gps.CoordinatesID,
                com.prerepa.gps.Coordinates>(
                  this, METHODID_APP_RETRIEVE)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class GpsServiceStub extends io.grpc.stub.AbstractStub<GpsServiceStub> {
    private GpsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GpsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GpsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GpsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves coordinates, inserts, sends back a status.
     * </pre>
     */
    public void caneInsert(com.prerepa.gps.CaneCoordinates request,
        io.grpc.stub.StreamObserver<com.prerepa.gps.InsertStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCaneInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves user and id from database (recieved from app) and sends coordinates.
     * </pre>
     */
    public void appRetrieve(com.prerepa.gps.CoordinatesID request,
        io.grpc.stub.StreamObserver<com.prerepa.gps.Coordinates> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAppRetrieveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class GpsServiceBlockingStub extends io.grpc.stub.AbstractStub<GpsServiceBlockingStub> {
    private GpsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GpsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GpsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GpsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves coordinates, inserts, sends back a status.
     * </pre>
     */
    public com.prerepa.gps.InsertStatus caneInsert(com.prerepa.gps.CaneCoordinates request) {
      return blockingUnaryCall(
          getChannel(), getCaneInsertMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves user and id from database (recieved from app) and sends coordinates.
     * </pre>
     */
    public com.prerepa.gps.Coordinates appRetrieve(com.prerepa.gps.CoordinatesID request) {
      return blockingUnaryCall(
          getChannel(), getAppRetrieveMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class GpsServiceFutureStub extends io.grpc.stub.AbstractStub<GpsServiceFutureStub> {
    private GpsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GpsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GpsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GpsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves coordinates, inserts, sends back a status.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.prerepa.gps.InsertStatus> caneInsert(
        com.prerepa.gps.CaneCoordinates request) {
      return futureUnaryCall(
          getChannel().newCall(getCaneInsertMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves user and id from database (recieved from app) and sends coordinates.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.prerepa.gps.Coordinates> appRetrieve(
        com.prerepa.gps.CoordinatesID request) {
      return futureUnaryCall(
          getChannel().newCall(getAppRetrieveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CANE_INSERT = 0;
  private static final int METHODID_APP_RETRIEVE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GpsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GpsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CANE_INSERT:
          serviceImpl.caneInsert((com.prerepa.gps.CaneCoordinates) request,
              (io.grpc.stub.StreamObserver<com.prerepa.gps.InsertStatus>) responseObserver);
          break;
        case METHODID_APP_RETRIEVE:
          serviceImpl.appRetrieve((com.prerepa.gps.CoordinatesID) request,
              (io.grpc.stub.StreamObserver<com.prerepa.gps.Coordinates>) responseObserver);
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

  private static abstract class GpsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GpsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.prerepa.gps.GpsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GpsService");
    }
  }

  private static final class GpsServiceFileDescriptorSupplier
      extends GpsServiceBaseDescriptorSupplier {
    GpsServiceFileDescriptorSupplier() {}
  }

  private static final class GpsServiceMethodDescriptorSupplier
      extends GpsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GpsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GpsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GpsServiceFileDescriptorSupplier())
              .addMethod(getCaneInsertMethod())
              .addMethod(getAppRetrieveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
