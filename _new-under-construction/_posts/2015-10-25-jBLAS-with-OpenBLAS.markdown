---
layout: post
comments: true
title:  "jBLAS with OpenBLAS"
excerpt: "What if you don't have any GPU at your fingertips? This is the situation that I face at work. So, will you be satisfied to train your model on one CPU and wait for couple of weeks? No, right? Here is one alternative for Java users. I will explain how to create a JBLAS jar wrapped with OpenBLAS on Linux."
date:   2015-10-25 09:40
---

<!--### jBLAS with OpenBLAS-->

[BLAS](http://www.netlib.org/blas/) is a widely used linear algebra library which provides
fast matrix/vector operations such as multiplication. [OpenBLAS](https://github.com/xianyi/OpenBLAS/wiki) is an optimized and parallel version of BLAS. Finally, jBLAS is a Java wrapper of above libraries as well as [LAPACK](http://www.netlib.org/lapack/) and [ATLAS](http://math-atlas.sourceforge.net/). Couple of days ago, I would like to create a jBLAS jar file built with OpenBLAS. It wasn't as easy as I thought.

Here is the story. I'm working on Deep Learning. This area is now dominated by GPUs since you can basically vectorize (express the instruction with vector/matrix operations) the heaviest parts of the algorithms. Who's the master for processing vector operations? Yeah, GPUs. [Here](http://www.denizyuret.com/2015/01/parallel-processing-for-natural-language.html) is one analysis of using GPU instead of using single/multi core CPU in Natural Language Processing. You can even see **100x** speed-up from single CPU in _particular settings_. As expected, this speed-up is very useful especially if you're working on large datasets. All this sounds exciting but what if you don't have any GPU at your fingertips? This is the situation that I face at work. So, will you be satisfied to train your model on one CPU and wait (or [fighting with swords](http://imgs.xkcd.com/comics/compiling.png)) for couple of weeks? No, right? Here is one alternative for Java users to bring down weeks to days depending on how many cores your machine have. Therefore, I will explain how to create a JBLAS jar wrapped with OpenBLAS on Linux.

```bash
sudo apt-get -y install git-core build-essential gfortran
git clone git@github.com:xianyi/OpenBLAS.git
cd OpenBLAS
make DYNAMIC_ARCH=1 NO_AFFINITY=1 NUM_THREADS=32 # default NUM_THREADS=12
make install PREFIX=/opt/OpenBLAS
sudo ldcache
cd ../
git clone  git@github.com:mikiobraun/jblas.git
cd jblas
./configure --static-libs --libpath=/opt/OpenBLAS/lib --libs=openblas --download-lapack --build-type=openblas
make
ant static-lean-jar
```

If you want to install OpenBLAS elsewhere please change all the `/opt/OpenBLAS/lib` with an appropriate path. Instead of using `ant` in the last step, I tried `make all-jars` but it gives me error such as _lean-jar does not exist in the java-blas project_. Since the libraries are most likely not used by other processes, instead of building dynamic jar, I decided to go with static jar by running the command `ant static-lean-jar`.

[The simple java code and the Makefile](https://github.com/osmanbaskaya/osmanbaskaya.github.io/tree/master/code/2015-10-25-jBLAS-with-OpenBLAS-code). In order to run the code you just need to create a directory named jars, copy the jar you have just created in `jblas` directory into jars and run `make test` in the same directory with Makefile.

Let me know if you get any error.
