// ignore_for_file: public_member_api_docs, sort_constructors_first
import 'dart:convert';

class JustificationModel {
  int idAbsence;
  String motif;
  JustificationModel({
    required this.idAbsence,
    required this.motif,
  });

  JustificationModel copyWith({
    int? idAbsence,
    String? motif,
  }) {
    return JustificationModel(
      idAbsence: idAbsence ?? this.idAbsence,
      motif: motif ?? this.motif,
    );
  }

  Map<String, dynamic> toMap() {
    return <String, dynamic>{
      'idAbsence': idAbsence,
      'motif': motif,
    };
  }

  factory JustificationModel.fromMap(Map<String, dynamic> map) {
    return JustificationModel(
      idAbsence: map['idAbsence'] as int,
      motif: map['motif'] as String,
    );
  }

  String toJson() => json.encode(toMap());

  factory JustificationModel.fromJson(String source) =>
      JustificationModel.fromMap(json.decode(source) as Map<String, dynamic>);

  @override
  String toString() =>
      'JustificationModel(idAbsence: $idAbsence, motif: $motif)';

  @override
  bool operator ==(covariant JustificationModel other) {
    if (identical(this, other)) return true;

    return other.idAbsence == idAbsence && other.motif == motif;
  }

  @override
  int get hashCode => idAbsence.hashCode ^ motif.hashCode;
}
