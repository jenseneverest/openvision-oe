#!/bin/sh
echo -e ""
RED='\033[0;31m'
NC='\033[0m' # No Color
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[0;33m'
VISIONVERSION=`cat conf/distro/openvision-common.conf | grep -oP '(?<=VISIONVERSION = ")[0-9].[0-9]*'`
VISIONREVISION=`cat conf/distro/openvision-common.conf | grep -oP '(?<=VISIONREVISION = "r)[0-9][0-9]'`
echo -e "${BLUE}Welcome to Open Vision ${GREEN}${VISIONVERSION}-r${VISIONREVISION} ${BLUE}image compile script!"
echo -e ""
echo -e "First we need to check your Ubuntu 18.04.x"
echo -e ""
if [ -f user.ovstep ]; then
	echo -e "Seems you run ltsubuntu.sh before but keep in mind it's better to run it each month to get latest updates."
	echo -e ""
else
	echo -e "Oh, we need to setup your Ubuntu so you need internet connection and a cup of coffee."
	/bin/sh ltsubuntu.sh
	echo "once" > user.ovstep
fi
echo -e "Check ${NC}Vision-metas.md ${BLUE}and enter a meta or a specific machine to compile."
echo -e "Answers are in ${GREEN}green:${NC}"
echo -e ""
echo -e "${GREEN}Cube ${NC}- ${GREEN}Dreambox ${NC}- ${GREEN}HyperCube ${NC}- ${GREEN}Specific"
echo -e ""
echo -e "${GREEN}Specific${BLUE}: You have a specific machine in mind, Check ${NC}Vision-metas.md"
echo -e ""
echo -e "${BLUE}Enter the meta name:${NC}"
echo -e "${GREEN}"
read META
echo -e "${NC}"
if [ $META != "Cube" -a $META != "Dreambox" -a $META != "HyperCube" -a $META != "Specific" ]
then
	echo -e "${BLUE}Not a valid answer!${NC}"
	echo -e ""
	exit 0
fi
echo -e "${BLUE}Now choose whether you want to compile Open Vision or the online feeds."
echo -e "Answers are in ${GREEN}green:${NC}"
echo -e ""
echo -e "${GREEN}Vision ${NC}- ${GREEN}Feed ${NC}- ${GREEN}Kernel-Clean ${NC}- ${GREEN}Version-Clean${NC}"
echo -e ""
echo -e "${BLUE}Enter image type:${NC}"
echo -e "${GREEN}"
read IMAGETYPE
echo -e "${NC}"
if [ $IMAGETYPE != "Vision" -a $IMAGETYPE != "Feed" -a $IMAGETYPE != "Kernel-Clean" -a $IMAGETYPE != "Version-Clean" ]
then
	echo -e "${BLUE}Not a valid answer!${NC}"
	echo -e ""
	exit 0
fi
echo -e "${BLUE}First update everything, please wait ...${NC}"
/bin/sh update.sh
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
		echo -e "${BLUE}Not a valid answer!${NC}"
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
		sed -i '1 s/#//g' conf/distro/openvision-testers.conf
		sed -i "s|openvisiontesters|$USERURL|g" conf/distro/openvision-testers.conf
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
if [ $IMAGETYPE = "Version-Clean" ]
then
	IMAGECMD='make version-clean'
fi
cd ..
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
if [ $META = "Cube" ]
then
	MACHINE=cube $IMAGECMD
fi
if [ $META = "Dreambox" ]
then
	MACHINE=dm500hd $IMAGECMD
	MACHINE=dm500hdv2 $IMAGECMD
	MACHINE=dm520 $IMAGECMD
	MACHINE=dm7020hd $IMAGECMD
	MACHINE=dm7020hdv2 $IMAGECMD
	MACHINE=dm7080 $IMAGECMD
	MACHINE=dm800 $IMAGECMD
	MACHINE=dm8000 $IMAGECMD
	MACHINE=dm800se $IMAGECMD
	MACHINE=dm800sev2 $IMAGECMD
	MACHINE=dm820 $IMAGECMD
	MACHINE=dm900 $IMAGECMD
	MACHINE=dm920 $IMAGECMD
	MACHINE=dreamone $IMAGECMD
fi
if [ $META = "HyperCube" ]
then
	MACHINE=su980 $IMAGECMD
fi
echo -e ""
echo -e "${BLUE}Done, the compiled image is in ${NC}build/tmp/deploy/images/${GREEN}$MACHINE$MACHINESPECIFIC ${BLUE}folder!"
echo -e "It's a zipped file like ${NC}openvision-enigma2-old-multilanguage-${GREEN}${VISIONVERSION}-r${VISIONREVISION}${NC}-${RED}$MACHINE$MACHINESPECIFIC${NC}.zip"
