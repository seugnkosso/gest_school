import 'package:flutter/material.dart';
import 'package:gest_school_fluter/core/components/widget.appBar.dart';
import 'package:gest_school_fluter/core/components/widget.drawer.dart';

class Emargementpage extends StatefulWidget {
  const Emargementpage({super.key});
  static String routeName = '/emargementPage';

  @override
  State<Emargementpage> createState() => _EmargementpageState();
}

class _EmargementpageState extends State<Emargementpage> {
  @override
  Widget build(BuildContext context) {
    dynamic arguments = ModalRoute.of(context)!.settings.arguments;
    return Scaffold(
        appBar: MyAppBar(
          title: "Émargement",
        ),
        drawer: MyDrawer(),
        body: SafeArea(
          child: SingleChildScrollView(
            child: Text(arguments["idSession"].toString()),
          ),
        ));
  }
}
