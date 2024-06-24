import 'package:gest_school_fluter/core/models/login_model.dart';
import 'package:gest_school_fluter/core/models/login_response_model.dart';
import 'package:gest_school_fluter/core/repositories/security.repository.dart';

class SecurityService {
  static LoginResponseModel? userConnect;
  static Future<void> getUserConnect(LoginModel loginModel) async {
    userConnect =
        await SecurityRepository.findUserByusernameAndpassword(loginModel);
  }
}
