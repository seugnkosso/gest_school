import 'package:flutter/material.dart';
import 'package:gest_school_fluter/core/services/security_service.dart';
import 'package:gest_school_fluter/pagss/absence/absence.page.dart';
import 'package:gest_school_fluter/pagss/home/home.page.dart';
import 'package:gest_school_fluter/pagss/login/login.page.dart';

class MyDrawer extends StatefulWidget {
  MyDrawer({super.key});

  @override
  State<MyDrawer> createState() => _myAppBarState();
}

class _myAppBarState extends State<MyDrawer> {
  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(
        padding: EdgeInsets.zero,
        children: [
          const DrawerHeader(
              decoration: BoxDecoration(
                color: Color.fromARGB(255, 94, 34, 1),
              ),
              child: Text(
                "user",
                style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                    color: Colors.white),
              )),
          ListTile(
            leading: const Icon(Icons.school_rounded),
            title: const Text('Cours'),
            onTap: () {
              Navigator.pop(context);
              Navigator.pushNamed(context, HomePage.routeName);
            },
          ),
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
              SecurityService.userConnect = null;
              Navigator.pop(context);
              Navigator.pushNamed(context, LoginOrResgister.routeName);
            },
          ),
        ],
      ),
    );
  }
}
