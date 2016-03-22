---
layout: post
comments: true
title: TL;DR for Papers I recently read.
excerpt: I summarize the Deep Learning and NLP papers I read recently.
---

### Content

1. [Towards AI-Complete Question Answering: A Set of Prerequisite Toy Tasks](#towards)

----

### <a name="towards"></a> 1. Towards AI-Complete Question Answering: A Set of Prerequisite Toy Tasks

[This paper](http://arxiv.org/pdf/1502.05698.pdf) aims to provide a systematic and controlled experiment suite for Q/A systems. They grouped the question answering problem into 20 subproblems such as "Single Supporting Fact", "Counting", "Basic Deduction", "Path Finding", "Yes/No Question" and so on. This is really useful because you might have better understanding about the weaknesses of a given Q/A system. I said "controlled" since the paper provides a method ([code](https://github.com/facebook/bAbI-tasks)) for dataset generation. Right now, you can only generate short sentences and diversity of the sentences are somewhat limited but they think that this dataset and the generation process are helpful especially when developing and analyzing algorithms. Another contribution is that they extend the work in Weston et al. (2014) ([Memory Networks](http://arxiv.org/pdf/1410.3916v11.pdf)) in 3 ways. They use (1) "Adaptive Memories" thus they can do well in "Three Supporting Facts" subproblem. Original algorithm (Memory Network, MemNN) performs two hops of inference and it doesn't do well tasks where algorithm needs to perform more than two hops of inference such as "Three Supporting Facts" and "Path Finding". Second extension is (2) N-Grams. This extension addresses the bag of words problems in the nature of some subtasks such as "Two Argument Relations". If a system use only bag-of-words approach, it cannot distinguish which one is in the north of which: `the office is north of the bedroom`. This is equivalent of `the bedroom is north of the office` in bag-of-word methodology, however, the semantic is completely different. The last extension is that (3) Nonlinearity in matching function. I think paper is worth a read.
