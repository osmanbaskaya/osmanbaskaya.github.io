---
layout: post
comments: true
title:  "jBLAS with OpenBLAS"
excerpt: "If you don't have GPU in your fingertips? This is the situation that I face at work. So, will you satisfied with running training the model on one CPU. No, right? Here is one alternative for Java users. I will explain how to create a JBLAS jar wrapped with OpenBLAS in Linux."
date:   2015-10-25 09:40
---

<!--### jBLAS with OpenBLAS-->

[BLAS](http://www.netlib.org/blas/) is a widely used linear algebra library which provides
fast matrix/vector operations such as multiplication. [OpenBLAS](https://github.com/xianyi/OpenBLAS/wiki) is a optimized and parallel version of BLAS. Finally, jBLAS is a Java wrapper of above libraries as well as [LAPACK](http://www.netlib.org/lapack/) and [ATLAS](http://math-atlas.sourceforge.net/). Couple of days ago, I would like to create a jBLAS jar file built with OpenBLAS.

Here is the story. I'm working on Deep Learning. This area is now in the control of GPUs since the you basically vectorize (express the instruction with vector/matrix operations) the ,vy parts of the algorithm. Who's the master for processing vector operations? Yeah, GPUs. [Here](http://www.denizyuret.com/2015/01/parallel-processing-for-natural-language.html) is one analysis of using GPU instead of using single/multi core CPU in Natural Language Processing. You can even see *100x* speed-up from single CPU in _particular settings_. As expected, this speed-up is very useful especially if you're working on large datasets. All this sounds exciting but what if you don't have GPU in your fingertips? Will you satisfied with running training the model on one CPU. No, right? Here is one alternative for Java users. I will explain how to create a JBLAS jar wrapped with OpenBLAS in Linux.

```bash
sudo apt-get install libopenblas-dev
git clone  git@github.com:mikiobraun/jblas.git
./configure --libpath=/usr/lib --libs=openblas,lapack --download-lapack --build-type=openblas`
make
ant dynamic-lean-jar
```

Instead of using `ant` in the last step, I tried `make all-jars` but it gives me error such as `lean-jar does not exist in the java-blas project`. Since the libraries are most likely not used by other processes, instead of building dynamic jar, I tried static jar by running the command `ant static-lean-jar`. Although I managed to create a jar, I tested and it doesn't work paralel. 

The simple java code and the Makefile is [here](). In order to run the code you just need to create a directory named `jars and run `make test`. 

I am trying to figure out if there is a way to create static version of it. When I have the answer, you will have, too :).