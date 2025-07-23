import 'package:flutter_dotenv/flutter_dotenv.dart';
import 'package:flutter_lottoresult/system/constants.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class Config {
  final String dbFile;

  Config(this.dbFile);
}

final configProvider = Provider<Config>((ref) {
  final dbFile = dotenv.env[Constants.envDbFile] ?? Constants.defaultDbFileName;
  return Config(dbFile);
});
