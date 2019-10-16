Open Vision 7.3 (Stable) enigma2 images [![Build Status](https://travis-ci.org/OpenVisionE2/openvision-oe.svg?branch=develop)](https://travis-ci.org/OpenVisionE2/openvision-oe) [![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
==========================
![alt tag](https://raw.github.com/OpenVisionE2/openvision-oe/develop/recipes-openvision/bootlogo/openvision-bootlogo/bootlogo.jpg)

# Donation

Do you want to help us grow? Do you want us to extend our projects and make things faster?

You have the chance to participate in Open Vision and make everything better for everyone: https://forum.openvision.tech/app.php/donate

Do you want to donate anonymously?

bitcoincash: qpsu4jhl5qyze9dklnakjm8mks23lqd0hc49dqf57n

bitcoincore: 19v5Uum2zcuRzYmkekbFeQ5V4nfbB5iLbm

ethereum: 0x6233d20...08EF59d10

# Contribution

Do you want to contribute to Open Vision and you don’t know where to start? https://forum.openvision.tech/viewtopic.php?f=2&t=306 is for you.

# Download

<strike>You could download our builds from https://openvision.tech/stb-images/</strike>
* How to use sdcard images (E.g. raspberrypi):

You could use https://sourceforge.net/projects/win32diskimager/ or similar tools to write the image on a sdcard.

# Support

Please use our forum at https://forum.openvision.tech or our issue page at https://github.com/OpenVisionE2/openvision-oe/issues

# Distribution

* Are you allowed to compile development versions? Yes!
* Are you allowed to distribute development versions? Yes but only with "unofficial-version" tag.
* Are you allowed to make our images compatible with clones? Yes!
* Are you allowed to distribute cloned images? Yes but only with "clone-version" tag.
* Do we support clones? No!
* Are you allowed to make backup of our images? Yes!
* Are you allowed to distribute backup images? Yes but only with "backup-version" tag.
* Do we provide support for self-building? No! We prefer to work on our projects.
* Do we need more Vision Developers? Absolutely yes! Contribute to our git and we will contact you!
* Do we need more Vision Testers? Absolutely yes! Test our images and report bugs, help us grow you'll see the title flows.
* Do we support our image in multiboot situations? No! Check about screen and if our module is not loaded then you're on your own!

If you see your model in https://github.com/OpenVisionE2/openvision-oe/blob/develop/Vision-metas.md it means there will be Open Vision for it otherwise read https://forum.openvision.tech/viewtopic.php?f=2&t=30 and don't spam the board!

---

# Compile

You could compile Open Vision for so many brands/models:
* Vision-metas: https://github.com/OpenVisionE2/openvision-oe/blob/develop/Vision-metas.md

# How to build an Open Vision image (on native Ubuntu)

1. Clone openpli-oe-core somewhere:
```
git clone -b develop --depth 1 https://github.com/OpenPLi/openpli-oe-core.git
```
2. Enter the openpli-oe-core directory:
```
cd openpli-oe-core
```
3. Clone openvision-oe:
```
git clone --depth 1 https://github.com/OpenVisionE2/openvision-oe.git
```
4. Run our image.sh script (Do not run bitbake or any related script as root!):
```
cd openvision-oe
./image.sh
```
Always go with "Vision" first, compile and test the image then go with "Feed".

If you want to compile an image for only 1 machine just choose "Specific".

If you want to go clean again, do not remove your "sources" directoy! Never!

If you answered something wrong don't worry, just remove "user.ovstep"!

# Hints for multiple architectures

* Removing the "build" directory solves most of the errors. For a fast remove use "rm -rf build".
(If you just want to reduce the build size use "cleanup.sh".)
* If you want to compile images for old machines like dm800/cube/su980, first build for them.
* If you want to compile images for x64 machines like alienx/kxpx series, first build for them.
* If you want to compile images for 4K machines with ARM architecture and you get error each time, try compile for a Mipsel machine like dm7020hd first then compile your ARM images.

# Blacklisted companies/teams/persons

There are some stupid companies/teams/persons which want to keep enigma2 closed-source.

Please don't buy their products, don't help them, don't donate anything to them, don't use their images.

If you support them they will grow but we need to fight this kind of behavior together.

* DMM (DreamBox) company which did close their enigma2 sources years ago.
* Japhar team, despite the fact that they're supporting clones they are using everyone's work and don't publish their changes.
* PurE2 team which are using everyone's work and trying to close things like using .so libraries, they don't publish their changes.
* VITMOD which is stealing our sources even our procfs driver without publishing his work.
