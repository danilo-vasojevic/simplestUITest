# Working with Selenoid - PR pet project

Main idea behind this repository is to demonstrate how Selenoid is set up, configured and how Selenium UI tests can be executed within Docker containers created by Selenoid.

### Installation of additional tools
IN the next few paragraphs, we'll quickly ho through all tools that make whole process much, much simpler. At this moment, I'll not go into alternative methods of setting up Selenoid, simply because there's no need to complicate.

Also, I'll assume the following:
1. You're using Mac
2. You have decent experience with command line tools and Terminal

#### Docker
If you don't have Docker, install it.

#### Homebrew
If you, for any reason, don't already have Homebrew installed on your Mac, I highly recommend getting it. Quickest method I've found is simply executing the following command in Terminal:
```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```
Just to make sure everything went smoothly, execute ``` brew help ``` in Terminal. If everything is fine, continue through this tutorial and get those formulas brewing :-).

#### cURL
First thing we'll use Homebrew for is installing cURL. This process is very simple. As before execute the following command in Terminal:
``` 
brew install curl 
```
Done! You can now use ```curl```.

### Selenoid installation and starting
Now that we have all the bits and pieces set up, installation and running of Selenoid should be a piece of cake. Execute the following command in Terminal:
```
curl -s https://aerokube.com/cm/bash | bash \
      && ./cm selenoid start --vnc --tmpfs 128
```
Installation will take some time, since there are quite a few things needing download, but ASCII art and Terminal changes will sure keep you amazed.
Throughout the installation, you'll be informed on the progress pretty well. Once it's done, you should have a path to your browser configuration file (```browsers.json```)

## Running the tests
Before digging a bit deeper in Selenoid and introducing SelenoidUI, assuming all went well in previous steps, we can now run our simple UI test and it should execute inside Selenoid container.

First of all, let's check if our browsers are set up properly. Visit ```http://localhost:4444/status```. You should a ```json``` file looking something like this:
```json
{  
   "total":5,
   "used":0,
   "queued":0,
   "pending":0,
   "browsers":{  
      "chrome":{  
         "68.0":{  

         },
         "69.0":{  

         }
      },
      "firefox":{  
         "61.0":{  

         },
         "62.0":{  

         }
      },
      "opera":{  
         "54.0":{  

         },
         "55.0":{  

         }
      }
   }
}
```

I assume you already cloned this repository on your local machine. Just go ahead and open in in you favorite IDE (I strongly suggest using IntelliJ IDEA) and simply run ```RunnerClass.main()``` method. Keep a close eye on the console window.
Test should perform a google searche and print out window title in console. Of course, you shouldn't see any browser windows popup on your screen.

## Introducing SelenoidUI
As for Selenoid, there are multiple ways of intalling selenoid UI. One of the ways is, as it's distributed as a tiny Docker container, executing this command:
```
docker run -d --name selenoid-ui  \
    --link selenoid                 \
    -p 8080:8080                    \
    aerokube/selenoid-ui --selenoid-uri=http://selenoid:4444
```
Keep in mind that ```--link selenoid``` linking will only work if your selenoid container is named selenoid (if you've followed this tutorial, it should be)
