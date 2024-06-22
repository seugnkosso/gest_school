// ignore_for_file: public_member_api_docs, sort_constructors_first
import 'dart:convert';

import 'package:flutter/foundation.dart';

class LoginResponseModel {
  final int id;
  final String token;
  final String username;
  final List<String> roles;
  LoginResponseModel({
    required this.id,
    required this.token,
    required this.username,
    required this.roles,
  });

  LoginResponseModel copyWith({
    int? id,
    String? token,
    String? username,
    List<String>? roles,
  }) {
    return LoginResponseModel(
      id: id ?? this.id,
      token: token ?? this.token,
      username: username ?? this.username,
      roles: roles ?? this.roles,
    );
  }

  Map<String, dynamic> toMap() {
    return <String, dynamic>{
      'id': id,
      'token': token,
      'username': username,
      'roles': roles,
    };
  }

  factory LoginResponseModel.fromMap(Map<String, dynamic> map) {
    return LoginResponseModel(
      id: map['id'] as int,
      token: map['token'] as String,
      username: map['username'] as String,
      roles: [],
      // List<String>.from((map['roles'] as List<String>),
    );
  }

  String toJson() => json.encode(toMap());

  factory LoginResponseModel.fromJson(String source) =>
      LoginResponseModel.fromMap(json.decode(source) as Map<String, dynamic>);

  @override
  String toString() {
    return 'LoginResponseModel(id: $id, token: $token, username: $username, roles: $roles)';
  }

  @override
  bool operator ==(covariant LoginResponseModel other) {
    if (identical(this, other)) return true;

    return other.id == id &&
        other.token == token &&
        other.username == username &&
        listEquals(other.roles, roles);
  }

  @override
  int get hashCode {
    return id.hashCode ^ token.hashCode ^ username.hashCode ^ roles.hashCode;
  }
}
