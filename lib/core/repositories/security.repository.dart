import 'package:dio/dio.dart';
import 'package:gest_school_fluter/core/constantes/api.constante.dart';
import 'package:gest_school_fluter/core/models/login_model.dart';
import 'package:gest_school_fluter/core/models/login_response_model.dart';

class SecurityRepository {
  static const url = "$APIURL/login";
  static Dio dio = Dio();

  static Future<LoginResponseModel?> findUserByusernameAndpassword(
      LoginModel loginModel) async {
    final response = await dio.post(
      url,
      data: loginModel.toJson(),
      options: Options(
          followRedirects: false,
          validateStatus: (status) {
            return status! < 500;
          },
          headers: {Headers.contentTypeHeader: "application/json"}),
    );

    if (response.statusCode == 200) {
      dynamic datas = response.data['results'];
      return LoginResponseModel.fromMap(datas);
    } else {
      return null;
    }
  }
}
