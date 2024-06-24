import 'dart:convert';

// ignore_for_file: public_member_api_docs, sort_constructors_first

class Cour {
  int id;
  int nbrHeure;
  bool isValider;
  String professeur;
  String semestre;
  String module;
  String listeClasse;
  Cour({
    required this.id,
    required this.nbrHeure,
    required this.isValider,
    required this.professeur,
    required this.semestre,
    required this.module,
    required this.listeClasse,
  });

  Cour copyWith({
    int? id,
    int? nbrHeure,
    bool? isValider,
    String? professeur,
    String? semestre,
    String? module,
    String? listeClasse,
  }) {
    return Cour(
      id: id ?? this.id,
      nbrHeure: nbrHeure ?? this.nbrHeure,
      isValider: isValider ?? this.isValider,
      professeur: professeur ?? this.professeur,
      semestre: semestre ?? this.semestre,
      module: module ?? this.module,
      listeClasse: listeClasse ?? this.listeClasse,
    );
  }

  Map<String, dynamic> toMap() {
    return <String, dynamic>{
      'id': id,
      'nbrHeure': nbrHeure,
      'isValider': isValider,
      'professeur': professeur,
      'semestre': semestre,
      'module': module,
      'listeClasse': listeClasse,
    };
  }

  factory Cour.fromMap(Map<String, dynamic> map) {
    return Cour(
      id: map['id'] as int,
      nbrHeure: map['nbrHeure'] as int,
      isValider: map['isValider'] as bool,
      professeur: map['professeur'] as String,
      semestre: map['semestre'] as String,
      module: map['module'] as String,
      listeClasse: map['listeClasse'] as String,
    );
  }

  String toJson() => json.encode(toMap());

  factory Cour.fromJson(String source) =>
      Cour.fromMap(json.decode(source) as Map<String, dynamic>);

  @override
  String toString() {
    return 'Cour(id: $id, nbrHeure: $nbrHeure, isValider: $isValider, professeur: $professeur, semestre: $semestre, module: $module, listeClasse: $listeClasse)';
  }

  @override
  bool operator ==(covariant Cour other) {
    if (identical(this, other)) return true;

    return other.id == id &&
        other.nbrHeure == nbrHeure &&
        other.isValider == isValider &&
        other.professeur == professeur &&
        other.semestre == semestre &&
        other.module == module &&
        other.listeClasse == listeClasse;
  }

  @override
  int get hashCode {
    return id.hashCode ^
        nbrHeure.hashCode ^
        isValider.hashCode ^
        professeur.hashCode ^
        semestre.hashCode ^
        module.hashCode ^
        listeClasse.hashCode;
  }
}
