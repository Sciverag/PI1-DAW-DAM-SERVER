import 'package:flutter/material.dart';
import '../date/counties.dart';

class InfoComarca2Screen extends StatelessWidget {
  const InfoComarca2Screen({super.key});

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
            const SizedBox(height: 20),
            const Divider(),
            const Text(
              "Clima",
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 10),
            const Row(
              children: [
                Icon(Icons.wb_sunny, color: Colors.orange),
                SizedBox(width: 10),
                Text("Soleado, 25°C"),
              ],
            ),
            const SizedBox(height: 10),
            const Row(
              children: [
                Icon(Icons.air, color: Colors.blue),
                SizedBox(width: 10),
                Text("Viento: 10 km/h hacia el norte"),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
