import 'package:flutter/material.dart';
import 'package:gest_school_fluter/core/modals/sessionCour.modal.dart';
import 'package:gest_school_fluter/pagss/sessionCour/emargement_page.dart';

class listSessionCour extends StatelessWidget {
  Future<List<SessionCour>> sessionCours;
  listSessionCour({super.key, required this.sessionCours});

  @override
  Widget build(BuildContext context) {
    return FutureBuilder<List<SessionCour>>(
        future: sessionCours,
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            return SizedBox(
              height: MediaQuery.of(context).size.height,
              child: Padding(
                padding: const EdgeInsets.all(10.0),
                child: ListView.builder(
                  scrollDirection: Axis.vertical,
                  itemCount: snapshot.data!.length,
                  itemBuilder: (context, index) {
                    return InkWell(
                      child: SessionCourItem(
                        sessionCour: snapshot.data![index],
                      ),
                      onTap: () {},
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

class SessionCourItem extends StatelessWidget {
  SessionCour sessionCour;
  SessionCourItem({super.key, required this.sessionCour});

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
                    sessionCour.date,
                    style: const TextStyle(
                        color: Colors.white,
                        fontSize: 17,
                        fontWeight: FontWeight.bold),
                  ),
                  Text(
                    sessionCour.salle == 'none'
                        ? "" + sessionCour.etat
                        : sessionCour.salle + " " + sessionCour.etat,
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
                    sessionCour.heureDebutFin,
                    style: const TextStyle(
                        color: Colors.white,
                        fontSize: 17,
                        fontWeight: FontWeight.bold),
                  ),
                  sessionCour.start == true
                      ? GestureDetector(
                          onTap: () {
                            Navigator.pop(context);
                            Navigator.pushNamed(
                                context, Emargementpage.routeName,
                                arguments: {"idSession": sessionCour.id});
                          },
                          child: Container(
                            decoration: BoxDecoration(
                              borderRadius: BorderRadius.circular(20),
                              color: Colors.amber.shade100,
                            ),
                            child: Padding(
                              padding: const EdgeInsets.all(6.0),
                              child: const Text(
                                "émargement",
                                style: TextStyle(
                                    color: Color.fromARGB(255, 126, 102, 14),
                                    fontSize: 17,
                                    fontWeight: FontWeight.bold),
                              ),
                            ),
                          ))
                      : Container(),
                ],
              ),
            )
          ],
        ),
      ),
    );
  }
}
