import 'package:flutter/material.dart';
import 'package:gest_school_fluter/core/services/security_service.dart';
import 'package:gest_school_fluter/pagss/etudiant/absence/absence.page.dart';
import 'package:gest_school_fluter/pagss/etudiant/home/home.page.dart';
import 'package:gest_school_fluter/pagss/login/login.page.dart';

class MyDrawer extends StatefulWidget {
  MyDrawer({super.key});

  @override
  State<MyDrawer> createState() => _myAppBarState();
}

class _myAppBarState extends State<MyDrawer> {
  String user = SecurityService.userConnect!.username;
  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(
        padding: EdgeInsets.zero,
        children: [
          DrawerHeader(
              decoration: const BoxDecoration(
                color: Color.fromARGB(255, 94, 34, 1),
              ),
              child: Text(
                user,
                style: const TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                    color: Colors.white),
              )),
          if (SecurityService.userConnect!.roles.contains("Etudiant"))
            ListTile(
              leading: const Icon(Icons.school_rounded),
              title: const Text('Cours'),
              onTap: () {
                Navigator.pop(context);
                Navigator.pushNamed(context, HomePage.routeName);
              },
            ),
          if (SecurityService.userConnect!.roles.contains("Etudiant"))
            ListTile(
              leading: Icon(Icons.access_time),
              title: const Text('absences'),
              onTap: () {
                Navigator.pop(context);
                Navigator.pushNamed(context, AbsencePage.routeName);
              },
            ),
          ListTile(
            leading: const Icon(Icons.logout_rounded),
            title: const Text('Déconexion'),
            onTap: () {
              Navigator.pop(context);
              Navigator.pushNamed(context, LoginOrResgister.routeName);
              // SecurityService.userConnect = null;
            },
          ),
        ],
      ),
    );
  }
}
