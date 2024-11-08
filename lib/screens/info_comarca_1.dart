import 'package:flutter/material.dart';
import '../date/counties.dart';

class InfoComarca1Screen extends StatelessWidget {
  const InfoComarca1Screen({super.key});

  @override
  Widget build(BuildContext context) {
    final comarca = provincies["provincies"][0]["comarques"][0];

    return Scaffold(
      appBar: AppBar(
        title: Text(comarca["comarca"]),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Image.network(comarca["img"]),
            const SizedBox(height: 20),
            Text(
              comarca["comarca"],
              style: const TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 10),
            Text("Capital: ${comarca["capital"]}"),
            const SizedBox(height: 10),
            Text("Población: ${comarca["poblacio"]}"),
            const SizedBox(height: 10),
            Text("Descripción: ${comarca["desc"]}"),
            const SizedBox(height: 10),
            Text(
                "Coordenadas: ${comarca["coordenades"][0]}, ${comarca["coordenades"][1]}"),
          ],
        ),
      ),
    );
  }
}
