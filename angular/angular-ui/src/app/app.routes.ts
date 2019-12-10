export class AppRoutes {

  static app_prefix = "ui/";

  static authenticated = AppRoutes.app_prefix + "authenticated";
  static public = AppRoutes.app_prefix + "public";

  static login = 'login';
  static loginRoute = AppRoutes.public + "/" + AppRoutes.login;

}
