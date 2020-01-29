#!/bin/sh
echo -e ""
RED='\033[0;31m'
NC='\033[0m' # No Color
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[0;33m'
echo -e "${BLUE}Ubuntu 18.04.x LTS setup by Open Vision"
echo -e ""
echo -e "First answer ${RED}No${BLUE} to dash"
echo -e ""
sudo dpkg-reconfigure dash
echo -e ""
echo -e "Update package list first ..."
echo -e ""
sudo apt-get update
echo -e ""
echo -e "Remove useless packages ..."
echo -e ""
sudo apt autoremove -y
echo -e ""
echo -e "Upgrade packages ..."
echo -e ""
sudo apt-get upgrade -y
echo -e ""
echo -e "Get latest LTS changes ..."
echo -e ""
sudo apt-get install -y --install-recommends linux-generic-hwe-18.04 xserver-xorg-hwe-18.04
echo -e ""
echo -e "Now install what we need, answer yes and wait for complete download"
echo -e ""
sudo apt-get install -y autoconf automake bison bzip2 cvs diffstat flex g++ gawk gcc gettext git git-lfs gzip help2man ncurses-bin libncurses5-dev libc6-dev libtool make texinfo patch perl pkg-config subversion tar texi2html wget chrpath libxml2-utils xsltproc python-setuptools libc6 genromfs mtd-utils dpkg-dev sshpass poedit translate-toolkit xclip linux-firmware linux-headers-`uname -r` linux-headers-generic linux-image-generic linux-libc-dev linux-source u-boot-tools upx-ucl doxygen repo optipng python-dev libglib2.0-dev pngquant default-jdk android-tools-fastboot android-tools-fsutils libssl-dev libc6-dev-i386 lib32z1 m4 liborbit2-dev intltool ccache zlib1g zlib1g-dev liblzo2-dev tcl dpkg asciidoc texlive-latex-base dblatex xutils-dev gparted openssh-server nfs-common nfs-kernel-server lintian git-doc git-gui gitk indent tofrodos fakeroot meld atftpd sharutils manpages-dev manpages-posix manpages-posix-dev libgdk-pixbuf2.0-dev linux-doc python-autopep8 build-essential socat libsdl1.2-dev xterm gcc-multilib libopenmpi-dev parted
echo -e ""
echo -e "Remove useless packages ..."
echo -e ""
sudo apt autoremove -y
echo -e ""
echo -e "Done, now you can compile an Open Vision image!"
echo -e ""
