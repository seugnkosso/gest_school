import 'package:flutter/material.dart';

class MyAppBar extends StatefulWidget implements PreferredSizeWidget {
  String title;
  MyAppBar({super.key, required this.title});

  @override
  State<MyAppBar> createState() => _myAppBarState();
  @override
  Size get preferredSize => const Size.fromHeight(kToolbarHeight);
}

class _myAppBarState extends State<MyAppBar> {
  @override
  Widget build(BuildContext context) {
    return AppBar(
      title: Text(
        widget.title,
        style: TextStyle(color: Colors.white),
      ),
      backgroundColor: Color.fromARGB(255, 107, 66, 4),
    );
  }
}
