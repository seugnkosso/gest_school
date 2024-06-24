import 'package:gest_school_fluter/core/models/cour.modal.dart';
import 'package:gest_school_fluter/core/repositories/cour.repository.dart';

class CourService {
  static CourRepository courRepository = CourRepository();
  static Future<List<Cour>> findAll() async {
    return await courRepository.findAll();
  }
}
