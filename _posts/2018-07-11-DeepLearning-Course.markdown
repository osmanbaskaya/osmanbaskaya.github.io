---
layout: post
comments: true
title: 7 Important Points from Coursera's Deep Learning Specialization
excerpt: "I would like to share some points in the last two courses of Deep Learning specialization that I found useful and perhaps less widely known."
date: 2018-07-11 00:30
---

I left my previous job recently and I had time to complete Coursera's [Deep Learning Specialization](https://www.coursera.org/specializations/deep-learning). I completed all 5 courses in ~2 weeks. Although I was pretty familiar with the subjects in the specialization, it was a good opportunity for me to remember important things that I forgot and learn things that I didn't know. I was started to write what I learned from the specialization from scratch but then I came across [this post](https://towardsdatascience.com/deep-learning-specialization-by-andrew-ng-21-lessons-learned-15ffaaef627c) where the first three courses in the specialization are summarized. It's a nice, high-level summary; check it out. Similar to that post, I'd like to provide the key points in the remaining courses, specifically, Convoutional Neural Networks (course 4), and Sequence Models (course 5), perhaps a little bit verbose way.

## Course 4: Convolutional Neural Networks

### Point 1: Why Convolution?

Why does convolution work amazingly, especially in images? Why don't we use typical Deep Neural Nets (DNNs) for images, too? DNNs might work for very small images but when the image size gets bigger, the number of parameters your network needs to learn increases dramatically. This does not only make DNNs very difficult to train but also a neuron that learns a specific feature (e.g., vertical edge detection) will only be useful for that same pixel. So, each neuron needs to learn many different features at the same time. On the other hand, if you use CNNs where each filter (i.e. feature detector) can learn different thing and can be used to analyze each pixel in the image. This is **parameter sharing**. The same filters are used for whole image. So, CNNs are computationally more efficient (loosely speaking, number of parameters to train a CNN is much less than to train a fully connected neural networks), also a feature detector can be used for any pixel, thus, this makes CNNs **traslation invariant**.


### Point 2: More layers, smaller error?


<div style="font-size:80%; text-align:center;">
<img src="/images/why-resnet.png" width="100%" height="100%" alt="Why Resnet">
"In theory, theory and practice are the same. In practice, they are not." - Albert Einstein (the image is borrowed from Coursera Deep Learning Course)</div>

In theory, the more layer means the smaller training error. However, because of the nature of backpropagation, gradients reached to the earlier layers would be close to zero (this problem is widely known as **vanishing gradient problem**). Therefore, earlier layer of the network wouldn't be trained that much to provide useful information to later layers. So, it's better to train a smaller network properly. ResNet has residual connections (shortcuts). This residual connections help gradients reach to the previous (earlier) layers since they are connected that layer with addition operation in the forward propagation. Addition operation passes the gradient comes from the next layer directly in contrast to multiplication operation. Thanks to the residual connections, to train a deep network is _easier_.

## Course 5: Sequence Models

### Point 3: Why not a standard DNN?

Why do we need a specific models such as RNN for sequence modeling? Why don't we use DNNs? There are couple of reasons:

- Inputs and outputs can be in different lengths for each sentences. Think of sentences in this post. They are not the same length.
- The bigger problem though is that DNNs do not share features that are learned across different positions of the text. In _Point #1_, I was talking about how sharing parameters for CNNs  make a huge difference in ease of training and improving the performance. Instead of a neuron that learns each feature detector separately, we were learning a small filter to do one specific task such as vertical edge detection. Then, we were using the same filter for all the pixels in the image. The situation is very similar for RNN in sequence modeling. RNNs' ability of sharing parameters reduces the number of parameters that should be learned thanks to **parameter sharing**.

### Point 4: Vanishing Gradient / Exploding Gradient

Language can have long term dependencies. When the sentences get longer and longer, to train an RNN gets harder and harder since gradients may get smaller and smaller for each step of backpropagation (because of the chain rule, the gradients will be multiplied for each time step). So, the necessary update for the long term dependencies won't be reached because of many multiplication in the chain rule. This means that the network won't learn long term dependencies. Exploding gradient is somewhat similar (and more straightforward to detect). Gradients get bigger and bigger (e.g., +inf and -inf) and weight update becomes non-sense; instead of convergence, the algorithm diverges. 

In order to alleviate these problems, 

- Many new architectures are introduced. LSTM and GRU are the widely-used ones.
- Non-saturating activation functions proposed. RELU, leaky RELU, ELU are some of them.
- The new weight initialization methods are proposed (e.g., Xavier and He initialization).
- [Batch normalization](https://arxiv.org/pdf/1502.03167v3.pdf) is introduced..

<div style="font-size:80%; text-align:center;">
<img src="https://upload.wikimedia.org/wikipedia/commons/8/88/Logistic-curve.svg" width="60%" height="60%" class="center" alt="Sigmoid - Saturation">
<br>Sigmoid activation function. It saturates (its derivative approaches to zero) when its input gets bigger.</div>


### Point 5: Why do we need Beam Search? 
Beam search is used heavily in Machine Translation but it can be helpful for any sequence generation. Think how you speak or write. You start a sentence by choosing a word. Then, you choose another word. And another. One. By. One. You may have a language model in your head, providing a probability distribution for each word (in your vocabulary for that language) for each slot in a sentence, depending on who is your audience, the time and where you speak, what words you choose last 1 hour, and much more contextual information. This is a speculation; we do not know for sure how we can able to [form a sentence](https://www.sciencedaily.com/releases/2011/11/111128171220.htm) yet but assume that we have a machine that gives a probability distribution for each word in a finite set of words. Also assume that this computation has some flaws and our dear machine ignores many contextual information such as with whom you are talking and so on. Providing the most probable word for each slot in the sentence can be seen as a greedy algorithm. You choose the best solution for each subproblem (for each step), hoping you will end up with the best solution for the original problem (sentence generation). This might not work. Another thing we can do is to generate all possible sentences and compute the probability for each generated sentence; choose the best at the end. This definitely helps to find the most likely sentence but even though you have a 10,000-words vocabulary (this is very humble vocabulary size. According to [this article and the study](https://www.economist.com/johnson/2013/05/29/lexical-facts), average native test-takers of age 8 already know 10,000 words), number of 21-word sentences you generate is larger than all the atoms in the known universe. A large-scale machine translation system can have 1M vocabulary which makes the sentence length reduces to 14 words to hit the number of atoms in the same known universe. So, it doesn't seem feasible to me. Beam search helps to reduce this search space to _k_ most prominent candidates. For each step, only _k_ current most likely candidates will survive for the next step. Beam search is just that. But we have one problem: if you just put equal length sentences into a race and choose the best among them; that's fine. However, you have to compare shorter sentences with the longer ones, too. Sounds unfair, doesn't it? Since more words you add into the sequence, whole sequence probability will be decreased (multiplying probabilities: probability is by definition between 0 and 1). One refinement to vanilla version of the beam search is to penalize shorter sentences more than longer ones to give enough chance for longer sentence generations.. In the course, sentence length was the normalization term.

Also, choosing the beam size is important. Large beam size means that you may end up with better sequences but computation gets slower. The beam size depends on the application you are building and it should be tuned according to that application's requirements. If you have a lot of computation power, no time limit to return the result and you care a lot about performance, then go ahead and choose larger beam size. Whereas it's an online system, your users may not like waiting for the results.

### Point 6: Who is the suspect? Beam Search vs Model?

If you read the previous point, you may or may not notice that to train that kind of model can be tricky. Why? The system has two parts: the model part and the part that finds the _best_ sequences. Model calculates the probability distribution for each word for each position. The second part (e.g., beam search) uses these probabilities to provide sequence as an answer. Assume that your system provides crappy sequences. Who is the one to be blamed? Is it because your model provides shitty probability distributions or beam search is not able to find high quality sequences even your model gives it good information. It might be hard to pin down. Andrew Ng suggested a good way to figure out the origin of the problem. Assume that we have pairs of sequences (e.g. sentences), each pair has two sequences; one sentence comes from a human judge (gold data), and another sentence is our system's output. We can calculate these two sentences' probabilities. If the gold sentence's probability is lower than the our system's output (and we believe that the output of the system is not good), this might be a sign that instead of spending time to optimize beam search, we should focus on improving our model. Why? Since the model gives low probability for the decent sequences (gold data), but gives high probability for crappy sentences. So, there is not so much evidence to blame beam search. On the other hand, if the gold data gets higher probability than the probability of the sentence that system provides, than we can think that model may be decent, beam size might be small since even though the probability of the gold sentence was higher, beam search couldn't find that sentence. 

### Point 7: Why do we need attention?

Let's remember encoder-decoder models in Machine Translation. The encoder part embeds the source sentence into low-dimensional dense vector. The decoder part starts with this information and generates words sequencially. If you think how human translators translate a sentence, they first read the source sentence, translate a little bit, then go back to source, read again, translate more. So translators go back and forth while translating. They give more attention to word or word groups that they are translating. They don't memorize the whole sentence. As you can see the image below, Andrew Ng explains the rough performance drop for long sentences for the systems that has no attention mechanism. Of course, it is just a rough idea, it is **not** [xkcd-themed plot of a controlled experiment](https://stackoverflow.com/questions/12675147/how-can-we-make-xkcd-style-graphs), so take it with a grain of a salt. So, it was the intuition.

<div style="font-size:80%; text-align:center;">
<img src="/images/intuition-for-attention.png" width="100%" height="100%" class="center" alt="Attention performance">
Blue line denotes the performance of a translation model without attention. Green line denotes the same model with attention. As you can see there is no dramatical drop for the system with attention. On the other hand, the mouse pointer close to the origin belongs to Professor Andrew Ng (The image is borrowed from Cousera's Deep Learning Course). </div>

What's attention mechanism, then? Attention mechanism is just a fully-connected neural network that provides weights for activation vectors calculated in encoding for each time step while decoding. Question that this neural network answers is that "how much _attention_ I should give for activations of each step in encoding part?". So, input of the decoding part is not just previous hidden state (and the previous word that is generated) anymore but also weighted average of activations in encoding for each step. 

<div style="font-size:80%; text-align:center;">
<img src="/images/attention-in-action.png" width="50%" height="50%" class="center" alt="Attention performance">
<br>Attention in action. Syntactically similar two languages. It would be fun to see the same figure but for Turkish-English. (image is taken from https://arxiv.org/pdf/1409.0473.pdf)</div>

The figure above shows which words get more attention while decoding. Isn't it quite amazing? I am curious if there is any scientist who conducted an eye fixation experiment on translators while they are translating a sentence. The time they spend focusing on words while translating the parts of a sentence may be similar to this plot.

That's it, folks. Hope you enjoyed reading. Let me know if you have any correction, question or suggestion. 
