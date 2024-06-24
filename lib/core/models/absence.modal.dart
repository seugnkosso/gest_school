import 'dart:convert';

// ignore_for_file: public_member_api_docs, sort_constructors_first

class Absence {
  int id;
  String date;
  String cour;
  bool isValider;
  String motif;
  Absence({
    required this.id,
    required this.date,
    required this.cour,
    required this.isValider,
    required this.motif,
  });

  Absence copyWith({
    int? id,
    String? date,
    String? cour,
    bool? isValider,
    String? motif,
  }) {
    return Absence(
      id: id ?? this.id,
      date: date ?? this.date,
      cour: cour ?? this.cour,
      isValider: isValider ?? this.isValider,
      motif: motif ?? this.motif,
    );
  }

  Map<String, dynamic> toMap() {
    return <String, dynamic>{
      'id': id,
      'date': date,
      'cour': cour,
      'isValider': isValider,
      'motif': motif,
    };
  }

  factory Absence.fromMap(Map<String, dynamic> map) {
    return Absence(
      id: map['id'] as int,
      date: map['date'] as String,
      cour: map['cour'] as String,
      isValider: map['isValider'] as bool,
      motif: map['motif'] as String,
    );
  }

  String toJson() => json.encode(toMap());

  factory Absence.fromJson(String source) =>
      Absence.fromMap(json.decode(source) as Map<String, dynamic>);

  @override
  String toString() {
    return 'Absence(id: $id, date: $date, cour: $cour, isValider: $isValider, motif: $motif)';
  }

  @override
  bool operator ==(covariant Absence other) {
    if (identical(this, other)) return true;

    return other.id == id &&
        other.date == date &&
        other.cour == cour &&
        other.isValider == isValider &&
        other.motif == motif;
  }

  @override
  int get hashCode {
    return id.hashCode ^
        date.hashCode ^
        cour.hashCode ^
        isValider.hashCode ^
        motif.hashCode;
  }
}
