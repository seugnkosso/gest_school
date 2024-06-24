import 'package:flutter/material.dart';
import 'package:gest_school_fluter/pagss/attacher/attacher_scanner_page.dart';
import 'package:gest_school_fluter/pagss/etudiant/absence/absence.page.dart';
import 'package:gest_school_fluter/pagss/etudiant/absence/justification_page.dart';
import 'package:gest_school_fluter/pagss/etudiant/home/home.page.dart';
import 'package:gest_school_fluter/pagss/etudiant/sessionCour/emargement_page.dart';
import 'package:gest_school_fluter/pagss/etudiant/sessionCour/sessionCour.page.dart';
import 'package:gest_school_fluter/pagss/login/login.page.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        title: 'Flutter Demo',
        theme: ThemeData(
          colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepOrangeAccent),
          useMaterial3: true,
        ),
        initialRoute: '/loginOrResgister',
        routes: {
          '/home': (context) => const HomePage(),
          '/sessionCour': (context) => const SessionCourPage(),
          '/absences': (context) => const AbsencePage(),
          '/justification': (context) => const JustificationPage(),
          '/loginOrResgister': (context) => const LoginOrResgister(),
          '/emargementPage': (context) => const Emargementpage(),
          '/scannerPage': (context) => const ScannerPage(),
        },
        home: const LoginOrResgister());
  }
}
