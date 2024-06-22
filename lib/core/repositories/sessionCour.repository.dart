import 'package:dio/dio.dart';
import 'package:gest_school_fluter/core/constantes/api.constante.dart';
import 'package:gest_school_fluter/core/modals/sessionCour.modal.dart';

class SessionCourRepository {
  static const url = "$APIURL/sessionCours";
  static Dio dio = Dio();
  Future<List<SessionCour>> findAllByCour(String idCour) async {
    final response = await dio.get(url + "/cour/" + idCour);

    if (response.statusCode == 200) {
      List<dynamic> datas = response.data['results'];
      List<SessionCour> sessionCourList = [];
      for (var map in datas) {
        sessionCourList.add(SessionCour.fromMap(map));
      }
      return sessionCourList;
    } else {
      throw Exception;
    }
  }
}
