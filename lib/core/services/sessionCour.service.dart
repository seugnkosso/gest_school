import 'package:gest_school_fluter/core/models/sessionCour.modal.dart';
import 'package:gest_school_fluter/core/repositories/sessionCour.repository.dart';

class SessionCourService {
  static SessionCourRepository sessionCourRepository = SessionCourRepository();
  static Future<List<SessionCour>> findAll(String idCour) async {
    return await sessionCourRepository.findAllByCour(idCour);
  }
}
