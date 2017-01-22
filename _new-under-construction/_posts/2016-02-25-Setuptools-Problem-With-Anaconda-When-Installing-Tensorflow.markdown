---
layout: post
comments: true
title:  "Install TensorFlow on Anaconda"
excerpt: setuptools package gives headache when installing TensorFlow on Anaconda environment. Sometimes you get "Cannot remove entries from nonexistent file". The solution might be simple.
---

**setuptools** package gives headache when installing TensorFlow on Anaconda environment. Sometimes you get "Cannot remove entries from nonexistent file". The solution might be simple.

When you run this:

```
pip install --upgrade https://storage.googleapis.com/tensorflow/linux/gpu/tensorflow-0.7.1-cp27-none-linux_x86_64.whl
```

Perhaps you will get this:


`Installing collected packages: setuptools, protobuf, wheel, numpy, tensorflow
Found existing installation: setuptools 19.4
Cannot remove entries from nonexistent file /home/obaskaya/anaconda2/lib/python2.7/site-packages/easy-install.pth`


However, if you do this:
```
conda update setuptool
```

After that, run the first command again:

```
pip install --upgrade https://storage.googleapis.com/tensorflow/linux/gpu/tensorflow-0.7.1-cp27-none-linux_x86_64.whl
```

Hopefully you'll get:

``Successfully installed numpy-1.10.4 protobuf-3.0.0b2 tensorflow-0.7.1``


Please note that TensorFlow installation link might be old. Consider the change it while you're installing to your machine.
