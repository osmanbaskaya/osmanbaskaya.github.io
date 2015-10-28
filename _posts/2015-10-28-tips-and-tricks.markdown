---
layout: post
title:  "Linux Tips and Tricks"
excerpt: "I'd like to note some of the tricks I've learned recently. These tips and tricks may not be well-known and hopefully helpful."
tags: 
    - Linux
    - Tricks
---

I am using GNU/Linux (hereafter, I will refer this by saying Linux. Sorry Mr. Stallman) for more than 5 years. In those years I tried to improve my skills as much as possible without devoting any special effort. In this reason, sometimes I came across straightforward but really useful stuff that I missed in years. So, from now on I will note and share those.

#### 1. Use the same user after setting an environment variable.
If you set an environment variable, you should run a command with that user in the same session (assuming you don't export the environment variable in `.zshrc` or `.bashrc`). This totally makes sense, right? Although it's trivial, you should be careful especially with `sudo` command. Couple of days ago, I set some environment variable related with proxy configurations. Then, I tried to install some packages using aptitute. However, it didn't work. I lost considerable amount of time looking for the problem elsewhere. So, you may want to consider this.

There are ways to keep current environment variables using running a command with `sudo`. One is `sudo -E`

```
-E, --preserve-env
        Indicates to the security policy that the user wishes to preserve 
        their existing environment variables.  The security policy may
        return an error if the user does not have permission to 
        preserve the environment.
```

Another way is to edit visudo especially if you're using this environment variable more than sometimes:

```bash
sudo visudo # .bashrc for sudo command.
```

Add the following line:

```
Defaults env_keep += "SOME_ENV_VARIABLE"
```

More information:

1. [https://stackoverflow.com/questions/8633461/how-to-keep-environment-variables-when-using-sudo](https://stackoverflow.com/questions/8633461/how-to-keep-environment-variables-when-using-sudo)
2. [https://unix.stackexchange.com/questions/202383/how-to-pass-environment-variable-to-sudo-su](https://unix.stackexchange.com/questions/202383/how-to-pass-environment-variable-to-sudo-su)

#### 2. Set the fastest sources for Ubuntu/Debian.

Here is Ubuntu and Debian [source list generator](http://repogen.simplylinux.ch/). You should select the country, the release you're using, and the repos. Then click the *Generate List* button at the bottom (yeah, it's almost hidden). Copy those into the `/etc/apt/source.list` file and voilà! 


