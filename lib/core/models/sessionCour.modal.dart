import 'dart:convert';

// ignore_for_file: public_member_api_docs, sort_constructors_first

class SessionCour {
  int id;
  String date;
  String heureDebutFin;
  String salle;
  String etat;
  bool start;
  SessionCour({
    required this.id,
    required this.date,
    required this.heureDebutFin,
    required this.salle,
    required this.etat,
    required this.start,
  });

  SessionCour copyWith({
    int? id,
    String? date,
    String? heureDebutFin,
    String? salle,
    String? etat,
    bool? start,
  }) {
    return SessionCour(
      id: id ?? this.id,
      date: date ?? this.date,
      heureDebutFin: heureDebutFin ?? this.heureDebutFin,
      salle: salle ?? this.salle,
      etat: etat ?? this.etat,
      start: start ?? this.start,
    );
  }

  Map<String, dynamic> toMap() {
    return <String, dynamic>{
      'id': id,
      'date': date,
      'heureDebutFin': heureDebutFin,
      'salle': salle,
      'etat': etat,
      'start': start,
    };
  }

  factory SessionCour.fromMap(Map<String, dynamic> map) {
    return SessionCour(
      id: map['id'] as int,
      date: map['date'] as String,
      heureDebutFin: map['heureDebutFin'] as String,
      salle: map['salle'] as String,
      etat: map['etat'] as String,
      start: map['start'] as bool,
    );
  }

  String toJson() => json.encode(toMap());

  factory SessionCour.fromJson(String source) =>
      SessionCour.fromMap(json.decode(source) as Map<String, dynamic>);

  @override
  String toString() {
    return 'SessionCour(id: $id, date: $date, heureDebutFin: $heureDebutFin, salle: $salle, etat: $etat, start: $start)';
  }

  @override
  bool operator ==(covariant SessionCour other) {
    if (identical(this, other)) return true;

    return other.id == id &&
        other.date == date &&
        other.heureDebutFin == heureDebutFin &&
        other.salle == salle &&
        other.etat == etat &&
        other.start == start;
  }

  @override
  int get hashCode {
    return id.hashCode ^
        date.hashCode ^
        heureDebutFin.hashCode ^
        salle.hashCode ^
        etat.hashCode ^
        start.hashCode;
  }
}
