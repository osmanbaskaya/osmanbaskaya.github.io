---
layout: post
comments: true
title: TL;DR for Papers I recently read.
mathjax: true
excerpt: I summarize the Deep Learning and NLP papers I read recently.
---
[comment]: # http://gastonsanchez.com/opinion/2014/02/16/Mathjax-with-jekyll/

### Content

1. [A Convolutional Neural Network for Modelling Sentences](#sentmodel)
1. [Towards AI-Complete Question Answering: A Set of Prerequisite Toy Tasks](#towards)

----

### <a name="sentmodel"></a> 1. A Convolutional Neural Network for Modelling Sentences

[This paper](http://www.aclweb.org/anthology/P14-1062) extends the work described in [Natural Language Processing (almost) from Scratch](http://arxiv.org/pdf/1103.0398v1.pdf). Their method has two components which are the generalization of Max Pooling layer: Dynamic k-Max Pooling. _k_ in the k-Max pooling means that the layer pools _k_ most active features and _dynamic_ in "Dynamic k-Max Pooling" stands for k is not fixed; it is computed by a function of depth of the network and the sentence length. Another improvement is that they have "Multiple Feature Maps" which means that 3 layers (Convolution, Dynamic k-Max Pooling and Non-linear Feature Function) can be computed in parallel with different filters in Convolution layer and then putting all the scores together simply by summing. They also provided some intuition about their feature filters (ie., feature detector to be active for a specific pattern(s)). They fed 7-grams in validation and the test sets for each of 288 feature detectors, and ranked them. They showed feature detectors that are active for "positive", "negative", "too", "not" phrases. In other words, one feature detector active when the 7-grams was "either too serious or too lighthearted." for instance. They illustrated their system's performance by using 4 different datasets.


### <a name="towards"></a> 2. Towards AI-Complete Question Answering: A Set of Prerequisite Toy Tasks

[This paper](http://arxiv.org/pdf/1502.05698.pdf) aims to provide a systematic and controlled experiment suite for Q/A systems. They grouped the question answering problem into 20 subproblems such as "Single Supporting Fact", "Counting", "Basic Deduction", "Path Finding", "Yes/No Question" and so on. This is really useful because you might have better understanding about the weaknesses of a given Q/A system. I said "controlled" since the paper provides a method ([code](https://github.com/facebook/bAbI-tasks)) for dataset generation. Right now, you can only generate short sentences and diversity of the sentences are somewhat limited but they think that this dataset and the generation process are helpful especially when developing and analyzing algorithms. Another contribution is that they extend the work in Weston et al. (2014) ([Memory Networks](http://arxiv.org/pdf/1410.3916v11.pdf)) in 3 ways. They use (1) "Adaptive Memories" thus they can do well in "Three Supporting Facts" subproblem. Original algorithm (Memory Network, MemNN) performs two hops of inference and it doesn't do well on tasks where algorithm needs to perform more than two hops of inference such as "Three Supporting Facts" or "Path Finding". Second extension is (2) N-Grams. This extension addresses the limitations of bag of words problem in the nature of some subtasks such as "Two Argument Relations". If a system use only bag-of-words approach, it cannot distinguish which one is in the north of which: `the office is north of the bedroom`. This is equivalent of `the bedroom is north of the office` in bag-of-word methodology, however, the semantic is completely different. The last extension is that (3) Nonlinearity in matching function. I think paper is worth a read.

