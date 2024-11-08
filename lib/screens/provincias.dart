import 'package:flutter/material.dart';
import '../date/counties.dart';

class ProvinciasScreen extends StatelessWidget {
  const ProvinciasScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Provincias'),
      ),
      body: ListView(
        padding: const EdgeInsets.all(16),
        children: [
          provinciaCard('València', provincies["provincies"][0]["img"]),
          const SizedBox(height: 10),
          provinciaCard('Alacant', provincies["provincies"][1]["img"]),
          const SizedBox(height: 10),
          provinciaCard('Castelló', provincies["provincies"][2]["img"]),
        ],
      ),
    );
  }

  Widget provinciaCard(String nombre, String imagenUrl) {
    return Card(
      child: ListTile(
        leading: CircleAvatar(
          backgroundImage: NetworkImage(imagenUrl),
          radius: 30,
        ),
        title: Text(nombre,
            style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
      ),
    );
  }
}
