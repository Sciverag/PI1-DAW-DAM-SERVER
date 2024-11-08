import 'package:flutter/material.dart';
import '../date/counties.dart';

class ComarcasScreen extends StatelessWidget {
  const ComarcasScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final List<dynamic> comarcas = provincies["provincies"][0]["comarques"];

    return Scaffold(
      appBar: AppBar(
        title: const Text('Comarcas de València'),
      ),
      body: ListView.builder(
        padding: const EdgeInsets.all(16),
        itemCount: comarcas.length,
        itemBuilder: (context, index) {
          final comarca = comarcas[index];
          return Card(
            child: ListTile(
              leading: CircleAvatar(
                backgroundImage: NetworkImage(comarca["img"]),
                radius: 30,
              ),
              title: Text(comarca["comarca"],
                  style: const TextStyle(
                      fontSize: 18, fontWeight: FontWeight.w600)),
            ),
          );
        },
      ),
    );
  }
}
