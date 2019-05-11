# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: gps.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='gps.proto',
  package='gps',
  syntax='proto3',
  serialized_options=_b('\n\017com.prerepa.gpsB\010GpsProtoP\001\242\002\003HLW'),
  serialized_pb=_b('\n\tgps.proto\x12\x03gps\"H\n\x0f\x43\x61neCoordinates\x12\x10\n\x08username\x18\x01 \x01(\t\x12\x10\n\x08latitude\x18\x02 \x01(\x01\x12\x11\n\tlongitude\x18\x03 \x01(\x01\"$\n\x0cInsertStatus\x12\x14\n\x0cinsertStatus\x18\x01 \x01(\x05\"8\n\rCoordinatesID\x12\x10\n\x08username\x18\x01 \x01(\t\x12\x15\n\rcoordinatesID\x18\x02 \x01(\x05\"2\n\x0b\x43oordinates\x12\x10\n\x08latitude\x18\x01 \x01(\x01\x12\x11\n\tlongitude\x18\x02 \x01(\x01\x32|\n\nGpsService\x12\x37\n\nCaneInsert\x12\x14.gps.CaneCoordinates\x1a\x11.gps.InsertStatus\"\x00\x12\x35\n\x0b\x41ppRetrieve\x12\x12.gps.CoordinatesID\x1a\x10.gps.Coordinates\"\x00\x42#\n\x0f\x63om.prerepa.gpsB\x08GpsProtoP\x01\xa2\x02\x03HLWb\x06proto3')
)




_CANECOORDINATES = _descriptor.Descriptor(
  name='CaneCoordinates',
  full_name='gps.CaneCoordinates',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='username', full_name='gps.CaneCoordinates.username', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='latitude', full_name='gps.CaneCoordinates.latitude', index=1,
      number=2, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='longitude', full_name='gps.CaneCoordinates.longitude', index=2,
      number=3, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=18,
  serialized_end=90,
)


_INSERTSTATUS = _descriptor.Descriptor(
  name='InsertStatus',
  full_name='gps.InsertStatus',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='insertStatus', full_name='gps.InsertStatus.insertStatus', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=92,
  serialized_end=128,
)


_COORDINATESID = _descriptor.Descriptor(
  name='CoordinatesID',
  full_name='gps.CoordinatesID',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='username', full_name='gps.CoordinatesID.username', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='coordinatesID', full_name='gps.CoordinatesID.coordinatesID', index=1,
      number=2, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=130,
  serialized_end=186,
)


_COORDINATES = _descriptor.Descriptor(
  name='Coordinates',
  full_name='gps.Coordinates',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='latitude', full_name='gps.Coordinates.latitude', index=0,
      number=1, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='longitude', full_name='gps.Coordinates.longitude', index=1,
      number=2, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=188,
  serialized_end=238,
)

DESCRIPTOR.message_types_by_name['CaneCoordinates'] = _CANECOORDINATES
DESCRIPTOR.message_types_by_name['InsertStatus'] = _INSERTSTATUS
DESCRIPTOR.message_types_by_name['CoordinatesID'] = _COORDINATESID
DESCRIPTOR.message_types_by_name['Coordinates'] = _COORDINATES
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

CaneCoordinates = _reflection.GeneratedProtocolMessageType('CaneCoordinates', (_message.Message,), dict(
  DESCRIPTOR = _CANECOORDINATES,
  __module__ = 'gps_pb2'
  # @@protoc_insertion_point(class_scope:gps.CaneCoordinates)
  ))
_sym_db.RegisterMessage(CaneCoordinates)

InsertStatus = _reflection.GeneratedProtocolMessageType('InsertStatus', (_message.Message,), dict(
  DESCRIPTOR = _INSERTSTATUS,
  __module__ = 'gps_pb2'
  # @@protoc_insertion_point(class_scope:gps.InsertStatus)
  ))
_sym_db.RegisterMessage(InsertStatus)

CoordinatesID = _reflection.GeneratedProtocolMessageType('CoordinatesID', (_message.Message,), dict(
  DESCRIPTOR = _COORDINATESID,
  __module__ = 'gps_pb2'
  # @@protoc_insertion_point(class_scope:gps.CoordinatesID)
  ))
_sym_db.RegisterMessage(CoordinatesID)

Coordinates = _reflection.GeneratedProtocolMessageType('Coordinates', (_message.Message,), dict(
  DESCRIPTOR = _COORDINATES,
  __module__ = 'gps_pb2'
  # @@protoc_insertion_point(class_scope:gps.Coordinates)
  ))
_sym_db.RegisterMessage(Coordinates)


DESCRIPTOR._options = None

_GPSSERVICE = _descriptor.ServiceDescriptor(
  name='GpsService',
  full_name='gps.GpsService',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  serialized_start=240,
  serialized_end=364,
  methods=[
  _descriptor.MethodDescriptor(
    name='CaneInsert',
    full_name='gps.GpsService.CaneInsert',
    index=0,
    containing_service=None,
    input_type=_CANECOORDINATES,
    output_type=_INSERTSTATUS,
    serialized_options=None,
  ),
  _descriptor.MethodDescriptor(
    name='AppRetrieve',
    full_name='gps.GpsService.AppRetrieve',
    index=1,
    containing_service=None,
    input_type=_COORDINATESID,
    output_type=_COORDINATES,
    serialized_options=None,
  ),
])
_sym_db.RegisterServiceDescriptor(_GPSSERVICE)

DESCRIPTOR.services_by_name['GpsService'] = _GPSSERVICE

# @@protoc_insertion_point(module_scope)