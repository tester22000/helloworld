import 'package:flutter/material.dart';
import 'package:flutter_dotenv/flutter_dotenv.dart';
import 'package:flutter_lottoresult/ui/pages/lotto_result/view/lotto_result_page.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  try {
    await dotenv.load(fileName: ".env");
  } catch (e) {
    print("Error loading .env file: $e");
  }
  runApp(const ProviderScope(child: LottoResultApp()));
}

class LottoResultApp extends StatelessWidget {
  const LottoResultApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Lotto Draw Result',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        textTheme: TextTheme(
          bodyLarge: TextStyle(
            fontSize: 16,
            decoration: TextDecoration.none,
          )
        )
      ),
      home: const LottoResultPage(),
    );
  }
}