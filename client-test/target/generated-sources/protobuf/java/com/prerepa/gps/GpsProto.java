// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: info.proto

package com.prerepa.gps;

public final class GpsProto {
  private GpsProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_gps_CaneCoordinates_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_gps_CaneCoordinates_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_gps_InsertStatus_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_gps_InsertStatus_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_gps_CoordinatesID_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_gps_CoordinatesID_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_gps_Coordinates_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_gps_Coordinates_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ninfo.proto\022\003gps\"H\n\017CaneCoordinates\022\020\n\010" +
      "username\030\001 \001(\t\022\020\n\010latitude\030\002 \001(\001\022\021\n\tlong" +
      "itude\030\003 \001(\001\"$\n\014InsertStatus\022\024\n\014insertSta" +
      "tus\030\001 \001(\005\"!\n\rCoordinatesID\022\020\n\010username\030\001" +
      " \001(\t\"B\n\013Coordinates\022\020\n\010latitude\030\001 \003(\001\022\021\n" +
      "\tlongitude\030\002 \003(\001\022\016\n\006status\030\003 \001(\0052|\n\nGpsS" +
      "ervice\0227\n\nCaneInsert\022\024.gps.CaneCoordinat" +
      "es\032\021.gps.InsertStatus\"\000\0225\n\013AppRetrieve\022\022" +
      ".gps.CoordinatesID\032\020.gps.Coordinates\"\000B#" +
      "\n\017com.prerepa.gpsB\010GpsProtoP\001\242\002\003HLWb\006pro" +
      "to3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_gps_CaneCoordinates_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_gps_CaneCoordinates_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_gps_CaneCoordinates_descriptor,
        new java.lang.String[] { "Username", "Latitude", "Longitude", });
    internal_static_gps_InsertStatus_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_gps_InsertStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_gps_InsertStatus_descriptor,
        new java.lang.String[] { "InsertStatus", });
    internal_static_gps_CoordinatesID_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_gps_CoordinatesID_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_gps_CoordinatesID_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_gps_Coordinates_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_gps_Coordinates_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_gps_Coordinates_descriptor,
        new java.lang.String[] { "Latitude", "Longitude", "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
