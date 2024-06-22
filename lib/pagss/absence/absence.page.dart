import 'package:flutter/material.dart';
import 'package:gest_school_fluter/core/components/widget.appBar.dart';
import 'package:gest_school_fluter/core/components/widget.drawer.dart';
import 'package:gest_school_fluter/core/modals/absence.modal.dart';
import 'package:gest_school_fluter/core/services/absence.service.dart';
import 'package:gest_school_fluter/pagss/absence/components/absence.list.dart';

class AbsencePage extends StatelessWidget {
  static String routeName = "/absences";
  const AbsencePage({super.key});

  @override
  Widget build(BuildContext context) {
    Future<List<Absence>> absenceListFuture = AbsenceService.findAll();
    return Scaffold(
        appBar: MyAppBar(
          title: "Absences",
        ),
        drawer: MyDrawer(),
        body: SafeArea(
          child: SingleChildScrollView(
            child:
                Column(mainAxisAlignment: MainAxisAlignment.start, children: [
              const SizedBox(
                height: 20,
              ),
              AbsenceList(abcencelist: absenceListFuture)
            ]),
          ),
        ));
  }
}
