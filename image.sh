#!/bin/sh
echo -e ""
RED='\033[0;31m'
NC='\033[0m' # No Color
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[0;33m'
if grep -Fqi "ubuntu 20.04" /etc/*-release
then
    echo -e "${GREEN}You have Ubuntu 20.04.x LTS, great!${NC}"
    echo -e ""
else
    echo -e "${RED}We only support Ubuntu 20.04.x LTS!${NC}"
    echo -e ""
    exit 0
fi
VISIONVERSION=`cat meta-openvision/conf/distro/openvision-common.conf | grep -oP '(?<=VISIONVERSION = ")[0-9].[0-9]*'`
VISIONREVISION=`cat meta-openvision/conf/distro/revision.conf | grep -oP '(?<=VISIONREVISION = "r)[0-9]*'`
VISIONSTATUSCOLOR=`cat meta-openvision/conf/distro/vision-status-color`
echo -e "${BLUE}Welcome to Open Vision ${GREEN}${VISIONVERSION}-r${VISIONREVISION} ${BLUE}image compile script!"
echo -e ""
if [ "${VISIONSTATUSCOLOR}" == 'RED' ]; then
	echo -e "${RED}Code RED detected!"
	echo -e "It means you need to use cleanup.sh (Build) but only once!"
	echo -e "If you already used cleanup.sh (Build) ignore this message."
	echo -e "RED releases happen when we do OE upgrades.${NC}"
else
	echo -e "${GREEN}It's a normal release, no need to use cleanup.sh${NC}"
fi
echo -e ""
echo -e "${YELLOW}Notice: this script is case sensitive!${NC}"
echo -e ""
echo -e "First we need to check your Ubuntu 20.04.x"
echo -e ""
if [ -f user.ovstep ]; then
	echo -e "Seems you run ltsubuntu.sh before but keep in mind it's better to run it each month to get latest updates."
	echo -e ""
else
	echo -e "Oh, we need to setup your Ubuntu so you need internet connection and a cup of coffee."
	/bin/sh ltsubuntu.sh
	echo "once" > user.ovstep
fi
gcc --version | sed -nr '/Ubuntu [0-9]+/ s/.*Ubuntu +([0-9]+).*/\1/p' > /tmp/vision-gcc-version
VISIONGCCVERSION=`cat /tmp/vision-gcc-version`
if [ "${VISIONGCCVERSION}" != '7' ]; then
	echo -e "${RED}GCC version is wrong!"
	echo -e "It means you need to choose version 7 of GCC!"
	sudo update-alternatives --config gcc
	sudo ln -s /usr/include/asm-generic /usr/include/asm
	gcc --version | sed -nr '/Ubuntu [0-9]+/ s/.*Ubuntu +([0-9]+).*/\1/p' > /tmp/vision-gcc-version
	VISIONGCCVERSION=`cat /tmp/vision-gcc-version`
	echo -e "Done, now GCC version is: ${VISIONGCCVERSION} ${NC}"
	echo -e ""
else
	echo -e "${GREEN}You enabled GCC 7 for OV 7.x, great!${NC}"
	echo -e ""
fi
DEVELOPERNAME=`git config user.name`
if [ "${DEVELOPERNAME}" != '' ]; then
	echo "DEVELOPER_NAME = '${DEVELOPERNAME}'" > meta-openvision/conf/distro/developer.conf
else
	echo -e "${RED}You don't have a git username!${NC}"
	echo -e ""
	echo -e "${BLUE}Enter a name as your git username:${NC}"
	echo -e "${GREEN}"
	read GITUSERNAME
	echo -e "${NC}"
	git config --global user.name "${GITUSERNAME}"
	echo "DEVELOPER_NAME = '${GITUSERNAME}'" > meta-openvision/conf/distro/developer.conf
fi
echo -e "Check ${NC}Vision-metas.md ${BLUE}and enter a meta or a specific machine to compile."
echo -e "Answers are in ${GREEN}green:${NC}"
echo -e ""
echo -e "${GREEN}AZ ${NC}- ${GREEN}Cube ${NC}- ${GREEN}DM ${NC}- ${GREEN}GB ${NC}- ${GREEN}HyperCube ${NC}- ${GREEN}Linkdroid"
echo -e "MINIX ${NC}- ${GREEN}Odroid ${NC}- ${GREEN}RPi ${NC}- ${GREEN}WeTek ${NC}- ${GREEN}Specific"
echo -e ""
echo -e "${GREEN}Specific${BLUE}: You have a specific machine in mind, Check ${NC}Vision-metas.md"
echo -e ""
echo -e "${BLUE}Enter the meta name:${NC}"
echo -e "${GREEN}"
read META
echo -e "${NC}"
if [ $META != "AZ" -a $META != "Cube" -a $META != "DM" -a $META != "GB" -a $META != "HyperCube" -a $META != "Linkdroid" -a $META != "MINIX" -a $META != "Odroid" -a $META != "RPi" -a $META != "WeTek" -a $META != "Specific" ]
then
	echo -e "${RED}Not a valid answer!${NC}"
	echo -e ""
	exit 0
fi
echo -e "${BLUE}Now choose whether you want to compile Open Vision or the online feeds."
echo -e "Answers are in ${GREEN}green:${NC}"
echo -e ""
echo -e "${GREEN}Vision ${NC}- ${GREEN}Feed ${NC}- ${GREEN}Kernel-Clean${NC}"
echo -e ""
echo -e "${BLUE}Enter image type:${NC}"
echo -e "${GREEN}"
read IMAGETYPE
echo -e "${NC}"
if [ $IMAGETYPE != "Vision" -a $IMAGETYPE != "Feed" -a $IMAGETYPE != "Kernel-Clean" ]
then
	echo -e "${RED}Not a valid answer!${NC}"
	echo -e ""
	exit 0
fi
echo -e "${BLUE}First update everything, please wait ...${NC}"
/bin/sh update.sh
sleep 0.1
#gnome-terminal --tab --title="GitHub keep alive terminal" --command="ping github.com"
echo -e ""
echo -e "${BLUE}Updated.${NC}"
echo -e ""
echo -e "${BLUE}Compiling${GREEN} $META ${BLUE}images, please wait ...${NC}"
echo -e ""
if [ $IMAGETYPE = "Vision" ]
then
	IMAGECMD='make image'
fi
if [ $IMAGETYPE = "Feed" ]
then
	IMAGECMD='make feed'
	if grep -Fqi "feed" user.ovstep
	then
	    echo -e "${BLUE}No need to set custom feed.${NC}"
	    echo -e ""
	else
	    echo -e "${BLUE}Do you want to set your own feed?"
	    echo -e ""
	    echo -e "Answers are in ${GREEN}green:${NC}"
	    echo -e ""
	    echo -e "${GREEN}Yes ${NC}- ${GREEN}No"
	    echo -e ""
	    echo -e "${BLUE}Enter custom feed mode:${NC}"
	    echo -e "${GREEN}"
	    read OWNFEED
	    echo -e "${NC}"
	    if [ $OWNFEED != "Yes" -a $OWNFEED != "No" ]
	    then
		echo -e "${RED}Not a valid answer!${NC}"
		echo -e ""
		exit 0
	    fi
	    if [ $OWNFEED = "No" ]
	    then
		echo "feed-is-not-set" >> user.ovstep
	    fi
	    if [ $OWNFEED = "Yes" ]
	    then
		echo -e "${BLUE}Enter your desired IP or URL without http or anything extra:"
		echo -e "${GREEN}"
		read USERURL
		echo -e "${NC}"
		sed -i '1 s/#//g' meta-openvision/conf/distro/openvision-testers.conf
		sed -i "s|openvisiontesters|$USERURL|g" meta-openvision/conf/distro/openvision-testers.conf
		echo "feed-is-set-to=${USERURL}" >> user.ovstep
		echo -e "${BLUE}Done!${GREEN} $USERURL ${BLUE}is now set as your custom feed.${NC}"
		echo -e ""
	    fi
	fi
fi
if [ $IMAGETYPE = "Kernel-Clean" ]
then
	IMAGECMD='make kernel-clean'
fi
if [ $META = "Specific" ]
then
	echo -e "${BLUE}Enter your specific machine name exactly like what you see in ${NC}Vision-metas.md"
	echo -e "${GREEN}"
	read MACHINESPECIFIC
	echo -e "${NC}"
	echo -e "${BLUE}Compiling${GREEN} $MACHINESPECIFIC ${BLUE}image, please wait ...${NC}"
	echo -e ""
	MACHINE=$MACHINESPECIFIC $IMAGECMD
fi
if [ $META = "AZ" ]
then
	MACHINE=azboxhd $IMAGECMD
fi
if [ $META = "Cube" ]
then
	MACHINE=cube $IMAGECMD
fi
if [ $META = "DM" ]
then
	MACHINE=dm500hd $IMAGECMD
	MACHINE=dm800 $IMAGECMD
	MACHINE=dm800se $IMAGECMD
fi
if [ $META = "GB" ]
then
	MACHINE=gb800se $IMAGECMD
	MACHINE=gb800ue $IMAGECMD
fi
if [ $META = "HyperCube" ]
then
	MACHINE=su980 $IMAGECMD
fi
if [ $META = "Linkdroid" ]
then
	MACHINE=alien5 $IMAGECMD
	MACHINE=k1plus $IMAGECMD
	MACHINE=k1plusv2 $IMAGECMD
	MACHINE=k1pro $IMAGECMD
	MACHINE=k2pro $IMAGECMD
	MACHINE=k2prov2 $IMAGECMD
	MACHINE=k3pro $IMAGECMD
fi
if [ $META = "MINIX" ]
then
	MACHINE=x8hp $IMAGECMD
fi
if [ $META = "Odroid" ]
then
	MACHINE=odroidc2 $IMAGECMD
fi
if [ $META = "RPi" ]
then
	MACHINE=raspberrypi $IMAGECMD
	MACHINE=raspberrypi0 $IMAGECMD
	MACHINE=raspberrypi2 $IMAGECMD
	MACHINE=raspberrypi3 $IMAGECMD
	MACHINE=raspberrypi4 $IMAGECMD
fi
if [ $META = "WeTek" ]
then
	MACHINE=wetekhub $IMAGECMD
	MACHINE=wetekplay $IMAGECMD
	MACHINE=wetekplay2 $IMAGECMD
fi
echo -e ""
echo -e "${BLUE}Done, the compiled image is in ${NC}build/tmp/deploy/images/${GREEN}$MACHINE$MACHINESPECIFIC ${BLUE}folder!"
echo -e "It's a zipped file like ${NC}openvision-enigma2-develop-english|multilanguage|extralanguage-${GREEN}${VISIONVERSION}-r${VISIONREVISION}${NC}-${RED}$MACHINE$MACHINESPECIFIC${NC}.zip"
