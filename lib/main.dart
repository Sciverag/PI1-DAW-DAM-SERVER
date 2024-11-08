import 'package:flutter/material.dart';
import 'screens/comarcas.dart';

void main() {
  runApp(MaterialApp(
    theme: ThemeData(
      primarySwatch: Colors.blue,
    ),
    debugShowCheckedModeBanner: false,
    title: 'Comarcas',
    home: Scaffold(
      appBar: AppBar(
        title: const Text(
          'Comarcas',
        ),
      ),
      //body: const LoginScreen(), // Pantalla de inicio de sesión
      //body: const ProvinciasScreen(), // Pantalla de provincias
      body: const ComarcasScreen(), // Pantalla de comarcas
      // body: const InfoComarca1Screen(), // Pantalla de información de la comarca (sin clima)
      // body: const InfoComarca2Screen(), // Pantalla de información de la comarca (con clima)
    ),
  ));
}
