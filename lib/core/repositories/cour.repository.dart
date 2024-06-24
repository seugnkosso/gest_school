import 'package:dio/dio.dart';
import 'package:gest_school_fluter/core/constantes/api.constante.dart';
import 'package:gest_school_fluter/core/models/cour.modal.dart';
import 'package:gest_school_fluter/core/services/security_service.dart';

class CourRepository {
  static const url = "$APIURL/cours";
  static Dio dio = Dio();
  Future<List<Cour>> findAll() async {
    final response = await dio
        .get(url + "?idUser=" + SecurityService.userConnect!.id.toString());

    if (response.statusCode == 200) {
      List<dynamic> datas = response.data['results'];
      List<Cour> courList = [];
      for (var map in datas) {
        courList.add(Cour.fromMap(map));
      }
      return courList;
    } else {
      throw Exception;
    }
  }
}
