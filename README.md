# traveling-salesman
Traveling Salesman Problem (TSP)


Problem Description

The Traveling Salesman Problem (TSP) is a classic optimization problem in which a salesperson must visit a list of cities, starting and ending at the same city, and do so by traveling the shortest possible route. The challenge lies in finding this optimal route among all possible permutations of the cities.

The TSP is NP-hard, meaning that as the number of cities increases, the number of possible routes grows factorially, making it computationally expensive to solve by brute-force methods. TSP has applications in logistics, manufacturing, and many other fields where efficient routing is critical.

Solving the TSP
Various algorithms have been developed to find solutions to the TSP. Some of the common approaches include:

Exact Algorithms: These guarantee finding the optimal solution but are computationally intensive. Examples include dynamic programming and branch-and-bound methods.

Heuristic and Approximation Algorithms: These find good solutions in a reasonable time but do not guarantee optimality. Examples include nearest neighbor, Christofides' algorithm, and genetic algorithms.

Metaheuristic Algorithms: These are higher-level procedures designed to generate good solutions by exploring the solution space more thoroughly. Examples include simulated annealing, ant colony optimization, and genetic algorithms.

Genetic Algorithm (GA) Approach
In this application, a Genetic Algorithm (GA) is used to solve the TSP. A genetic algorithm is a search heuristic that mimics the process of natural selection. It is particularly useful for solving optimization problems like TSP where the solution space is vast.

How GA Works
Initialization: A population of potential solutions (routes) is generated randomly.

Selection: Routes are evaluated based on a fitness function, which, in the case of TSP, is usually the inverse of the total route distance. The fittest routes are selected as parents for the next generation.

Crossover: Pairs of parent routes are combined to create offspring. This mimics genetic recombination where parts of each parent’s route are inherited by the offspring.

Mutation: Small random changes are made to some offspring routes to maintain diversity within the population and to explore new solutions.

Evolution: Over successive generations, the population evolves. Fitter routes become more common, and eventually, the algorithm converges to a near-optimal solution.

Why GA?
GA is particularly effective for TSP because it can explore a large number of potential solutions in parallel and doesn't require the solution space to be smooth or continuous. It is robust and can find good solutions in a reasonable time, even for larger problem instances.

Application Overview
This application implements a Genetic Algorithm to solve the Traveling Salesman Problem for a selected list of Serbian cities. The user can interact with the application via a console interface, choosing cities they wish to visit. The algorithm then calculates and displays the best route and the total distance using the genetic algorithm approach.

Features
User Interaction: The user selects cities from a list by entering their corresponding numbers. The application handles input validation and ensures that the selections are valid.

Genetic Algorithm: The core of the application is the GA, which iterates over several generations to find the most efficient route.

Dynamic City Selection: Users can run multiple queries with different city combinations without restarting the application.

## Usage
To run the application:

Ensure you have Leiningen installed.
Clone the repository and navigate to the project directory.
Run the application using lein run.

Example Usage

To run the Traveling Salesman Problem application, execute the following command:

lein run


You will see a welcome message and a list of available cities:

        Dobrodošli, hajde da rešimo tvoj problem, trgovački putniče!
        Dostupni gradovi:
        1. Beograd
        2. Novi Sad
        3. Niš
        4. Kragujevac
        5. Mladenovac
        6. Užice
        7. Zaječar
        8. Subotica
        9. Sombor
        10. Pančevo
        11. Smederevo
        12. Leskovac
        13. Vranje
        14. Šabac
        15. Valjevo
        16. Loznica
        17. Požarevac
        18. Jagodina
        19. Čačak
        20. Kraljevo


Enter the numbers of the cities you want to visit, separated by spaces (e.g., 1 2 3):

        5 9 3 4 6


The application will then display the best route and its total distance:

        Najbolja ruta: [Kragujevac Niš Sombor Užice Mladenovac]
        Ukupna distanca: 932 kilometara


Finally, you will be asked if you want to enter a new set of cities:
        Da li želite da izvršite upit za nove gradove? (da/ne)
        ne

If you choose "ne" you will receive a farewell message:
        Hvala što ste koristili aplikaciju. Do viđenja!

Another example:
        lein run
Dobrodosli, hajde da resimo tvoj problem, trgovacki putnice
Dostupni gradovi:
1. Beograd
2. Novi Sad
3. Nis
4. Kragujevac
5. Mladenovac
6. Uzice
7. Zajecar
8. Subotica
9. Sombor
10. Pancevo
11. Smederevo
12. Leskovac
13. Vranje
14. Sabac
15. Valjevo
16. Loznica
17. Pozarevac
18. Jagodina
19. Cacak
20. Kraljevo
Unesite brojeve gradova koje zelite da posetite, odvojene razmakom (npr. 1 2 3):
        5 j 9 l
Nevalidan unos.
Unesite brojeve gradova koje zelite da posetite, odvojene razmakom (npr. 1 2 3):
        5 6 3
Najbolja ruta: [Mladenovac Uzice Nis]
Ukupna distanca: 527  kilometara.
Da li zelite da izvrsite upit za nove gradove? (da/ne)
        da
Dostupni gradovi:
1. Beograd
2. Novi Sad
3. Nis
4. Kragujevac
5. Mladenovac
6. Uzice
7. Zajecar
8. Subotica
9. Sombor
10. Pancevo
11. Smederevo
12. Leskovac
13. Vranje
14. Sabac
15. Valjevo
16. Loznica
17. Pozarevac
18. Jagodina
19. Cacak
20. Kraljevo
Unesite brojeve gradova koje zelite da posetite, odvojene razmakom (npr. 1 2 3):
        5 9 3 7 15
Najbolja ruta: [Mladenovac Valjevo Sombor Nis Zajecar]
Ukupna distanca: 946  kilometara.
Da li zelite da izvrsite upit za nove gradove? (da/ne)
        da
Unesite brojeve gradova koje zelite da posetite, odvojene razmakom (npr. 1 2 3):
        5 9 3 7 15
Najbolja ruta: [Mladenovac Valjevo Sombor Nis Zajecar]
Ukupna distanca: 946  kilometara.
Da li zelite da izvrsite upit za nove gradove? (da/ne)
        ne
Hvala sto ste koristili aplikaciju. Do vidjenja!
PS C:\Users\Korisnik\traveling-salesman>











16. Loznica
17. Pozarevac
18. Jagodina
19. Cacak
20. Kraljevo
Unesite brojeve gradova koje zelite da posetite, odvojene razmakom (npr. 1 2 3):
5 9 3 7 15
Najbolja ruta: [Mladenovac Valjevo Sombor Nis Zajecar]
Ukupna distanca: 946  kilometara.
Da li zelite da izvrsite upit za nove gradove? (da/ne)
ne
Hvala sto ste koristili aplikaciju. Do vidjenja!
PS C:\Users\Korisnik\traveling-salesman>
ne
Hvala sto ste koristili aplikaciju. Do vidjenja!
Hvala sto ste koristili aplikaciju. Do vidjenja!
Hvala sto ste koristili aplikaciju. Do vidjenja!
PS C:\Users\Korisnik\traveling-salesman>
Hvala sto ste koristili aplikaciju. Do vidjenja!
Hvala sto ste koristili aplikaciju. Do vidjenja!
Hvala sto ste koristili aplikaciju. Do vidjenja!
PS C:\Users\Korisnik\traveling-salesman>


Hvala sto ste koristili aplikaciju. Do vidjenja!
PS C:\Users\Korisnik\traveling-salesman>

Hvala sto ste koristili aplikaciju. Do vidjenja!
Hvala sto ste koristili aplikaciju. Do vidjenja!
PS C:\Users\Korisnik\traveling-salesman>
Hvala sto ste koristili aplikaciju. Do vidjenja!
PS C:\Users\Korisnik\traveling-salesman>

## Options


## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2024 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
