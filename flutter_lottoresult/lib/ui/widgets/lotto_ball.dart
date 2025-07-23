import 'package:flutter/material.dart';
import 'package:flutter_lottoresult/system/extensions/color_extensions.dart';

class LottoBall extends StatelessWidget {
  final int number;
  final bool leftMargin;
  const LottoBall({super.key, required this.number, required this.leftMargin});
  static final List<Color> _backColors = [
    HexColorExtension.hexToColor("#c99d01"),
    HexColorExtension.hexToColor("#0c6389"),
    HexColorExtension.hexToColor("#880200"),
    HexColorExtension.hexToColor("#474e50"),
    HexColorExtension.hexToColor("#637619"),
  ];

  @override
  Widget build(BuildContext context) {
    final bgColor = (number / 10).toInt();
    return Center(
      child: Container(
        width: 64,
        height: 64,
        margin: EdgeInsets.only(left: leftMargin ? 20.0 : 0),
        decoration: BoxDecoration(color: _backColors[bgColor], shape: BoxShape.circle),
        child: Center(
          child: Text(
            "$number",
            textAlign: TextAlign.center,
            style: TextStyle(color: Colors.white, fontSize: 25.0, decoration: TextDecoration.none),
          ),
        ),
      ),
    );
  }
}
