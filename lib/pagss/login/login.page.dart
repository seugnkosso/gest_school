import 'package:flutter/material.dart';
import 'package:gest_school_fluter/core/components/custum_text_form.dart';
import 'package:gest_school_fluter/core/models/login_model.dart';
import 'package:gest_school_fluter/core/services/security_service.dart';
import 'package:gest_school_fluter/pagss/attacher/attacher_scanner_page.dart';
import 'package:gest_school_fluter/pagss/etudiant/home/home.page.dart';

class LoginOrResgister extends StatefulWidget {
  static String routeName = "/loginOrResgister";
  const LoginOrResgister({super.key});

  @override
  State<LoginOrResgister> createState() => _LoginOrResgisterState();
}

class _LoginOrResgisterState extends State<LoginOrResgister> {
  final _formKey = GlobalKey<FormState>();
  final TextEditingController _controllerUsername = TextEditingController();
  final TextEditingController _controllerPassword = TextEditingController();
  String errorMessage = "";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: SingleChildScrollView(
          child: Container(
            height: MediaQuery.of(context).size.height,
            width: MediaQuery.of(context).size.width,
            child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Container(
                    height: MediaQuery.of(context).size.height * 0.45,
                    width: MediaQuery.of(context).size.width * 0.9,
                    decoration: BoxDecoration(
                        border: Border.all(
                          width: 2,
                          color: Colors.orange.shade300,
                        ),
                        color: Colors.orange.shade200,
                        borderRadius: BorderRadius.circular(18)),
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.center,
                      crossAxisAlignment: CrossAxisAlignment.center,
                      children: [
                        Form(
                            key: _formKey,
                            child: Container(
                              width: MediaQuery.of(context).size.width * 0.7,
                              child: Column(
                                children: [
                                  const Text(
                                    "Formulaire de connexion",
                                    style: TextStyle(
                                        color:
                                            Color.fromARGB(255, 126, 102, 14),
                                        fontSize: 20,
                                        fontWeight: FontWeight.bold),
                                  ),
                                  const SizedBox(
                                    height: 10,
                                  ),
                                  Text(
                                    errorMessage,
                                    style: TextStyle(
                                        color: Colors.red.shade900,
                                        fontSize: 18.5,
                                        fontWeight: FontWeight.bold),
                                  ),
                                  // USERNAME FIELD ON
                                  const SizedBox(
                                    height: 10,
                                  ),
                                  CustumTextField(
                                    controller: _controllerUsername,
                                    placeholder: "username",
                                    validator: (value) {
                                      if (value == null || value.isEmpty) {
                                        return "username est obligatoire";
                                      }
                                    },
                                  ),
                                  // USERNAME FIELD ON
                                  // PASSWORD FIELD ON
                                  const SizedBox(
                                    height: 20,
                                  ),
                                  CustumTextField(
                                    controller: _controllerPassword,
                                    placeholder: "password",
                                    obscurText: true,
                                    validator: (value) {
                                      if (value == null || value.isEmpty) {
                                        return "password est obligatoire";
                                      }
                                    },
                                  ),
                                  // PASSWORD FIELD ON
                                  // BUTTON FIELD ON
                                  const SizedBox(
                                    height: 25,
                                  ),
                                  Container(
                                    width: double.infinity,
                                    child: ElevatedButton(
                                      onPressed: () async {
                                        if (_formKey.currentState!.validate()) {
                                          _formKey.currentState!.save();
                                          LoginModel loginModel = LoginModel(
                                            username: _controllerUsername.text,
                                            password: _controllerPassword.text,
                                          );
                                          await SecurityService.getUserConnect(
                                            loginModel,
                                          );
                                          if (SecurityService.userConnect !=
                                              null) {
                                            if (SecurityService
                                                .userConnect!.roles
                                                .contains("Etudiant")) {
                                              Navigator.pop(context);
                                              Navigator.pushNamed(
                                                  context, HomePage.routeName);
                                            } else if (SecurityService
                                                .userConnect!.roles
                                                .contains("Attacher")) {
                                              Navigator.pop(context);
                                              Navigator.pushNamed(context,
                                                  ScannerPage.routeName);
                                            } else {
                                              setState(() {
                                                errorMessage =
                                                    "vous n'avez les droits";
                                              });
                                            }
                                          } else {
                                            setState(() {
                                              errorMessage =
                                                  "username ou password incorrect";
                                            });
                                          }
                                        }
                                      },
                                      child: const Text(
                                        "connexion",
                                        style: TextStyle(fontSize: 25),
                                      ),
                                    ),
                                  )
                                  // BUTTON FIELD ON
                                ],
                              ),
                            ))
                      ],
                    ),
                  )
                ]),
          ),
        ),
      ),
    );
  }
}
