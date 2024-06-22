import 'package:flutter/material.dart';
import 'package:gest_school_fluter/core/components/custum_text_form.dart';
import 'package:gest_school_fluter/core/components/widget.appBar.dart';
import 'package:gest_school_fluter/core/components/widget.drawer.dart';
import 'package:gest_school_fluter/core/modals/justication.model.dart';
import 'package:gest_school_fluter/core/services/absence.service.dart';
import 'package:gest_school_fluter/pagss/absence/absence.page.dart';

class JustificationPage extends StatefulWidget {
  static String routeName = '/justification';
  const JustificationPage({super.key});

  @override
  State<JustificationPage> createState() => _JustificationpageState();
}

class _JustificationpageState extends State<JustificationPage> {
  final _formKeyMotif = GlobalKey<FormState>();
  final TextEditingController _controllerMotif = TextEditingController();
  @override
  Widget build(BuildContext context) {
    dynamic arguments = ModalRoute.of(context)!.settings.arguments;
    return Scaffold(
      appBar: MyAppBar(title: "justification"),
      drawer: MyDrawer(),
      body: SafeArea(
        child: SingleChildScrollView(
          // SCREEN ON
          child: SizedBox(
            width: MediaQuery.of(context).size.width,
            height: MediaQuery.of(context).size.height,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                // DIV FORMULAIRE ON
                Container(
                  decoration: BoxDecoration(
                      border: Border.all(
                        width: 2,
                        color: Colors.orange.shade300,
                      ),
                      color: Colors.orange.shade100,
                      borderRadius: BorderRadius.circular(18)),
                  width: MediaQuery.of(context).size.width * 0.9,
                  height: MediaQuery.of(context).size.height * 0.3,
                  child: Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 10),
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.center,
                      crossAxisAlignment: CrossAxisAlignment.center,
                      children: [
                        // FORMULAIRE ON
                        Form(
                          key: _formKeyMotif,
                          child: Column(children: [
                            const Text(
                              "justification",
                              style: TextStyle(
                                  color: Colors.black,
                                  fontSize: 25.5,
                                  fontWeight: FontWeight.bold),
                            ),
                            const SizedBox(
                              height: 40,
                            ),
                            CustumTextField(
                              controller: _controllerMotif,
                              placeholder: "Motif",
                              validator: (value) {
                                if (value == null || value.isEmpty) {
                                  return "le motif est obligatoire";
                                }
                              },
                            ),
                            // BUTTON FIELD ON
                            const SizedBox(
                              height: 25,
                            ),
                            Container(
                              width: double.infinity,
                              child: ElevatedButton(
                                onPressed: () async {
                                  if (_formKeyMotif.currentState!.validate()) {
                                    _formKeyMotif.currentState!.save();
                                    JustificationModel justificationModel =
                                        JustificationModel(
                                      idAbsence: arguments['abcence'],
                                      motif: _controllerMotif.text,
                                    );
                                    print(arguments['abcence']);

                                    await AbsenceService.justifier(
                                      justificationModel,
                                    );
                                    Navigator.pop(context);
                                    Navigator.pushNamed(
                                        context, AbsencePage.routeName);
                                  }
                                },
                                child: const Text(
                                  "envoyer",
                                  style: TextStyle(fontSize: 25),
                                ),
                              ),
                            ),
                            // BUTTON FIELD OFF
                          ]),
                        ),
                        // FORMULAIRE OFF
                      ],
                    ),
                  ),
                ),
                // DIV FORMULAIRE OFF
              ],
            ),
          ),
          // SCREEN OFF
        ),
      ),
    );
  }
}
