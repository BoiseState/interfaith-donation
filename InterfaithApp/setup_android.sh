#!/bin/bash

sudo dnf install wget

echo "Making directory ~/android/"
mkdir ~/android/
cd ~/android/

echo "Downloading SDK tools"
wget 'https://dl.google.com/android/repository/sdk-tools-linux-3859397.zip'

echo "Unzipping"
unzip sdk-tools-linux-3859397

cd ~/android/tools/
./bin/sdkmanager "build-tools;26.0.3"
./bin/sdkmanager "platform-tools"

echo "Installing dependencies"
sudo dnf install zlib.i686 ncurses-libs.i686 bzip2-libs.i686

echo "export ANDROID_HOME=~/android" >> ~/.bash_profile
echo "PATH=\$PATH:\$ANDROID_HOME/tools/" >> ~/.bash_profile
echo "PATH=\$PATH:\$ANDROID_HOME/platform-tools/" >> ~/.bash_profile
echo "PATH=\$PATH:\$ANDROID_HOME/build-tools/" >> ~/.bash_profile

export ANDROID_HOME=~/android
PATH=$PATH:$ANDROID_HOME/tools/
PATH=$PATH:$ANDROID_HOME/platform-tools/
PATH=$PATH:$ANDROID_HOME/build-tools/
