import 'package:flutter/material.dart';
import 'package:gest_school_fluter/core/components/widget.appBar.dart';
import 'package:gest_school_fluter/core/components/widget.drawer.dart';
import 'package:gest_school_fluter/core/services/security_service.dart';
import 'package:qr_flutter/qr_flutter.dart';

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
    dynamic data = {
      "idSession": arguments['idSession'],
      "idUser": SecurityService.userConnect!.id
    };
    bool emarge = false;
    return Scaffold(
      appBar: MyAppBar(
        title: "Émargement",
      ),
      drawer: MyDrawer(),
      body: SafeArea(
        child: SingleChildScrollView(
          child: Container(
            width: MediaQuery.of(context).size.width,
            height: MediaQuery.of(context).size.height,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                QrImageView(
                  data: "$data",
                  version: QrVersions.auto,
                  size: 250.0,
                ),
                SizedBox(
                  height: 20,
                ),
                if (emarge == true)
                  ElevatedButton(
                      onPressed: () {
                        setState(() {
                          emarge = true;
                        });
                      },
                      child: Text("émarger"))
              ],
            ),
          ),
        ),
      ),
    );
  }
}
