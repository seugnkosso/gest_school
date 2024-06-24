import 'package:flutter/material.dart';
import 'package:gest_school_fluter/core/components/widget.appBar.dart';
import 'package:gest_school_fluter/core/components/widget.drawer.dart';
// import 'package:qr_bar_code_scanner_dialog/qr_bar_code_scanner_dialog.dart';

class ScannerPage extends StatefulWidget {
  const ScannerPage({super.key});
  static String routeName = "/scannerPage";
  @override
  State<ScannerPage> createState() => _ScannerPageState();
}

class _ScannerPageState extends State<ScannerPage> {
  // final _qrBarCodeScannerDialogPlugin = QrBarCodeScannerDialog();
  String? code;
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
                  onPressed: () {
                    // _qrBarCodeScannerDialogPlugin.getScannedQrBarCode(
                    //     context: context,
                    //     onCode: (code) {
                    //       setState(() {
                    //         this.code = code;
                    //       });
                    //     });
                  },
                  child: Text(code ?? "Click me"),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
