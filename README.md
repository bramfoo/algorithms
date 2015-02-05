![](http://algs4.cs.princeton.edu/cover.png)

# Algorithms (Sedgewick and Wayne, Princeton)

## What does it do?

This is a [mavenized](http://maven.apache.org/), [version controlled](http://git-scm.com/) version of the algorithms and data structures provided as part of the *Algorithms, 4th Edition* textbook  by Robert Sedgewick and Kevin Wayne.

### Why reproduce it here?
- Easily retrieve and build the source code of all algorithms, data structures, I/O libraries and test data (the original site only has [single files](http://algs4.cs.princeton.edu/code/) or a [pre-packaged jar](http://algs4.cs.princeton.edu/code/algs4-package.jar)
- Added the APIs of the 10 assignments of the Coursera [Algorithms, part I](https://www.coursera.org/course/algs4partI) and [Algorithms, part II](https://www.coursera.org/course/algs4partII) courses (highly recommended!), for ease of use and as an example of how to document the classes/methods
- Added unit tests for these assignments, for ease of use and as an example of how to write unit tests for those not familiar with them
- (TODO) Provide different maven targets for compiling only the algorithms, assignments, or running the unit tests


## Full Documentation

See the authors' [Booksite](http://algs4.cs.princeton.edu/) for full documentation, examples, operational details and other information.

## Build

```
$ git clone https://github.com/bramfoo/algorithms.git
$ cd algorithms/
$ mvn clean verify -DskipTests
```

## Disclaimer
- This repository is not associated with, approved, or endorsed by Princeton, or Mr. Sedgewick/Mr. Wayne. The materials is reproduced as allowed by the license (GPL v3), purely because I cannot recommend the algorithms, courses and lessons highly enough
- No assignment answers are, or ever will be, part of this repository. Providing the answers is not only against [Coursera's Honor code](https://learner.coursera.help/hc/en-us/articles/201223999-Honor-Code-Plagiarism), but also the quickest way to stop the learning process. Unfortunately there are many places where you can find these answers, so if that's what you're looking for, please look elsewhere. NOTE: the unit tests related to the assignments are purely provided for informational/learning purposes.
