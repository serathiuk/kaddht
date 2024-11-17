package dev.serathiuk.kademlia.server.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.65.0)",
    comments = "Source: kademlia.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class KademliaGrpc {

  private KademliaGrpc() {}

  public static final java.lang.String SERVICE_NAME = "Kademlia";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dev.serathiuk.kademlia.server.grpc.NodeId,
      dev.serathiuk.kademlia.server.grpc.Node> getFindNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findNode",
      requestType = dev.serathiuk.kademlia.server.grpc.NodeId.class,
      responseType = dev.serathiuk.kademlia.server.grpc.Node.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dev.serathiuk.kademlia.server.grpc.NodeId,
      dev.serathiuk.kademlia.server.grpc.Node> getFindNodeMethod() {
    io.grpc.MethodDescriptor<dev.serathiuk.kademlia.server.grpc.NodeId, dev.serathiuk.kademlia.server.grpc.Node> getFindNodeMethod;
    if ((getFindNodeMethod = KademliaGrpc.getFindNodeMethod) == null) {
      synchronized (KademliaGrpc.class) {
        if ((getFindNodeMethod = KademliaGrpc.getFindNodeMethod) == null) {
          KademliaGrpc.getFindNodeMethod = getFindNodeMethod =
              io.grpc.MethodDescriptor.<dev.serathiuk.kademlia.server.grpc.NodeId, dev.serathiuk.kademlia.server.grpc.Node>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.serathiuk.kademlia.server.grpc.NodeId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.serathiuk.kademlia.server.grpc.Node.getDefaultInstance()))
              .setSchemaDescriptor(new KademliaMethodDescriptorSupplier("findNode"))
              .build();
        }
      }
    }
    return getFindNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dev.serathiuk.kademlia.server.grpc.NodeId,
      dev.serathiuk.kademlia.server.grpc.NodeId> getPingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ping",
      requestType = dev.serathiuk.kademlia.server.grpc.NodeId.class,
      responseType = dev.serathiuk.kademlia.server.grpc.NodeId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dev.serathiuk.kademlia.server.grpc.NodeId,
      dev.serathiuk.kademlia.server.grpc.NodeId> getPingMethod() {
    io.grpc.MethodDescriptor<dev.serathiuk.kademlia.server.grpc.NodeId, dev.serathiuk.kademlia.server.grpc.NodeId> getPingMethod;
    if ((getPingMethod = KademliaGrpc.getPingMethod) == null) {
      synchronized (KademliaGrpc.class) {
        if ((getPingMethod = KademliaGrpc.getPingMethod) == null) {
          KademliaGrpc.getPingMethod = getPingMethod =
              io.grpc.MethodDescriptor.<dev.serathiuk.kademlia.server.grpc.NodeId, dev.serathiuk.kademlia.server.grpc.NodeId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.serathiuk.kademlia.server.grpc.NodeId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.serathiuk.kademlia.server.grpc.NodeId.getDefaultInstance()))
              .setSchemaDescriptor(new KademliaMethodDescriptorSupplier("ping"))
              .build();
        }
      }
    }
    return getPingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dev.serathiuk.kademlia.server.grpc.Entry,
      dev.serathiuk.kademlia.server.grpc.StoreResponse> getStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "store",
      requestType = dev.serathiuk.kademlia.server.grpc.Entry.class,
      responseType = dev.serathiuk.kademlia.server.grpc.StoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dev.serathiuk.kademlia.server.grpc.Entry,
      dev.serathiuk.kademlia.server.grpc.StoreResponse> getStoreMethod() {
    io.grpc.MethodDescriptor<dev.serathiuk.kademlia.server.grpc.Entry, dev.serathiuk.kademlia.server.grpc.StoreResponse> getStoreMethod;
    if ((getStoreMethod = KademliaGrpc.getStoreMethod) == null) {
      synchronized (KademliaGrpc.class) {
        if ((getStoreMethod = KademliaGrpc.getStoreMethod) == null) {
          KademliaGrpc.getStoreMethod = getStoreMethod =
              io.grpc.MethodDescriptor.<dev.serathiuk.kademlia.server.grpc.Entry, dev.serathiuk.kademlia.server.grpc.StoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "store"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.serathiuk.kademlia.server.grpc.Entry.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.serathiuk.kademlia.server.grpc.StoreResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KademliaMethodDescriptorSupplier("store"))
              .build();
        }
      }
    }
    return getStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dev.serathiuk.kademlia.server.grpc.FindValueRequest,
      dev.serathiuk.kademlia.server.grpc.FindValueResponse> getFindValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findValue",
      requestType = dev.serathiuk.kademlia.server.grpc.FindValueRequest.class,
      responseType = dev.serathiuk.kademlia.server.grpc.FindValueResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dev.serathiuk.kademlia.server.grpc.FindValueRequest,
      dev.serathiuk.kademlia.server.grpc.FindValueResponse> getFindValueMethod() {
    io.grpc.MethodDescriptor<dev.serathiuk.kademlia.server.grpc.FindValueRequest, dev.serathiuk.kademlia.server.grpc.FindValueResponse> getFindValueMethod;
    if ((getFindValueMethod = KademliaGrpc.getFindValueMethod) == null) {
      synchronized (KademliaGrpc.class) {
        if ((getFindValueMethod = KademliaGrpc.getFindValueMethod) == null) {
          KademliaGrpc.getFindValueMethod = getFindValueMethod =
              io.grpc.MethodDescriptor.<dev.serathiuk.kademlia.server.grpc.FindValueRequest, dev.serathiuk.kademlia.server.grpc.FindValueResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.serathiuk.kademlia.server.grpc.FindValueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.serathiuk.kademlia.server.grpc.FindValueResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KademliaMethodDescriptorSupplier("findValue"))
              .build();
        }
      }
    }
    return getFindValueMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static KademliaStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KademliaStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KademliaStub>() {
        @java.lang.Override
        public KademliaStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KademliaStub(channel, callOptions);
        }
      };
    return KademliaStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KademliaBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KademliaBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KademliaBlockingStub>() {
        @java.lang.Override
        public KademliaBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KademliaBlockingStub(channel, callOptions);
        }
      };
    return KademliaBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static KademliaFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KademliaFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KademliaFutureStub>() {
        @java.lang.Override
        public KademliaFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KademliaFutureStub(channel, callOptions);
        }
      };
    return KademliaFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void findNode(dev.serathiuk.kademlia.server.grpc.NodeId request,
        io.grpc.stub.StreamObserver<dev.serathiuk.kademlia.server.grpc.Node> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindNodeMethod(), responseObserver);
    }

    /**
     */
    default void ping(dev.serathiuk.kademlia.server.grpc.NodeId request,
        io.grpc.stub.StreamObserver<dev.serathiuk.kademlia.server.grpc.NodeId> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPingMethod(), responseObserver);
    }

    /**
     */
    default void store(dev.serathiuk.kademlia.server.grpc.Entry request,
        io.grpc.stub.StreamObserver<dev.serathiuk.kademlia.server.grpc.StoreResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStoreMethod(), responseObserver);
    }

    /**
     */
    default void findValue(dev.serathiuk.kademlia.server.grpc.FindValueRequest request,
        io.grpc.stub.StreamObserver<dev.serathiuk.kademlia.server.grpc.FindValueResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindValueMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Kademlia.
   */
  public static abstract class KademliaImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return KademliaGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Kademlia.
   */
  public static final class KademliaStub
      extends io.grpc.stub.AbstractAsyncStub<KademliaStub> {
    private KademliaStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KademliaStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KademliaStub(channel, callOptions);
    }

    /**
     */
    public void findNode(dev.serathiuk.kademlia.server.grpc.NodeId request,
        io.grpc.stub.StreamObserver<dev.serathiuk.kademlia.server.grpc.Node> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void ping(dev.serathiuk.kademlia.server.grpc.NodeId request,
        io.grpc.stub.StreamObserver<dev.serathiuk.kademlia.server.grpc.NodeId> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void store(dev.serathiuk.kademlia.server.grpc.Entry request,
        io.grpc.stub.StreamObserver<dev.serathiuk.kademlia.server.grpc.StoreResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findValue(dev.serathiuk.kademlia.server.grpc.FindValueRequest request,
        io.grpc.stub.StreamObserver<dev.serathiuk.kademlia.server.grpc.FindValueResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindValueMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Kademlia.
   */
  public static final class KademliaBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<KademliaBlockingStub> {
    private KademliaBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KademliaBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KademliaBlockingStub(channel, callOptions);
    }

    /**
     */
    public dev.serathiuk.kademlia.server.grpc.Node findNode(dev.serathiuk.kademlia.server.grpc.NodeId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindNodeMethod(), getCallOptions(), request);
    }

    /**
     */
    public dev.serathiuk.kademlia.server.grpc.NodeId ping(dev.serathiuk.kademlia.server.grpc.NodeId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPingMethod(), getCallOptions(), request);
    }

    /**
     */
    public dev.serathiuk.kademlia.server.grpc.StoreResponse store(dev.serathiuk.kademlia.server.grpc.Entry request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public dev.serathiuk.kademlia.server.grpc.FindValueResponse findValue(dev.serathiuk.kademlia.server.grpc.FindValueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindValueMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Kademlia.
   */
  public static final class KademliaFutureStub
      extends io.grpc.stub.AbstractFutureStub<KademliaFutureStub> {
    private KademliaFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KademliaFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KademliaFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dev.serathiuk.kademlia.server.grpc.Node> findNode(
        dev.serathiuk.kademlia.server.grpc.NodeId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindNodeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dev.serathiuk.kademlia.server.grpc.NodeId> ping(
        dev.serathiuk.kademlia.server.grpc.NodeId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dev.serathiuk.kademlia.server.grpc.StoreResponse> store(
        dev.serathiuk.kademlia.server.grpc.Entry request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStoreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dev.serathiuk.kademlia.server.grpc.FindValueResponse> findValue(
        dev.serathiuk.kademlia.server.grpc.FindValueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindValueMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_NODE = 0;
  private static final int METHODID_PING = 1;
  private static final int METHODID_STORE = 2;
  private static final int METHODID_FIND_VALUE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_NODE:
          serviceImpl.findNode((dev.serathiuk.kademlia.server.grpc.NodeId) request,
              (io.grpc.stub.StreamObserver<dev.serathiuk.kademlia.server.grpc.Node>) responseObserver);
          break;
        case METHODID_PING:
          serviceImpl.ping((dev.serathiuk.kademlia.server.grpc.NodeId) request,
              (io.grpc.stub.StreamObserver<dev.serathiuk.kademlia.server.grpc.NodeId>) responseObserver);
          break;
        case METHODID_STORE:
          serviceImpl.store((dev.serathiuk.kademlia.server.grpc.Entry) request,
              (io.grpc.stub.StreamObserver<dev.serathiuk.kademlia.server.grpc.StoreResponse>) responseObserver);
          break;
        case METHODID_FIND_VALUE:
          serviceImpl.findValue((dev.serathiuk.kademlia.server.grpc.FindValueRequest) request,
              (io.grpc.stub.StreamObserver<dev.serathiuk.kademlia.server.grpc.FindValueResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getFindNodeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dev.serathiuk.kademlia.server.grpc.NodeId,
              dev.serathiuk.kademlia.server.grpc.Node>(
                service, METHODID_FIND_NODE)))
        .addMethod(
          getPingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dev.serathiuk.kademlia.server.grpc.NodeId,
              dev.serathiuk.kademlia.server.grpc.NodeId>(
                service, METHODID_PING)))
        .addMethod(
          getStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dev.serathiuk.kademlia.server.grpc.Entry,
              dev.serathiuk.kademlia.server.grpc.StoreResponse>(
                service, METHODID_STORE)))
        .addMethod(
          getFindValueMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dev.serathiuk.kademlia.server.grpc.FindValueRequest,
              dev.serathiuk.kademlia.server.grpc.FindValueResponse>(
                service, METHODID_FIND_VALUE)))
        .build();
  }

  private static abstract class KademliaBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    KademliaBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dev.serathiuk.kademlia.server.grpc.KademliaOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Kademlia");
    }
  }

  private static final class KademliaFileDescriptorSupplier
      extends KademliaBaseDescriptorSupplier {
    KademliaFileDescriptorSupplier() {}
  }

  private static final class KademliaMethodDescriptorSupplier
      extends KademliaBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    KademliaMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (KademliaGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new KademliaFileDescriptorSupplier())
              .addMethod(getFindNodeMethod())
              .addMethod(getPingMethod())
              .addMethod(getStoreMethod())
              .addMethod(getFindValueMethod())
              .build();
        }
      }
    }
    return result;
  }
}
