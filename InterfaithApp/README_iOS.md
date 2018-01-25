# Build and deploy ionic test app to ios
## Step 1: sign up for an AppleID
To build an ios application and deploy it to the Apple store you need a membership
to the developers program. This is a recurring annual cost of $99 USD. To test your
application locally on a device you can get by with just an AppleID. I have created
team red star AppleID for our project (teamredstarbsu@gmail.com) and have saved its
credentials in the 'shared resources' directory as 'redstarioscert.developerprofile'.
*NOTE* You will need to have these credentials on your test device and in xcode. 

## Step 2: Add AppleID to XCode
Next we must add our account to Xcode. Xcode generates a certificate when building 
the application and needs an account to sign the package. *NOTE:* you must have XCode
version 7 or later installed for this to work.

To add an account navigate to 'shared resources' and open the file named 
'redstarioscert.developerprofile'. This should launch Xcode and prompt you for a 
password. The password is redstarBSU1. The credentials will import into Xcode.

## Step 3: Check Cordova Requirements
Check that all Cordova dependencies are installed by navigating to the InterfaithApp
directory in the terminal and running 'npm update' followed by 'cordova requirements'.
If there are any dependencies missing, install them.

## Step 4: Add your AppleID to the ios Platform 
In Xcode open the ios platform directory 'InterfaithApp/platforms/ios'. Then 
select 'Interfaith Sanctuary' from the sidebar menu. Under the General tab look for a
section labeled 'Signing'. Click the 'Team' Dropdown menu and select Red Star from  the
menu. *NOTE* If you do not have your test device plugged into your computer you will get
an error and a prompt to try again. Take a moment to sign into the AppleID on your test
device, the credentials are posted in the files section of slack. Then plug your test
device into the computer and make sure it is selected as the device at the top of the 
screen and then click the 'Try Again' Button. The error should clear.

## Step 5: Build your ionic program
Back in the terminal in the InterfaithApp directory run the command 
'ionic cordova build ios'. 

## Step 6: Deploy your app
Check that your device is still plugged in and shows up in the tool bar as the 'Active
Schema'. Select  'Interfaith Sanctuary' from the sidebar menu and then click the run icon
in the tool bar. Your app should build and deploy to your device. 

If this is the first time deploying to your device you will need to set your AppleID as
a trusted source to do that go to: 

System Preferences->General->Profiles & Device Management and under the Developer App
section select your account and then hit 'Trust' in the popup. Your app should now 
display.
