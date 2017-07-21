#AndroRAT
 
<b>DISCLAIMER: This software is meant for educational purposes only. We are not responsible for any malicious use of the app.</b>

<b>Remember that if you want to use this software on your home network you should use a private ip, but if you want to use this application remotely, you must use a public IP. In every case, you should open TCP-UDP port in your router.</b>


## Remote Administration Tool for Android

Androrat is a client/server application developed in Java Android for the client side and in Java/Swing for the Server.

The name Androrat is a mix of Android and RAT (Remote Access Tool).


## Available features

Get contacts (and all theirs informations)

Get call logs

Get all messages

Location by GPS/Network

Monitoring received messages in live

Monitoring phone state in live (call received, call sent, call missed..)

Take a picture from the camera

Stream sound from microphone (or other sources..)

Streaming video (for activity based client only)

Do a toast

Send a text message

Give call

Open an URL in the default browser

Do vibrate the phone

#Changelog:

-fixed camera and phototaker problems

-added lib to project for quicker android build

## How to stop

$dumpsys activity services | grep my                      
ServiceRecord{9bb93ba u0 my.app.client/.Client}
    intent={act=my.app.client.LauncherActivity cmp=my.app.client/.Client}
    packageName=my.app.client
    processName=my.app.client
    baseDir=/data/app/my.app.client-1/base.apk
    dataDir=/data/user/0/my.app.client
    app=ProcessRecord{cf5cc99 30720:my.app.client/u0a164}
      intent=Intent { act=AlarmListener cmp=my.app.client/.Client }

$am stopservice my.app.client.LauncherActivity