import 'package:dio/dio.dart';
import 'package:gest_school_fluter/core/constantes/api.constante.dart';
import 'package:gest_school_fluter/core/models/absence.modal.dart';
import 'package:gest_school_fluter/core/models/justication.model.dart';
import 'package:gest_school_fluter/core/services/security_service.dart';

class AbsenceRepository {
  static const url = "$APIURL/absences";
  static Dio dio = Dio();
  Future<List<Absence>> findAll() async {
    final response =
        await dio.get("$url?idUser=${SecurityService.userConnect!.id}");
    if (response.statusCode == 200) {
      List<dynamic> datas = response.data['results'];
      List<Absence> absenceList = [];
      for (var map in datas) {
        absenceList.add(Absence.fromMap(map));
      }
      return absenceList;
    } else {
      throw Exception;
    }
  }

  Future<JustificationModel?> justifier(
      JustificationModel justificationModel) async {
    final response = await dio.post(
      url + "/justification",
      data: justificationModel.toJson(),
      options: Options(
          followRedirects: false,
          validateStatus: (status) {
            return status! < 500;
          },
          headers: {Headers.contentTypeHeader: "application/json"}),
    );
  }
}
