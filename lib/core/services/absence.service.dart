import 'package:gest_school_fluter/core/models/absence.modal.dart';
import 'package:gest_school_fluter/core/models/justication.model.dart';
import 'package:gest_school_fluter/core/repositories/absence.repository.dart';

class AbsenceService {
  static AbsenceRepository absenceRepository = AbsenceRepository();
  static Future<List<Absence>> findAll() async {
    return await absenceRepository.findAll();
  }

  static Future<JustificationModel?> justifier(
      JustificationModel justificationModel) async {
    return await absenceRepository.justifier(justificationModel);
  }
}
