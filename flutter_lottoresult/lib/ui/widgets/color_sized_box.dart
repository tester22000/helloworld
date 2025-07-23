import 'package:flutter/material.dart';

class ColorSizedBox extends StatelessWidget {
  final Color color;
  final double? width;
  final double? height;

  const ColorSizedBox({required this.color, this.width, this.height});

  @override
  Widget build(BuildContext context) {
    return ColoredBox(
      color: color,
      child: SizedBox(
        width: width,
        height: height,
      ),
    );
  }
}
