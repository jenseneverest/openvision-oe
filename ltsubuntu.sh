#!/bin/sh
echo -e ""
RED='\033[0;31m'
NC='\033[0m' # No Color
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[0;33m'
echo -e "${BLUE}Ubuntu 20.04.x LTS setup by Open Vision"
echo -e ""
echo -e "First answer ${RED}No${BLUE} to dash"
echo -e ""
sudo dpkg-reconfigure dash
echo -e ""
echo -e "Update package list first ..."
echo -e ""
sudo apt update
echo -e ""
echo -e "Remove useless packages ..."
echo -e ""
sudo apt autoremove -y
echo -e ""
echo -e "Upgrade packages ..."
echo -e ""
sudo apt upgrade -y
sudo apt dist-upgrade -y
echo -e ""
echo -e "Get latest LTS changes ..."
echo -e ""
sudo apt install -y --install-recommends linux-generic-hwe-20.04
echo -e ""
echo -e "Now install what we need, answer yes and wait for complete download"
echo -e ""
sudo apt install -y autoconf automake bison bzip2 cvs diffstat flex g++ gawk gcc gettext git git-lfs gzip help2man ncurses-bin libncurses5-dev libc6-dev libtool make texinfo patch perl pkg-config subversion tar texi2html wget chrpath libxml2-utils xsltproc python-setuptools libc6 genromfs mtd-utils dpkg-dev sshpass poedit translate-toolkit xclip linux-firmware linux-headers-`uname -r` linux-headers-`uname -r` linux-image-`uname -r` linux-tools-`uname -r` linux-libc-dev linux-source u-boot-tools upx-ucl doxygen optipng python-dev libglib2.0-dev pngquant default-jdk android-tools-fastboot libssl-dev libc6-dev-i386 lib32z1 m4 intltool ccache zlib1g zlib1g-dev liblzo2-dev tcl dpkg asciidoc texlive-latex-base dblatex xutils-dev gparted openssh-server nfs-common nfs-kernel-server lintian git-doc git-gui gitk indent tofrodos fakeroot meld atftpd sharutils manpages-dev manpages-posix manpages-posix-dev libgdk-pixbuf2.0-dev linux-doc python3-autopep8 build-essential socat libsdl1.2-dev xterm gcc-multilib libopenmpi-dev parted mercurial binutils imagemagick librsvg2-bin jq linux-libc-dev:i386 linux-headers-generic
echo -e ""
echo -e "Add GCC 10 to Ubuntu which is needed for newer OE!"
echo -e ""
sudo apt install -y software-properties-common
sudo add-apt-repository ppa:ubuntu-toolchain-r/test -y
sudo apt update
sudo apt install -y gcc-10 g++-10
sudo apt update --fix-missing
sudo apt --fix-broken install
sudo apt install -f
sudo update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-10 100 --slave /usr/bin/g++ g++ /usr/bin/g++-10 --slave /usr/bin/gcov gcov /usr/bin/gcov-10
#sudo update-alternatives --config gcc
gcc --version
echo -e ""
echo -e "Remove useless packages ..."
echo -e ""
sudo apt --purge autoremove -y
echo -e ""
echo -e "Done, now you can compile an Open Vision image!"
echo -e ""
