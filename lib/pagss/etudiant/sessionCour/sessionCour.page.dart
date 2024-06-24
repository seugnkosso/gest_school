import 'package:flutter/material.dart';
import 'package:gest_school_fluter/core/components/widget.appBar.dart';
import 'package:gest_school_fluter/core/components/widget.drawer.dart';
import 'package:gest_school_fluter/core/models/sessionCour.modal.dart';
import 'package:gest_school_fluter/core/services/sessionCour.service.dart';
import 'package:gest_school_fluter/pagss/etudiant/sessionCour/components/sessionCour.list.dart';

class SessionCourPage extends StatelessWidget {
  static String routeName = "/sessionCour";
  const SessionCourPage({super.key});

  @override
  Widget build(BuildContext context) {
    final String id = ModalRoute.of(context)!.settings.arguments.toString();
    Future<List<SessionCour>> sessionCourFuture =
        SessionCourService.findAll(id);
    return Scaffold(
        appBar: MyAppBar(
          title: "Session cours",
        ),
        drawer: MyDrawer(),
        body: SafeArea(
          child: SingleChildScrollView(
            child:
                Column(mainAxisAlignment: MainAxisAlignment.start, children: [
              SizedBox(
                height: 20,
              ),
              listSessionCour(sessionCours: sessionCourFuture),
            ]),
          ),
        ));
  }
}
