import 'package:flutter/material.dart';
import 'package:gest_school_fluter/core/components/widget.appBar.dart';
import 'package:gest_school_fluter/core/components/widget.drawer.dart';
import 'package:gest_school_fluter/core/modals/cour.modal.dart';
import 'package:gest_school_fluter/core/services/cour.service.dart';
import 'package:gest_school_fluter/pagss/home/components/cour.liste.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});
  static String routeName = "/home";
  @override
  Widget build(BuildContext context) {
    Future<List<Cour>> courFuture = CourService.findAll();
    return Scaffold(
        appBar: MyAppBar(
          title: "Cours",
        ),
        drawer: MyDrawer(),
        body: SafeArea(
          child: SingleChildScrollView(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              children: [
                const Padding(
                  padding: EdgeInsets.all(10),
                  child: SizedBox(
                      width: double.infinity,
                      child: Text(
                        "Cours",
                        style: TextStyle(
                            color: Color.fromARGB(255, 76, 76, 76),
                            fontSize: 30,
                            fontWeight: FontWeight.bold),
                        textAlign: TextAlign.center,
                      )),
                ),
                CourList(listCour: courFuture)
              ],
            ),
          ),
        ));
  }
}
