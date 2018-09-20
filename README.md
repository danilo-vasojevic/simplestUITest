# Working with Selenoid - PR pet project

Main idea behind this repository is to demonstrate how Selenoid is set up, configured and how Selenium UI tests can be executed within Docker containers created by Selenoid.

## Installation of additional tools
IN the next few paragraphs, we'll quickly ho through all tools that make whole process much, much simpler. At this moment, I'll not go into alternative methods of setting up Selenoid, simply because there's no need to complicate.

Also, I'll assume the following:
1. You're using Mac
2. You have decent experience with command line tools and Terminal

### Docker
If you don't have Docker, install it.

### Homebrew
If you, for any reason, don't already have Homebrew installed on your Mac, I highly recommend getting it. Quickest method I've found is simply executing the following command in Terminal:
```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```
Just to make sure everything went smoothly, execute ``` brew help ``` in Terminal. If everything is fine, continue through this tutorial and get those formulas brewing :-).

### cURL
First thing we'll use Homebrew for is installing cURL. This process is very simple. As before execute the following command in Terminal:
``` 
brew install curl 
```
Done! You can now use ```curl```.

## Selenoid installation and starting
Now that we have all the bits and pieces set up, installation and running of Selenoid should be a piece of cake. Execute the following command in Terminal:
```
curl -s https://aerokube.com/cm/bash | bash \
      && ./cm selenoid start --vnc --tmpfs 128
```
Installation will take some time, since there are quite a few things needing download, but ASCII art and Terminal changes will sure keep you amazed.
Throughout the installation, you'll be informed on the progress pretty well. Once it's done, you should have a path to your browser configuration file (```browsers.json```)
