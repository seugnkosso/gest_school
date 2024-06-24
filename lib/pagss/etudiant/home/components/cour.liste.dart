import 'package:flutter/material.dart';
import 'package:gest_school_fluter/core/models/cour.modal.dart';
import 'package:gest_school_fluter/pagss/etudiant/sessionCour/sessionCour.page.dart';

class CourList extends StatelessWidget {
  Future<List<Cour>> listCour;
  CourList({super.key, required this.listCour});

  @override
  Widget build(BuildContext context) {
    return FutureBuilder<List<Cour>>(
        future: listCour,
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            return SizedBox(
              height: MediaQuery.of(context).size.height * 0.8,
              child: Padding(
                padding: const EdgeInsets.all(10.0),
                child: ListView.builder(
                  scrollDirection: Axis.vertical,
                  itemCount: snapshot.data!.length,
                  itemBuilder: (context, index) {
                    return InkWell(
                      child: CourItem(
                        cour: snapshot.data![index],
                        callback: () {},
                      ),
                      onTap: () {
                        Navigator.pushNamed(context, SessionCourPage.routeName,
                            arguments: snapshot.data![index].id.toString());
                      },
                    );
                  },
                ),
              ),
            );
          } else {
            return const Center(
              child: Text("Pas Donnees"),
            );
          }
        });
  }
}

class CourItem extends StatelessWidget {
  Cour cour;
  VoidCallback callback;
  CourItem({super.key, required this.cour, required this.callback});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(5),
      child: Container(
        width: double.infinity,
        height: 100,
        decoration: BoxDecoration(
            boxShadow: const [
              BoxShadow(
                color: Colors.amber,
                spreadRadius: 1,
                blurRadius: 10,
                offset: Offset(0, 3),
              )
            ],
            color: Color.fromARGB(255, 126, 102, 14),
            border: Border.all(color: Colors.black, width: 3),
            borderRadius: BorderRadius.all(Radius.circular(10))),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    cour.professeur,
                    style: const TextStyle(
                        color: Colors.white,
                        fontSize: 17,
                        fontWeight: FontWeight.bold),
                  ),
                  Text(
                    cour.module,
                    style: const TextStyle(
                        color: Colors.white,
                        fontSize: 17,
                        fontWeight: FontWeight.bold),
                  )
                ],
              ),
            ),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    cour.semestre,
                    style: const TextStyle(
                        color: Colors.white,
                        fontSize: 17,
                        fontWeight: FontWeight.bold),
                  ),
                  Text(
                    cour.nbrHeure.toString() + " Heure",
                    style: const TextStyle(
                        color: Colors.white,
                        fontSize: 17,
                        fontWeight: FontWeight.bold),
                  )
                ],
              ),
            )
          ],
        ),
      ),
    );
  }
}
