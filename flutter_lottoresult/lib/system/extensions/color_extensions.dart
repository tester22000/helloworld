import 'dart:ui';

extension HexColorExtension on Color {
  static Color hexToColor(String hexString) {
    String formattedHexString = hexString.replaceAll('#', '');
    if (formattedHexString.length == 6) {
      // If it's a 6-digit hex (RRGGBB), assume full opacity (FF)
      formattedHexString = 'FF$formattedHexString';
    }
    // Parse the hex string as an integer (base 16)
    // The '0x' prefix denotes a hexadecimal literal
    return Color(int.parse(formattedHexString, radix: 16));
  }
}
