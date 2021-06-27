# AndroidApp

## group members:
Shilo Ulman, Shaked Winder

## Design:
This is an android app for joystick control on flight gear.
In our site, the user put IP and PORT of the computer with flight gear, and connect to the FG.

We used the MVVM design pattern to create the application.
The View of the application wrote with the xml language.
The view can communicate with the viewmodel, that was wrote with kotlin technology.
The Model was wrote also with kotlin, and he also can communicate with the viewmodel, and through it - with the view. The model "talk" with the flight gear, while the view get from the user the behavior.

## Preparations for using the application:
In order to use our application, the user needs to put IP and PORT, and thats it! just play!

## project structure
### Model:
The model is the code that take what the user asked and send to the flught gear.
The model holds 2 queues that present the behvior and the value to send, and with another thread always send the new requests from user to the flight gear.


### view model:
The view model get from the view what the model should send, and put it in the model.


### View:
The view part is what the user sees when he/ she visits our site.
The view is complex from IP and PORT windows, joystick, rudder and throttle.
The view listen to the joystick, rudder and throttle, and when it change he sent to the viewmodel.

## Explanation video of how to use the site:
Click this link (https://youtu.be/hOf5rRjUjlQ) for a tutorial video on how to use the app

## UML diagram:
You can find  a UML diagram of our project at the following link: https://github.com/ullmans/AndroidApp/blob/main/UML_ex3.pdf