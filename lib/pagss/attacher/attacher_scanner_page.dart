import 'package:flutter/material.dart';
import 'package:gest_school_fluter/core/components/widget.appBar.dart';
import 'package:gest_school_fluter/core/components/widget.drawer.dart';

class ScannerPage extends StatefulWidget {
  const ScannerPage({super.key});
  static String routeName = "/scannerPage";
  @override
  State<ScannerPage> createState() => _ScannerPageState();
}

class _ScannerPageState extends State<ScannerPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: MyAppBar(
        title: "Scanner",
      ),
      drawer: MyDrawer(),
      body: SafeArea(
        child: SingleChildScrollView(
          child: SizedBox(
            height: MediaQuery.of(context).size.height,
            width: MediaQuery.of(context).size.width,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                ElevatedButton(
                  onPressed: () {},
                  child: Text("Click me"),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
