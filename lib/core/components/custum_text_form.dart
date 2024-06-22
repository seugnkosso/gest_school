import 'package:flutter/material.dart';

class CustumTextField extends StatelessWidget {
  TextEditingController controller;
  String placeholder;
  bool obscurText;
  final String? Function(String?)? validator;
  CustumTextField({
    super.key,
    required this.controller,
    required this.placeholder,
    required this.validator,
    this.obscurText = false,
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
          color: Colors.white, borderRadius: BorderRadius.circular(5)),
      child: Padding(
        padding: EdgeInsets.all(5.0),
        child: TextFormField(
          controller: controller,
          validator: validator,
          obscureText: obscurText,
          obscuringCharacter: "*",
          decoration: InputDecoration.collapsed(
              fillColor: Colors.transparent,
              hintText: placeholder,
              hintStyle: TextStyle(fontSize: 23)),
        ),
      ),
    );
  }
}
