import 'package:flutter/material.dart';
import 'package:gest_school_fluter/pagss/absence/absence.page.dart';
import 'package:gest_school_fluter/pagss/absence/justification_page.dart';
import 'package:gest_school_fluter/pagss/home/home.page.dart';
import 'package:gest_school_fluter/pagss/login/login.page.dart';
import 'package:gest_school_fluter/pagss/sessionCour/emargement_page.dart';
import 'package:gest_school_fluter/pagss/sessionCour/sessionCour.page.dart';

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
        },
        home: const LoginOrResgister());
  }
}
