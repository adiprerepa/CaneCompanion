# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: vision.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='vision.proto',
  package='helloworld',
  syntax='proto3',
  serialized_options=None,
  serialized_pb=_b('\n\x0cvision.proto\x12\nhelloworld\"1\n\x0b\x43\x61neRequest\x12\x10\n\x08username\x18\x01 \x01(\t\x12\x10\n\x08png_data\x18\x02 \x01(\x0c\"\x1d\n\tCaneReply\x12\x10\n\x08wav_data\x18\x01 \x01(\x0c\"\x1e\n\nAppRequest\x12\x10\n\x08username\x18\x01 \x01(\t\"-\n\x08\x41ppReply\x12\x13\n\x0bobject_name\x18\x01 \x01(\t\x12\x0c\n\x04time\x18\x02 \x01(\t2\x8d\x01\n\x12VisionMicroservice\x12\x39\n\x07\x41ppCall\x12\x16.helloworld.AppRequest\x1a\x14.helloworld.AppReply\"\x00\x12<\n\x08\x43\x61neCall\x12\x17.helloworld.CaneRequest\x1a\x15.helloworld.CaneReply\"\x00\x62\x06proto3')
)




_CANEREQUEST = _descriptor.Descriptor(
  name='CaneRequest',
  full_name='helloworld.CaneRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='username', full_name='helloworld.CaneRequest.username', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='png_data', full_name='helloworld.CaneRequest.png_data', index=1,
      number=2, type=12, cpp_type=9, label=1,
      has_default_value=False, default_value=_b(""),
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
  serialized_start=28,
  serialized_end=77,
)


_CANEREPLY = _descriptor.Descriptor(
  name='CaneReply',
  full_name='helloworld.CaneReply',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='wav_data', full_name='helloworld.CaneReply.wav_data', index=0,
      number=1, type=12, cpp_type=9, label=1,
      has_default_value=False, default_value=_b(""),
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
  serialized_start=79,
  serialized_end=108,
)


_APPREQUEST = _descriptor.Descriptor(
  name='AppRequest',
  full_name='helloworld.AppRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='username', full_name='helloworld.AppRequest.username', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
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
  serialized_start=110,
  serialized_end=140,
)


_APPREPLY = _descriptor.Descriptor(
  name='AppReply',
  full_name='helloworld.AppReply',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='object_name', full_name='helloworld.AppReply.object_name', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='time', full_name='helloworld.AppReply.time', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
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
  serialized_start=142,
  serialized_end=187,
)

DESCRIPTOR.message_types_by_name['CaneRequest'] = _CANEREQUEST
DESCRIPTOR.message_types_by_name['CaneReply'] = _CANEREPLY
DESCRIPTOR.message_types_by_name['AppRequest'] = _APPREQUEST
DESCRIPTOR.message_types_by_name['AppReply'] = _APPREPLY
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

CaneRequest = _reflection.GeneratedProtocolMessageType('CaneRequest', (_message.Message,), dict(
  DESCRIPTOR = _CANEREQUEST,
  __module__ = 'vision_pb2'
  # @@protoc_insertion_point(class_scope:helloworld.CaneRequest)
  ))
_sym_db.RegisterMessage(CaneRequest)

CaneReply = _reflection.GeneratedProtocolMessageType('CaneReply', (_message.Message,), dict(
  DESCRIPTOR = _CANEREPLY,
  __module__ = 'vision_pb2'
  # @@protoc_insertion_point(class_scope:helloworld.CaneReply)
  ))
_sym_db.RegisterMessage(CaneReply)

AppRequest = _reflection.GeneratedProtocolMessageType('AppRequest', (_message.Message,), dict(
  DESCRIPTOR = _APPREQUEST,
  __module__ = 'vision_pb2'
  # @@protoc_insertion_point(class_scope:helloworld.AppRequest)
  ))
_sym_db.RegisterMessage(AppRequest)

AppReply = _reflection.GeneratedProtocolMessageType('AppReply', (_message.Message,), dict(
  DESCRIPTOR = _APPREPLY,
  __module__ = 'vision_pb2'
  # @@protoc_insertion_point(class_scope:helloworld.AppReply)
  ))
_sym_db.RegisterMessage(AppReply)



_VISIONMICROSERVICE = _descriptor.ServiceDescriptor(
  name='VisionMicroservice',
  full_name='helloworld.VisionMicroservice',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  serialized_start=190,
  serialized_end=331,
  methods=[
  _descriptor.MethodDescriptor(
    name='AppCall',
    full_name='helloworld.VisionMicroservice.AppCall',
    index=0,
    containing_service=None,
    input_type=_APPREQUEST,
    output_type=_APPREPLY,
    serialized_options=None,
  ),
  _descriptor.MethodDescriptor(
    name='CaneCall',
    full_name='helloworld.VisionMicroservice.CaneCall',
    index=1,
    containing_service=None,
    input_type=_CANEREQUEST,
    output_type=_CANEREPLY,
    serialized_options=None,
  ),
])
_sym_db.RegisterServiceDescriptor(_VISIONMICROSERVICE)

DESCRIPTOR.services_by_name['VisionMicroservice'] = _VISIONMICROSERVICE

# @@protoc_insertion_point(module_scope)