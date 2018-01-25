#!/bin/bash

echo "Installing nodejs"
sudo dnf install nodejs java-1.8.0-openjdk-devel gradle

echo "Installing ionic cordova"
sudo npm install -g ionic cordova
