# Build and deploy the Ionic test app to Android
## Step 0: Ensure Java jdk is installed
`sudo dnf install java`

## Step 1: download Android SDK tools
Download the Android SDK tools from the bottom of this page: 

`https://developer.android.com/studio/index.html`


Optionally, you can install the entire Android
Studio (which includes the sdk tools).

## Step 2: install Android SDK tools

### Instructions for Fedora 26:

Make a new directory:

`mkdir ~/android/`

Extract the contents of the sdk tools zip downloaded in step 1 into
~/android/

Change directory into ~/android/tools/.

Install the build-tools:

`./bin/sdkmanager "build-tools;26.0.3"`

Install the platform-tools:

`./bin/sdkmanager "platform-tools"`

Install dependencies:

`sudo dnf install zlib.i686 ncurses-libs.i686 bzip2-libs.i686`

Add the following lines to ~/.bash_profile:

`export ANDROID_HOME=~/android`
`PATH=$PATH:$ANDROID_HOME/tools/`
`PATH=$PATH:$ANDROID_HOME/platform-tools/`
`PATH=$PATH:$ANDROID_HOME/build-tools/`

Then issue the commmand:

`source ~/.bash_profile`

If this doesn't work, log and and log back in.

## Step 3: build the apk

From the /InterfaithApp/ directory, run:

`ionic cordova build android`
