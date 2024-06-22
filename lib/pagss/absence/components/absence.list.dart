import 'package:flutter/material.dart';
import 'package:gest_school_fluter/core/modals/absence.modal.dart';
import 'package:gest_school_fluter/core/services/security_service.dart';
import 'package:gest_school_fluter/pagss/absence/justification_page.dart';
// import 'package:gest_school_fluter/pagss/absence/justification_page.dart';

class AbsenceList extends StatelessWidget {
  Future<List<Absence>> abcencelist;
  AbsenceList({super.key, required this.abcencelist});

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
        future: abcencelist,
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            print(snapshot.data![0].motif);
            print(SecurityService.userConnect!.id);
            return SizedBox(
              height: MediaQuery.of(context).size.height * 0.85,
              child: ListView.builder(
                scrollDirection: Axis.vertical,
                itemCount: snapshot.data!.length,
                itemBuilder: (context, index) {
                  return AbsenceItem(
                    absence: snapshot.data![index],
                  );
                },
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

class AbsenceItem extends StatelessWidget {
  Absence absence;
  AbsenceItem({super.key, required this.absence});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(5),
      child: Container(
        width: double.infinity,
        height: 107,
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
                    absence.date,
                    style: const TextStyle(
                        color: Colors.white,
                        fontSize: 17,
                        fontWeight: FontWeight.bold),
                  ),
                  Text(
                    absence.cour,
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
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  if (absence.motif == "")
                    ElevatedButton(
                      style: ButtonStyle(
                        backgroundColor: MaterialStateProperty.all(
                          Colors.amber.shade100,
                        ),
                        foregroundColor: MaterialStateProperty.all<Color>(
                            Color.fromARGB(255, 126, 102, 14)),
                      ),
                      onPressed: () {
                        Navigator.pop(context);
                        Navigator.pushNamed(
                          context,
                          JustificationPage.routeName,
                          arguments: {"abcence": absence.id},
                        );
                      },
                      child: const Text(
                        'justifier',
                        style: TextStyle(
                            fontSize: 20, fontWeight: FontWeight.w700),
                      ),
                    ),
                ],
              ),
            )
          ],
        ),
      ),
    );
  }
}
